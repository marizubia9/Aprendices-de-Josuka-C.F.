package Aprendices_de_Josuka.LD;

import java.sql.Date;
import java.util.Set;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@PersistenceCapable
public class Partido {

	@PrimaryKey
	private String cod_partido;
	private Date fecha;
	private int resultado;
	@Column(name = "equipo_1")
	private Equipo equipo_1;
	@Column(name = "equipo_2")
	private String equipo_2;
	private Set<Sancion> sanciones;
	// private Equipo equipo_2;
	// private Entrenador entrenador_sancionado_equipo1;
	// private Entrenador entrenador_sancionado_equipo2;
	// private Set<Jugador> jugador_sancionado;

	public Partido(String cod_partido, Date fecha, int resultado, Equipo equipo_1, String equipo_2) {
		super();
		this.cod_partido = cod_partido;
		this.fecha = fecha;
		this.resultado = resultado;
		this.equipo_1 = equipo_1;
		this.equipo_2 = equipo_2;
		Sancion s= new Sancion();
		
		
	}

	

}
