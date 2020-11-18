package Aprendices_de_Josuka.LD;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Data;
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public @Data class Persona {
	
	@PrimaryKey
	private String DNI;
	private String nombre;
	private String apellido;
	private String fecha_nacimiento;
	private int telefono;
	private String correo;
	private String psw;





public Persona(String dNI, String nombre, String apellido, String fecha_nacimiento, int telefono, String correo,
		String psw) {
	super();
	DNI = dNI;
	this.nombre = nombre;
	this.apellido = apellido;
	this.fecha_nacimiento = fecha_nacimiento;
	this.telefono = telefono;
	this.correo = correo;
	this.psw = psw;
}



@Override
public String toString() {
	return  nombre + " " + apellido + " | "+DNI;
}
}


