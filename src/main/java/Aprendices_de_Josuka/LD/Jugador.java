package Aprendices_de_Josuka.LD;

import java.io.Serializable;
import java.sql.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PersistenceCapable

public class Jugador implements Serializable{

	@PrimaryKey
	private String DNI;
	private String nombre;
	private String apellido;
	private String fecha_nacimiento;
	private int telefono;
	private String correo;
	private String psw;
	private boolean asignado;
	private boolean reconocimiento_medico;
	private boolean lesionado; // Tiene lesiones o no
	private boolean cuota_pagada;
	


	public Jugador(String nombre, String apellido, String fecha_nacimiento, String DNI, boolean reconocimiento_medico,
			boolean estado, int telefono, String correo, String password, boolean cuota_pagada, boolean asignado) {

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
		this.asignado=asignado;
		
	}


@Override
public String toString() {
	return  nombre + " " + apellido + " | "+DNI;
}
}
	

