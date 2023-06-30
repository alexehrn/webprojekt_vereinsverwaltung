//Quirin Gerstberger:

package bean;

import java.io.Serializable;


public class TrainerBean implements Serializable {
private static final long serialVersionUID = 1L;


		private Long id;
		private String email;
		private String team;
		
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


}