package Aprendices_de_Josuka.LD;

import java.sql.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Getter;
import lombok.Setter;


@PersistenceCapable
@Inheritance
public class Jugador extends Persona {


	private Equipo equipo;
	private boolean reconocimiento_medico;
	private boolean lesionado; // Tiene lesiones o no
	private boolean cuota_pagada;
	

	public Jugador(String nombre, String apellido, String fecha_nacimiento, String DNI, boolean reconocimiento_medico,
			boolean estado, int telefono, String correo, String password, boolean cuota_pagada) {

		super(DNI, nombre, apellido, fecha_nacimiento, telefono, correo, password);
		this.reconocimiento_medico = reconocimiento_medico;
		this.lesionado = estado;
		this.cuota_pagada = cuota_pagada;
		
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	public boolean isReconocimiento_medico() {
		return reconocimiento_medico;
	}


	public void setReconocimiento_medico(boolean reconocimiento_medico) {
		this.reconocimiento_medico = reconocimiento_medico;
	}


	public boolean isLesionado() {
		return lesionado;
	}


	public void setLesionado(boolean lesionado) {
		this.lesionado = lesionado;
	}


	public boolean isCuota_pagada() {
		return cuota_pagada;
	}


	public void setCuota_pagada(boolean cuota_pagada) {
		this.cuota_pagada = cuota_pagada;
	}

	

}
