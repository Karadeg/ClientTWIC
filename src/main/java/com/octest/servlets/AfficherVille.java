package com.octest.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.octest.api.APIRequest;
import com.octest.beans.Ville;

/**
 * Servlet implementation class afficherVille
 */
@WebServlet("/afficherVille")
public class AfficherVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static APIRequest apiRequest = new APIRequest();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherVille() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = apiRequest.APIGet("");
		List<Ville> villes = null;
		try {
			villes = new Gson().fromJson(json, new TypeToken<List<Ville>>() {}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("json", json);
		request.setAttribute("villes", villes);
		try {
			this.getServletContext().getRequestDispatcher("/WEB-INF/afficherVille.jsp").forward(request, response);
		} catch (IOException|ServletException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ville> villes;
		if (request.getParameter("modifier") != null || request.getParameter("supprimer") != null) {
			if (request.getParameter("supprimer") != null) {
				apiRequest.APIDelete(request.getParameter("codeCommuneINSEE"));
			} else if (request.getParameter("modifier") != null) {
				HttpResponse responsePUT = apiRequest.APIPut(request);
				HttpEntity entity = responsePUT.getEntity();
				String responseString = EntityUtils.toString(entity, "UTF-8");
				request.setAttribute("responsePUT", responseString);
			}
			HttpSession session = request.getSession();
			
			String json = apiRequest.APIGet("");
			
			villes = new Gson().fromJson(json, new TypeToken<List<Ville>>() {}.getType());
			session.setAttribute("villes", villes);
		}
		try {
			this.getServletContext().getRequestDispatcher("/WEB-INF/afficherVille.jsp").forward(request, response);
		} catch (IOException|ServletException e) {
			e.printStackTrace();
		}
	}

}
