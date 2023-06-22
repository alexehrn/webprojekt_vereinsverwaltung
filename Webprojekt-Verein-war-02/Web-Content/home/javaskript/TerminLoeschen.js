/Quirin Gerstberger: /
 
"use strict"; //Kein Zufriff auf Argumente

document.addEventListener("DOMContentLoaded", init);

function init(){
	var terminloeschenclick= document.getElementById("terminloeschen");
	terminloeschenclick.addEventListener("submit", terminwirklichloeschen)
}

function terminwirklichloeschen(evt){
	var reallyReset = confirm("Termin wirklich löschen?");
	if(!reallyReset){
		evt.preventDefault();
	}
}