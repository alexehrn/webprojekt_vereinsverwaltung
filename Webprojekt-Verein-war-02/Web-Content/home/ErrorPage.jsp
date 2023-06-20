<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
	<html lang="de">
		<head>
			<meta charset="UTF-8">
			<title>Error-Page</title>
			<base href="${pageContext.request.requestURI}" />
			<link rel="stylesheet" type="text/css" href="../stylesheet.css">
			
		</head>

 <body>
	
	<%@ include file="head.jspf" %> 	
		
	<main class="zentrieren">	
	
	<h2>Oooooops hier ist etwas schief gelaufen....</h2>
	
	<p>Es ist ein Fehler aufgetreten! Bitte setzen Sie sich mit Ihrem Administrator in Verbindung: ingo@softwarehouse.de</p>
	<p>Die Fehlermeldung lautet: ${pageContext.exception}</p>
	<p>Stack trace:</p>
	<c:forEach var = "trace" items = "${pageContext.exception.stackTrace}">
      <p>${trace}</p>
   </c:forEach>
	
	</main>
	
	<%@ include file="footer.jspf" %> 
	</body>
</html>