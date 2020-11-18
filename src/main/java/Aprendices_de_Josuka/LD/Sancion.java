package Aprendices_de_Josuka.LD;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@PersistenceCapable
public class Sancion {

	@PrimaryKey
	private String codigo;
	private Persona persona;
	private Tipo_Sancion tipo;
	private String comentarios;


	public Sancion(String codigo, Tipo_Sancion tipo, String comentarios, Persona persona) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.comentarios = comentarios;
		this.persona = persona;
	}


}
