<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Spieler-Home</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			
		</head>

<body>

<%@ include file="head.jspf"%>

<nav>
	<a href="/Webprojekt-Verein-war-02/SearchServletSpielerHome" class="active">Dashboard</a>
	<a href="./SpielerKalender.jsp">Kalender</a>

</nav>




<main>
	<h1>Termine</h1>
	<table>
		<tr>
			<th>Nummer</th>
			<th>Beschreibung</th>
			<th>Ort</th>
			<th class="datumsspalte">Datum</th>
			<th>Beginn</th>
			<th>Ende</th>
			<th>Information</th>
			<th>Meldung</th>
			<th>Status</th>
		</tr>

		<c:forEach var="currentTermin" items="${termine}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${currentTermin.kurzbeschreibung}</td>
				<td>${currentTermin.ort}</td>
				<td class="datumsspalte">${currentTermin.datum}</td>
				<td>${currentTermin.uhrzeitVON}</td>
				<td>${currentTermin.uhrzeitBIS}</td>
				<td>${currentTermin.beschreibung}</td>
				<td>
					<form action="/Webprojekt-Verein-war-02/SpielerRueckmeldungServlet" method="get">
						<input type="hidden" name="id" value="${currentTermin.id}">
						<button type="submit" name="rueckmeldung" value="Zugesagt">Zusage</button>
						<button type="submit" name="rueckmeldung" value="Abgesagt">Absage</button></td>
					</form>
				<td>
				
				<!-- Anfang ChatGPT -->
				<c:choose>
  					<c:when test="${currentTermin.rueckmeldung == null}">
    					Keine Rückmeldung
 					</c:when>
 					<c:otherwise>
  						${currentTermin.rueckmeldung}
					</c:otherwise>
				</c:choose>
				<!-- Ende ChatGPT -->
				
				</td>  
			</tr>
			</c:forEach>
	</table>

	<form action="/Webprojekt-Verein-war-02/SpielerAbwesenheitServlet" action="post">
		<h1>Abwesenheit anlegen</h1>
		<table>
			<tr>
				<th>Grund</th>
				<th>von</th>
				<th>bis</th>
			</tr>
			<tr>

				<td><input name="abwesenheit_eingabe"></input></td>
				<td><input type="date" id="startdatum" name="startdatum"></td>
				<td><input type="date" id="enddatum" name="enddatum"></td>
		</table>
		<button type="submit" name="abwesenheitAbsenden" value="submit">Abwesenheit
			absenden!</button>

	</form>
	<br>

	<h1>Meine Abwesenheiten</h1>
		<table>
			<tr>
				<th>Nummer</th>
				<th>Beschreibung</th>
				<th>von</th>
				<th>bis</th>
			</tr>
		<c:forEach var="currentAbwesenheit" items="${abwesenheiten}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${currentAbwesenheit.grund}</td>
				<td>${currentAbwesenheit.start}</td>
				<td>${currentAbwesenheit.ende}</td>
			</tr>
		</c:forEach>
		</table>
	<br>
	
	
	<h1>Nachrichten der letzten 7 Tage vom Trainerteam</h1>

	<table>
		<tr>
			<th class="datumsspalte">Tag</th>
			<th>Nachrichtenforum</th>
		</tr>
	<c:forEach var="currentNachricht" items="${nachrichten}" varStatus="status">
		<tr>
		<td class="datumsspalte">${currentNachricht.tag}</td>
		<td>${currentNachricht.beschreibung}</td>
		</tr>
		</c:forEach>

	</table>
</main>

<%@ include file="footer.jspf"%>
