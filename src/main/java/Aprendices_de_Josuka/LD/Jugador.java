package Aprendices_de_Josuka.LD;

import java.sql.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PersistenceCapable
public class Jugador {

	@PrimaryKey
	private String DNI;
	private String nombre;
	private String apellido;
	private String fecha_nacimiento;
	private int telefono;
	private String correo;
	private String psw;
	private Equipo equipo;
	private boolean reconocimiento_medico;
	private boolean lesionado; // Tiene lesiones o no
	private boolean cuota_pagada;
	private boolean asignado_equipo;

	public Jugador(String nombre, String apellido, String fecha_nacimiento, String DNI, boolean reconocimiento_medico,
			boolean estado, int telefono, String correo, String password, boolean cuota_pagada,
			boolean asignado_equipo) {

		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.correo = correo;
		this.psw = password;
		this.reconocimiento_medico = reconocimiento_medico;
		this.lesionado = estado;
		this.cuota_pagada = cuota_pagada;
		this.asignado_equipo = asignado_equipo;
		

	}
	public String toString() {
		return  nombre + " " + apellido + " | "+DNI;
	}

}
