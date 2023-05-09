<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jspf"%>


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
					<th>Name</th>
					<th>Vorname</th>
					<th>Position</th>
					<th><button type="submit" title="Neuen Spieler hinzufügen"
							name="hinzufügen">Hinzufügen</button></th>
				</tr>
				<tr>
					<td>Mustermann</td>
					<td>Max</td>
					<td>Stürmer</td>
					<td><button type="submit" title="Spieler löschen"
							name="spielerlöschen">&#x1F5D1;</button></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><button type="submit" title="Spieler löschen"
							name="spielerlöschen">&#x1F5D1;</button></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><button type="submit" title="Spieler löschen"
							name="spielerlöschen">&#x1F5D1;</button></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><button type="submit" title="Spieler löschen"
							name="spielerlöschen">&#x1F5D1;</button></td>
				</tr>
			</table>
		</section>

	</main>

<%@ include file="footer.jspf"%>