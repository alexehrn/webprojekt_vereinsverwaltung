//Quirin Gerstberger:
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalTime;
import javax.sql.DataSource;
import bean.TrainerTerminverwaltungsBean;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrainerTerminBearbeiten
 */
	@WebServlet("/TrainerTerminBearbeiten")
	public class TrainerTerminBearbeiten extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
    /**
     * Default constructor. 
     */
    public TrainerTerminBearbeiten() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		Long id = Long.valueOf(request.getParameter("id"));
		
		
		TrainerTerminverwaltungsBean trainerTerminverwaltungsBean = new TrainerTerminverwaltungsBean();
		
		//Attribute in Bean
		trainerTerminverwaltungsBean.setKurzbeschreibung(request.getParameter("kurzbeschreibung"));
		trainerTerminverwaltungsBean.setOrt(request.getParameter("ort"));
		trainerTerminverwaltungsBean.setDatum(Date.valueOf(request.getParameter("datum")));
		trainerTerminverwaltungsBean.setUhrzeitVON(LocalTime.parse(request.getParameter("startzeit")));
		trainerTerminverwaltungsBean.setUhrzeitBIS(LocalTime.parse(request.getParameter("endzeit")));
		trainerTerminverwaltungsBean.setBeschreibung(request.getParameter("trainer_eingabe"));
		

		
		// DB-Zugriff
		updateTermin(id, trainerTerminverwaltungsBean);
		
				
		// Weiterleiten an JSP
		response.sendRedirect("./SearchServletTrainerTerminverwaltung");	
	}

	private void updateTermin(Long id, TrainerTerminverwaltungsBean trainerTerminverwaltungsBean) throws ServletException {
		try (Connection con = ds.getConnection();
			    PreparedStatement pstmt = con.prepareStatement("UPDATE termine SET kurzbeschreibung=?, ort=?, datum=?, beginn=?, ende=?, beschreibung=? WHERE termin_id = ?")) {
				
				pstmt.setString(1, trainerTerminverwaltungsBean.getKurzbeschreibung());
				pstmt.setString(2, trainerTerminverwaltungsBean.getOrt());
				pstmt.setDate(3, trainerTerminverwaltungsBean.getDatum());
				pstmt.setTime(4, java.sql.Time.valueOf(trainerTerminverwaltungsBean.getUhrzeitVON()));
				pstmt.setTime(5, java.sql.Time.valueOf(trainerTerminverwaltungsBean.getUhrzeitBIS()));
				pstmt.setString(6, trainerTerminverwaltungsBean.getBeschreibung());
				
				pstmt.setLong(7,id);
				pstmt.executeUpdate();
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
