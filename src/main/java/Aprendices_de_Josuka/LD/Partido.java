
package Aprendices_de_Josuka.LD;

import java.io.Serializable;
/**
 * Esta clase define objetos de tipo partido que no están guardados en la base de datos 
 * y se obtienen de la raspberry.
 */
import java.time.LocalDateTime;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
/**
 * @class Partido
 * @brief Esta clase define objetos de tipo partido que no están guardados en la base de datos y se obtienen de la raspberry.
 * @author Alumno
 *
 */
@Getter
@Setter
public class Partido implements Serializable{


	private String cod_partido;
	private LocalDateTime fecha;
	private long resultado_e1;
	private long resultado_e2;
	private Equipos_Ext equipo_1;
	private Equipos_Ext equipo_2;
	private Set<Sancion> sanciones;


	public Partido(String cod_partido, LocalDateTime fecha, long resultado_e1, long resultado_e2, Equipos_Ext equipo_1, Equipos_Ext equipo_2) {
		super();
		this.cod_partido = cod_partido;
		this.fecha = fecha;
		this.resultado_e1 = resultado_e1;
		this.resultado_e2 = resultado_e2;
		this.equipo_1 = equipo_1;
		this.equipo_2 = equipo_2;

		
		
	}

	

}
