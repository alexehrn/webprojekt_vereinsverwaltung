<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jspf"%>


	<nav>
		<a href="./TrainerHome.jsp">Dashboard</a>                                       
		<a			href="./TrainerKalender.jsp">Kalender</a>                       
		<a href="./TrainerTeamverwaltung.jsp" class="active">Teamverwaltung</a>
		<a href="./TrainerTerminverwaltung.jsp">Terminverwaltung</a>

	</nav>

	<main>
	
	<h1>Spielerpool</h1>
			<table border="1">
				<tr>
					<th>Bild</th>
					<th>Name</th>
					<th>Vorname</th>
					<th>Registriert als</th>
					<th></th>
				</tr>
				<tr>
					<td>Hier kommt ein Bild</td>
					<td>Max</td>
					<td>Maier</td>
					<td>A-Jugend</td>
					<td><button type="submit" title="Neuen Spieler hinzufügen" name="hinzufügen">Hinzufügen</button></td>
				</tr>
				<tr>
					<td>Hier kommt ein Bild</td>
					<td>Max</td>
					<td>Maier</td>
					<td>A-Jugend</td>
					<td><button type="submit" title="Neuen Spieler hinzufügen" name="hinzufügen">Hinzufügen</button></td>
				</tr>
				<tr>
					<td>Hier kommt ein Bild</td>
					<td>Max</td>
					<td>Maier</td>
					<td>A-Jugend</td>
					<td><button type="submit" title="Neuen Spieler hinzufügen" name="hinzufügen">Hinzufügen</button></td>
				</tr>
				<tr>
					<td>Hier kommt ein Bild</td>
					<td>Max</td>
					<td>Maier</td>
					<td>A-Jugend</td>
					<td><button type="submit" title="Neuen Spieler hinzufügen" name="hinzufügen">Hinzufügen</button></td>
				</tr>
			</table>

	</main>

<%@ include file="footer.jspf"%>