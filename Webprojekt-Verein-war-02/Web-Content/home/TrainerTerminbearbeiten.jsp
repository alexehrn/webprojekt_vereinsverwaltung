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
			
		</head>

<body>
<%@ include file="head.jspf"%>

<nav>
	<a href="/Webprojekt-Verein-war-02/SearchServletTrainerHome">Dashboard</a>   
	<a href="./TrainerKalender.jsp">Kalender</a>
	<a href="/Webprojekt-Verein-war-02/TrainerTeamverwaltungSearch">Teamverwaltung</a>
	<a href="/Webprojekt-Verein-war-02/SearchServletTrainerTerminverwaltung" class="active">Terminverwaltung</a>
	
</nav>



<main class="zentrieren">

	<h1>Termin bearbeiten</h1>
	<form action="/Webprojekt-Verein-war-02/TrainerTerminBearbeiten?id=${param.id}" method="post">
		<fieldset>
			<div>
				<label for="kurzbeschreibung">Beschreibung:</label>
				<input type="text" name="kurzbeschreibung" id="kurzbeschreibung" size="30" maxlength="20" required value="${termin.kurzbeschreibung}">
			</div>
			<div>
				<label for="ort">Ort:</label>
				<input type="text" name="ort" id="ort" size="30" maxlength="30" required value="${termin.ort}">
			</div>
			<div>
				<label for="datum">Datum:</label>
			 	<input type="date" name="datum" id="datum" required value="${termin.datum}">
			</div>
			<div>
				Uhrzeit: <br> 
				<label for="startzeit">Von:</label>
				<input type="time" name="startzeit" id="startzeit" required value="${termin.uhrzeitVON}">
				<label for="endzeit">Bis:</label>
				<input type="time" name="endzeit" id="endzeit" required value="${termin.uhrzeitBIS}">
			</div>
			<div>
				<label for="trainer_eingabe">Details:</label>
				<textarea name="trainer_eingabe" id="trainer_eingabe" rows="4" cols="40" placeholder="Details eingeben... (max. 200 Zeichen)" maxlength="200">${termin.beschreibung}</textarea>
			</div>
			<div>
				<button type="submit" name="aktualisieren">Termin aktualisieren</button>
			</div>
		</fieldset>
	</form>
</main>

<%@ include file="footer.jspf"%>