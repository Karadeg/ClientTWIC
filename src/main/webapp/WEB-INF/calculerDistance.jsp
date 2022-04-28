<%@ page language="java" contentType="text/html; encoding=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<style type="text/css"><%@include file="css/stylesheet.css"%></style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<a href="index">Accueil</a>
		<h1>Calculer la distance entre deux villes</h1>
		<form name="distanceCalculator" action="calculerDistance" method="post">
			<select name="ville1" id="ville1">
				<c:forEach var="i" begin="1" end="${villes.size()}">
					<option value="${ villes.get(i-1).getCodeCommuneINSEE() }"/><c:out value="${ villes.get(i-1).getNomCommune() }"/></option>
				</c:forEach>
			</select>
			<select name="ville2" id="ville2">
				<c:forEach var="i" begin="1" end="${villes.size()}">
					<option value="${ villes.get(i-1).getCodeCommuneINSEE() }"/><c:out value="${ villes.get(i-1).getNomCommune() }"/></option>
				</c:forEach>
			</select>
			<input type="submit" value="Calculer"/>
		</form>
		<c:if test="${ !empty distance }">
			<h4>La distance entre <c:out value="${ nom1 }"/> et <c:out value="${ nom2 }"/> est de <c:out value="${ distance }"/>km</h4>
		</c:if>
	</div>
</body>
</html>