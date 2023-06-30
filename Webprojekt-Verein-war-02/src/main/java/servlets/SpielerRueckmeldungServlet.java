//Fabian Wolfsteiner:

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

	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	public SpielerRueckmeldungServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// Spieler aus Session holen
		HttpSession session = request.getSession();
		SpielerBean spieler = (SpielerBean) session.getAttribute("spieler");

		RueckmeldungsBean rueckmeldung = new RueckmeldungsBean();

		rueckmeldung.setRueckmeldung(request.getParameter("rueckmeldung"));
		Long terminId = Long.valueOf(request.getParameter("id"));

		// falls noch keine Rückmeldung gegeben wurde --> rueckmeldung == Keine Rückmeldung
		if (rueckmeldungVorhanden(spieler, terminId)) {
			rueckmeldungAktualisieren(rueckmeldung, spieler, terminId);
		} else {
			rueckmeldungAnlegen(rueckmeldung, spieler, terminId);
		}

	    session.setAttribute("rueckmeldung", rueckmeldung); 
		response.sendRedirect("SearchServletSpielerHome");

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

	private void rueckmeldungAnlegen(RueckmeldungsBean rueckmeldung, SpielerBean spieler, Long terminId)
			throws ServletException {

		// DB-Zugriff
		

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO rueckmeldung (spieler_id,termin_id, meldung) VALUES (?, ?, ?)")) {

			// Zugriff über Klasse java.sql.PreparedStatement

			pstmt.setLong(1, spieler.getId());
			pstmt.setLong(2, terminId);
			pstmt.setString(3, rueckmeldung.getRueckmeldung());
			
			

			pstmt.executeUpdate();

		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
