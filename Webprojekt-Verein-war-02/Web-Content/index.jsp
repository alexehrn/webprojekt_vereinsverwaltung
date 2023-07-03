<%-- Alexander Ehrnstrasser: --%>
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="de">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="icon" type="image/x-icon" href="./img/tapicon.png">
<base href="${pageContext.request.requestURI}" />
<link rel="stylesheet" type="text/css" href="./home/css/styleloginundregist.css">

</head>
<body>




	<main>
	
	<noscript><h1>Sie müssen Java-Skript aktivieren, <br>
	um die Anwendung optimal nutzen zu können !</h1></noscript>
	
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
				<div class="zentrieren">
					<button class="anmeldebutton" name="anmelden" type="submit"><span>Anmelden </span></button>
				</div>	
		</form>
		
		<form action="./home/registrierung.jsp" method="get">
		<div> Noch kein Konto? <button type="submit"><span>Registrieren </span></button>
		</div>
		</form>
	</main>

</body>
</html>