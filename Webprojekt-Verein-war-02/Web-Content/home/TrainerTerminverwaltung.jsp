<%-- Quirin Gerstberger: --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
	<html lang="de">
		<head>
			<meta charset="UTF-8">
			<title>Trainer-Terminverwaltung</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			<link rel="icon" type="image/x-icon" href="../img/tapicon.png">			
			<script type="text/javascript" src="./javaskript/terminverwaltung.js"></script>
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



<main class="zentrieren">

	<h1>Upcoming Events</h1>

	<table>
		<tr>
			<th>Beschreibung</th>
			<th>Kategorie</th>
			<th>Ort</th>
			<th class="datumsspalte">Datum</th>
			<th class="datumsspalte">Uhrzeit</th>
			<th class="langertextspalte">Details</th>
			<th>Optionen</th>
		</tr>

			
		        <c:forEach var="currentTermin" items="${termine}" varStatus="status">
		            <tr>
		                <td>${currentTermin.kurzbeschreibung}</td>
		                <td>${currentTermin.kategorie}</td>
		                <td>${currentTermin.ort}</td>
		                <td class="datumsspalte">${currentTermin.day}.${currentTermin.month}.${currentTermin.year}</td>
		                <td class="datumsspalte">${currentTermin.uhrzeitVON}-${currentTermin.uhrzeitBIS}</td>
		                <td class="langertextspalte">${currentTermin.beschreibung}</td>
		                <td class="zentrierteschrift">
		                <a href="/Webprojekt-Verein-war-02/SearchServletTrainerTerminBearbeiten?id=${currentTermin.id}" class="button" title="Termin bearbeiten">&#x270E;</a>
		                <a href="/Webprojekt-Verein-war-02/TrainerTerminLoeschen?id=${currentTermin.id}" id="terminloeschen" class="button"  title="Termin löschen">&#x1F5D1;</a>
		                </td>
		            </tr>
		        </c:forEach>

		
		
	</table>

	<div id="platzhalter">
	<div id="terminformularzentrieren">

	<h1>Einen neuen Termin anlegen</h1>
	<form action="/Webprojekt-Verein-war-02/TrainerTerminverwaltungsServlet" method="post">
		<fieldset>
			<div>
				<label for="kurzbeschreibung">Beschreibung:</label>
				<input type="text" name="kurzbeschreibung" id="kurzbeschreibung" size="30" maxlength="20" required placeholder="Beschreibung (max. 20 Zeichen) eingeben">
			</div>
			<div>
				<label for="kategorie">Kategorie:</label>
				<select name="kategorie" id="kategorie" size="1" required>
						<option value="Training">Training</option>
						<option value="Spiel">Spiel</option>
							 <c:forEach var="currentKategorie" items="${kategorien}" varStatus="status">
								<option value="${currentKategorie.kategorie}">${currentKategorie.kategorie}</option>
							</c:forEach>
				</select>
				<button type="button" name="kategorienbearbeiten" id="kategorienbearbeiten" title="Kategorie bearbeiten">&#x270E;</button>
			</div>
			<div>
				<label for="ort">Ort:</label>
				<input type="text" name="ort" id="ort" size="30" maxlength="30" required placeholder="Ort eingeben">
			</div>
			<div>
				<label for="datum">Datum:</label>
			 	<input type="date" name="datum" id="datum" required>
			</div>
			<div>
				Uhrzeit: <br> 
				<label for="startzeit">Von:</label>
				<input type="time" name="startzeit" id="startzeit" required>
				<label for="endzeit">Bis:</label>
				<input type="time" name="endzeit" id="endzeit" required>
			</div>
			<div>
				<label for="trainer_eingabe">Details:</label>
				<textarea name="trainer_eingabe" id="trainer_eingabe" rows="4" cols="40" placeholder="Details eingeben... (max. 200 Zeichen)" maxlength="200"></textarea>
			</div>
			<div>
				<button type="submit" name="anlegen">Termin anlegen</button>
			</div>
		</fieldset>
	</form>
	</div>
	
	<div id="kategorieformausgeblendet">
	<h1  class="abwesenheitsline">Kategorieverwaltung</h1>
	
	
	<c:choose>
		<c:when test="${empty kategorien}">
				<table>
						<tr>
							<th>Kategorie</th>
						</tr>
						<tr>
							<td>Keine Kategorie vorhanden</td>
						</tr>
					</table>
			</c:when>
			<c:otherwise>
					<table>
						<tr>
							<th>Kategorie</th>
						</tr>
						
						 <c:forEach var="currentKategorie" items="${kategorien}" varStatus="status">
						<tr>
							<td>${currentKategorie.kategorie}	<a href="/Webprojekt-Verein-war-02/TrainerKategorieLoeschen?kategorie=${currentKategorie.kategorie}" id="kategorielöschen" class="button rightfloat"  title="Kategorie löschen">&#x1F5D1;</a></td>
						</tr>
						 </c:forEach>
					</table>
			
			</c:otherwise>
	
	</c:choose>
	
	</div>	
	
	<div id="neuekategorieausgeblendet">
	<h1 class="abwesenheitsline">Neue Kategorie</h1>
	<form action="/Webprojekt-Verein-war-02/TrainerKategorieAnlegen" method="get">
  	<div>
  	<input type="text" name="kategorie" id="kategorie" size="30" maxlength="20" required placeholder="Kategorie (max. 20 Zeichen) eingeben">
  	</div>
  	<div>
  	<button type="submit">Hinzufügen</button>
  	</div>
	</form>
	</div>
	</div>


	
</main>

<%@ include file="footer.jspf"%>