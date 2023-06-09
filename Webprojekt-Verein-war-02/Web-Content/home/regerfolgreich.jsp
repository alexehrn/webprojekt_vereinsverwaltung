<%-- Alexander Ehrnstrasser: --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Registrierungsformular ausgeben</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			
		</head>

<body>
	
	<%@ include file="head.jspf" %> 	
	
	<main class="zentrieren">
		
	<h2>Registrierung erfolgreich</h2>
		
		<p><b>Auswahl: </b>${registerform.auswahl}</p>
		<p><b>Vorname: </b>${registerform.vorname}</p>
		<p><b>Nachname: </b>${registerform.nachname}</p>
		<p><b>Email: </b>${registerform.email}</p>
		<p><b>Passwort: </b>${registerform.passwort}</p>
		<p><b>Mannschaft: </b>${registerform.team}</p>
		
		<p>Dein Trainer muss dich noch, bei der bei deiner Registrierung gewählten Mannschaft, zuordnen.</p>
	    <p>Informiere bitte deinen Trainer persönlich, dass er dich zuordnen soll und damit deinen User freigeben soll.</p>
		
		<a href="../index.jsp"><button >zurück zum Login</button></a>
	
	</main>
	
	<%@ include file="footer.jspf" %> 
	</body>
</html>