package bean;

import java.io.Serializable;
import java.sql.Date;

public class TrainerHomeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
		private Long nachricht_id;
		private String beschreibung;
		private Date tag;

		
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
		
		
		
		
}
