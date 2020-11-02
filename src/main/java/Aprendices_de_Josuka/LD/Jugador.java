package Aprendices_de_Josuka.LD;

import java.sql.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Getter;
import lombok.Setter;


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
	private boolean reconocimiento_medico;
	private boolean estado; //Tiene lesiones o no
	private boolean cuota_pagada;
	private boolean asignado_equipo;

	
	
	public Jugador(String nombre, String apellido, String fecha_nacimiento, String DNI, boolean reconocimiento_medico,
			boolean estado, int telefono, String correo, String password, boolean cuota_pagada, boolean asignado_equipo) {
		

		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.correo = correo;
		this.psw= password;
		this.reconocimiento_medico = reconocimiento_medico;
		this.estado = estado;
		this.cuota_pagada = cuota_pagada;
		this.asignado_equipo=asignado_equipo;

	}



	public String getDNI() {
		return DNI;
	}



	public void setDNI(String dNI) {
		DNI = dNI;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}



	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getPsw() {
		return psw;
	}



	public void setPsw(String psw) {
		this.psw = psw;
	}



	public boolean isReconocimiento_medico() {
		return reconocimiento_medico;
	}



	public void setReconocimiento_medico(boolean reconocimiento_medico) {
		this.reconocimiento_medico = reconocimiento_medico;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}



	public boolean isCuota_pagada() {
		return cuota_pagada;
	}



	public void setCuota_pagada(boolean cuota_pagada) {
		this.cuota_pagada = cuota_pagada;
	}



	public boolean getAsignado_equipo() {
		return asignado_equipo;
	}



	public void setAsignado_equipo(boolean asignado_equipo) {
		this.asignado_equipo = asignado_equipo;
	}




	

	
	
	
}
