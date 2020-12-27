package Aprendices_de_Josuka.LD;

import java.io.Serializable;
import java.sql.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
@Data
public class Entrenador extends Persona implements Serializable{


	private long salario; // Bruto anual
	private boolean asignado_equipo;

	public Entrenador(String nombre, String apellido, String fecha_nacimiento, String DNI, int telefono, String correo,
			String psw, long salario, boolean asignado_equipo) {

		super(DNI, nombre, apellido, fecha_nacimiento, telefono, correo, psw);
		this.salario = salario;
		this.asignado_equipo = asignado_equipo;

	}
	
	public String toString()
	{
		return this.getDNI() + " | " + this.getNombre() + " " + this.getApellido() ;
		
	}





}
