package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import bean.registrierungsbean01;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrierungsServlet
 */
@WebServlet("/RegistrierungsServlet")
public class RegistrierungsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrierungsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		registrierungsbean01 registerform = new registrierungsbean01();

		registerform.setAuswahl(request.getParameter("auswahl"));
		registerform.setVorname(request.getParameter("vorname"));
		registerform.setNachname(request.getParameter("nachname"));
		registerform.setPasswort(request.getParameter("passwort"));
		registerform.setEmail(request.getParameter("email"));
		registerform.setTeam(request.getParameter("team"));
		
		final HttpSession session = request.getSession();
		session.setAttribute("registerform", registerform);
		
		response.sendRedirect("home/regerfolgreich.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
