/Kalender wurde komplett mit Chat-GPT erstellt und nach Best-Pratice bestmöglich angepasst/

"use strict";

	document.addEventListener("DOMContentLoaded", init);
	
function init() {
  // Button-Elemente auswählen
  var prevMonthBtn = document.getElementById("prev-month-btn");
  var nextMonthBtn = document.getElementById("next-month-btn");

  // Event Listener für vorherigen Monat hinzufügen
  prevMonthBtn.addEventListener("click", previousMonth);

  // Event Listener für nächsten Monat hinzufügen
  nextMonthBtn.addEventListener("click", nextMonth);

  // Termine erstellen
  erstelleTermine();

  // Kalender generieren
  generateCalendar();
}

	var monthNames = [
      "Januar", "Februar", "März", "April", "Mai", "Juni",
      "Juli", "August", "September", "Oktober", "November", "Dezember"
    ];
	

	var currentDate = new Date();
    var currentMonth = currentDate.getMonth();
    var currentYear = currentDate.getFullYear();
    var events = [];
    
    
    /*[
       { date: new Date(currentYear, currentMonth, 01), title: "Training", time: "09:00" },
  	   { date: new Date(currentYear, currentMonth, 10), title: "Event 2", time: "14:00 - 16:00" },
       { date: new Date(currentYear, currentMonth, 21), title: "Event 3", time: "18:00 - 20:00" },
       { date: new Date(currentYear, currentMonth, 15), title: "Event 4", time: "10:00 - 12:00" },
       { date: new Date(currentYear, currentMonth, 22), title: "Event 5", time: "16:00 - 18:00" },
       { date: new Date(currentYear, currentMonth, 25), title: "Event 6", time: "14:30 - 15:30" },
     ];*/
    
  
    
			 // Termine von DB einfügen
			function erstelleTermine() {
				var searchTermine = "SearchServletTrainerKalender";
				
				var xmlhttp = new XMLHttpRequest();
				xmlhttp.responseType = "json"; // Wenn gesetzt, ist kein JSON.parse() notwendig!
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
						var terminList = xmlhttp.response; // Wenn responseType auf JSON gesetzt ist
						
						for (var i = 0; i < terminList.length; i++) {
							
							
							// Erstelle ein neues Event-Objekt
							var event = {
								date: new Date(terminList[i].datum),
								title: terminList[i].kurzbeschreibung,
								time: terminList[i].uhrzeitVON
							};
			  
							// Füge das Event-Objekt zum Array hinzu
							events.push(event);
						}
					}
				};
				
				xmlhttp.open("GET", searchTermine, true);
				xmlhttp.send();
			
			}

				
				
    
    function generateCalendar() {
      var calendarBody = document.getElementById("calendar-body");
      calendarBody.innerHTML = "";
    
      var firstDay = new Date(currentYear, currentMonth, 1).getDay();
      var daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();
      var startDay = (firstDay === 0) ? 6 : firstDay - 1; // Adjust start day to Monday
    
      var date = 1;
      for (var i = 0; i < 6; i++) {
        for (var j = 0; j < 7; j++) {
          var dayCell = document.createElement("div");
          dayCell.classList.add("day");
    
          if (i === 0 && j < startDay) {
            dayCell.classList.add("prev-month");
          } else if (date > daysInMonth) {
            dayCell.classList.add("next-month");
          } else {
            var dayDate = new Date(currentYear, currentMonth, date);
    
            var eventText = getEventText(dayDate);
            dayCell.innerHTML = "<span class='date'>" + date + "</span>";
    
            if (currentDate.toDateString() === dayDate.toDateString()) {
              dayCell.classList.add("current-day");
            }
    
            if (eventText.length > 0) {
              var eventList = document.createElement("ul");
              eventList.classList.add("event-list");
    
              eventText.forEach(function(event) {
                var eventItem = document.createElement("li");
                eventItem.innerHTML = event;
                eventList.appendChild(eventItem);
              });
    
              dayCell.appendChild(eventList);
            }
    
            date++;
          }
    
          calendarBody.appendChild(dayCell);
        }
      }
    
      document.getElementById("current-month").textContent = monthNames[currentMonth] + " " + currentYear;
    }
    
    function getEventText(date) {
      var eventText = [];
    
      events.forEach(function(event) {
        if (event.date.toDateString() === date.toDateString()) {
          eventText.push(event.time + " Uhr: " + event.title);
        }
      });
    
      return eventText;
    }
    
    function previousMonth() {
      currentMonth--;
      if (currentMonth < 0) {
        currentMonth = 11;
        currentYear--;
      }
      generateCalendar();
    }
    
    function nextMonth() {
      currentMonth++;
      if (currentMonth > 11) {
        currentMonth = 0;
        currentYear++;
      }
      generateCalendar();
    }
    
    generateCalendar(); 

