package bean;

import java.io.Serializable;

public class TrainerHomeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
		private String beschreibung;

		public String getBeschreibung() {
			return beschreibung;
		}

		public void setBeschreibung(String beschreibung) {
			this.beschreibung = beschreibung;
		}
		
		
}
