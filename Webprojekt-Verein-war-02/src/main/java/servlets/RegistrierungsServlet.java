package servlets;


import java.io.IOException;
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

/* Alexander Ehrnstrasser: */
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
		
		
		if (registerform.getAuswahl().equals("Spieler")) {
		Part filepart = request.getPart("image");
		registerform.setFilename(filepart.getSubmittedFileName());
		
		persistspieler(registerform, filepart);
		
		} else if (registerform.getAuswahl().equals("Trainer")) {
			
			persisttrainer(registerform);
		}
		
		
		
		
		final HttpSession session = request.getSession();
		session.setAttribute("registerform", registerform);
		
		response.sendRedirect("home/regerfolgreich.jsp");
		
	}

	private void persistspieler(registrierungsbean01 regbean, Part filepart) throws ServletException {
		
		
		
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
				pstmt.setString(6, regbean.getTeam());
				
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
	
private void persisttrainer(registrierungsbean01 regbean) throws ServletException {
		

			
			String[] generatedKeys = new String[] {"trainer_id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
			
			// DB-Zugriff
			try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
							"INSERT INTO trainer (vorname,nachname,email,passwort,mannschaft)" + 
							" VALUES (?,?,?,?,?)", generatedKeys)) {
				
				pstmt.setString(1, regbean.getVorname());
				pstmt.setString(2, regbean.getNachname());
				pstmt.setString(3, regbean.getEmail());
				pstmt.setString(4, regbean.getPasswort());
				pstmt.setString(5, regbean.getTeam());
				
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
	
	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
