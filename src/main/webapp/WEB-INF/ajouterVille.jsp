<%@ page language="java" contentType="text/html; encoding=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<style type="text/css"><%@include file="css/stylesheet.css"%></style>
<head>
<meta charset="UTF-8">
<title>Ajouter une ville</title>
</head>
<body>
	<div class="container">
		<a href="index">Accueil</a>
		<h1>Ajouter une ville dans notre base de données !</h1>
		<form id="insert" class="formulaire" method="post" action="ajouterVille" name="myForm">
			<label for="nomCommune">Nom de la Commune</label><br>
			<input id="nomCommune" type="text" required name="nomCommune" placeholder="Nom de la Commune"/><br>
			
			<label for="codeCommuneINSEE">Code commune INSEE</label><br>
			<input id="codeCommuneINSEE" type="text" required name="codeCommuneINSEE" placeholder="Code commune INSEE"/><br>
			
			<label for="codePostal">Code postal</label><br>
			<input id="codePostal" type="text" required name="codePostal" placeholder="Code postal"/><br>
			
			<label for="libelleAcheminement">Libellé acheminement</label><br>
			<input id="libelleAcheminement" type="text" name="libelleAcheminement" placeholder="Libellé acheminement"/><br>
			
			<label for="ligne5">Ligne 5</label><br>
			<input id="ligne5" type="text" name="ligne5" placeholder="Ligne 5"/><br>
			
			<label for="latitude">Latitude</label><br>
			<input type="number"  step=any required name="latitude" placeholder="Latitude"/><br>
			
			<label for="longitude">Longitude</label><br>
			<input id="longitude" type="number"  step=any required name="longitude" placeholder="Longitude"/><br>
			
			<input type="submit" value="Ajouter"/>
			<input id="latitude" type="reset" value="Reset"/>
		</form>
	</div>
</body>
</html>