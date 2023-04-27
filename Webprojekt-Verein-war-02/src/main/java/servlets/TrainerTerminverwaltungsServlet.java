package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import bean.TrainerTerminverwaltungsBean;



@WebServlet("/TrainerTerminverwaltungsServlet")
public class TrainerTerminverwaltungsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public TrainerTerminverwaltungsServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		TrainerTerminverwaltungsBean trainerTerminverwaltungsBean = new TrainerTerminverwaltungsBean();
		
		trainerTerminverwaltungsBean.setKurzbeschreibung(request.getParameter("kurzbeschreibung"));
		trainerTerminverwaltungsBean.setOrt(request.getParameter("ort"));
		trainerTerminverwaltungsBean.setDatum(request.getParameter("datum"));
		trainerTerminverwaltungsBean.setUhrzeitVON(request.getParameter("startzeit"));
		trainerTerminverwaltungsBean.setUhrzeitBIS(request.getParameter("endzeit"));
		trainerTerminverwaltungsBean.setBeschreibung(request.getParameter("trainer_eingabe"));
		
		
		final HttpSession session = request.getSession();
		session.setAttribute("trainerTerminverwaltungsBean", trainerTerminverwaltungsBean);//Redirect weil Formulareingabe? --> würde sonst öfter schicken

		response.sendRedirect("jsps/TrainerTermin_anlegen.jsp");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
