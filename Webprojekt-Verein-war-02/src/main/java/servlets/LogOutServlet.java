//Alexander Ehrnstrasser:

package servlets;

import java.io.IOException;

import bean.SpielerBean;
import bean.TrainerBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogOutServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		Object trainerObj = session.getAttribute("trainer");
		Object spielerObj = session.getAttribute("spieler");

		if (trainerObj instanceof TrainerBean) {
		    
		    session.removeAttribute("trainer");
			
			// Weiterleiten an JSP
		    RequestDispatcher disp = request.getRequestDispatcher("./index.jsp");
			disp.forward(request, response);
		} else if (spielerObj instanceof SpielerBean) {
		
		    session.removeAttribute("spieler");

			// Weiterleiten an JSP
		    RequestDispatcher disp = request.getRequestDispatcher("./index.jsp");
			disp.forward(request, response);
		} else  {
			//wenn Spieler noch nicht freigegeben ist
			RequestDispatcher disp = request.getRequestDispatcher("./index.jsp");
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
