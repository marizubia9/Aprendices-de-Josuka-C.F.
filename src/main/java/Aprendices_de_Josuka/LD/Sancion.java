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
	private Jugador jugador;
	private Tipo_Sancion tipo;
	private String comentarios;
	private Entrenador entrenador;

	public Sancion() {

	}

	public Sancion(String codigo, Tipo_Sancion tipo, String comentarios, Entrenador entrenador) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.comentarios = comentarios;
		this.entrenador = entrenador;
	}

	public Sancion(String codigo, Jugador jugador, Tipo_Sancion tipo, String comentarios) {
		super();
		this.codigo = codigo;
		this.jugador = jugador;
		this.tipo = tipo;
		this.comentarios = comentarios;
	}

}
