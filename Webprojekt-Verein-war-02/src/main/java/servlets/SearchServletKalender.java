//Alexander Ehrnstrasser:

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

import bean.KalenderItemBean;
import bean.SpielerBean;
import bean.TrainerBean;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * Servlet zum Suchen der Termine für den Kalender
 */
@WebServlet("/SearchServletKalender")
public class SearchServletKalender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
   
	
    public SearchServletKalender() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// Team des Trainers aus Session holen
		HttpSession session = request.getSession();
		
		Object trainerObj = session.getAttribute("trainer");
		Object spielerObj = session.getAttribute("spieler");

		if (trainerObj instanceof TrainerBean) {
		    TrainerBean trainer = (TrainerBean) trainerObj;
		    String team = trainer.getTeam();
		    List<KalenderItemBean> termine = searchtermine(team);
		    // Scope "Request"
			request.setAttribute("termine", termine);

			
			// Weiterleiten an JSP
			RequestDispatcher dispatcher = request.getRequestDispatcher("./home/javaskript/kalenderJSON.jsp");
			dispatcher.forward(request, response);
		} else if (spielerObj instanceof SpielerBean) {
		    SpielerBean spieler = (SpielerBean) spielerObj;
		    String team = spieler.getTeam();
		    List<KalenderItemBean> termine = searchtermine(team);
		    // Scope "Request"
			request.setAttribute("termine", termine);

			
			// Weiterleiten an JSP
			RequestDispatcher dispatcher = request.getRequestDispatcher("./home/javaskript/kalenderJSON.jsp");
			dispatcher.forward(request, response);
		}
		

	

	}

	private List<KalenderItemBean> searchtermine(String team) throws ServletException {
		List<KalenderItemBean> termine = new ArrayList<KalenderItemBean>();
	
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT termin_id, kurzbeschreibung, datum, beginn FROM termine WHERE mannschaft=? ORDER BY datum ASC, beginn ASC")) { 

			pstmt.setString(1,team);																			
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					KalenderItemBean termin = new KalenderItemBean();
					
					Long id = Long.valueOf(rs.getLong("termin_id"));
					termin.setId(id);
					
					String kurzbeschreibung = rs.getString("kurzbeschreibung");
					termin.setKurzbeschreibung(kurzbeschreibung);
					
					Date datum = rs.getDate("datum");
					termin.setDatum(datum);
					
					LocalTime beginn = rs.getTime("beginn").toLocalTime();
					termin.setUhrzeitVON(beginn);
					
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
