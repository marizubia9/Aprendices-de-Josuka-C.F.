package Aprendices_de_Josuka.LD;

import java.sql.Date;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Entrenador {

	private String nombre;
	private String apellido;
	private Date fecha_nacimiento;
	private String DNI;
	private int telefono;
	private String correo;
	private int salario; //Bruto anual
	private Equipo equipo;
	
	public Entrenador(String nombre, String apellido, Date fecha_nacimiento, String dNI, int telefono, String correo,
			int salario, Equipo equipo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		DNI = dNI;
		this.telefono = telefono;
		this.correo = correo;
		this.salario = salario;
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

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	
	
}
