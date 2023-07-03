//Fabian Wolfsteiner:

package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import bean.TrainerBean;
import bean.terminkategorie;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class TrainerKategorieAnlegen
 */
@WebServlet("/TrainerKategorieAnlegen")
public class TrainerKategorieAnlegen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//DB Anbindung
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

    /**
     * Default constructor. 
     */
    public TrainerKategorieAnlegen() {
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
		
		terminkategorie neueKategorie = new terminkategorie();
		
		neueKategorie.setKategorie(request.getParameter("kategorie"));
		neueKategorie.setMannschaft(team);
		
		kategorieAnlegen(neueKategorie);
		
		response.sendRedirect("/Webprojekt-Verein-war-02/SearchServletTrainerTerminverwaltung");
		
		
	}

	private void kategorieAnlegen(terminkategorie neueKategorie) throws ServletException{
		
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO kategorien (Kategorie, Mannschaft) VALUES (?, ?)")){
			
			pstmt.setString(1, neueKategorie.getKategorie());
			pstmt.setString(2, neueKategorie.getMannschaft());
		
			
			
			pstmt.executeUpdate();
			
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
