<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jspf"%>

	<nav>
		 <a href="./TrainerHome.jsp">Dashboard</a>                                         <!-- LINK STIMMT NOCH NICHT!! -->
		<a	href="./TrainerKalender.jsp">Kalender</a>                                     <!-- LINK STIMMT NOCH NICHT!! -->
		<a href="./TrainerTeamverwaltung.jsp">Teamverwaltung</a> <a
			href="./TrainerTerminverwaltung.jsp" class="active">Terminverwaltung</a>

	</nav>


	<main>

	<h1>Upcoming Events</h1>

			<table border="1">
				<tr>
					<th>Kurzbeschreibung</th>
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


<h1>Einen neuen Termin anlegen</h1>


		
					
				
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
								Uhrzeit: <br>
								Von: <input type="time" name="startzeit"> <br>
								Bis: <input type="time" name="endzeit">
							</p>
							<p>
								Details: <br>
								<textarea name="trainer_eingabe" rows="10" cols="50"
									placeholder="Beschreibung eingeben..."></textarea>
							</p>
							<p>
								<button type="submit" name="anlegen">Termin anlegen</button>
							</p>
						</form>



	</main>

<%@ include file="footer.jspf"%>