package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import bean.TrainerBean;
import bean.SpielerBean;
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
		
		//Attribute in Bean
		trainerTerminverwaltungsBean.setKurzbeschreibung(request.getParameter("kurzbeschreibung"));
		trainerTerminverwaltungsBean.setOrt(request.getParameter("ort"));
		trainerTerminverwaltungsBean.setDatum(Date.valueOf(request.getParameter("datum")));
		trainerTerminverwaltungsBean.setUhrzeitVON(LocalTime.parse(request.getParameter("startzeit")));
		trainerTerminverwaltungsBean.setUhrzeitBIS(LocalTime.parse(request.getParameter("endzeit")));
		trainerTerminverwaltungsBean.setBeschreibung(request.getParameter("trainer_eingabe"));
		
		
		
		
		
		//Team aus Session holen
		HttpSession session = request.getSession();
		TrainerBean trainer = (TrainerBean) session.getAttribute("trainer");
		String team = trainer.getTeam();
		
		persist(trainerTerminverwaltungsBean, team);		
		
		
		//Scope "Request"
		session.setAttribute("trainerTerminverwaltungsBean", trainerTerminverwaltungsBean);//Redirect weil Formulareingabe? --> würde sonst öfter schicken
		
		//Weiterleiten an  JSP
		response.sendRedirect("/Webprojekt-Verein-war-02/SearchServletTrainerTerminverwaltung");
	
	}
	
	private void persist(TrainerTerminverwaltungsBean trainerTeamverwaltungsBean, String team) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] {"id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
	
		try (Connection con = ds.getConnection();
			 /*final Statement stmt = con.createStatement()*/
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO termine (kurzbeschreibung, ort, datum, beginn, ende, beschreibung, mannschaft) VALUES (?, ?, ?, ?, ?, ?, ?)", 
					generatedKeys)){

		
			
			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, trainerTeamverwaltungsBean.getKurzbeschreibung());
			pstmt.setString(2, trainerTeamverwaltungsBean.getOrt());
			pstmt.setDate(3, trainerTeamverwaltungsBean.getDatum());
			pstmt.setTime(4, java.sql.Time.valueOf(trainerTeamverwaltungsBean.getUhrzeitVON()));
			pstmt.setTime(5, java.sql.Time.valueOf(trainerTeamverwaltungsBean.getUhrzeitBIS()));
			pstmt.setString(6, trainerTeamverwaltungsBean.getBeschreibung());
			pstmt.setString(7, team);
			
			
			
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
