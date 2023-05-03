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
		 <a href="./TrainerHome.jsp">Dashboard</a>                                         <!-- LINK STIMMT NOCH NICHT!! -->
		<a	href="./TrainerKalender.jsp">Kalender</a>                                     <!-- LINK STIMMT NOCH NICHT!! -->
		<a href="./TrainerTeamverwaltung.jsp">Teamverwaltung</a> <a
			href="./TrainerTerminverwaltung.jsp" class="active">Terminverwaltung</a>

	</nav>


	<main>

		<section>
			<table border="1">
				<tr>
					<th>Beschreibung</th>
					<th>Ort</th>
					<th>Datum</th>
					<th>Uhrzeit</th>
					<th>Details</th>
					<th>Optionen</th>
				</tr>
				<tr>
					<td>Beispielevent</td>
					<td>Fahlenbach</td>
					<td>12.05.2023</td>
					<td>8:00 - 14:00 Uhr</td>
					<td>Laufschuhe mitbringen</td>
					<td>
						<button type="submit" title="Termin bearbeiten" name="bearbeiten">&#x270E;</button>
						<button type="submit" title="Termin löschen" name="terminlöschen">&#x1F5D1;</button>
					</td>
				</tr>
				<tr>
					<td>Beispielevent</td>
					<td>Fahlenbach</td>
					<td>12.05.2023</td>
					<td>8:00 - 14:00 Uhr</td>
					<td>Langes Abschlussspiel</td>
					<td>
						<button type="submit" title="Termin bearbeiten" name="bearbeiten">&#x270E;</button>
						<button type="submit" title="Termin löschen" name="terminlöschen">&#x1F5D1;</button>
					</td>
				</tr>
				<tr>
					<td>Beispielevent</td>
					<td>Fahlenbach</td>
					<td>12.05.2023</td>
					<td>8:00 - 14:00 Uhr</td>
					<td>A-Jugendspieler schnuppern rein</td>
					<td>
						<button type="submit" title="Termin bearbeiten" name="bearbeiten">&#x270E;</button>
						<button type="submit" title="Termin löschen" name="terminlöschen">&#x1F5D1;</button>
					</td>
				</tr>
			</table>
		</section>

		<section>
			<table border="1">
				<tr>
					<th><h1>Einen neuen Termin anlegen</h1></th>
				</tr>
				<tr>
					<th>
						<form
							action="/Webprojekt-Verein-war-02/TrainerTerminverwaltungsServlet"
							method="post">
							<p>
								Kurzbeschreibung: <br> <input type="text"
									name="kurzbeschreibung" size="30" maxlength="30" required
									placeholder="Kurzbeschreibung eingeben">
							</p>
							<p>
								Ort: <br> <input type="text" name="ort" size="30"
									maxlength="30" required placeholder="Ort eingeben">
							</p>
							<p>
								Datum: <br> <input type="date" name="datum">
							</p>
							<p>
								Uhrzeit: <br> Von: <input type="time" name="startzeit">
								<br> Bis: <input type="time" name="endzeit">
							</p>
							<p>
								Beschreibung: <br>
								<textarea name="trainer_eingabe" rows="10" cols="50"
									placeholder="Beschreibung eingeben..."></textarea>
							</p>
							<p>
								<button type="submit" name="anlegen">Termin anlegen</button>
							</p>
						</form>


					</th>
				</tr>

			</table>
		</section>

	</main>


</body>
</html>
<%@ include file="footer.jspf"%>