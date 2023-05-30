<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Trainer-Terminverwaltung</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			
		</head>

<body>
<%@ include file="head.jspf"%>

<nav>
	<a href="/Webprojekt-Verein-war-02/SearchServletTrainerHome">Dashboard</a>   
	 <a
		href="./TrainerKalender.jsp">Kalender</a> <a
		href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSearch">Teamverwaltung</a>
	<a href="/Webprojekt-Verein-war-02/SearchServletTrainerTerminverwaltung" class="active">Terminverwaltung</a>
	
</nav>



<main>

	<h1>Upcoming Events</h1>

	<table border="1">
		<tr>
			<th>Nummer</th>
			<th>Kurzbeschreibung</th>
			<th>Ort</th>
			<th>Datum</th>
			<th>Uhrzeit</th>
			<th>Details</th>
			<th>Optionen</th>
		</tr>


		<c:forEach var="currentTermin" items="${termine}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${currentTermin.kurzbeschreibung}</td>
				<td>${currentTermin.ort}</td>
				<td>${currentTermin.datum}</td>
				<td>${currentTermin.uhrzeitVON}-${currentTermin.uhrzeitBIS}</td>
				<td>${currentTermin.beschreibung}</td>
				<td><button type="submit" title="Termin ändern" name="terminändern">&#9998;</button></td>
				<td><a href="/Webprojekt-Verein-war-02/TrainerTerminLoeschen?id=${currentTermin.id}"><button type="submit" title="Termin löschen" name="terminlöschen">&#x1F5D1;</button></a></td>
			</tr>
		</c:forEach>
	</table>




	<h1>Einen neuen Termin anlegen</h1>





	<form
		action="/Webprojekt-Verein-war-02/TrainerTerminverwaltungsServlet"
		method="post">
		<p>
			Kurzbeschreibung: <br> <input type="text"
				name="kurzbeschreibung" size="30" maxlength="30" required
				placeholder="Kurzbeschreibung eingeben">
		</p>${trainerTeamverwaltungsBean.kurzbeschreibung}
		<p>
			Ort: <br> <input type="text" name="ort" size="30" maxlength="30"
				required placeholder="Ort eingeben">
		</p>${trainerTeamverwaltungsBean.ort}
		<p>
			Datum: <br> <input type="date" name="datum">
		</p>${trainerTeamverwaltungsBean.datum}
		<p>
			Uhrzeit: <br> Von: <input type="time" name="startzeit">
			<br> Bis: <input type="time" name="endzeit">
		</p>

		<p>
			Details: <br>
			<textarea name="trainer_eingabe" rows="10" cols="50"
				placeholder="Beschreibung eingeben..."></textarea>
		</p>${trainerTeamverwaltungsBean.beschreibung}
		<p>
			<button type="submit" name="anlegen">Termin anlegen</button>
		</p>
	</form>



</main>

<%@ include file="footer.jspf"%>