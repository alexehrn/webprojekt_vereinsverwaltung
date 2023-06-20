<%-- Alexander Ehrnstrasser: --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
	<html lang="de">
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
		<a href="../index.jsp">Zurück zum Login</a>
	
	</main>
	
	
	<%@ include file="footer.jspf" %> 
