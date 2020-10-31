package Aprendices_de_Josuka.LD;

import java.sql.Date;
import java.util.Set;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Partido {

	@PrimaryKey
	private String cod_partido;
	private Date fecha;
	private int resultado;
	@Column(name="equipo_1")
	private Equipo equipo_1;
	@Column(name="equipo_2")
	private Equipo equipo_2;
	private Entrenador entrenador_sancionado_equipo1;
	private Entrenador entrenador_sancionado_equipo2;
	private Set<Jugador> jugador_sancionado;
	
	public Partido(String cod_partido, Date fecha, int resultado, Equipo equipo_1, Equipo equipo_2,
			Entrenador entrenador_sancionado_equipo1,Entrenador entrenador_sancionado_equipo2, Set<Jugador> jugador_sancionado) {
		super();
		this.cod_partido = cod_partido;
		this.fecha = fecha;
		this.resultado = resultado;
		this.equipo_1 = equipo_1;
		this.equipo_2 = equipo_2;
		this.entrenador_sancionado_equipo1 = entrenador_sancionado_equipo1;
		this.entrenador_sancionado_equipo2 = entrenador_sancionado_equipo2;
		this.jugador_sancionado = jugador_sancionado;
	}

	public String getCod_partido() {
		return cod_partido;
	}

	public void setCod_partido(String cod_partido) {
		this.cod_partido = cod_partido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public Equipo getEquipo_1() {
		return equipo_1;
	}

	public void setEquipo_1(Equipo equipo_1) {
		this.equipo_1 = equipo_1;
	}

	public Equipo getEquipo_2() {
		return equipo_2;
	}

	public void setEquipo_2(Equipo equipo_2) {
		this.equipo_2 = equipo_2;
	}

	public Entrenador getEntrenador_sancionado_equipo1() {
		return entrenador_sancionado_equipo1;
	}

	public void setEntrenador_sancionado_equipo1(Entrenador entrenador_sancionado_equipo1) {
		this.entrenador_sancionado_equipo1 = entrenador_sancionado_equipo1;
	}

	public Entrenador getEntrenador_sancionado_equipo2() {
		return entrenador_sancionado_equipo2;
	}

	public void setEntrenador_sancionado_equipo2(Entrenador entrenador_sancionado_equipo2) {
		this.entrenador_sancionado_equipo2 = entrenador_sancionado_equipo2;
	}

	public Set<Jugador> getJugador_sancionado() {
		return jugador_sancionado;
	}

	public void setJugador_sancionado(Set<Jugador> jugador_sancionado) {
		this.jugador_sancionado = jugador_sancionado;
	}
	
	
	
	
}
