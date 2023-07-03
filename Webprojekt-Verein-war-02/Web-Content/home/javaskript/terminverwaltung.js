/Alexander Ehrnstrasser: /
 
"use strict"; //Kein Zufriff auf Argumente

document.addEventListener("DOMContentLoaded", init);

function init(){
	var kategoriebutton = document.getElementById("kategorienbearbeiten");
	kategoriebutton.addEventListener("click", kategoriebearbeiten);
		
	var terminloeschenclick = document.getElementsByClassName("terminloeschen");
	for (var i=0; terminloeschenclick.length; i++){
		terminloeschenclick[i].addEventListener("click", terminwirklichloeschen);
	}	
	
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

