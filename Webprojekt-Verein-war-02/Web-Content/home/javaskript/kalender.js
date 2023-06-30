/Kalender wurde komplett mit Chat-GPT erstellt und nach Best-Pratice gemeinsam, bestmöglich angepasst/

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
    
    //Ab hier wurde selber, gemeinsam erstellt://
    
  	var events=[];
    
			 // Termine von DB einfügen
			function erstelleTermine() {
				var searchTermine = "/Webprojekt-Verein-war-02/SearchServletKalender";
				
				var xmlhttp = new XMLHttpRequest();
				xmlhttp.responseType = "json"; 
				xmlhttp.addEventListener("load",function() {
					var terminList = xmlhttp.response;
						
						events = [];
						
						for (var i = 0; i < terminList.length; i++) {
							
							
							var date = new Date(terminList[i].date);
							var year = date.getFullYear();
							var month = date.getMonth();
							var day = date.getDate();
							
							// Erstelle ein neues Event-Objekt
							var event = {
								date: new Date(year, month, day),
								title: terminList[i].title,
								time: terminList[i].time
							};
			  			
							// Füge das Event-Objekt zum Array hinzu
							events.push(event);
						}
					generateCalendar();
					console.log(events);
					return events;		      					
				});
				
				xmlhttp.open("GET", searchTermine, true);
				xmlhttp.send();
				
			
			
				
			
			}

		 //Ende selber erstellt//		
				
    
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
    

