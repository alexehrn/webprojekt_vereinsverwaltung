/ Alexander Ehrnstrasser:/
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
  var trainerRadio = document.getElementById("r2");
  trainerRadio.addEventListener("click", fotodeaktivieren);

  var spielerRadio = document.getElementById("r1");
  spielerRadio.addEventListener("click", fotoaktivieren);

  var passwort2Input = document.getElementById("passwort2");
  passwort2Input.addEventListener("input", fehleranzeige);
  

}

function fotodeaktivieren() {
  var imageInput = document.getElementById("image");
  imageInput.disabled = true;
}

function fotoaktivieren() {
  var imageInput = document.getElementById("image");
  imageInput.disabled = false;
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


