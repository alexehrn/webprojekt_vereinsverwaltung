<%-- Fabian Wolfsteiner: --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
	<html lang="de">
		<head>
			<meta charset="UTF-8">
			<title>Spieler-Home</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">	
			<link rel="icon" type="image/x-icon" href="../img/tapicon.png">
			
			<script type="text/javascript" src="./javaskript/abwesenheitscheck.js"></script>		
		</head>


<body>
<%@ include file="head.jspf"%>


<nav>
	<a href="/Webprojekt-Verein-war-02/SearchServletSpielerHome" class="active">Dashboard</a>
	<a href="./SpielerKalender.jsp">Kalender</a>

</nav>




<main class="zentrieren">




	<h1>News der letzten 7 Tage vom Trainerteam</h1>

	<c:choose>
  			<c:when test="${empty nachrichten}">
				<table>
						<tr>
							<th>Nachricht</th>
						</tr>
						<tr>
							<td>Es gibt keine Nachricht aus den letzten 7 Tagen.</td>
						</tr>
				
					</table>
			</c:when>
 			
 			<c:otherwise>
				<table>
					<tr>
						<th class="datumsspalte">Tag</th>
						<th>Nachrichtenforum</th>
					</tr>
					<c:forEach var="currentNachricht" items="${nachrichten}" varStatus="status">
						<tr>
						<td class="datumsspalte">${currentNachricht.day}.${currentNachricht.month}.${currentNachricht.year}</td>
						<td class="langertextspalte">${currentNachricht.beschreibung}</td>
						</tr>
					</c:forEach>
			
				</table>
 			</c:otherwise>
 	</c:choose>

	




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
				<td class="datumsspalte">${currentTermin.day}.${currentTermin.month}.${currentTermin.year}</td>
				<td class="uhrzeitspalte">${currentTermin.uhrzeitVON}</td>
				<td class="uhrzeitspalte">${currentTermin.uhrzeitBIS}</td>
				<td class="langertextspalte">${currentTermin.beschreibung}</td>
				<td class="zentrierteschrift">
					<form action="/Webprojekt-Verein-war-02/SpielerRueckmeldungServlet" method="get">
						<input type="hidden" name="id" value="${currentTermin.id}">
						<button class ="zubutton" type="submit" name="rueckmeldung" value="Zugesagt" title="Zusagen">&#10003;</button>
						<button class ="abbutton" type="submit" name="rueckmeldung" value="Abgesagt" title="Absagen">&#10005;</button>
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



	<c:choose>
  			<c:when test="${empty abwesenheiten}">
    				
					<h1>Neue Abwesenheit anlegen</h1>
						<form action="/Webprojekt-Verein-war-02/SpielerAbwesenheitServlet" method="post">
									<fieldset>
													<div>
														<label for="abwesenheit_eingabe">Grund:</label> 
														<input name="abwesenheit_eingabe" id="abwesenheit_eingabe" maxlength="25"  size="25" placeholder="max. 25 Zeichen" required>
													</div>
													<div>
														<label for="startdatum">von:</label>
														<input type="date" name="startdatum" id="startdatum" required>
													</div>
													<div>
														<label for="enddatum">bis:</label> 
														<input type="date" name="enddatum" id="enddatum" required>
													</div>
													<div>
													<span id="abwesenheitserror"></span>
													</div>
													<div class="zentrieren">
														<button type="submit" name="abwesenheitAbsenden" id="abwesenheitsenden" value="submit">Abwesenheit absenden!</button>
													</div>
									</fieldset>
									</form>
 			</c:when>
 					<c:otherwise>
  							<div id="flexarea">
								<div id="abwesenheitstable">
								<h1 class="abwesenheitsline">Meine geplanten Abwesenheiten</h1>
									<table>
										<tr>
											<th>Nr.</th>
											<th>Beschreibung</th>
											<th>von</th>
											<th>bis</th>
											<th></th>
										</tr>
									<c:forEach var="currentAbwesenheit" items="${abwesenheiten}" varStatus="status">
										<tr>
											<td>${status.count}</td>
											<td>${currentAbwesenheit.grund}</td>
											<td>${currentAbwesenheit.startday}.${currentAbwesenheit.startmonth}.${currentAbwesenheit.startyear}</td>
											<td>${currentAbwesenheit.endeday}.${currentAbwesenheit.endemonth}.${currentAbwesenheit.endeyear}</td>
											<td class="zentrierteschrift">
												<a href="/Webprojekt-Verein-war-02/SpielerAbwesenheitLoeschen?id=${currentAbwesenheit.id}" class="button abwesenheitloeschen" title="Abwesenheit löschen">&#x1F5D1;</a> 
									        </td>
										</tr>
									</c:forEach>
									</table>
								</div>
								
								<div id="abwesenheitsform">
								<h1 class="abwesenheitsline">Neue Abwesenheit anlegen</h1>
									<form action="/Webprojekt-Verein-war-02/SpielerAbwesenheitServlet" method="post">
									<fieldset>
													<div>
														<label for="abwesenheit_eingabe">Grund:</label> 
														<input name="abwesenheit_eingabe" id="abwesenheit_eingabe" maxlength="25"  size="25" placeholder="max. 25 Zeichen" required>
													</div>
													<div>
														<label for="startdatum">von:</label>
														<input type="date" name="startdatum" id="startdatum" required>
													</div>
													<div>
														<label for="enddatum">bis:</label> 
														<input type="date" name="enddatum" id="enddatum" required>
													</div>
													<div>
													<span id="abwesenheitserror"></span>
													</div>
													<div>
														<button type="submit" name="abwesenheitAbsenden" id="abwesenheitsenden" value="submit">Abwesenheit absenden!</button>
													</div>
									</fieldset>
									</form>
								</div>
							</div>
					</c:otherwise>
	</c:choose>

	




</main>
<%@ include file="footer.jspf"%>
