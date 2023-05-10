package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import bean.registrierungsbean01;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class RegistrierungsServlet
 */
@WebServlet("/RegistrierungsServlet")
@MultipartConfig( 
		maxFileSize=1024*1024*5, 
		maxRequestSize=1024*1024*5*5,
		location= "/tmp",
		fileSizeThreshold=1024*1024)

public class RegistrierungsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

   
    public RegistrierungsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		registrierungsbean01 registerform = new registrierungsbean01();

		registerform.setAuswahl(request.getParameter("auswahl"));
		registerform.setVorname(request.getParameter("vorname"));
		registerform.setNachname(request.getParameter("nachname"));
		registerform.setPasswort(request.getParameter("passwort"));
		registerform.setEmail(request.getParameter("email"));
		registerform.setTeam(request.getParameter("team"));
		

		// Filebehandlung
		Part filepart = request.getPart("image");
		registerform.setFilename(filepart.getSubmittedFileName());
		
		persist(registerform, filepart);
		
		final HttpSession session = request.getSession();
		session.setAttribute("registerform", registerform);
		
		response.sendRedirect("home/regerfolgreich.jsp");
		
	}

	private void persist(registrierungsbean01 regbean, Part filepart) throws ServletException {
		
		
		if(regbean.getAuswahl().equals("Spieler")) {
		
			String[] generatedKeys = new String[] {"spieler_id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
			
			// DB-Zugriff
			try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
							"INSERT INTO spieler (vorname,nachname,spielerfoto,email,passwort,mannschaft, zugeordnet)" + 
							" VALUES (?,?,?,?,?,?, FALSE)", generatedKeys)) {
				
				pstmt.setString(1, regbean.getVorname());
				pstmt.setString(2, regbean.getNachname());
				pstmt.setBinaryStream(3, filepart.getInputStream());
				pstmt.setString(4, regbean.getEmail());
				pstmt.setString(5, regbean.getPasswort());
				pstmt.setInt(6, getTeamID(regbean.getTeam()));
				
				pstmt.executeUpdate();
				
				
				// Generierte(n) Schlüssel auslesen (funktioniert nur mit PreparedStatement)
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					while (rs.next()) {
						regbean.setId(rs.getLong(1));
						}
				}
				
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
			
		} else if (regbean.getAuswahl().equals("Trainer")) {
			
			String[] generatedKeys = new String[] {"trainer_id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
			
			// DB-Zugriff
			try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
							"INSERT INTO trainer (vorname,nachname,trainerfoto,email,passwort,mannschaft)" + 
							" VALUES (?,?,?,?,?,?)", generatedKeys)) {
				
				pstmt.setString(1, regbean.getVorname());
				pstmt.setString(2, regbean.getNachname());
				pstmt.setBinaryStream(3, filepart.getInputStream());
				pstmt.setString(4, regbean.getEmail());
				pstmt.setString(5, regbean.getPasswort());
				pstmt.setInt(6, getTeamID(regbean.getTeam()));
				
				pstmt.executeUpdate();
				
				
				// Generierte(n) Schlüssel auslesen (funktioniert nur mit PreparedStatement)
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					while (rs.next()) {
						regbean.setId(rs.getLong(1));
						}
				}
				
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}			
		}
		
		
	}
	
	
	private int getTeamID(String team) {
		int erg=0;
		
		switch(team) {
		case "1. Mannschaft":
			erg=1;
			break;
		case "2. Mannschaft":
			erg=2;
			break;
		case "A-Jugend":
			erg=3;
			break;
		case "B-Jugend":
			erg=4;
			break;
		case "C-Jugend":
			erg=5;
			break;
		case "D-Jugend":
			erg=6;
			break;
		case "E-Jugend":
			erg=7;
			break;
		case "F-Jugend":
			erg=8;
			break;
		case "G-Jugend":
			erg=9;
			break;
		}
		return erg;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
