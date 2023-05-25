package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

import javax.sql.DataSource;

import bean.RueckmeldungsBean;
import bean.SpielerBean;
import bean.TrainerHomeBean;
import bean.TrainerTerminverwaltungsBean;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/SearchServletSpielerHome")
public class SearchServletSpielerHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
    public SearchServletSpielerHome() {
    	super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		
		//Team des Spielers aus Session holen
		HttpSession session = request.getSession();
		SpielerBean spieler = (SpielerBean) session.getAttribute("spieler");
		String team = spieler.getTeam();
		
		//Rückmeldung Anlegen/Aktualisieren
		RueckmeldungsBean rueckmeldung = new RueckmeldungsBean();
		rueckmeldung.setRueckmeldung(request.getParameter("rueckmeldung"));
		Long terminId = Long.valueOf(request.getParameter("id"));
				
				// falls noch keine Rückmeldung gegeben wurde --> rueckmeldung == Keine Rückmeldung
						if (rueckmeldungVorhanden(spieler, terminId)) {
							rueckmeldungAktualisieren(rueckmeldung, spieler, terminId);
						} else {
							rueckmeldungAnlegen(spieler, terminId);
						}
		
		
		
		// DB-Zugriff
		List<TrainerTerminverwaltungsBean> termine = searchTermine(team, spieler);
		List<TrainerHomeBean> nachrichten = searchNachrichten(team);
			
		
		// Scope "Request"
		request.setAttribute("termine", termine);					
		request.setAttribute("nachrichten", nachrichten);			
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./home/SpielerHome.jsp");
		dispatcher.forward(request, response);
	}

	
		
		private List<TrainerTerminverwaltungsBean> searchTermine(String team, SpielerBean spieler) throws ServletException {
			List<TrainerTerminverwaltungsBean> termine = new ArrayList<TrainerTerminverwaltungsBean>();
		
			// DB-Zugriff
			try (Connection con = ds.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM termine NATURAL JOIN rueckmeldung WHERE termine.mannschaft = ? AND rueckmeldung.spieler_id =? AND termine.datum > CURDATE();")) { 

				
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
						
						String beschreibung = rs.getString("beschreibung");
						termin.setBeschreibung(beschreibung);
						
						String rueckmeldung = rs.getString("meldung");
						termin.setRueckmeldung(rueckmeldung);
						
						termine.add(termin);
					}
				}
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
			
			return termine;
		}
	
		
		
		
		private List<TrainerHomeBean> searchNachrichten(String team) throws ServletException {
			List<TrainerHomeBean> nachrichten = new ArrayList<TrainerHomeBean>();
			
			// DB-Zugriff
			try (Connection con = ds.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM nachricht WHERE mannschaft = ? AND tag >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) ORDER BY tag DESC")) { //tag >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) --> ChatGPT	

				pstmt.setString(1,team);																				
				try (ResultSet rs = pstmt.executeQuery()) {
				
					while (rs.next()) {
						TrainerHomeBean nachricht = new TrainerHomeBean();
						
						Long id = Long.valueOf(rs.getLong("nachricht_id"));
						nachricht.setNachricht_id(id);
						
						String text = rs.getString("text");
						nachricht.setBeschreibung(text);
						
						Date datum = rs.getDate("tag");
						nachricht.setTag(datum);

						
						nachrichten.add(nachricht);
					}
				}
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
			
			
			return nachrichten;
		}
	
	
		private boolean rueckmeldungVorhanden(SpielerBean spieler, Long terminId) throws ServletException {

			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con
							.prepareStatement("SELECT * FROM rueckmeldung WHERE spieler_id=? AND termin_id=?")) {

				// Zugriff über Klasse java.sql.PreparedStatement
				pstmt.setLong(1, spieler.getId());
				pstmt.setLong(2, terminId);

				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				}
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
		}

		private void rueckmeldungAktualisieren(RueckmeldungsBean rueckmeldung, SpielerBean spieler, Long terminId)
				throws ServletException {

			// DB-Zugriff
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con
							.prepareStatement("Update rueckmeldung SET meldung=? WHERE spieler_id=? AND termin_id=?")) {

				// Zugriff über Klasse java.sql.PreparedStatement
				pstmt.setString(1, rueckmeldung.getRueckmeldung());
				pstmt.setLong(2, spieler.getId());
				pstmt.setLong(3, terminId);

				pstmt.executeUpdate();

			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
		}

		private void rueckmeldungAnlegen(SpielerBean spieler, Long terminId)
				throws ServletException {

			// DB-Zugriff
			

			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(
							"INSERT INTO rueckmeldung (spieler_id,termin_id, meldung) VALUES (?, ?, 'Keine Rückmeldung')")) {

				// Zugriff über Klasse java.sql.PreparedStatement

				pstmt.setLong(1, spieler.getId());
				pstmt.setLong(2, terminId);
				
				

				pstmt.executeUpdate();

			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
		}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
