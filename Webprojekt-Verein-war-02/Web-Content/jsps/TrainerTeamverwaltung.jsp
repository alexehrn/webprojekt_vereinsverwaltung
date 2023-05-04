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

<%@ include file="footer.jspf"%>