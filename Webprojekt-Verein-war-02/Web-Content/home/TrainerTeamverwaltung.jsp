<%-- Alexander Ehrnstrasser: --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jspf"%>


	<nav>
		<a href="./TrainerHome.jsp">Dashboard</a>
		<a href="./TrainerKalender.jsp">Kalender</a>
		<a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSearch" class="active">Teamverwaltung</a>
		<a href="/Webprojekt-Verein-war-02/SearchServletTrainerTerminverwaltung">Terminverwaltung</a>

	</nav>

	<main>
	
			<form method="post" action="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSpielerSuche">
			<fieldset><legend>Spieler hinzufügen</legend>
				<p>Hier können neu registrierte Spieler gefunden oder Spieler aus anderen Mannschaften des Vereins hinzugefügt werden</p>
				<div>
				  <label for="nachname">Nachname des Spielers:</label>
				  <input type="text" name="nachname" id="nachname" placeholder="Nachname des Spielers oder freilassen für alle Spieler" size="125">
				</div>
				<div>
				  <button name="submit" type="submit">Suchen</button>
				</div>
			</fieldset>
		</form>
			
			
			<h3>Deine Mannschaft:</h3>

			<table border="1">
				<tr>
					<th>Lfd. Nummer</th>
					<th>Spielerbild</th>
					<th>Name</th>
					<th>Vorname</th>
					<th></th>
				</tr>
				
				<c:forEach var="currentSpieler" items="${spielerliste}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td text-align="center"><img src="/Webprojekt-Verein-war-02/BildVerarbeitungServlet?id=${currentSpieler.id}" width="200" height="300"></td>
						<td>${currentSpieler.nachname}</td>
						<td>${currentSpieler.vorname}</td>
						<td><a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSpielerLoeschen?id=${currentSpieler.id}"><button type="submit" title="Spieler löschen" name="spielerlöschen">&#x1F5D1;</button></a></td>
					</tr>
				</c:forEach>
			
			</table>
				
		

	</main>

<%@ include file="footer.jspf"%>