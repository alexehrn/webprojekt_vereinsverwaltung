package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

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
 * Servlet implementation class TrainerTeamverwaltungSpielerHinzufuegen
 */
/* Alexander Ehrnstrasser: */
@WebServlet("/TrainerTeamverwaltungSpielerHinzufuegen")
public class TrainerTeamverwaltungSpielerHinzufuegen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	

	
    /**
     * Default constructor. 
     */
    public TrainerTeamverwaltungSpielerHinzufuegen() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		Long id = Long.valueOf(request.getParameter("id"));
		
		//Team aus Session holen
		HttpSession session = request.getSession();
		TrainerBean trainer = (TrainerBean) session.getAttribute("trainer");
		String team = trainer.getTeam();
		
		
		
		// DB-Zugriff
		addPlayer(id, team);
		//upadteAbwesenheit(id, team);
				
		// Weiterleiten an JSP
		response.sendRedirect("./TrainerTeamverwaltungSearch");	
	}
	
	private void addPlayer(Long id, String team) throws ServletException {
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			     PreparedStatement pstmt = con.prepareStatement("UPDATE spieler SET zugeordnet = TRUE, mannschaft= ? WHERE spieler_id = ?")) {
				
				pstmt.setString(1, team);
				pstmt.setLong(2,id);
				pstmt.executeUpdate();
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
	}
	
/*	private void upadteAbwesenheit(Long id, String team) throws ServletException {
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			     PreparedStatement pstmt = con.prepareStatement("UPDATE abwesenheit SET mannschaft= ? WHERE spieler = ?")) {
				
				pstmt.setString(1, team);
				pstmt.setLong(2,id);
				pstmt.executeUpdate();
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
