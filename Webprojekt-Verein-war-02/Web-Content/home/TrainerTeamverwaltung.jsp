<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jspf"%>


	<nav>
		<a href="./TrainerHome.jsp">Dashboard</a>
		<a href="./TrainerKalender.jsp">Kalender</a>
		<a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSearch" class="active">Teamverwaltung</a>
		<a href="./TrainerTerminverwaltung.jsp">Terminverwaltung</a>

	</nav>

	<main>
	


			<table border="1">
				<tr>
					<th>Lfd. Nummer</th>
					<th>Spielerbild</th>
					<th>Name</th>
					<th>Vorname</th>
					<th>Position</th>
					<th><a href="./TrainerHinzufuegenSpieler.jsp"><button type="submit" title="Neuen Spieler hinzufügen"
							name="hinzufügen">Hinzufügen</button></a></th>
				</tr>
				
				<c:forEach var="currentSpieler" items="${spielerliste}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td text-align="center"><img src="/Webprojekt-Verein-war-02/BildVerarbeitungServlet?id=${currentSpieler.id}" width="200" height="300"></td>
						<td>${currentSpieler.nachname}</td>
						<td>${currentSpieler.vorname}</td>
						<td>${currentSpieler.position}</td>
						<td><button type="submit" title="Spieler löschen" 
						name="spielerlöschen">&#x1F5D1;</button></td>
					</tr>
				</c:forEach>
			
			</table>
				
		

	</main>

<%@ include file="footer.jspf"%>