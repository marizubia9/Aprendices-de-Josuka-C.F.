package Aprendices_de_Josuka.LD;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Equipos_Ext implements Serializable{
	private String nombre;
	private String cod;
	private long puntuacion;
	private String categoria;
	
	public Equipos_Ext(String cod,String nombre, long puntuacion, String categoria)
	{
		super();
		this.cod = cod;
		this.nombre = nombre; 
		this.puntuacion = puntuacion;
		this.categoria = categoria;
	}
	public boolean equals(Object equipo) {
		if (equipo == null)
			return false;

		Equipos_Ext a = (Equipos_Ext) equipo;
		if (this.getCod().equals(((Equipos_Ext) equipo).getCod()))
			return true;

		return false;
	}

	public int hashCode() {
		return this.getCod().hashCode();
	}
}
