<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jspf"%>


	<nav>
		<a href="/Webprojekt-Verein-war-02/TrainerHomeServlet" class="active">Dashboard</a>                                
		<a href="./TrainerKalender.jsp">Kalender</a>                      
		<a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSearch">Teamverwaltung</a>
		<a href="/Webprojekt-Verein-war-02/SearchServletTrainerTerminverwaltung">Terminverwaltung</a>

	</nav>

<main>


<p>Termine</p>
		<table border="1">
			<tr>
				<th>Beschreibung</th>
				<th>Datum</th>
				<th>Zusagen</th>
				<th>Absagen</th>
			</tr>

			<tr>
				<td>Trainingsbeispiel</td>
				<td>29.04.2022</td>
				<td>18</td>
				<td>7</td>
			</tr>

			<tr>
				<td>Trainingsbeispiel</td>
				<td>31.04.2022</td>
				<td>20</td>
				<td>5</td>
			</tr>
		</table>

		<p>Abwesenheit</p>
		<table border="1">
			<tr>
				<th></th>
				<th>Diese Woche abwesend:</th>
				<th>Zeitraum</th>
				<th>Grund</th>
			</tr>
		
		<c:forEach var="currentAbwesenheit" items="${abwesenheit}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${currentAbwesenheit.vorname} ${currentAbwesenheit.nachname}</td>
				<td>${currentAbwesenheit.start} ${currentAbwesenheit.ende}</td>
				<td>${currentAbwesenheit.grund}</td>
			</tr>
		</c:forEach>
		</table>


		<form action="/Webprojekt-Verein-war-02/TrainerHomeServlet" method="post" accept-charset="utf-8">
			<p>Nachricht an das Team senden:</p>
			<textarea name="trainer_eingabe" rows="20" cols="100"></textarea>
			<button type="submit" name="nachrichtAbsenden" value="submit">Absenden
				der Nachricht</button>
		</form>


</main>

<%@ include file="footer.jspf"%>