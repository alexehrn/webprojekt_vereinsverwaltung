package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import bean.TrainerTerminverwaltungsBean;



@WebServlet("/TrainerTerminverwaltungsServlet")
public class TrainerTerminverwaltungsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

    
    public TrainerTerminverwaltungsServlet() { 
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		
		TrainerTerminverwaltungsBean trainerTerminverwaltungsBean = new TrainerTerminverwaltungsBean();
		
		trainerTerminverwaltungsBean.setKurzbeschreibung(request.getParameter("kurzbeschreibung"));
		trainerTerminverwaltungsBean.setOrt(request.getParameter("ort"));
		trainerTerminverwaltungsBean.setDatum(Date.valueOf(request.getParameter("datum")));
		trainerTerminverwaltungsBean.setUhrzeitVON(Time.valueOf(request.getParameter("startzeit")));
		trainerTerminverwaltungsBean.setUhrzeitBIS(Time.valueOf(request.getParameter("endzeit")));
		trainerTerminverwaltungsBean.setBeschreibung(request.getParameter("trainer_eingabe"));
		
		persist(trainerTerminverwaltungsBean);
		
		final HttpSession session = request.getSession();
		session.setAttribute("trainerTerminverwaltungsBean", trainerTerminverwaltungsBean);//Redirect weil Formulareingabe? --> würde sonst öfter schicken

		response.sendRedirect("jsps/TrainerTermin_anlegen.jsp");
	
	}
	
	private void persist(TrainerTerminverwaltungsBean trainerTeamverwaltungsBean) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] {"id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
		
		try (Connection con = ds.getConnection();
			 /*final Statement stmt = con.createStatement()*/
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO termine (kurzbeschreibung, ort, datum, beginn, ende, beschreibung) VALUES (?,?, ?, ?, ?, ?)", 
					generatedKeys)){

		
	
			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, trainerTeamverwaltungsBean.getKurzbeschreibung());
			pstmt.setString(2, trainerTeamverwaltungsBean.getOrt());
			pstmt.setDate(3, (Date) trainerTeamverwaltungsBean.getDatum());
			pstmt.setTime(4, (Time) trainerTeamverwaltungsBean.getUhrzeitVON());
			pstmt.setTime(5, (Time) trainerTeamverwaltungsBean.getUhrzeitBIS());
			pstmt.setString(6, trainerTeamverwaltungsBean.getBeschreibung());
			
			
			pstmt.executeUpdate();
			
			
			// Generierte(n) Schlüssel auslesen (funktioniert nur mit PreparedStatement)
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				int i = 1;
				while (rs.next()) {
					trainerTeamverwaltungsBean.setId(rs.getLong(i));
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
