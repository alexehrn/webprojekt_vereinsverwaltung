<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jspf"%>


	<nav>
		<a href="./TrainerHome.jsp">Dashboard</a>                                       
		<a			href="./TrainerKalender.jsp">Kalender</a>                       
		<a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSearch" class="active">Teamverwaltung</a>
		<a href="./TrainerTerminverwaltung.jsp">Terminverwaltung</a>

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

						<td text-align="center"><img src="/Webprojekt-Verein-war-02/BildVerarbeitungServlet?id=${currentSpieler.id}" width="200" height="300"></td>
						<td>${currentSpieler.nachname}</td>
						<td>${currentSpieler.vorname}</td>
						<td>${currentSpieler.team}</td>
						<td><button type="submit" title="Spieler hinzufuegen" name="spielerhinzufuegen">Spieler hinzufügen</button><button type="submit" title="Spieler löschen" name="spielerlöschen">&#x1F5D1;</button></td>
					</tr>
				</c:forEach>
			
			</table>

	</main>

<%@ include file="footer.jspf"%>