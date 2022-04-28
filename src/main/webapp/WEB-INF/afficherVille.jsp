<%@ page language="java" contentType="text/html; encoding=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<style type="text/css"><%@include file="css/stylesheet.css"%></style>
<style type="text/css"><%@include file="css/afficherVilleStylesheet.css"%></style>
<head>
<meta charset="UTF-8">
<title>Ville de France</title>
</head>
<body onload="initiate()">
	<div class="container">
		<a href="index">Accueil</a>
		<h1>Liste des villes :</h1>
		<div class="fond_tableau">
			<table>
				<thead>
					<tr>
						<th>Numéro</th>
						<th>Nom</th>
						<th>Code postal</th>
						<th>Latitude</th>
						<th>Longitude</th>
					</tr>
				</thead>
				<tbody id="listeVilles">
					<c:forEach var="i" begin="1" end="${villes.size()}">
						<tr class="hidden">
							<td><c:out value="${ i }"/></td>
							<td><c:out value="${ villes.get(i-1).getNom_commune() }"/></td>
							<td><c:out value="${ villes.get(i-1).getCode_postal() }"/></td>
							<td><c:out value="${ villes.get(i-1).getLatitude() }"/></td>
							<td><c:out value="${ villes.get(i-1).getLongitude() }"/></td>
							<td>
								<form action="modifierVille" method="post">
									<input name="ville" type="hidden" value="${ villes.get(i-1).getCode_commune_INSEE() }"/>
									<input type="submit" value="Modifier"/>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<button id="previous" onclick="previous()">Précédent</button>
		<button id="next" onclick="next()">Suivant</button>
	</div>
</body>
<script type="text/javascript">
	var debut = 0;
	var array = Array.prototype.slice.call(document.getElementById("listeVilles").rows);

	function initiate(){
		for (let i = debut; i < debut+50; i++) {
	  		array[i].classList.remove("hidden");
		}
		if (debut < 50){
			document.getElementById("previous").setAttribute("disabled", "");
		}
	}
	function next(){
		var limite;
		document.getElementById("previous").removeAttribute("disabled", "");
		for (let i = debut; i < debut+50; i++) {
	  		array[i].classList.add("hidden");
		}
		debut += 50;
		if (debut + 50 > array.length){
			limite = array.length;
		} else {
			limite = debut + 50;
		}
		for (let i = debut; i < limite; i++) {
	  		array[i].classList.remove("hidden");
		}
		
		if (array.length-debut < 50){
			document.getElementById("next").setAttribute("disabled", "");
		}
	}
	
	function previous(){
		var limite;
		if (debut + 50 > array.length){
			limite = array.length;
		} else {
			limite = debut + 50;
		}
		for (let i = debut; i < limite; i++) {
	  		array[i].classList.add("hidden");
		}
		debut -= 50;
		if (debut - 50 > array.length){
			limite = array.length;
		} else {
			limite = debut;
		}
		for (let i = debut; i < debut+50; i++) {
	  		array[i].classList.remove("hidden");
		}
		if (debut < array.length - 50){
			document.getElementById("next").removeAttribute("disabled", "");
		}
		if (debut < 50){
			document.getElementById("previous").setAttribute("disabled", "");
		}
	}
</script>
</html>