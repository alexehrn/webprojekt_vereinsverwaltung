//Alexander Ehrnstrasser:

package bean;

import java.io.Serializable;
import java.sql.Date;

public class TrainerHomeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
		private Long nachricht_id;
		private String beschreibung;
		private Date tag;
		private String year;
		private String month;
		private String day;

		
		public Long getNachricht_id() {
			return nachricht_id;
		}

		public void setNachricht_id(Long nachricht_id) {
			this.nachricht_id = nachricht_id;
		}

		public String getBeschreibung() {
			return beschreibung;
		}

		public void setBeschreibung(String beschreibung) {
			this.beschreibung = beschreibung;
		}

		public Date getTag() {
			return tag;
		}

		public void setTag(Date tag) {
			this.tag = tag;
		}

		public String getYear() {
			return year;
		}

		public void setYear(Date tag) {
			this.year = tag.toString().substring(0,4);
		}

		public String getMonth() {
			return month;
		}

		public void setMonth(Date tag) {
			this.month = tag.toString().substring(5,7);
		}

		public String getDay() {
			return day;
		}

		public void setDay(Date tag) {
			this.day = tag.toString().substring(8,10);
		}

		
		
		
		
		
}
