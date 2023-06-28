/Quirin Gerstberger: /
 
"use strict"; //Kein Zufriff auf Argumente

document.addEventListener("DOMContentLoaded", init);

function init(){
	var spielerloeschenclick = document.getElementsByClassName("spielerauspoolloeschen");
	for (var i=0; i<spielerloeschenclick.length;i++){
	spielerloeschenclick[i].addEventListener("click", spielerloeschen)
	}
}

function spielerloeschen(event){
	var reallyloeschen = confirm("Wollen Sie den Spieler wirklich unwiederruflich löschen? Alle dazugehörigen Daten werden ebenfalls gelöscht! ⚠️");
	if(!reallyloeschen){
		event.preventDefault();
	}
}