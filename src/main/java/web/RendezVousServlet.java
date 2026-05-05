package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.RendezVous;

import java.io.IOException;
import java.util.List;

import dao.RendezVousDAO;

/**
 * Servlet implementation class RendezVousServlet
 */
@WebServlet("/RendezVous")
public class RendezVousServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RendezVousDAO dao = new RendezVousDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RendezVousServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RendezVous> liste = dao.getAll();
		request.setAttribute("listeRdv", liste);
		request.getRequestDispatcher("/WEB-INF/views/listeRendezVous.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String patient = request.getParameter("patient");
		boolean ok = dao.reserver(id, patient);
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("patient", patient);
		session.setAttribute("messageSuccees", "success");
		session.setAttribute("messageEchec", "Echec");
		if(ok) {
			session.removeAttribute("messageEchec");
		}else {			
			session.removeAttribute("messageSuccees");
		}
		response.sendRedirect(request.getContextPath()+"/rendezvous");
		doGet(request, response);
	}

}
