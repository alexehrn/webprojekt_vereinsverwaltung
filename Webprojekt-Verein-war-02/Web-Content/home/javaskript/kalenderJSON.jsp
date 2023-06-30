<%-- Gemeinsam erstellt: --%>

<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    [
    <c:forEach var="termin" items="${termine}" varStatus="status">
    {
    	"date":"${termin.datum}",
    	"title":"${termin.kurzbeschreibung}",
    	"time":"${termin.uhrzeitVON}"
     }<c:if test="${not status.last}">,</c:if>
    </c:forEach>
    ]
    