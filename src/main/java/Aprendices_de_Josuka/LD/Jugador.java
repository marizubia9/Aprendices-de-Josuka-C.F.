package Aprendices_de_Josuka.LD;

import java.sql.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Jugador {
	
	@PrimaryKey
	private String DNI;
	private String nombre;
	private String apellido;
	private Date fecha_nacimiento;
	private boolean reconocimiento_medico;
	private boolean estado; //Tiene lesiones o no
	private int telefono;
	private String correo;
	private boolean cuota_pagada;
	@Column(name="Equipo")
	private Equipo equipo;
	
	
	public Jugador(String nombre, String apellido, Date fecha_nacimiento, String dNI, boolean reconocimiento_medico,
			boolean estado, int telefono, String correo, boolean cuota_pagada, Equipo equipo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		DNI = dNI;
		this.reconocimiento_medico = reconocimiento_medico;
		this.estado = estado;
		this.telefono = telefono;
		this.correo = correo;
		this.cuota_pagada = cuota_pagada;
		this.equipo = equipo;
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
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
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
	public boolean isCuota_pagada() {
		return cuota_pagada;
	}
	public void setCuota_pagada(boolean cuota_pagada) {
		this.cuota_pagada = cuota_pagada;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	} 
	
	
	
}
