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
import bean.TrainerHomeBean;
import bean.TrainerTerminverwaltungsBean;
import bean.abwesenheitsbean;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import bean.SpielerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServletTrainerTerminverwaltung
 */
@WebServlet("/SearchServletTrainerTerminverwaltung")
public class SearchServletTrainerTerminverwaltung extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//DB Anbindung
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

    /**
     * Default constructor. 
     */
    public SearchServletTrainerTerminverwaltung() {
       super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		
		//Team des Trainers aus Session holen
		HttpSession session = request.getSession();
		TrainerBean trainer = (TrainerBean) session.getAttribute("trainer");
		String team = trainer.getTeam();

		
		// DB-Zugriff
		List<abwesenheitsbean> abwesenheiten = searchAbwesenheiten(team);
		
		
		// Scope "Request"
		request.setAttribute("abwesenheiten", abwesenheiten);					
				
				
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./home/TrainerTerminverwaltung.jsp");
		dispatcher.forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	private List<abwesenheitsbean> searchAbwesenheiten(String team) throws ServletException {
		List<abwesenheitsbean> abwesenheiten = new ArrayList<abwesenheitsbean>();
	
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM abwesenheit WHERE mannschaft=?")) { 

			pstmt.setString(1,team);																			
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					abwesenheitsbean abwesenheit = new abwesenheitsbean();
					
					Long id = Long.valueOf(rs.getLong("abwesenheits_id"));
					abwesenheit.setId(id);
					
					String beschreibung = rs.getString("beschreibung");
					abwesenheit.setGrund(beschreibung);
					
					Date startdatum = rs.getDate("datum_von");
					abwesenheit.setStart(startdatum);
					
					Date enddatum = rs.getDate("datum_bis");
					abwesenheit.setEnde(enddatum);
					
					abwesenheiten.add(abwesenheit);
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return abwesenheiten;
	}

	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
