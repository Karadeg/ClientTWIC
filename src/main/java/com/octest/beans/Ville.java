package com.octest.beans;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class Ville {
	private int codeCommuneINSEE;
    private String nomCommune;
    private int codePostal;
    private String libelleAcheminement;
    private String ligne5;
    private String latitude;
    private String longitude;

    public Ville(){
    	//Nothing to do
    }

    public String toString() {
        return "{" +
                "\"Code_commune_INSEE\": \"" + codeCommuneINSEE +
                "\", \"Nom_commune\": \"" + nomCommune + '\"' +
                ", \"Code_postal\": \"" + codePostal + '\"' +
                ", \"Libelle_acheminement\": \"" + libelleAcheminement + '\"' +
                ", \"Ligne_5\": \"" + ligne5 + '\"' +
                ", \"Latitude\": \"" + latitude +
                "\", \"Longitude\": \"" + longitude +
                "\"}";
    }
    public String toStringSelect() {
    	return ""+nomCommune+
    			"\""+codeCommuneINSEE;
    }
    
    public String calculDistance(Ville ville) {
    	double longitude1 = Float.parseFloat(this.getLongitude())*Math.PI/180;
    	double longitude2 = Float.parseFloat(ville.getLongitude())*Math.PI/180;
    	double latitude1 = Float.parseFloat(this.getLatitude())*Math.PI/180;
    	double latitude2 = Float.parseFloat(ville.getLatitude())*Math.PI/180;
    	double distance = 6372.795477598 * Math.acos(Math.sin(latitude1)*Math.sin(latitude2) + Math.cos(latitude2)*Math.cos(latitude1)*Math.cos(longitude1-longitude2));
    	
    	String format = "0.00";
        NumberFormat formatter = new DecimalFormat(format);  
        String distanceString = formatter.format(distance);
    	return distanceString;
    }

    public int getCodeCommuneINSEE() {
		return codeCommuneINSEE;
	}

	public void setCodeCommuneINSEE(int codeCommuneINSEE) {
		this.codeCommuneINSEE = codeCommuneINSEE;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	public String getLigne5() {
		return ligne5;
	}

	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
