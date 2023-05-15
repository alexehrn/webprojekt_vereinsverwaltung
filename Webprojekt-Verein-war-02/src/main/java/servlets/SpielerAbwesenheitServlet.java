package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import bean.SpielerBean;
import bean.abwesenheitsbean;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SpielerAbwesenheitServlet
 */
@WebServlet("/SpielerAbwesenheitServlet")
public class SpielerAbwesenheitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
    /**
     * Default constructor. 
     */
    public SpielerAbwesenheitServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		
		
		//Spieler aus Session holen
		final HttpSession session = request.getSession();
		SpielerBean spieler = (SpielerBean) session.getAttribute("spieler");
		
		abwesenheitsbean abwesenheit = new abwesenheitsbean();
		
		abwesenheit.setGrund(request.getParameter("abwesenheit_eingabe"));
		abwesenheit.setStart(Date.valueOf(request.getParameter("startdatum")));
		abwesenheit.setEnde(Date.valueOf(request.getParameter("enddatum")));
		
		
		abwesenheitAnlegen(abwesenheit, spieler);
		
		
		session.setAttribute("abwesenheit", abwesenheit);
		
		response.sendRedirect("SearchServletSpielerHome"); 
	}

	
	
	private void abwesenheitAnlegen(abwesenheitsbean abwesenheit, SpielerBean spieler) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] {"abwesenheits_id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO abwesenheit (spieler, beschreibung, datum_von, datum_bis) VALUES (?,?,?,?)", 
					generatedKeys)){

		
			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setLong(1, spieler.getId());
			pstmt.setString(2, abwesenheit.getGrund());
			pstmt.setDate(3, abwesenheit.getStart()); 
			pstmt.setDate(4, abwesenheit.getEnde());   
			pstmt.executeUpdate();
			
			// Generierte(n) Schlüssel auslesen (funktioniert nur mit PreparedStatement)
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					abwesenheit.setId(rs.getLong(1));
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
