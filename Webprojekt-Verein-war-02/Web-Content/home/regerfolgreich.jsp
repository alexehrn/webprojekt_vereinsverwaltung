<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
	<head>
		
		<meta charset="UTF-8">
		<title>Registrierungsformular ausgeben</title>
	</head>
	
	<body>
	
	<%@ include file="head.jspf" %> 	
		
	<h2>Registrierung erfolgreich</h2>
		<h3>Ihre Formulareingaben</h3>
		
		<br><b>Auswahl: </b>${registerform.auswahl}
		<br><b>Id: </b>${registerform.id}
		<br><b>Vorname: </b>${registerform.vorname}
		<br><b>Nachname: </b>${registerform.nachname}
		<br><b>Email: </b>${registerform.email}
		<br><b>Passwort: </b>${registerform.passwort}
		<br><b>Mannschaft: </b>${registerform.team}
		<br><b>Profilbild: </b> <br>
		<img src="BildVerarbeitungServlet?id=${registerform.id}">
		
		
	
	<%@ include file="footer.jspf" %> 
	</body>
</html>