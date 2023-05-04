<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jspf"%>


	<nav>
		<a href="./TrainerHome.jsp">Dashboard</a>                                   <!-- LINK STIMMT NOCH NICHT!! -->    
		<a href="./TrainerKalender.jsp"  class="active">Kalender</a>                         
		<a href="./TrainerTeamverwaltung.jsp">Teamverwaltung</a>
		<a href="./TrainerTerminverwaltung.jsp">Terminverwaltung</a>

	</nav>

	<main>
		<%@ include file="kalender.jspf" %> 
	</main>

<%@ include file="footer.jspf"%>