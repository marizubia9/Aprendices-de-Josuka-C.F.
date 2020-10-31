package Aprendices_de_Josuka.LD;

import java.sql.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public abstract class Persona {

	@PrimaryKey
	private String DNI;
	private String nombre;
	private String apellido;
	private Date fecha_nacimiento;
	private int telefono;
	private String correo;
	
	public Persona(String dNI, String nombre, String apellido, Date fecha_nacimiento, int telefono, String correo) {
		super();
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.correo = correo;
	}
}
