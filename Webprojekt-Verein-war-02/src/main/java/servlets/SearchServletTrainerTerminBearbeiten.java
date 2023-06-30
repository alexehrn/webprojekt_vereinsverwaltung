//Fabian Wolfsteiner:
package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import javax.sql.DataSource;
import bean.TrainerTerminverwaltungsBean;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet zum Suchen der Termine für den Trainer
 */
@WebServlet("/SearchServletTrainerTerminBearbeiten")
public class SearchServletTrainerTerminBearbeiten extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//DB Anbindung
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

    
    public SearchServletTrainerTerminBearbeiten() {
       super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		
		
		Long id = Long.valueOf(request.getParameter("id"));
		
		
		// DB-Zugriff
		TrainerTerminverwaltungsBean termin = loadtermin(id);
		
		
		// Scope "Request"
		request.setAttribute("termin", termin);					
				
				
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./home/TrainerTerminbearbeiten.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private TrainerTerminverwaltungsBean loadtermin(Long id) throws ServletException {
		TrainerTerminverwaltungsBean termin = new TrainerTerminverwaltungsBean();
		termin.setId(id);
	
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM termine WHERE termin_id=?")) { 

			pstmt.setLong(1,id);		
			
			try (ResultSet rs = pstmt.executeQuery()) {
			
				if(rs != null && rs.next()) {
					
					String kurzbeschreibung = rs.getString("kurzbeschreibung");
					termin.setKurzbeschreibung(kurzbeschreibung);
					
					Date datum = rs.getDate("datum");
					termin.setDatum(datum);
					
					String ort = rs.getString("ort");
					termin.setOrt(ort);
					
					LocalTime beginn = rs.getTime("beginn").toLocalTime();
					termin.setUhrzeitVON(beginn);
					
					LocalTime ende = rs.getTime("ende").toLocalTime();
					termin.setUhrzeitBIS(ende);
					
					String beschreibung = rs.getString("beschreibung");
					termin.setBeschreibung(beschreibung);
		
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return termin;
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
