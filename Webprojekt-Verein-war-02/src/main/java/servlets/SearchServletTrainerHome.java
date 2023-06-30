//Fabian Wolfsteiner:

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

/*
 * Servlet zum Suchen der Daten für die TrainerHome-Seite
 */

@WebServlet("/SearchServletTrainerHome")
public class SearchServletTrainerHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
 
	
	public SearchServletTrainerHome() {
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// Team des Trainers aus Session holen
		final HttpSession session = request.getSession();
		TrainerBean trainer = (TrainerBean) session.getAttribute("trainer");
		String team = trainer.getTeam();

		// DB-Zugriff
		List<abwesenheitsbean> abwesenheiten = searchAbwesenheiten(team);
		List<RueckmeldungsBean> rueckmeldungen = searchRueckmeldung(team);
		String spielerzahl = countPlayers(team);
		
		// Scope "Request"
		request.setAttribute("abwesenheit", abwesenheiten);
		request.setAttribute("rueckmeldung", rueckmeldungen);
		request.setAttribute("spielerzahl", spielerzahl);
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./home/TrainerHome.jsp");
		dispatcher.forward(request, response);

	}

	private String countPlayers(String team) throws ServletException {
	    String spieleranzahl;

	    // DB-Zugriff
	    try (Connection con = ds.getConnection();
	         PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(*) AS anzahl FROM spieler WHERE mannschaft=? AND zugeordnet = TRUE")) {

	        pstmt.setString(1, team);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                spieleranzahl = rs.getString("anzahl");
	            } else {
	                spieleranzahl = "0";
	            }
	        }
	    } catch (Exception ex) {
	        throw new ServletException(ex.getMessage());
	    }

	    return spieleranzahl;
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
					abwesenheit.setStartyear(startdatum);
					abwesenheit.setStartmonth(startdatum);
					abwesenheit.setStartday(startdatum);
					
					Date enddatum = rs.getDate("datum_bis");
					abwesenheit.setEnde(enddatum);
					abwesenheit.setEndeyear(enddatum);
					abwesenheit.setEndemonth(enddatum);
					abwesenheit.setEndeday(enddatum);
					
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
			
			try (Connection con = ds.getConnection();
					 PreparedStatement pstmt = con.prepareStatement("SELECT termine.kurzbeschreibung, termine.kategorie, termine.datum,\r\n"
					 		+ "       IFNULL(SUM(CASE WHEN rueckmeldung.meldung = 'Zugesagt' THEN 1 ELSE 0 END), 0) AS anzahlzusagen,\r\n" //IFNULL: Wenn keine Rückmeldungen vorhanden sind (d.h. Ergbenis=NULL) wird 0 als anzahlzusagen eingefügt
					 		+ "       IFNULL(SUM(CASE WHEN rueckmeldung.meldung = 'Abgesagt' THEN 1 ELSE 0 END), 0) AS anzahlabsagen\r\n"  //IFNULL: Wenn keine Rückmeldungen vorhanden sind (d.h. Ergbenis=NULL) wird 0 als anzahlabsagen eingefügt
					 		+ "FROM termine\r\n"
					 		+ "LEFT JOIN rueckmeldung ON (termine.termin_id = rueckmeldung.termin_id)\r\n"
					 		+ "WHERE termine.mannschaft = ? AND termine.datum >= CURRENT_DATE\r\n"
					 		+ "GROUP BY termine.kurzbeschreibung, termine.datum\r\n"
					 		+ "ORDER BY termine.datum ASC;")) {

			pstmt.setString(1,team);																			
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					RueckmeldungsBean rueckmeldung = new RueckmeldungsBean();
					
					String beschreibung = rs.getString("kurzbeschreibung");
					rueckmeldung.setBeschreibung(beschreibung);
					
					String kategorie = rs.getString("kategorie");
					rueckmeldung.setKategorie(kategorie);
					
					Date datum = rs.getDate("datum");
					rueckmeldung.setDatum(datum);
					rueckmeldung.setYear(datum);
					rueckmeldung.setMonth(datum);
					rueckmeldung.setDay(datum);
					
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
