package servlets;

import java.io.IOException;

import bean.loginbean;
import bean.registrierungsbean01;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogInServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		loginbean login = new loginbean();

		login.setAuswahl(request.getParameter("auswahl"));
		login.setEmail(request.getParameter("email"));
		login.setPasswort(request.getParameter("passwort"));
		
		if(login.getAuswahl()=="Spieler") {
			RequestDispatcher disp = request.getRequestDispatcher("jsps/SpielerHome.jsp");
			disp.forward(request, response);
		}
		else {
			RequestDispatcher disp = request.getRequestDispatcher("jsps/TrainerHome.jsp");
			disp.forward(request, response);
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
