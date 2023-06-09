/ Alexander Ehrnstrasser:/
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
  var reset = document.getElementById("registrierungsForm");
  reset.addEventListener("reset", confirmReset); 
 
  var trainerRadio = document.getElementById("r2");
  trainerRadio.addEventListener("click", fotodeaktivieren);

  var spielerRadio = document.getElementById("r1");
  spielerRadio.addEventListener("click", fotoaktivieren);

  var passwort2Input = document.getElementById("passwort2");
  passwort2Input.addEventListener("input", fehleranzeige);
  
 
  

}

function fotodeaktivieren() {
  var imageInput = document.getElementById("image");
  var spanElement = document.getElementById("image").nextElementSibling;
  imageInput.disabled = true;
  spanElement.style.display = 'none';
}

function fotoaktivieren() {
  var imageInput = document.getElementById("image");
  var spanElement = document.getElementById("image").nextElementSibling;
  imageInput.disabled = false;
  spanElement.style.display = 'inline';
}

function fehleranzeige() {
  var passwortInput = document.getElementById("passwort");
  var passwort2Input = document.getElementById("passwort2");
  var passwortError = document.getElementById("passworterror");
  var registrierungsButton = document.querySelector('button[name="absenden"]');

  if (passwortInput.value !== passwort2Input.value) {
    passwortError.innerHTML = "Die Passwörter stimmen nicht überein!";
    registrierungsButton.disabled = true;
  } else {
    passwortError.innerHTML = "";
    registrierungsButton.disabled = false;
  }
}

function confirmReset(evt){
	var reallyReset = confirm("Formular wirklich zurücksetzen?");
	if(!reallyReset){
		evt.preventDefault();
	}
}

