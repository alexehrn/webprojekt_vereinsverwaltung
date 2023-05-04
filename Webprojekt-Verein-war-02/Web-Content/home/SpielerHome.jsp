<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="head.jspf" %> 

<nav>
		<a href="./SpielerHome.jsp" class="active">Dashboard</a> 
		<a href="./SpielerKalender.jsp">Kalender</a>

</nav>



	<main>
		<p>Termine</p>
		<table border="1">
			<tr>
				<th>Beschreibung</th>
				<th>Datum</th>
				<th>Information</th>
				<th>Zusagen</th>
				<th>Absagen</th>
			</tr>

			<tr>
				<td>Trainingsbeispiel</td>
				<td>29.04.2022</td>
				<td>Bitte Laufschuhe mitbringen!</td>
				
			<td><form action="/Webprojekt-Verein-war-02/SpielerRueckmeldungServlet" method="get">
					<label for="zusage"></label>
					<button type="submit" id="zusage" name="rueckmeldung" value="zugesagt">Zusage</button>
				</td>
				<td>
						<label for="absage"></label>
						<button type="submit" id="absage" name="rueckmeldung" value="abgesagt">Absage</button>
				</td>
				</form>
			</tr>

			<tr>
				<td>Trainingsbeispiel</td>
				<td>31.04.2022</td>
				<td>Heute eine Stunde Abschlussspiel!</td>
				
				<td><form action="/Webprojekt-Verein-war-02/SpielerRueckmeldungServlet" method="get">
					<label for="zusage"></label>
					<button type="submit" id="zusage" name="rueckmeldung" value="zugesagt">Zusage</button>
				</td>
				<td>
						<label for="absage"></label>
						<button type="submit" id="absage" name="rueckmeldung" value="abgesagt">Absage</button>
				</td>
				</form>
			</tr>
		</table>
		
		<form action="/Webprojekt-Verein-war-02/SpielerAbwesenheitServlet" action="post">
			<p>Abwesenheit anlegen</p>
			<table border="1">
				<tr>
					<th>Beschreibung</th>
					<th>von</th>
					<th>bis</th>
				</tr>
				<tr>
				
					<td><textarea name="abwesenheit_eingabe" rows="1" cols="100"></textarea></td>
					<td><input type="date" id="startdatum" name="startdatum"></td>
					<td><input type="date" id="enddatum" name="enddatum"></td>
			</table>
			<button type="submit" name="abwesenheitAbsenden" value="submit">Abwesenheit absenden!</button>

		</form>
		<br>

		<table border="1">
			<tr>
				<th>Nachrichtenforum</th>
			</tr>

			<tr>
				<td>Glückwunsch zum Sieg, Buben!</td>

			</tr>

		</table>
	</main>
<%@ include file="footer.jspf" %> 