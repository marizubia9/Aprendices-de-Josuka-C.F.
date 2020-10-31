package Aprendices_de_Josuka.LD;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Sancion {

	@PrimaryKey
	private String codigo;
	private Persona persona;
	private Tipo_Sancion tipo;
	private String comentarios;
	
	
}
