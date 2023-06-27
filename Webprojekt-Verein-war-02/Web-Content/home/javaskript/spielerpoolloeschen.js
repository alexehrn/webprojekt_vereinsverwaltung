/Quirin Gerstberger: /
 
"use strict"; //Kein Zufriff auf Argumente

document.addEventListener("DOMContentLoaded", init);

function init(){
	var spielerloeschenclick = document.getElementById("spielerauspoolloeschen");
	spielerloeschenclick.addEventListener("click", spielerloeschen)
}

function spielerloeschen(event2){
	var reallyloeschen = confirm("Wollen Sie den Spieler wirklich unwiederruflich löschen? Alle dazugehörigen Daten werden ebenfalls gelöscht! ⚠️");
	if(!reallyloeschen){
		event2.preventDefault();
	}
}