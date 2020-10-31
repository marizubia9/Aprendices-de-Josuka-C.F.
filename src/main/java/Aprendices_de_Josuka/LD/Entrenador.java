package Aprendices_de_Josuka.LD;

import java.sql.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Entrenador extends Persona{
	

	private long salario; //Bruto anual

	
	public Entrenador(String nombre, String apellido, Date fecha_nacimiento, String DNI, int telefono, String correo,int salario) 
	{
		super(DNI, nombre, apellido, fecha_nacimiento, telefono, correo);
		this.salario = salario;

	}

	

	public long getSalario() {
		return salario;
	}

	public void setSalario(long salario) {
		this.salario = salario;
	}

	
	
}
