package com.octest.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.octest.beans.Ville;

public class APIRequest {
	private static final String URL = "http://localhost:8181/ville";
	private static final String ERROR_CODE = "Failed with HTTP error code : ";

	public APIRequest() {
		// Do nothing.
	}

	public String APIGet(String parameter) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String apiOutput = null;
		try {
			HttpGet getRequest = new HttpGet(URL+parameter);
			
			HttpResponse responseAPI = httpClient.execute(getRequest);

			int statusCode = responseAPI.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException(ERROR_CODE + statusCode);
			}

			HttpEntity httpEntity = responseAPI.getEntity();
			apiOutput = EntityUtils.toString(httpEntity);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Important: Close the connect
			httpClient.getConnectionManager().shutdown();
		}
		return apiOutput;
	}

	public HttpResponse APIPost(HttpServletRequest request) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpResponse response = null;

		Ville ville = new Ville();
		ville.setCodeCommuneINSEE(Integer.parseInt(request.getParameter("codeCommuneINSEE")));
		ville.setNomCommune(request.getParameter("nomCommune"));
		ville.setCodePostal(Integer.parseInt(request.getParameter("codePostal")));
		ville.setLibelleAcheminement(request.getParameter("libelleAcheminement"));
		ville.setLigne5(request.getParameter("ligne5"));
		ville.setLatitude(request.getParameter("latitude"));
		ville.setLongitude(request.getParameter("longitude"));

		String json = new Gson().toJson(ville);

		try {
			HttpPost postRequest = new HttpPost(URL);

			postRequest.addHeader("content-type", "application/xml");

			StringEntity userEntity = null;
			try {
				userEntity = new StringEntity(json);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			postRequest.setEntity(userEntity);
			
			try {
				response = httpClient.execute(postRequest);
				
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode != 200 && statusCode != 201) {
					throw new RuntimeException(ERROR_CODE + statusCode);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return response;
	}

	public HttpResponse APIPut(HttpServletRequest request) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpResponse response = null;

		Ville villePrevious = new Ville();
		Ville ville = new Ville();
		ville.setCodeCommuneINSEE(Integer.parseInt(request.getParameter("codeCommuneINSEE")));
		ville.setNomCommune(request.getParameter("nomCommune"));
		ville.setCodePostal(Integer.parseInt(request.getParameter("codePostal")));
		ville.setLibelleAcheminement(request.getParameter("libelleAcheminement"));
		ville.setLigne5(request.getParameter("ligne5"));
		ville.setLatitude(request.getParameter("latitude"));
		ville.setLongitude(request.getParameter("longitude"));
		villePrevious.setCodeCommuneINSEE(Integer.parseInt(request.getParameter("codeCommuneINSEEPrevious")));
		
		String json1 = new Gson().toJson(villePrevious);
		String json2 = new Gson().toJson(ville);
		String json = "["+json1+","+json2+"]";

		try {
			HttpPut putRequest = new HttpPut(URL);
			putRequest.addHeader("content-type", "application/xml");
			StringEntity userEntity = null;
			try {
				userEntity = new StringEntity(json);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			putRequest.setEntity(userEntity);
			try {
				response = httpClient.execute(putRequest);
				
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode != 200 && statusCode != 201) {
					throw new RuntimeException(ERROR_CODE + statusCode);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return response;
	}

	public void APIDelete(String parameter) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			HttpDelete deleteRequest = new HttpDelete(URL+"/"+parameter);

			HttpResponse responseAPI = httpClient.execute(deleteRequest);

			// verify the valid error code first
			int statusCode = responseAPI.getStatusLine().getStatusCode();
			if (statusCode != 200 || statusCode != 201) {
				//DO nothing
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Important: Close the connect
			httpClient.getConnectionManager().shutdown();
		}
	}
}
