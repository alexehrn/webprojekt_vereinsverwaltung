package servlets;

import bean.TrainerHomeBean;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/TrainerHomeServlet")
public class TrainerHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
    public TrainerHomeServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		TrainerHomeBean trainerHomeBean = new TrainerHomeBean();
		
		trainerHomeBean.setBeschreibung(request.getParameter("trainer_eingabe"));
		
		final HttpSession session = request.getSession();
		session.setAttribute("TrainerHombeBean", trainerHomeBean);//Redirect weil Formulareingabe? --> würde sonst öfter schicken

		response.sendRedirect("jsps/");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
