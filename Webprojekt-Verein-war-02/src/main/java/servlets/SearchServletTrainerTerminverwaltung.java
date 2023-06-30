//Fabian Wolfsteiner:

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
import bean.TrainerBean;
import bean.TrainerTerminverwaltungsBean;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet zum Suchen der Termine für den Trainer
 */
@WebServlet("/SearchServletTrainerTerminverwaltung")
public class SearchServletTrainerTerminverwaltung extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//DB Anbindung
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

    
    public SearchServletTrainerTerminverwaltung() {
       super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		
		//Team des Trainers aus Session holen
		HttpSession session = request.getSession();
		TrainerBean trainer = (TrainerBean) session.getAttribute("trainer");
		String team = trainer.getTeam();

		
		// DB-Zugriff
		List<TrainerTerminverwaltungsBean> termine = searchTermine(team);
		
		
		// Scope "Request"
		request.setAttribute("termine", termine);					
				
				
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./home/TrainerTerminverwaltung.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private List<TrainerTerminverwaltungsBean> searchTermine(String team) throws ServletException {
		List<TrainerTerminverwaltungsBean> termine = new ArrayList<TrainerTerminverwaltungsBean>();
	
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM termine WHERE mannschaft=? && datum >= CURRENT_DATE ORDER BY datum ASC, ende ASC, beginn ASC")) { 

			pstmt.setString(1,team);																			
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					TrainerTerminverwaltungsBean termin = new TrainerTerminverwaltungsBean();
					
					Long id = Long.valueOf(rs.getLong("termin_id"));
					termin.setId(id);
					
					String kurzbeschreibung = rs.getString("kurzbeschreibung");
					termin.setKurzbeschreibung(kurzbeschreibung);
					
					Date datum = rs.getDate("datum");
					termin.setDatum(datum);
					termin.setYear(datum);
					termin.setMonth(datum);
					termin.setDay(datum);
					
					String ort = rs.getString("ort");
					termin.setOrt(ort);
					
					LocalTime beginn = rs.getTime("beginn").toLocalTime();
					termin.setUhrzeitVON(beginn);
					
					LocalTime ende = rs.getTime("ende").toLocalTime();
					termin.setUhrzeitBIS(ende);
					
					String beschreibung = rs.getString("beschreibung");
					termin.setBeschreibung(beschreibung);
					
					termine.add(termin);
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return termine;
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
