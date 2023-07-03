<%-- Fabian Wolfsteiner: --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Wichtiger Hinweis</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			<link rel="icon" type="image/x-icon" href="../img/tapicon.png">
			
		</head>

 <body>
	
	<%@ include file="head.jspf" %> 	
		
	<main class="zentrieren">	
	
	<h2>Wichtiger Hinweis!</h2>
	
	<p>Deine Registrierung in unserer Vereinsverwaltung-Software war bereits erfolgreich.</p>
	<p>Leider hat dich dein Trainer noch nicht zur Mannschaft zugeordnet.</p>
	<p>Informiere bitte deinen Trainer persönlich, dass er dich zuordnen soll.</p>
	<p>Klicke oben rechts auf den Logout-Button, um die Session zu verlassen.</p>
	
	</main>
	
	<%@ include file="footer.jspf" %> 