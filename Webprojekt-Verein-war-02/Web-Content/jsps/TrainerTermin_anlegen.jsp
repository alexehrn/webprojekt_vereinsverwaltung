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
		
		
	<h2>Termin erfolgreich angelegt</h2>
		<h3>Ihr Termin:</h3>
		
		<br><b>Kurzbeschreibung: </b>${trainerTerminverwaltungsBean.kurzbeschreibung}
		<br><b>Ort: </b>${trainerTerminverwaltungsBean.ort}
		<br><b>Datum: </b>${trainerTerminverwaltungsBean.datum}
		<br><b>Von: </b>${trainerTerminverwaltungsBean.uhrzeitVON}
		<br><b>Bis: </b>${trainerTerminverwaltungsBean.uhrzeitBIS}
		<br><b>Beschreibung: </b>${trainerTerminverwaltungsBean.beschreibung}
		
	</body>
</html>