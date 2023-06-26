package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bean.SpielerBean;
import bean.TrainerBean;
import bean.TrainerHomeBean;
import bean.TrainerTerminverwaltungsBean;
import bean.abwesenheitsbean;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * Servlet zum Suchen der Termine einer Mannschaft für den Kalender
 */
@WebServlet("/SearchServletTrainerKalender")
public class SearchServletTrainerKalender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
   
	
    public SearchServletTrainerKalender() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// Team des Trainers aus Session holen
		final HttpSession session = request.getSession();
		TrainerBean trainer = (TrainerBean) session.getAttribute("trainer");
		String team = trainer.getTeam();

		// DB-Zugriff
		List<TrainerTerminverwaltungsBean> termine = searchtermine(team);
		
		// Scope "Request"
		request.setAttribute("termine", termine);

		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./home/TrainerKalender.jsp");
		dispatcher.forward(request, response);

	}

	private List<TrainerTerminverwaltungsBean> searchtermine(String team) throws ServletException {
		List<TrainerTerminverwaltungsBean> termine = new ArrayList<TrainerTerminverwaltungsBean>();
	
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT termin_id, kurzbeschreibung, ort, datum, beginn, ende FROM termine WHERE mannschaft=?")) { 

			pstmt.setString(1,team);																			
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					TrainerTerminverwaltungsBean termin = new TrainerTerminverwaltungsBean();
					
					Long id = Long.valueOf(rs.getLong("termin_id"));
					termin.setId(id);
					
					String kurzbeschreibung = rs.getString("kurzbeschreibung");
					termin.setKurzbeschreibung(kurzbeschreibung);
					
					String ort = rs.getString("ort");
					termin.setOrt(ort);
					
					Date datum = rs.getDate("datum");
					termin.setDatum(datum);
					
					LocalTime beginn = rs.getTime("beginn").toLocalTime();
					termin.setUhrzeitVON(beginn);
					
					LocalTime ende = rs.getTime("ende").toLocalTime();
					termin.setUhrzeitBIS(ende);
					
					termine.add(termin);
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return termine;
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
