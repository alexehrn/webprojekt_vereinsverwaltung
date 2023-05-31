<%-- Alexander Ehrnstrasser: --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Trainer-Teamverwaltung</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			
		</head>

<body>
<%@ include file="head.jspf"%>


	<nav>
		<a href="/Webprojekt-Verein-war-02/SearchServletTrainerHome">Dashboard</a>   
		<a href="./TrainerKalender.jsp">Kalender</a>
		<a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSearch" class="active">Teamverwaltung</a>
		<a href="/Webprojekt-Verein-war-02/SearchServletTrainerTerminverwaltung">Terminverwaltung</a>
	</nav>

	<main>
	
	<h1>Spielerpool</h1>
			<table border="1">
				<tr>
					<th></th>
					<th>Name</th>
					<th>Vorname</th>
					<th>Registriert als</th>
					<th></th>
				</tr>
				<c:forEach var="currentSpieler" items="${spielerliste}" varStatus="status">
					<tr>

						<td text-align="center"><img src="/Webprojekt-Verein-war-02/BildVerarbeitungServlet?id=${currentSpieler.id}" width="150" height="200"></td>
						<td>${currentSpieler.nachname}</td>
						<td>${currentSpieler.vorname}</td>
						<td>${currentSpieler.team}</td>
						<td><a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSpielerHinzufuegen?id=${currentSpieler.id}"><button type="submit" title="Spieler hinzufuegen" name="spielerhinzufuegen">Spieler hinzufügen</button></a>
						<a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSpielerLoeschen?id=${currentSpieler.id}"><button type="submit" title="Spieler löschen" name="spielerlöschen">&#x1F5D1;</button></a></td>
					</tr>
				</c:forEach>
			
			</table>

	</main>

<%@ include file="footer.jspf"%>