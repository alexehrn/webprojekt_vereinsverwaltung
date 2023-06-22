<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Cookies-Nutzung</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			
		</head>

 <body>
	
	<%@ include file="head.jspf" %> 	
		
	<main class="zentrieren">	
	
	<h2>Wichtiger Hinweis!</h2>
	
	<p>Die Nutzung von Cookies ist für die Webanwendung zwingend erforderlich.</p>
	<p>Bitte aktiviere die Cookies in deinem Browser und versuche dich nochmal anzumelden.</p>
	
	<a class="button" href="../index.jsp">zum Login</a>
	
	
	</main>
	
	<%@ include file="footer.jspf" %> 