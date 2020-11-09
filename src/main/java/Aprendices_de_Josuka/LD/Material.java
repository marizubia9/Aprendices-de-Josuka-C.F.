package Aprendices_de_Josuka.LD;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PersistenceCapable
public class Material {

	@PrimaryKey
	private Tipo_Material tipo;
	private int cantidad;
	private long precio;

	public Material( Tipo_Material tipo, int cantidad, long precio) {
		super();

		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
	}


}
