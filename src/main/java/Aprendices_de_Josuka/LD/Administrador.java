package Aprendices_de_Josuka.LD;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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



}
