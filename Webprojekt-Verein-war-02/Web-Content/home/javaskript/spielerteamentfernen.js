/Quirin Gerstberger: /
 
"use strict"; //Kein Zufriff auf Argumente

document.addEventListener("DOMContentLoaded", init);

function init(){
	var spielerentfernenclick = document.getElementById("spielerausteamentfernen");
	spielerentfernenclick.addEventListener("click", spielerentfernen);
}

function spielerentfernen(event1){
	var reallyentfernen = confirm("⚠️ Wollen Sie den Spieler wirklich aus dem Team entfernen? Zugehörige Abwesenheiten werden ebenfalls entfernt! ⚠️");
	if(!reallyentfernen){
		event1.preventDefault();
	}
}