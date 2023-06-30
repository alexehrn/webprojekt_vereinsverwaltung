//Alexander Ehrnstrasser:
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bean.SpielerBean;
import bean.TrainerBean;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class TrainerTeamverwaltungSearch
 */

@WebServlet("/TrainerTeamverwaltungSearch")
public class TrainerTeamverwaltungSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
    
	
    public TrainerTeamverwaltungSearch() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//Team aus Session holen
		HttpSession session = request.getSession();
		TrainerBean trainer = (TrainerBean) session.getAttribute("trainer");
		String team = trainer.getTeam();
		
		// DB-Zugriff
		List<SpielerBean> spielerliste = search(team);
				
		// Scope "Request"
		request.setAttribute("spielerliste", spielerliste);
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("home/TrainerTeamverwaltung.jsp");
		dispatcher.forward(request, response);	
	}

	
	private List<SpielerBean> search(String team) throws ServletException {
		List<SpielerBean> spielerliste = new ArrayList<SpielerBean>();
		
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM spieler WHERE mannschaft = ? AND zugeordnet IS TRUE")) {

			pstmt.setString(1, team);
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					SpielerBean spieler = new SpielerBean();
					
					Long id=Long.valueOf(rs.getLong("spieler_id"));
					spieler.setId(id);
					
					String vorname = rs.getString("vorname");
					spieler.setVorname(vorname);
					
					String nachname = rs.getString("nachname");
					spieler.setNachname(nachname);
					
					spielerliste.add(spieler);
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return spielerliste;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
