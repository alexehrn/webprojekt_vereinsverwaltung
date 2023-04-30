package servlets;

import java.io.IOException;

import bean.abwesenheitsbean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SpielerAbwesenheitServlet
 */
@WebServlet("/SpielerAbwesenheitServlet")
public class SpielerAbwesenheitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SpielerAbwesenheitServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		abwesenheitsbean abwesenheit = new abwesenheitsbean();

		abwesenheit.setGrund(request.getParameter("abwesenheit_eingabe"));
		abwesenheit.setStart(request.getParameter("startdatum"));
		abwesenheit.setEnde(request.getParameter("enddatum"));
		
	
		
		final HttpSession session = request.getSession();
		session.setAttribute("abwesenheit", abwesenheit);
		
		response.sendRedirect("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
