<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style>

body {
 display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-image: url(img/Login.JPG);
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover; /* oder contain, je nach Wunsch */
}


main{
 width: 300px;
  margin: 0px auto;
 background-color: rgba(255, 255, 255, 0.6);
   text-align: center
}



</style>


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
				E-Mail:<br> <input type="text" name="email"
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


		<p>
			Noch kein Konto?<br> <a href="./home/registrierung.jsp"><button
					type="submit" name="registrieren">Registrieren</button></a>
		</p>
	</main>






</body>
</html>