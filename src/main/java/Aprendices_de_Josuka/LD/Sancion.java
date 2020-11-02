package Aprendices_de_Josuka.LD;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Sancion {

	@PrimaryKey
	private String codigo;
	private Jugador jugador;
	private Tipo_Sancion tipo;
	private String comentarios;
	private Entrenador entrenador;
	
	
	
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


	public String getCodigo() {
		return codigo;}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Tipo_Sancion getTipo() {
		return tipo;
	}
	public void setTipo(Tipo_Sancion tipo) {
		this.tipo = tipo;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	
	
	
}
