<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="head.jspf" %> 


<nav>
   	  <a href="/Webprojekt-Verein-war-02/SearchServletSpielerHome">Dashboard</a>
      <a href="./SpielerKalender.jsp" class="active">Kalender</a>

</nav>

<main>
		<%@ include file="kalender.jspf" %> 
</main>

<%@ include file="footer.jspf" %> 