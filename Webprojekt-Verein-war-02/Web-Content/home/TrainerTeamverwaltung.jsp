<%-- Alexander Ehrnstrasser: --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Trainer-Teamverwaltung</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			
		</head>

<body>
<%@ include file="head.jspf"%>


	<nav>
		<a href="/Webprojekt-Verein-war-02/SearchServletTrainerHome">Dashboard</a>   
		<a href="./TrainerKalender.jsp">Kalender</a>
		<a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSearch" class="active">Teamverwaltung</a>
		<a href="/Webprojekt-Verein-war-02/SearchServletTrainerTerminverwaltung">Terminverwaltung</a>

	</nav>

	<main class="zentrieren">
	
			<form method="post" action="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSpielerSuche">
			<fieldset><legend>Spieler hinzufügen</legend>
				<p>Hier können neu registrierte Spieler gefunden oder Spieler aus anderen Mannschaften des Vereins hinzugefügt werden</p>
				<div>
				  <label for="nachname">Nachname des Spielers:</label>
				  <input type="text" name="nachname" id="nachname" placeholder="Nachname des Spielers oder freilassen für alle Spieler" size="75">
				</div>
				<div>
				  <button name="submit" type="submit">Suchen</button>
				</div>
			</fieldset>
		</form>
			
			
			
			<h1>Deine Mannschaft:</h1>

			<table>
				<tr>
					<th>Nummer</th>
					<th>Bild</th>
					<th>Vorname</th>
					<th>Nachname</th>
				</tr>
				
				
			        <c:forEach var="currentSpieler" items="${spielerliste}" varStatus="status">
			            <tr>
			            	<td class="nummerspalte">${status.count}</td>
			            	<td></td>
			                <td>${currentSpieler.vorname}</td>
			                <td>${currentSpieler.nachname}</td>
			            </tr>
			        </c:forEach>
			   
			</table>
				
		

	</main>

<%@ include file="footer.jspf"%>