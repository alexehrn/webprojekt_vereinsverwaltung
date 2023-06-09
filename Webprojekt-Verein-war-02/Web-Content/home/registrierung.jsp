<%-- Alexander Ehrnstrasser: --%>
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrierung</title>

<link rel="stylesheet" type="text/css" href="./css/styleloginundregist.css">


<script>
window.onload = function() {
    var trainerRadio = document.getElementById("r2");
    var imageInput = document.getElementById("image");

    <%-- Wenn Trainer gewählt wurde kann kein Foto hochgeladen werden --%>
    
    trainerRadio.addEventListener("click", function() {
      imageInput.disabled = true;
    });

    var playerRadio = document.getElementById("r1");
    playerRadio.addEventListener("click", function() {
      imageInput.disabled = false;
    });
  };
  
  window.onload = function() {
	  var passwortInput = document.getElementById("passwort");
	  var passwort2Input = document.getElementById("passwort2");
	  var passwortError = document.getElementById("passwortError");
	  var registrierungsButton = document.querySelector('button[name="absenden"]');

	  passwort2Input.addEventListener("input", function() {
	    if (passwortInput.value !== passwort2Input.value) {
	      passwortError.innerHTML = "Die Passwörter stimmen nicht überein.";
	      passwortError.style.color = "red";
	      registrierungsButton.disabled = true;
	    } else {
	      passwortError.innerHTML = "";
	      registrierungsButton.disabled = false;
	    }
	  });
	};
</script>

</head>
<body>
	

	<main>
		<h1>Registrierung</h1>

		<form action="/Webprojekt-Verein-war-02/RegistrierungsServlet" method="post" accept-charset="utf-8"  enctype="multipart/form-data">
				<div>
					<label>Ich bin: </label>
					<input type="radio" name="auswahl" id="r1" value="Spieler" checked>  
					<label for="r1" class="nomargin">Spieler</label>
					<input type="radio" name="auswahl" id="r2" value="Trainer"> 
					<label for="r2" class="nomargin">Trainer</label>
				</div>
				<div>
					<label for="vorname">Vorname:</label>
					<input type="text" name="vorname" id="vorname" size="30" maxlength="30" required placeholder="Ihr Vorname">
					<span></span>
				</div>
				<div>
					<label for="nachname">Nachname:</label>
					<input type="text" name="nachname" id="nachname" size="30" maxlength="30" required placeholder="Ihr Nachname">
					<span></span>
				</div>
				<div>
					<label for="email">E-Mail:</label>
					<input type="email" name="email" id="email" size="30" maxlength="30" required placeholder="Ihre E-Mail-Adresse">
					<span></span>
				</div>
				<div>
					<label for="passwort">Passwort:</label>
					<input type="password" name="passwort" id="passwort" size="30" maxlength="30" minlength="6" required placeholder="Ihr Passwort">
					<span></span>
				</div>
				<div>
					<label for="passwort2">Passwort erneut:</label>
					<input type="password" name="passwort" id="passwort2" size="30" maxlength="30" minlength="6" required placeholder="Bitte Passwort wiederholen">
					<span></span>
					<span id="passwortError"></span>
				</div>
			
				<div>
					<label for="image">Bild (max. 1MB):</label>
					<input type="file" placeholder="max. 1MB" name="image" id="image" accept="image/*" required>
					<span></span>
				</div>
				<div>
					<label for="team">Team auswählen:</label>
					<select name="team" id="team" size="8" required>
						<option value="1. Mannschaft">1. Mannschaft</option>
						<option value="2. Mannschaft">2. Mannschaft</option>
						<option value="A-Jugend">A-Jugend</option>
						<option value="B-Jugend">B-Jugend</option>
						<option value="C-Jugend">C-Jugend</option>
						<option value="D-Jugend">D-Jugend</option>
						<option value="F-Jugend">F-Jugend</option>
						<option value="G-Jugend">G-Jugend</option>
					</select>
					<span></span>
				</div>
				<div class="zentrieren">
					<button type="submit" name="absenden"><span>Registrieren </span></button>
					<button name="reset" type="reset">Zurücksetzen</button>
				</div>
		</form>

	</main>
	

</body>
</html>