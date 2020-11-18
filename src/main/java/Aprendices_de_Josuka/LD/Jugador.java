package Aprendices_de_Josuka.LD;

import java.sql.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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


}
