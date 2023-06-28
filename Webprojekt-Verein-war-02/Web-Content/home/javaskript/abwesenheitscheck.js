/ Alexander Ehrnstrasser, Quirin Gerstberger:/
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
	var enddatum = document.getElementById("enddatum");
	enddatum.addEventListener("change", abwesenheitdeaktivieren);
	
	var startdatum =document.getElementById("startdatum");
	startdatum.addEventListener("change", abwesenheitdeaktivieren);
	
	var abwesenheitloeschenclick = document.getElementsByClassName("abwesenheitloeschen");
	for(var i=0; abwesenheitloeschenclick.length;i++){
		abwesenheitloeschenclick[i].addEventListener("click", abwesenheitwirklichloeschen);
	}
}


function abwesenheitdeaktivieren(){
	
	var startdatum =new Date(document.getElementById("startdatum").value);
	startdatum.setHours(23);
	startdatum.setMinutes(59);
	startdatum.setSeconds(59);
	var enddatum = new Date(document.getElementById("enddatum").value);
	var heute= new Date();
	var abwerror = document.getElementById("abwesenheitserror");
	var sendebutton = document.querySelector('button[name="abwesenheitAbsenden"]');
	
 	if(startdatum > enddatum){
		 abwerror.innerHTML = "Start- ist größer als Endzeitpunkt";
		 sendebutton.disabled=true;
		 
	 } else if(startdatum < heute){
		 abwerror.innerHTML = "Startzeitpunkt liegt in der Vergangenheit";
		 sendebutton.disabled=true;
	 }else {
		 abwerror.innerHTML = "";
		 sendebutton.disabled=false;
	 }
	
	
}

function abwesenheitwirklichloeschen(event){
	var abwesenheitreallyDelete = confirm("⚠️ Abwesenheit wirklich löschen? ⚠️");
	if(!abwesenheitreallyDelete){
		event.preventDefault();
	}
}

