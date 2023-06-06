<%-- Alexander Ehrnstrasser: --%>
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrierung</title>

<link rel="stylesheet" type="text/css" href="./css/styleloginundregist.css">

</head>
<body>
	

	<main>
		<h1>Registrierung</h1>

		<form action="/Webprojekt-Verein-war-02/RegistrierungsServlet" method="post" accept-charset="utf-8"  enctype="multipart/form-data">
			<fieldset>
				<div>Ich bin:<br>
					<label for="r1">Spieler</label>
					<input type="radio" name="auswahl" id="r1" value="Spieler" checked>  
					<label for="r2">Trainer</label>
					<input type="radio" name="auswahl" id="r2" value="Trainer"> 
				</div>
				<div>
					<label for="vorname">Vorname:</label>
					<input type="text" name="vorname" id="vorname" size="30" maxlength="30" required placeholder="Ihr Vorname">
				</div>
				<div>
					<label for="nachname">Nachname:</label>
					<input type="text" name="nachname" id="nachname" size="30" maxlength="30" required placeholder="Ihr Nachname">
				</div>
				<div>
					<label for="email">E-Mail:</label>
					<input type="email" name="email" id="email" size="30" maxlength="30" required placeholder="Ihre E-Mail-Adresse">
				</div>
				<div>
					<label for="passwort">Passwort:</label>
					<input type="password" name="passwort" id="passwort" size="30" maxlength="30" minlength="6" required placeholder="Ihr Passwort">
				</div>
				<div>
					<label for="passwort2">Passwort wiederholen:</label>
					<input type="password" name="passwort" id="passwort2" size="30" maxlength="30" minlength="6" required placeholder="Bitte Passwort wiederholen">
				</div>
				<%-- JavaSkript wenn Trainer ausgewählt ist keine möglichkeit bild hochzuladen --%>
				<div>
					<label for="image">Profilbild hochladen:</label>
					<input type="file" name="image" id="image" accept="image/*" required>
					<br>max. 1 MB
				</div>
				<div>
					<label for="team">Team auswählen:</label>
					<select name="team" id="team" size="8">
						<option value="1. Mannschaft">1. Mannschaft</option>
						<option value="2. Mannschaft">2. Mannschaft</option>
						<option value="A-Jugend">A-Jugend</option>
						<option value="B-Jugend">B-Jugend</option>
						<option value="C-Jugend">C-Jugend</option>
						<option value="D-Jugend">D-Jugend</option>
						<option value="F-Jugend">F-Jugend</option>
						<option value="G-Jugend">G-Jugend</option>
					</select>
				</div>
				<div>
					<button type="submit" name="absenden">Registrieren</button>
					<button name="reset" type="reset">Zurücksetzen</button>
				</div>
			</fieldset>
		</form>

	</main>
	

</body>
</html>