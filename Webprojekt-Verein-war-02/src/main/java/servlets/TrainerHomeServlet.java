package servlets;


import bean.TrainerBean;
import bean.TrainerHomeBean;
import bean.TrainerTerminverwaltungsBean;
import bean.abwesenheitsbean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/TrainerHomeServlet")
public class TrainerHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
 
    public TrainerHomeServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		TrainerHomeBean trainerHomeBean = new TrainerHomeBean();
		
		
		trainerHomeBean.setBeschreibung(request.getParameter("trainer_eingabe"));
		trainerHomeBean.setTag(new java.sql.Date(new java.util.Date().getTime()));		//Automatisches erstellen des Heutigen Datums --> mit ChatGPT Herausgefunden												//aktuellen Tag einfügen
		
		persist(trainerHomeBean);
		
		//Team des Trainers aus Session holen
		final HttpSession session = request.getSession();
		TrainerBean trainer = (TrainerBean) session.getAttribute("trainer");
		String team = trainer.getTeam();
		

		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("/Webprojekt-Verein-war-02/SearchServletTrainerHome");
		dispatcher.forward(request, response);
		
		
		session.setAttribute("TrainerHomeBean", trainerHomeBean);//Redirect weil Formulareingabe? --> würde sonst öfter schicken
		
		
		response.sendRedirect("");
		
	}
	
	private void persist(TrainerHomeBean trainerHomeBean) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] {"nachricht_id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO nachricht (text, tag) VALUES (?,?)", 
					generatedKeys)){

		
			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, trainerHomeBean.getBeschreibung());
			pstmt.setDate(2, trainerHomeBean.getTag());
			pstmt.executeUpdate();
			
			// Generierte(n) Schlüssel auslesen (funktioniert nur mit PreparedStatement)
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					trainerHomeBean.setNachricht_id(rs.getLong(1));
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
