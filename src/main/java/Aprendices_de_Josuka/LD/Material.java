package Aprendices_de_Josuka.LD;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase define los objetos de tipo material, es decir, del inventario.
 * @author Alumno
 *
 */
@Getter
@Setter
@PersistenceCapable
public class Material implements Serializable {

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

	@Override
	public String toString() {
		return tipo + ": " + cantidad + "uds";
	}


}
