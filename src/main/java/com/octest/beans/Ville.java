package com.octest.beans;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class Ville {
    private int Code_commune_INSEE;
    private String Nom_commune;
    private int Code_postal;
    private String Libelle_acheminement;
    private String Ligne_5;
    private String Latitude;
    private String Longitude;

    public Ville(){}

    public String toString() {
        return "{" +
                "\"Code_commune_INSEE\": \"" + Code_commune_INSEE +
                "\", \"Nom_commune\": \"" + Nom_commune + '\"' +
                ", \"Code_postal\": \"" + Code_postal + '\"' +
                ", \"Libelle_acheminement\": \"" + Libelle_acheminement + '\"' +
                ", \"Ligne_5\": \"" + Ligne_5 + '\"' +
                ", \"Latitude\": \"" + Latitude +
                "\", \"Longitude\": \"" + Longitude +
                "\"}";
    }
    public String toStringSelect() {
    	return ""+Nom_commune+
    			"\""+Code_commune_INSEE;
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
    	System.out.println(distance);
    	return distanceString;
    }

    public int getCode_commune_INSEE() {
		return Code_commune_INSEE;
	}

	public void setCode_commune_INSEE(int code_commune_INSEE) {
		Code_commune_INSEE = code_commune_INSEE;
	}

	public String getNom_commune() {
		return Nom_commune;
	}

	public void setNom_commune(String nom_commune) {
		Nom_commune = nom_commune;
	}

	public int getCode_postal() {
		return Code_postal;
	}

	public void setCode_postal(int code_postal) {
		Code_postal = code_postal;
	}

	public String getLibelle_acheminement() {
		return Libelle_acheminement;
	}

	public void setLibelle_acheminement(String libelle_acheminement) {
		Libelle_acheminement = libelle_acheminement;
	}

	public String getLigne_5() {
		return Ligne_5;
	}

	public void setLigne_5(String ligne_5) {
		Ligne_5 = ligne_5;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

    @Override
    public int hashCode() {
        return Objects.hash(this.getCode_commune_INSEE(), this.getNom_commune(), this.getCode_postal(), this.getLibelle_acheminement(), this.getLigne_5(), this.getLatitude(), this.getLongitude());
    }
}
