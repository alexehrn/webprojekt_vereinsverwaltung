<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrierung</title>


<style>

body {
 	display: flex;
  	align-items: center;
  	justify-content: center;
	height:100vh;
	
  	background-image: url(../img/Login.JPG);
  	background-repeat: no-repeat;
  	background-attachment: fixed;
  	background-size: cover;
}


main{
 
 width: 300px;
  margin: 0px auto;
 background-color: rgba(255, 255, 255, 0.7);
 text-align: center

}
</style>
</head>
<body>
	

	<main>
		<h1>Registrierung</h1>

		<form action="/Webprojekt-Verein-war-02/RegistrierungsServlet" method="post" accept-charset="utf-8" enctype="multipart/form-data">
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
				E-Mail: <br> <input type="email" name="email" size="30"
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
			
			<p>
				Profilbild hochladen: <br>
				<input type="file" name="image" id="image" accept="image/*" required>
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
	






</body>
</html>