package Aprendices_de_Josuka.LD;

import java.sql.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@PersistenceCapable
public @Data class Entrenador {

	@PrimaryKey
	private String DNI;
	private String nombre;
	private String apellido;
	private String fecha_nacimiento;
	private int telefono;
	private String correo;
	private String psw;
	private long salario; // Bruto anual
	private boolean asignado_equipo;

	public Entrenador(String nombre, String apellido, String fecha_nacimiento, String DNI, int telefono, String correo,
			String psw, long salario, boolean asignado_equipo) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.correo = correo;
		this.psw = psw;
		this.salario = salario;
		this.asignado_equipo = asignado_equipo;

	}

	@Override
	public String toString() {
		return  nombre + " " + apellido + " | "+DNI;
	}



}
