<%-- Alexander Ehrnstrasser: --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Spieler-Kalender</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			
		</head>

<body>
<%@ include file="head.jspf" %> 

<nav>
   	  <a href="/Webprojekt-Verein-war-02/SearchServletSpielerHome">Dashboard</a>
      <a href="./SpielerKalender.jsp" class="active">Kalender</a>

</nav>


<%@ include file="kalender.jspf" %> 


<%@ include file="footer.jspf" %> 