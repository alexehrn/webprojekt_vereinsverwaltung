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
 * Servlet zum Suchen der Daten für SpielerHome-Seite
 */

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
		
		
		
		
		// DB-Zugriff
		List<TrainerTerminverwaltungsBean> termine = searchTermine(team, spieler);
		List<TrainerHomeBean> nachrichten = searchNachrichten(team);
		List<abwesenheitsbean> abwesenheiten = searchAbwesenheiten(spieler);
		
		// Scope "Request"
		request.setAttribute("termine", termine);
		request.setAttribute("abwesenheiten", abwesenheiten);
		request.setAttribute("nachrichten", nachrichten);			
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./home/SpielerHome.jsp");
		dispatcher.forward(request, response);
	}

	
		
		private List<TrainerTerminverwaltungsBean> searchTermine(String team, SpielerBean spieler) throws ServletException {
			List<TrainerTerminverwaltungsBean> termine = new ArrayList<TrainerTerminverwaltungsBean>();
		
			// DB-Zugriff
			try (Connection con = ds.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("SELECT *\r\n"
				 		+ "FROM termine\r\n"
				 		+ "LEFT OUTER JOIN rueckmeldung ON termine.termin_id = rueckmeldung.termin_id AND rueckmeldung.spieler_id = ?\r\n"
				 		+ "WHERE termine.mannschaft = ? AND (rueckmeldung.spieler_id = ? OR rueckmeldung.spieler_id IS NULL) AND termine.datum >= CURDATE() ORDER BY termine.datum ASC;")) { 

				
				pstmt.setLong(1, spieler.getId());
				pstmt.setString(2,team);
				pstmt.setLong(3, spieler.getId());
				
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
	
		private List<abwesenheitsbean> searchAbwesenheiten(SpielerBean spieler) throws ServletException {
			List<abwesenheitsbean> abwesenheiten = new ArrayList<abwesenheitsbean>();
			// DB-Zugriff
						try (Connection con = ds.getConnection();
							 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM abwesenheit WHERE spieler = ? AND datum_bis >= CURRENT_DATE() ORDER BY datum_bis ASC, datum_von ASC;")) { 

							pstmt.setLong(1,spieler.getId());																				
							try (ResultSet rs = pstmt.executeQuery()) {
							
								while (rs.next()) {
									abwesenheitsbean abwesenheit = new abwesenheitsbean();
									
									Long id = Long.valueOf(rs.getLong("abwesenheits_id"));
									abwesenheit.setId(id);
									
									String grund = rs.getString("beschreibung");
									abwesenheit.setGrund(grund);
									
									Date datum_von = rs.getDate("datum_von");
									abwesenheit.setStart(datum_von);

									Date datum_bis = rs.getDate("datum_bis");
									abwesenheit.setEnde(datum_bis);
									
									abwesenheiten.add(abwesenheit);
								}
							}
						} catch (Exception ex) {
							throw new ServletException(ex.getMessage());
						}
						
						
						return abwesenheiten;
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
	
	
		
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
