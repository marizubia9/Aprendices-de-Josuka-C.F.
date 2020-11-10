package Aprendices_de_Josuka.LD;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PersistenceCapable
public class Equipo {

	@PrimaryKey
	private String nombre;
	private Categoria categoria;
	private Entrenador entrenador;
	@Join
	private List<Jugador> lista_jugador;
	@Join
	private HashMap<Material, Integer> inventario ;

	public Equipo(String nombre, Categoria categoria,Entrenador entrenador, List<Jugador>lista_jugador, HashMap<Material, Integer> inventario) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.entrenador=entrenador;
		this.lista_jugador=lista_jugador;
		this.inventario = inventario;
	}


}
