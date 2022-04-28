package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.octest.api.APIRequest;

/**
 * Servlet implementation class ajouterVille
 */
@WebServlet("/ajouterVille")
public class AjouterVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private APIRequest apiRequest;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		apiRequest = new APIRequest();
		HttpResponse responsePOST = apiRequest.APIPost(request);
		HttpEntity entity = responsePOST.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		request.setAttribute("responsePOST", responseString);
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterVille.jsp").forward(request, response);
	}

}
