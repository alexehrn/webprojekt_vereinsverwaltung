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
 * Servlet implementation class TrainerTeamverwaltungSpielerSuche
 */
/* Alexander Ehrnstrasser: */
@WebServlet("/TrainerTeamverwaltungSpielerSuche")
public class TrainerTeamverwaltungSpielerSuche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
    /**
     * Default constructor. 
     */
    public TrainerTeamverwaltungSpielerSuche() {
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Nachname aus Request holen
			request.setCharacterEncoding("UTF-8");
			String nachname = request.getParameter("nachname");
		
			//Team aus Session holen
				HttpSession session = request.getSession();
				TrainerBean trainer = (TrainerBean) session.getAttribute("trainer");
				String team = trainer.getTeam();
			
				
				// DB-Zugriff
				List<SpielerBean> spielerliste = search(team, nachname);
						
				// Scope "Request"
				request.setAttribute("spielerliste", spielerliste);
				
				// Weiterleiten an JSP
				final RequestDispatcher dispatcher = request.getRequestDispatcher("home/TrainerHinzufuegenSpieler.jsp");
				dispatcher.forward(request, response);	
	}
	
	private List<SpielerBean> search(String team, String searchword) throws ServletException {
		searchword = (searchword == null || searchword == "") ? "%" : "%" + searchword + "%";
		List<SpielerBean> spielerliste = new ArrayList<SpielerBean>();
		
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM spieler WHERE (nachname LIKE ? AND mannschaft=? AND zugeordnet IS FALSE) OR (nachname LIKE ? AND mannschaft <> ?)")) {

			pstmt.setString(1, searchword);
			pstmt.setString(2, team);
			pstmt.setString(3, searchword);
			pstmt.setString(4, team);
			
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					SpielerBean spieler = new SpielerBean();
					
					Long id = Long.valueOf(rs.getLong("spieler_id"));
					spieler.setId(id);
					
					String vorname = rs.getString("vorname");
					spieler.setVorname(vorname);
					
					String nachname = rs.getString("nachname");
					spieler.setNachname(nachname);
					
					String mannschaft = rs.getString("mannschaft");
					spieler.setTeam(mannschaft);
					
					spielerliste.add(spieler);
				} // while rs.next()
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
