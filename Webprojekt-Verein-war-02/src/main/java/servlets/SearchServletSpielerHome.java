package servlets;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;
import bean.TrainerHomeBean;
import bean.TrainerTerminverwaltungsBean;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SearchServletSpielerHome")
public class SearchServletSpielerHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
    public SearchServletSpielerHome() {
    	super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		
		String email = request.getParameter("email");
		String passwort = request.getParameter("passwort");
		
		// DB-Zugriff
		List<TrainerTerminverwaltungsBean> termine = searchTermine();
		List<TrainerHomeBean> nachrichten = searchNachrichten();
		
		// Scope "Request"
		request.setAttribute("termine", termine);					//Geht das?
		request.setAttribute("nachrichten", nachrichten);			//Geht das?
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./home/SpielerHome.jsp");
		dispatcher.forward(request, response);
	}

		
		private List<TrainerTerminverwaltungsBean> searchTermine() throws ServletException {
			List<TrainerTerminverwaltungsBean> termine = new ArrayList<TrainerTerminverwaltungsBean>();
		}
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
