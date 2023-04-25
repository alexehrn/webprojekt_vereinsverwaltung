<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		
		<meta charset="UTF-8">
		<title>Registrierungsformular ausgeben</title>
	</head>
	<body>
		
		
	<h2>Registrierung erfolgreich</h2>
		<h3>Ihre Formulareingaben</h3>
		
		<br><b>Auswahl: </b>${registerform.auswahl}
		<br><b>Vorname: </b>${registerform.vorname}
		<br><b>Nachname: </b>${registerform.nachname}
		<br><b>Email: </b>${registerform.email}
		<br><b>Geburtsjahr: </b>${registerform.passwort}
		<br><b>Mannschaft: </b>${registerform.team}
		
	</body>
</html>