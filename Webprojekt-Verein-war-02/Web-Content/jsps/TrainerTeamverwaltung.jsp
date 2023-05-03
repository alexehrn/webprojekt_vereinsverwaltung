<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jspf"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teamverwaltung</title>
<style>
body {
	font-family: Arial;
}

/* Styling for the navigation */
nav {
	display: flex;
	justify-content: space-between;
	background-color: #000000;
	color: #fff;
	padding: 10px;
}

/* Styling for the navigation links */
nav a {
	color: #fff;
	text-decoration: none;
	padding: 10px;
}

/* Styling for the active link */
nav .active {
	background-color: #fff;
	color: #333;
}

main {
	background-color: #fff;
	padding: 300px;
}

td, th {
	padding: 8px;
	text-align: left;
	width: 25%;
}

/* Styling für die Tabellenüberschrift */
th {
	font-size: 18px;
	font-weight: bold;
}
</style>

</head>
<body>




	<nav>
		<a href="./TrainerHome.jsp">Dashboard</a>                                   <!-- LINK STIMMT NOCH NICHT!! -->    
		<a			href="./TrainerKalender.jsp">Kalender</a>                       <!-- LINK STIMMT NOCH NICHT!! -->   
		<a href="./TrainerTeamverwaltung.jsp" class="active">Teamverwaltung</a>
		<a href="./TrainerTerminverwaltung.jsp">Terminverwaltung</a>

	</nav>

	<main>

		<section>
			<table border="1">
				<tr>
					<th><h1>Name</h1></th>
					<th><h1>Vorname</h1></th>
					<th><h1>Position</h1></th>
					<th><button type="submit" title="Neuen Spieler hinzufügen"
							name="hinzufügen">Hinzufügen</button></th>
				</tr>
				<tr>
					<th>Mustermann</th>
					<th>Max</th>
					<th>Stürmer</th>
					<th><button type="submit" title="Spieler löschen"
							name="spielerlöschen">&#x1F5D1;</button></th>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th><button type="submit" title="Spieler löschen"
							name="spielerlöschen">&#x1F5D1;</button></th>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th><button type="submit" title="Spieler löschen"
							name="spielerlöschen">&#x1F5D1;</button></th>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th><button type="submit" title="Spieler löschen"
							name="spielerlöschen">&#x1F5D1;</button></th>
				</tr>
			</table>
		</section>

	</main>


</body>
</html>
<%@ include file="footer.jspf"%>