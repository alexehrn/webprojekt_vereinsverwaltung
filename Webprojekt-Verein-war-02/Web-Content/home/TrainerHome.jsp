<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Trainer-Home</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			
		</head>

<body>
<%@ include file="head.jspf"%>


<nav>
	<a href="/Webprojekt-Verein-war-02/SearchServletTrainerHome" class="active">Dashboard</a>
	<a href="./TrainerKalender.jsp">Kalender</a>
	<a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSearch">Teamverwaltung</a>
	<a href="/Webprojekt-Verein-war-02/SearchServletTrainerTerminverwaltung">Terminverwaltung</a>

</nav>

<main>


	<h1>Termine</h1>
	<table>
		<tr>
			<th>Beschreibung</th>
			<th class="datumsspalte">Datum</th>
			<th>Zusagen</th>
			<th>Absagen</th>
		</tr>
		<c:forEach var="currentRueckmeldung" items="${rueckmeldung}"
			varStatus="status">
			<tr>

				<td>${currentRueckmeldung.beschreibung}</td>
				<td class="datumsspalte">${currentRueckmeldung.datum}</td>
				<td>${currentRueckmeldung.zusagen}</td>
				<td>${currentRueckmeldung.absagen}</td>
			</tr>
		</c:forEach>

	</table>

	<h1>Abwesenheit</h1>
	<table>
		<tr>
			<th></th>
			<th>Diese Woche abwesend:</th>
			<th>Zeitraum</th>
			<th>Grund</th>
		</tr>

		<c:forEach var="currentAbwesenheit" items="${abwesenheit}"
			varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${currentAbwesenheit.vorname}
					${currentAbwesenheit.nachname}</td>
				<td>${currentAbwesenheit.start} bis ${currentAbwesenheit.ende}</td>
				<td>${currentAbwesenheit.grund}</td>
			</tr>
		</c:forEach>
	</table>


	<form action="/Webprojekt-Verein-war-02/TrainerHomeServlet"
		method="post" accept-charset="utf-8">
		<h1>Nachricht an das Team senden:</h1>
		<textarea name="trainer_eingabe" rows="20" cols="100"></textarea>
		<br>
		<br>
		<button type="submit" name="nachrichtAbsenden" value="submit">Absenden
			der Nachricht</button>
	</form>


</main>

<%@ include file="footer.jspf"%>