package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import bean.SpielerBean;
import bean.TrainerBean;
import bean.registrierungsbean01;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogInServlet
 */

/* Alexander Ehrnstrasser: */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    /**
     * Default constructor. 
     */
    public LogInServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String email = String.valueOf(request.getParameter("email"));
		String pw = String.valueOf(request.getParameter("passwort"));
		String auswahl = String.valueOf(request.getParameter("auswahl"));
		

			
		
		if (check(auswahl, email, pw)==true) {
			
			if(auswahl.equals("Spieler")){
				
				// DB-Zugriff
				SpielerBean spieler=readspieler(email);
								
				// Scope "Session"
				HttpSession session = request.getSession();
				session.setAttribute("spieler", spieler);
				
				RequestDispatcher disp = request.getRequestDispatcher("SearchServletSpielerHome");
				disp.forward(request, response);
				
			}else if (auswahl.equals("Trainer")) {
				// DB-Zugriff
				TrainerBean trainer=readtrainer(email);
								
				// Scope "Session"
				HttpSession session = request.getSession();
				session.setAttribute("trainer", trainer);
				
				RequestDispatcher disp = request.getRequestDispatcher("SearchServletTrainerHome");
				disp.forward(request, response);
			}
			
			
		} else {
			//Fehlermeldung Java-Skript?????
			//Fehlermeldung Java-Skript?????
			//Fehlermeldung Java-Skript?????
			//Fehlermeldung Java-Skript?????
			//Fehlermeldung Java-Skript?????
			//Fehlermeldung Java-Skript?????
			//Fehlermeldung Java-Skript?????
			
		}
		
		
	
	}
	
	
	
	
	
	private boolean check(String auswahl, String email, String passwort) throws ServletException{
		// DB-Zugriff
		boolean result = false;
		ResultSet rs = null;
		
		if(auswahl.equals("Spieler")) {
		
				try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement("SELECT * FROM spieler WHERE email = ? AND passwort= ?")) {
					
					pstmt.setString(1, email);
					pstmt.setString(2, passwort);
					
		            // Abfrage ausführen und Ergebnis prüfen
					rs = pstmt.executeQuery();
					if (rs.next()) {
						result = true;
					}
					
					
				} catch (Exception ex) {
					throw new ServletException(ex.getMessage());
				}
				
				
				
		}else if(auswahl.equals("Trainer")) {
			
			try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM trainer WHERE email = ? AND passwort= ?")) {
				
				pstmt.setString(1, email);
				pstmt.setString(2, passwort);
				
	            // Abfrage ausführen und Ergebnis prüfen
				rs = pstmt.executeQuery();
				if (rs.next()) {
					result = true;
				}
				
				
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
			
			
			
	}
		return result;
	}
	
	
	
	
	
	private SpielerBean readspieler(String email) throws ServletException {
		SpielerBean spieler = new SpielerBean();

		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM spieler WHERE email = ?")) {
			pstmt.setString(1, email);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {
					spieler.setId(Long.valueOf(rs.getLong("spieler_id")));
					spieler.setEmail(rs.getString("email"));
					spieler.setTeam(rs.getString("mannschaft"));		
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return spieler;
	}
	
	private TrainerBean readtrainer(String email) throws ServletException {
		TrainerBean trainer = new TrainerBean();

		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM trainer WHERE email = ?")) {
			pstmt.setString(1, email);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {
					trainer.setId(Long.valueOf(rs.getLong("trainer_id")));
					trainer.setEmail(rs.getString("email"));
					trainer.setTeam(rs.getString("mannschaft"));		
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return trainer;
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}