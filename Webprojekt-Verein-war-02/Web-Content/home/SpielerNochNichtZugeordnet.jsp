<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Wichtiger Hinweis</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			
		</head>

 <body>
	
	<%@ include file="head.jspf" %> 	
		
	<main class="zentrieren">	
	
	<h2>Wichtiger Hinweis!</h2>
	
	<p>Deine Registrierung in unserer Vereinsverwaltung-Software war bereits erfolgreich</p>
	<p>Leider hat dich dein Trainer noch nicht, zu der bei deiner Registrierung gewählten Mannschaft, zugeordnet.</p>
	<p>Informiere bitte deinen Trainer persönlich, dass er dich zuordnen soll und damit deinen User freigeben soll.</p>
	<p>Klicke oben rechts auf den Logout-Button, um die Session zu verlassen.</p>
	
	</main>
	
	<%@ include file="footer.jspf" %> 
	</body>
</html>