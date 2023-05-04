<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrierung</title>
</head>
<body>
	<h1>Registrierung</h1>

	<main>


		<form action="/Webprojekt-Verein-war-02/RegistrierungsServlet" method="post" accept-charset="utf-8">
			<p>Ich bin:<br>
			<input type="radio" name="auswahl" id="r1" value="spieler" checked> <label for="r1">Spieler</label> 
			<input type="radio" name="auswahl" id="r2" value="trainer"> <label for="r2">Trainer</label>
			</p>
			
			<p>Vorname: <br> <input type="text" name="vorname" 
			size="30" maxlength="30" required placeholder="Ihr Vorname">
			</p>
			
			<p>Nachname: <br> <input type="text" name="nachname" 
			size="30" maxlength="30" required placeholder="Ihr Nachname">
			</p>
			
			<p>
				E-Mail: <br> <input type="text" name="email" size="30"
					maxlength="30" required placeholder="Ihre E-Mail-Adresse">
			</p>
			<p>
				Passwort: <br>
				<input type="password" name="passwort" size="30" maxlength="30" minlength="6"
					required placeholder="Ihr Passwort">
			</p>
			<p>
				Passwort wiederholen: <br>
				<input type="password" name="passwort" size="30" maxlength="30" minlength="6"
					required placeholder="Bitte Passwort wiederholen">
			</p>
			<p>Team auswählen:</p>
			<select name="team" size="8">
				<option value="1Man">1. Mannschaft</option>
				<option value="2Man">2. Mannschaft</option>
				<option value="AJug">A-Jugend</option>
				<option value="BJug">B-Jugend</option>
				<option value="CJug">C-Jugend</option>
				<option value="DJug">D-Jugend</option>
				<option value="FJug">F-Jugend</option>
				<option value="GJug">G-Jugend</option>
			</select>
			<p>
				<button type="submit" name="absenden">Registrieren</button>
			</p>
		</form>

	</main>
	<footer>
		<a href="../index.jsp">Zurück zum Login</a>
	</footer>






</body>
</html>