package Aprendices_de_Josuka.LD;

import java.util.Set;

import javax.jdo.annotations.Column;
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
	@Column(name = "nombre_categoria")
	private Categoria categoria;
	private Entrenador entrenador;
	private Set<Jugador> lista_jugador;
	private Set<Material> inventario;

	public Equipo(String nombre, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
	}


}
