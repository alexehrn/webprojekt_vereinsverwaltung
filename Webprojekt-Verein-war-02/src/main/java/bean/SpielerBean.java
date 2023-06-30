//Fabian Wolfsteiner:

package bean;

import java.io.Serializable;

public class SpielerBean implements Serializable {
private static final long serialVersionUID = 1L;


		private Long id;
		private String email;
		private String vorname;
		private String nachname;
		private String team;
		private Boolean zugeordnet;
		
	
		public String getVorname() {
			return vorname;
		}
		public void setVorname(String vorname) {
			this.vorname = vorname;
		}
		public String getNachname() {
			return nachname;
		}
		public void setNachname(String nachname) {
			this.nachname = nachname;
		}
			
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getTeam() {
			return team;
		}
		public void setTeam(String team) {
			this.team = team;
		}
		
		public Boolean getZugeordnet() {
			return zugeordnet;
		}
		public void setZugeordnet(Boolean zugeordnet) {
			this.zugeordnet = zugeordnet;
		}


}
