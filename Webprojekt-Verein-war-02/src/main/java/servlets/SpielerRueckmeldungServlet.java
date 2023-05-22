package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import bean.RueckmeldungsBean;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SpielerRueckmeldungServlet
 */
@WebServlet("/SpielerRueckmeldungServlet")
public class SpielerRueckmeldungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
    public SpielerRueckmeldungServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		RueckmeldungsBean rueckmeldung = new RueckmeldungsBean();
		
		
		rueckmeldung.setRueckmeldung(Boolean.valueOf(request.getParameter("rueckmeldung")));
		
		persist(rueckmeldung);
		
		response.getWriter().append("Erfolgreich ").append(request.getParameter("rueckmeldung"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private void persist(RueckmeldungsBean rueckmeldung) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] {"id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
		
		try (Connection con = ds.getConnection();
			 /*final Statement stmt = con.createStatement()*/
			PreparedStatement pstmt = con.prepareStatement(
				
					"INSERT INTO rueckmeldung (spieler_id,termin_id, meldung) VALUES (1, ?, ?)", 
					generatedKeys)){

			// Zugriff über Klasse java.sql.Statement
/*			stmt.executeUpdate("INSERT INTO employees (first,last,age) VALUES ('" +
								form.getFirstname() + "','" +
								form.getLastname() + "','" +
								form.getAge() + "')"
					);
*/		
			// Zugriff über Klasse java.sql.PreparedStatement
		
			pstmt.setBoolean(2, rueckmeldung.isRueckmeldung());
			
			
			
			pstmt.executeUpdate();
			
			
			// Generierte(n) Schlüssel auslesen (funktioniert nur mit PreparedStatement)
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				int i = 1;
				while (rs.next()) {
					rueckmeldung.setId(rs.getLong(i));
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
