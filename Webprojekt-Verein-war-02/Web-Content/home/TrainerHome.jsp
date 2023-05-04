<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jspf"%>


	<nav>
		<a href="./TrainerHome.jsp" class="active">Dashboard</a>                                
		<a href="./TrainerKalender.jsp">Kalender</a>                      
		<a href="./TrainerTeamverwaltung.jsp">Teamverwaltung</a>
		<a href="./TrainerTerminverwaltung.jsp">Terminverwaltung</a>

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
				<th>Diese Woche abwesend:</th>
				<th>bis</th>
				<th>Grund</th>
			</tr>

			<tr>
				<td>Alexander Ehrnstrasser</td>
				<td>31.04.2023</td>
				<td>Malle Opening</td>
			</tr>

			<tr>
				<td>Fabian Wolfsteiner</td>
				<td>31.04.2022</td>
				<td>Verletzung: Beim Rasieren geschnitten</td>
			</tr>
		</table>


		<form action="/Webprojekt-Verein-war-02/TrainerHomeServlet" method="post" accept-charset="utf-8">
			<p>Nachricht an das Team senden:</p>
			<textarea name="trainer_eingabe" rows="20" cols="100"></textarea>
			<button type="submit" name="nachrichtAbsenden" value="submit">Absenden
				der Nachricht</button>
		</form>


</main>

<%@ include file="footer.jspf"%>