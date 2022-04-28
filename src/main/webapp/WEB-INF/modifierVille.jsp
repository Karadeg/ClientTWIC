<%@ page language="java" contentType="text/html; encoding=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<style type="text/css"><%@include file="css/stylesheet.css"%></style>
<head>
<meta charset="UTF-8">
<title>Modifier ville</title>
</head>
<body>
	<a href="index">Accueil</a>
	<h1>Modifier les données de <c:out value="${ ville.getNom_commune() }"/></h1>
	<form id="update" class="formulaire" method="post" action="afficherVille" name="myForm">
		<input type="hidden" name="modifier" value="1"/>
		<input type="hidden" name="codeCommuneINSEEPrevious" value="${ ville.getCode_commune_INSEE() }"/>
		<label for="nomCommune">Nom de la Commune</label><br>
		<input id="nomCommune" type="text" required name="nomCommune" value="${ ville.getNom_commune() }"/><br>
		
		<label for="codeCommuneINSEE">Code commune INSEE</label><br>
		<input id="codeCommuneINSEE" type="text" required name="codeCommuneINSEE" value="${ ville.getCode_commune_INSEE() }"/><br>
		
		<label for="codePostal">Code postal</label><br>
		<input id="codePostal" type="text" required name="codePostal" value="${ ville.getCode_postal() }"/><br>
		
		<label for="libelleAcheminement">Libellé acheminement</label><br>
		<input id="libelleAcheminement" type="text" name="libelleAcheminement" value="${ ville.getLibelle_acheminement() }"/><br>
		
		<label for="ligne5">Ligne 5</label><br>
		<input id="ligne5" type="text" name="ligne5" value="${ ville.getLigne_5() }"/><br>
		
		<label for="latitude">Latitude</label><br>
		<input type="number"  step=any required name="latitude" value="${ ville.getLatitude() }"/><br>
		
		<label for="longitude">Longitude</label><br>
		<input id="longitude" type="number"  step=any required name="longitude" value="${ ville.getLongitude() }"/><br>
		
		<input type="submit" value="Modifier"/>
	</form>
	<form name="delete" action="afficherVille" method="post">
	<input type="hidden" name="supprimer" value="1"/>
		<input type="hidden" name="codeCommuneINSEE" value="${ ville.getCode_commune_INSEE() }"/>
		<input type="submit" value="Supprimer"/>
	</form>
</body>
</html>