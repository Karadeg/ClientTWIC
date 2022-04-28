package com.octest.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.beans.Ville;

/**
 * Servlet implementation class calculerDistance
 */
@WebServlet("/calculerDistance")
public class CalculerDistance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculerDistance() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (session == null) {
			session = request.getSession();
		}
		System.out.println(session);
		request.setAttribute("villes", session.getAttribute("villes"));
		System.out.println(session.getAttribute("villes"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/calculerDistance.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (session == null) {
			session = request.getSession();
		}
		request.setAttribute("villes", session.getAttribute("villes"));
		Ville ville1 = trouverVille(request.getParameter("ville1"));
		Ville ville2 = trouverVille(request.getParameter("ville2"));
		request.setAttribute("nom1", ville1.getNomCommune());
		request.setAttribute("nom2", ville2.getNomCommune());
		request.setAttribute("distance", ville1.calculDistance(ville2));
		this.getServletContext().getRequestDispatcher("/WEB-INF/calculerDistance.jsp").forward(request, response);
	}
	
	protected Ville trouverVille(String selectedVille) {
		Ville ville = null;
		System.out.println(selectedVille);
		List<Ville> villes = ((List<Ville>) session.getAttribute("villes"));
		for (int i = 0; i < villes.size(); i ++) {
			if (Integer.toString(villes.get(i).getCodeCommuneINSEE()).equals(selectedVille)) {
				ville = villes.get(i);
			}
		}
		return ville;
	}

}
