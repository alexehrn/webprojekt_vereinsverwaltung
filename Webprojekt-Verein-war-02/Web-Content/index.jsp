<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>


	<main>
		<h1>Login</h1>

		<form action="LogInServlet" method="post">
			<p>
				<input type="radio" name="auswahl" id="r1" value="Spieler" checked>
				<label for="r1">Spieler</label> <input type="radio" name="auswahl"
					id="r2" value="Trainer"> <label for="r2">Trainer</label>
			</p>

			<p>
				E-Mail <br> <input type="text" name="email"
					size="30" maxlength="30" required placeholder="Ihr Benutzername">
			</p>
			<p>
				Passwort: <br> <input type="password" name="passwort" size="30"
					maxlength="30" required placeholder="Ihr Passwort">
			</p>
			<p>
				<button type="submit" name="anmelden">
					Anmelden
				</button>
			</p>

		</form>


	</main>
	<footer>
		<p>
			Noch kein Konto?<br> <a href="./home/registrierung.jsp"><button
					type="submit" name="registrieren">Registrieren</button></a>
		</p>
	</footer>






</body>
</html>