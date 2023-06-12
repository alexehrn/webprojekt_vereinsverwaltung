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




<main class="zentrieren">

	<h1>News der letzten 7 Tage vom Trainerteam</h1>

	<table>
		<tr>
			<th class="datumsspalte">Tag</th>
			<th>Nachrichtenforum</th>
		</tr>
	<c:forEach var="currentNachricht" items="${nachrichten}" varStatus="status">
		<tr>
		<td class="datumsspalte">${currentNachricht.tag}</td>
		<td class="langertextspalte">${currentNachricht.beschreibung}</td>
		</tr>
		</c:forEach>

	</table>




	<h1>Upcoming Events</h1>
	<table>
		<tr>
			<th>Beschreibung</th>
			<th>Ort</th>
			<th class="datumsspalte">Datum</th>
			<th class="uhrzeitspalte">Beginn</th>
			<th class="uhrzeitspalte">Ende</th>
			<th class="langertextspalte">Information</th>
			<th class="buttonspalte">Meldung</th>
			<th>Status</th>
		</tr>

		<c:forEach var="currentTermin" items="${termine}" varStatus="status">
			<tr>
				<td>${currentTermin.kurzbeschreibung}</td>
				<td>${currentTermin.ort}</td>
				<td class="datumsspalte">${currentTermin.datum}</td>
				<td class="uhrzeitspalte">${currentTermin.uhrzeitVON}</td>
				<td class="uhrzeitspalte">${currentTermin.uhrzeitBIS}</td>
				<td class="langertextspalte">${currentTermin.beschreibung}</td>
				<td class="zentrierteschrift">
					<form action="/Webprojekt-Verein-war-02/SpielerRueckmeldungServlet" method="get">
						<input type="hidden" name="id" value="${currentTermin.id}">
						<button class ="zubutton" type="submit" name="rueckmeldung" value="Zugesagt">&#10003</button>
						<button class ="abbutton" type="submit" name="rueckmeldung" value="Abgesagt">X</button>
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

	
	<h1>Meine geplanten Abwesenheiten</h1>
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
			<tr>
				<th colspan="4">Neue Abwesenheit anlegen</th>
			</tr>
			<tr>
				<form action="/Webprojekt-Verein-war-02/SpielerAbwesenheitServlet" action="post">
				<td>Grund: <input name="abwesenheit_eingabe" id="abwesenheit_eingabe" required></input></td>
				<td>von: <input type="date" name="startdatum" id="startdatum" required></td>
				<td>bis: <input type="date" name="enddatum" id="enddatum" required></td>
				<td><button type="submit" name="abwesenheitAbsenden" value="submit">Abwesenheit absenden!</button></td>
				</form>
			</tr>
		</table>
	
	

</main>

<%@ include file="footer.jspf"%>
