package Aprendices_de_Josuka.LD;

import java.util.Set;

public class Equipo {
	
	private String nombre;
	private Set<Jugador> lista_jugador;
	private Entrenador entrenador;
	private Categoria categoria;
	
	public Equipo(String nombre, Set<Jugador> lista_jugador, Entrenador entrenador, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.lista_jugador = lista_jugador;
		this.entrenador = entrenador;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Jugador> getLista_jugador() {
		return lista_jugador;
	}

	public void setLista_jugador(Set<Jugador> lista_jugador) {
		this.lista_jugador = lista_jugador;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
