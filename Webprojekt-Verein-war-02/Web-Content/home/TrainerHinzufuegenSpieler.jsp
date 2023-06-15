<%-- Alexander Ehrnstrasser: --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
	<html lang="de">
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

	<main class="zentrieren">
	
	<h1>Spielerpool</h1>
			<table>
				<tr>
					<th></th>
					<th>Name</th>
					<th>Vorname</th>
					<th>Registriert als</th>
					<th></th>
				</tr>
				<c:forEach var="currentSpieler" items="${spielerliste}" varStatus="status">
					<tr>

						<td><img src="/Webprojekt-Verein-war-02/BildVerarbeitungServlet?id=${currentSpieler.id}" class="spielerfoto" alt="spielerfoto"></td>
						<td class="zentrierteschrift">${currentSpieler.nachname}</td>
						<td class="zentrierteschrift">${currentSpieler.vorname}</td>
						<td class="zentrierteschrift">${currentSpieler.team}</td>
						<td class="zentrierteschrift"><a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSpielerHinzufuegen?id=${currentSpieler.id}" class="button">Spieler hinzufügen</a>
						<a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSpielerLoeschen?id=${currentSpieler.id}" class="button">Spieler löschen</a></td>
					</tr>
				</c:forEach>
			
			</table>

	</main>

<%@ include file="footer.jspf"%>