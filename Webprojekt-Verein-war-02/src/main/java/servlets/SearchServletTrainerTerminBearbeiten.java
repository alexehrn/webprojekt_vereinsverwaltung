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
import bean.terminkategorie;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet zum Suchen der Termine für den Trainer
 */
@WebServlet("/SearchServletTrainerTerminBearbeiten")
public class SearchServletTrainerTerminBearbeiten extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//DB Anbindung
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

    
    public SearchServletTrainerTerminBearbeiten() {
       super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		//Team des Trainers aus Session holen
		HttpSession session = request.getSession();
		TrainerBean trainer = (TrainerBean) session.getAttribute("trainer");
		String team = trainer.getTeam();
		
		
		Long id = Long.valueOf(request.getParameter("id"));
		
		
		// DB-Zugriff
		TrainerTerminverwaltungsBean termin = loadtermin(id);
		List<terminkategorie> kategorien = searchKategorien(team);
		
		
		// Scope "Request"
		request.setAttribute("termin", termin);		
		request.setAttribute("kategorien", kategorien);	
				
				
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./home/TrainerTerminbearbeiten.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private List<terminkategorie> searchKategorien(String team) throws ServletException{
		List<terminkategorie> kategorien = new ArrayList<terminkategorie>();
		
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM kategorien WHERE Mannschaft=? OR Mannschaft='all'")) { 

			pstmt.setString(1,team);
			
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					terminkategorie kategorie = new terminkategorie();
					
					String kurzbeschreibung = rs.getString("Kategorie");
					kategorie.setKategorie(kurzbeschreibung);
					
					String mannschaft = rs.getString("Mannschaft");
					kategorie.setMannschaft(mannschaft);
					
					kategorien.add(kategorie);
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return kategorien;
	}
	
	private TrainerTerminverwaltungsBean loadtermin(Long id) throws ServletException {
		TrainerTerminverwaltungsBean termin = new TrainerTerminverwaltungsBean();
		termin.setId(id);
	
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM termine WHERE termin_id=?")) { 

			pstmt.setLong(1,id);		
			
			try (ResultSet rs = pstmt.executeQuery()) {
			
				if(rs != null && rs.next()) {
					
					String kurzbeschreibung = rs.getString("kurzbeschreibung");
					termin.setKurzbeschreibung(kurzbeschreibung);
					
					String kategorie =rs.getString("kategorie");
					termin.setKategorie(kategorie);
					
					Date datum = rs.getDate("datum");
					termin.setDatum(datum);
					
					String ort = rs.getString("ort");
					termin.setOrt(ort);
					
					LocalTime beginn = rs.getTime("beginn").toLocalTime();
					termin.setUhrzeitVON(beginn);
					
					LocalTime ende = rs.getTime("ende").toLocalTime();
					termin.setUhrzeitBIS(ende);
					
					String beschreibung = rs.getString("beschreibung");
					termin.setBeschreibung(beschreibung);
		
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return termin;
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
