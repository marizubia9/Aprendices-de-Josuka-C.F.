package Aprendices_de_Josuka.LD;

import java.sql.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Jugador extends Persona {
	

	private boolean reconocimiento_medico;
	private boolean estado; //Tiene lesiones o no
	private boolean cuota_pagada;

	
	
	public Jugador(String nombre, String apellido, Date fecha_nacimiento, String DNI, boolean reconocimiento_medico,
			boolean estado, int telefono, String correo, String password, boolean cuota_pagada) {
		super(DNI, nombre, apellido, fecha_nacimiento, telefono, correo, password);

		this.reconocimiento_medico = reconocimiento_medico;
		this.estado = estado;
		this.cuota_pagada = cuota_pagada;

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
	
	

	
	
	
}
