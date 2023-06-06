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
		
		<br><b>Auswahl: </b>${registerform.auswahl}
		<br><b>Vorname: </b>${registerform.vorname}
		<br><b>Nachname: </b>${registerform.nachname}
		<br><b>Email: </b>${registerform.email}
		<br><b>Passwort: </b>${registerform.passwort}
		<br><b>Mannschaft: </b>${registerform.team}
		<br>
		<br>
		<a href="../index.jsp">zurück zum Login</a>
	
	</main>
	
	<%@ include file="footer.jspf" %> 
	</body>
</html>