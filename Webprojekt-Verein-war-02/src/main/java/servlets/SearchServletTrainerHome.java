package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bean.RueckmeldungsBean;
import bean.TrainerBean;
import bean.abwesenheitsbean;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchServletAbwesenheit
 */
@WebServlet("/SearchServletTrainerHome")
public class SearchServletTrainerHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
 
	/**
	 * Default constructor.
	 */
	public SearchServletTrainerHome() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// Team des Trainers aus Session holen
		final HttpSession session = request.getSession();
		TrainerBean trainer = (TrainerBean) session.getAttribute("trainer");
		String team = trainer.getTeam();

		// DB-Zugriff
		List<abwesenheitsbean> abwesenheiten = searchAbwesenheiten(team);
		List<RueckmeldungsBean> rueckmeldungen = searchRueckmeldung(team);
		
		// Scope "Request"
		request.setAttribute("abwesenheit", abwesenheiten);
		request.setAttribute("rueckmeldung", rueckmeldungen);
		
		// Weiterleiten an JSP
		//final RequestDispatcher dispatcher = request.getRequestDispatcher("/Webprojekt-Verein-war-02/TrainerHomeServlet");
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./home/TrainerHome.jsp");
		dispatcher.forward(request, response);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private List<abwesenheitsbean> searchAbwesenheiten(String team) throws ServletException {
		List<abwesenheitsbean> abwesenheiten = new ArrayList<abwesenheitsbean>();
	
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT abwesenheit.abwesenheits_id, spieler.vorname, spieler.nachname, abwesenheit.datum_von, abwesenheit.datum_bis, abwesenheit.beschreibung FROM abwesenheit INNER JOIN spieler ON (abwesenheit.spieler = spieler.spieler_id) WHERE abwesenheit.mannschaft=? && abwesenheit.datum_bis >= CURRENT_DATE ORDER BY abwesenheit.datum_bis ASC, abwesenheit.datum_von ASC")) { 

			pstmt.setString(1,team);																			
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					abwesenheitsbean abwesenheit = new abwesenheitsbean();
					
					Long id = Long.valueOf(rs.getLong("abwesenheits_id"));
					abwesenheit.setId(id);
					
					String beschreibung = rs.getString("beschreibung");
					abwesenheit.setGrund(beschreibung);
					
					String vorname = rs.getString("vorname");
					abwesenheit.setVorname(vorname);
					
					String nachname = rs.getString("nachname");
					abwesenheit.setNachname(nachname);
					
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
	
	private List<RueckmeldungsBean> searchRueckmeldung(String team) throws ServletException {
		List<RueckmeldungsBean> rueckmeldungen = new ArrayList<RueckmeldungsBean>();
	
		
		// Das SQL Statement ist aus Chat-GPT
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT termine.kurzbeschreibung, termine.datum,\r\n"
			 		+ "       SUM(CASE WHEN rueckmeldung.meldung = 'Zugesagt' THEN 1 ELSE 0 END) AS anzahlzusagen,\r\n"
			 		+ "       SUM(CASE WHEN rueckmeldung.meldung = 'Abgesagt' THEN 1 ELSE 0 END) AS anzahlabsagen\r\n"
			 		+ "FROM termine\r\n"
			 		+ "INNER JOIN rueckmeldung ON (termine.termin_id = rueckmeldung.termin_id)\r\n"
			 		+ "WHERE termine.mannschaft = ? AND termine.datum >= CURRENT_DATE\r\n"
			 		+ "GROUP BY termine.kurzbeschreibung, termine.datum\r\n"
			 		+ "ORDER BY termine.datum ASC;")) { 

			pstmt.setString(1,team);																			
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					RueckmeldungsBean rueckmeldung = new RueckmeldungsBean();
					
					String beschreibung = rs.getString("kurzbeschreibung");
					rueckmeldung.setBeschreibung(beschreibung);
					
					Date datum = rs.getDate("datum");
					rueckmeldung.setDatum(datum);
					
					Long zusagen = rs.getLong("anzahlzusagen");
					rueckmeldung.setZusagen(zusagen);
					
					Long absagen = rs.getLong("anzahlabsagen");
					rueckmeldung.setAbsagen(absagen);
					
					rueckmeldungen.add(rueckmeldung);
					
					
					
			
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return rueckmeldungen;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
