package Aprendices_de_Josuka.LD;

import java.io.Serializable;
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
public class Equipo implements Serializable{

	@PrimaryKey
	private String nombre;
	private Categoria categoria;
	private String dni_entrenador;
	@Join
	private List<String> lista_jugador;
	@Join
	private HashMap<String, Integer> inventario ;

	public Equipo(String nombre, Categoria categoria,String entrenador, List<String>lista_jugador, HashMap<String, Integer> inventario) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.dni_entrenador=entrenador;
		this.lista_jugador=lista_jugador;
		this.inventario = inventario;
	}

	@Override
	public String toString() {
		return nombre;
	}


}
