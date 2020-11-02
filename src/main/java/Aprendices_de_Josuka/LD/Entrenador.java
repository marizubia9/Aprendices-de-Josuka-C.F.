package Aprendices_de_Josuka.LD;

import java.sql.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Entrenador {
	
	@PrimaryKey
	private String DNI;
	private String nombre;
	private String apellido;
	private String fecha_nacimiento;
	private int telefono;
	private String correo;
	private String psw;
	private long salario; //Bruto anual
	private boolean asignado_equipo;

	
	public Entrenador(String nombre, String apellido, String  fecha_nacimiento, String DNI, int telefono, String correo,String psw, long salario, boolean asignado_equipo) 
	{
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.correo = correo;
		this.psw= psw;
		this.salario = salario;
		this.asignado_equipo = asignado_equipo;

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


	public long getSalario() {
		return salario;
	}


	public void setSalario(long salario) {
		this.salario = salario;
	}


	public boolean getAsignado_equipo() {
		return asignado_equipo;
	}


	public void setAsignado_equipo(boolean asignado_equipo) {
		this.asignado_equipo = asignado_equipo;
	}

	


	
	
}
