<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jspf"%>

<nav>
	<a href="/Webprojekt-Verein-war-02/SearchServletSpielerHome" class="active">Dashboard</a>
	<a href="./SpielerKalender.jsp">Kalender</a>

</nav>




<main>
	<p>Termine</p>
	<table border="1">
		<tr>
			<th>Nummer</th>
			<th>Beschreibung</th>
			<th>Ort</th>
			<th>Datum</th>
			<th>Beginn</th>
			<th>Ende</th>
			<th>Information</th>
			<th>Meldung</th>
			<th>Status</th>
		</tr>

		<c:forEach var="currentTermin" items="${termine}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${currentTermin.kurzbeschreibung}</td>
				<td>${currentTermin.ort}</td>
				<td>${currentTermin.datum}</td>
				<td>${currentTermin.uhrzeitVON}</td>
				<td>${currentTermin.uhrzeitBIS}</td>
				<td>${currentTermin.beschreibung}</td>
				<td>
					<form action="/Webprojekt-Verein-war-02/SpielerRueckmeldungServlet" method="get">
						<input type="hidden" name="id" value="${currentTermin.id}">
						<button type="submit" name="rueckmeldung" value="Zugesagt">Zusage</button>
						<button type="submit" name="rueckmeldung" value="Abgesagt">Absage</button></td>
					</form>
				<td>
				Status
				</td>
				   
			</tr>
			</c:forEach>
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
		<button type="submit" name="abwesenheitAbsenden" value="submit">Abwesenheit
			absenden!</button>

	</form>
	<br>

	<table border="1">
		<tr>
			<th>Tag</th>
			<th>Nachrichtenforum</th>
		</tr>
	<c:forEach var="currentNachricht" items="${nachrichten}" varStatus="status">
		<tr>
		<td>${currentNachricht.tag}</td>
		<td>${currentNachricht.beschreibung}</td>
		</tr>
		</c:forEach>

	</table>
</main>
<%@ include file="footer.jspf"%>
