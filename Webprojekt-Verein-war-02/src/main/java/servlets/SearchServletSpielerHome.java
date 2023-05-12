package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bean.TrainerHomeBean;
import bean.TrainerTerminverwaltungsBean;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


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
		
		
		
		// DB-Zugriff
		List<TrainerTerminverwaltungsBean> termine = searchTermine();
		List<TrainerHomeBean> nachrichten = searchNachrichten();
		
		// Scope "Request"
		request.setAttribute("termine", termine);					
		request.setAttribute("nachrichten", nachrichten);			
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./home/SpielerHome.jsp");
		dispatcher.forward(request, response);
	}

		
		private List<TrainerTerminverwaltungsBean> searchTermine() throws ServletException {
			List<TrainerTerminverwaltungsBean> termine = new ArrayList<TrainerTerminverwaltungsBean>();
			
			// DB-Zugriff
			try (Connection con = ds.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM termine WHERE trainer LIKE ?")) { //Hier noch Änderungen

				pstmt.setString(1,"");																			//Hier noch Änderungen
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
						
						Time beginn = rs.getTime("beginn");
						termin.setUhrzeitVON(beginn);
						
						Time ende = rs.getTime("ende");
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
	
		
		
		
		private List<TrainerHomeBean> searchNachrichten() throws ServletException {
			List<TrainerHomeBean> nachrichten = new ArrayList<TrainerHomeBean>();
			
			// DB-Zugriff
			try (Connection con = ds.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM termine WHERE trainer LIKE ?")) {	//Hier noch Änderungen

				pstmt.setString(1,"");																				//Hier noch Änderungen
				try (ResultSet rs = pstmt.executeQuery()) {
				
					while (rs.next()) {
						TrainerHomeBean nachricht = new TrainerHomeBean();
						
						Long id = Long.valueOf(rs.getLong("nachricht_id"));
						nachricht.setNachricht_id(id);
						
						String text = rs.getString("text");
						nachricht.setBeschreibung(text);
						
						Date datum = rs.getDate("tag");
						nachricht.setTag(datum);
//			trainer_ID?
						
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
