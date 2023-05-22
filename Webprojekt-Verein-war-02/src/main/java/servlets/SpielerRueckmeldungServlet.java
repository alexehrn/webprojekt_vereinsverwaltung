package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import bean.RueckmeldungsBean;
import bean.SpielerBean;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/SpielerRueckmeldungServlet")
public class SpielerRueckmeldungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
    public SpielerRueckmeldungServlet() {
    	super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		//Spieler aus Session holen
		HttpSession session = request.getSession();
		SpielerBean spieler = (SpielerBean) session.getAttribute("spieler");
		
		RueckmeldungsBean rueckmeldung = new RueckmeldungsBean();
		
		rueckmeldung.setRueckmeldung(request.getParameter("rueckmeldung"));
		Long terminId = Long.valueOf(request.getParameter("id"));
		
		
		
		//falls noch keine Rückmeldung gegeben wurde --> rueckmeldung == Keine Rückmeldung
		rueckmeldungAnlegen(rueckmeldung, spieler, terminId);
		
		session.setAttribute("rueckmeldung", rueckmeldung); //braucht man das?
		
		response.sendRedirect("SearchServletSpielerHome");
		
	}


	
	private void rueckmeldungAnlegen(RueckmeldungsBean rueckmeldung,SpielerBean spieler, Long terminId)  throws ServletException {
		
		// DB-Zugriff
		String[] generatedKeys = new String[] {"id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO rueckmeldung (spieler_id,termin_id, meldung) VALUES (?, ?, ?)", 
					generatedKeys)){


			// Zugriff über Klasse java.sql.PreparedStatement
				
			pstmt.setLong(1, spieler.getId());
			pstmt.setLong(2, terminId);
			pstmt.setString(3, rueckmeldung.getRueckmeldung());
			
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
