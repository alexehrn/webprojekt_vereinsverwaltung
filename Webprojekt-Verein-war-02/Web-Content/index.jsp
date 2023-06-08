<%-- Alexander Ehrnstrasser: --%>
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="stylesheet" type="text/css" href="./home/css/styleloginundregist.css">

</head>
<body>



	<main>
		<h1>Login</h1>
		<form id="loginForm" action="LogInServlet" method="post">
				<div>
					<label>Einloggen als:</label>
					<input type="radio" name="auswahl" id="r1" value="Spieler" checked>
					<label for="r1" class="nomargin">Spieler</label>
					<input type="radio" name="auswahl" id="r2" value="Trainer">
					<label for="r2" class="nomargin">Trainer</label>
				</div>
				<div> 
					<label for="email">E-Mail:</label>
					<input type="email" name="email" id="email" size="30" maxlength="30" required placeholder="Ihre E-Mail-Adresse">
				</div>
				<div>
					<label for="passwort">Passwort:</label>
					<input type="password" name="passwort" id="passwort" size="30" maxlength="30" required placeholder="Ihr Passwort">
				</div>
				<div>
					<button name="anmelden" type="submit">Anmelden</button>
				</div>	
		</form>
		
		<div>
		Noch kein Konto?
		<a href="./home/registrierung.jsp"><button name="registrieren" type="submit" >Registrieren</button></a>
		</div>
	</main>

</body>
</html>