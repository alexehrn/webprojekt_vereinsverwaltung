<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="ErrorPage.jsp" %>
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

<main class="zentrieren">


	<h1>Termine</h1>
	<table> 
		<tr>
			<th>Beschreibung</th>
			<th class="datumsspalte">Datum</th>
			<th class="zentrierteschrift">Zusagen</th>
			<th class="zentrierteschrift">Absagen</th>
		</tr>
		
				<c:forEach var="currentRueckmeldung" items="${rueckmeldung}" varStatus="status">
					<tr>
						<td>${currentRueckmeldung.beschreibung}</td>
						<td class="datumsspalte">${currentRueckmeldung.datum}</td>
						<td class="zentrierteschrift">${currentRueckmeldung.zusagen}</td>
						<td class="zentrierteschrift">${currentRueckmeldung.absagen}</td>
					</tr>
				</c:forEach>
			

	</table>

	<h1>Geplante Abwesenheiten</h1>
	<table>
		<tr>
			<th></th>
			<th>Name</th>
			<th>Zeitraum</th>
			<th>Grund</th>
		</tr>
	
			
		        <c:forEach var="currentAbwesenheit" items="${abwesenheit}" varStatus="status">
		            <tr>
		                <td class="nummerspalte">${status.count}</td>
		                <td>${currentAbwesenheit.vorname} ${currentAbwesenheit.nachname}</td>
		                <td>${currentAbwesenheit.start} bis ${currentAbwesenheit.ende}</td>
		                <td class="zentrierteschrift">${currentAbwesenheit.grund}</td>
		            </tr>
		        </c:forEach>
		   

</table>

	<h1>Nachricht an das Team senden:</h1>
	<form action="/Webprojekt-Verein-war-02/TrainerHomeServlet" method="post" accept-charset="utf-8">
		<fieldset>
			<div class="zentrieren">
				<textarea name="trainer_eingabe" id="trainer_eingabe" rows="10" cols="100"></textarea>
			</div>
			<div class="zentrieren">
				<button type="submit" name="nachrichtAbsenden" value="submit">Absenden der Nachricht</button>
			</div>
		</fieldset>
	</form>


</main>

<%@ include file="footer.jspf"%>