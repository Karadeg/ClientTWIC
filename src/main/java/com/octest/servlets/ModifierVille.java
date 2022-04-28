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
 * Servlet implementation class ModifierVille
 */
@WebServlet("/modifierVille")
public class ModifierVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("ville"));
		if (session == null) {
			session = request.getSession();
		}
		Ville ville = trouverVille(request.getParameter("ville"));
		request.setAttribute("ville", ville);	
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierVille.jsp").forward(request, response);
	}
	
	protected Ville trouverVille(String selectedVille) {
		Ville ville = null;
		List<Ville> villes = (List<Ville>) session.getAttribute("villes");
		System.out.println(selectedVille);
		for (int i = 0; i < villes.size(); i ++) {
			if (Integer.toString(villes.get(i).getCode_commune_INSEE()).equals(selectedVille)) {
				ville = villes.get(i);
			}
		}
		return ville;
	}

}
