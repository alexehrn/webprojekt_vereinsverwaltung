/Quirin Gerstberger: /
 
"use strict"; //Kein Zufriff auf Argumente

document.addEventListener("DOMContentLoaded", init);

function init(){
	var terminloeschenclick = document.getElementById("terminloeschen");
	terminloeschenclick.addEventListener("click", terminwirklichloeschen);
	
	
}

function terminwirklichloeschen(evt){
	var reallyDelete = confirm("⚠️ Termin wirklich löschen? ⚠️");
	if(!reallyDelete){
		evt.preventDefault();
	}
}

