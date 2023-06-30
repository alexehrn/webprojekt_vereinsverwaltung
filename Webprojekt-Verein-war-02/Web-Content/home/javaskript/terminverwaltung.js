/Alexander Ehrnstrasser: /
 
"use strict"; //Kein Zufriff auf Argumente

document.addEventListener("DOMContentLoaded", init);

function init(){
	var terminloeschenclick = document.getElementById("terminloeschen");
	terminloeschenclick.addEventListener("click", terminwirklichloeschen);
	
	var kategoriebutton = document.getElementById("kategorienbearbeiten");
	kategoriebutton.addEventListener("click", kategoriebearbeiten);
	
	
}

function terminwirklichloeschen(evt){
	var reallyDelete = confirm("⚠️ Termin wirklich löschen? ⚠️");
	if(!reallyDelete){
		evt.preventDefault();
	}
}

function kategoriebearbeiten() {
  var openflexarea = document.getElementById('platzhalter');
  var terminformularzentrieren = document.getElementById('terminformularzentrieren');
  var kategorieformausgeblendet = document.getElementById('kategorieformausgeblendet');
  var neuekategorieausgeblendet = document.getElementById('neuekategorieausgeblendet');

  openflexarea.id = 'flexareatermin';
  terminformularzentrieren.id = 'terminform';
  kategorieformausgeblendet.id = 'kategorieform';
  neuekategorieausgeblendet.id = 'neuekategorie';


}

