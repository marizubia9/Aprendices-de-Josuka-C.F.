package Aprendices_de_Josuka.LD;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Administrador {

	@PrimaryKey
	private String email;
	private String psw;

	public Administrador(String email, String psw) {
		super();
		this.email = email;
		this.psw = psw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

}
