package com.octest.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.octest.api.*;
import com.octest.beans.Ville;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private APIRequest apiRequest = null;
	private List<Ville> villes;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		apiRequest = new APIRequest();
		String json = apiRequest.APIGet("");
		
		villes = new Gson().fromJson(json, new TypeToken<List<Ville>>() {}.getType());
		System.out.println("Ville : "+villes.get(0).getNom_commune());
		System.out.println(villes.size());
		session.setAttribute("villes", villes);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		apiRequest = new APIRequest();
//		HttpResponse responsePOST = apiRequest.APIPost(request);
//		HttpEntity entity = responsePOST.getEntity();
//		String responseString = EntityUtils.toString(entity, "UTF-8");
//		request.setAttribute("responsePOST", responseString);

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
