/Quirin Gerstberger: /
 
"use strict"; //Kein Zufriff auf Argumente

document.addEventListener("DOMContentLoaded", init);

function init(){
	var spielerentfernenclick = document.getElementsByClassName("spielerausteamentfernen");
	for (var i=0; spielerentfernenclick.length; i++){
	spielerentfernenclick[i].addEventListener("click", spielerentfernen);
	}
}

function spielerentfernen(event){
	var reallyentfernen = confirm("⚠️ Wollen Sie den Spieler wirklich aus dem Team entfernen? Zugehörige Abwesenheiten werden ebenfalls entfernt! ⚠️");
	if(!reallyentfernen){
		event.preventDefault();
	}
}