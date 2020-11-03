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
	private String cod_material;
	@Column(name = "tipo_material")
	private Tipo_Material tipo;
	private int cantidad;
	private long precio;

	public Material(String cod_material, Tipo_Material tipo, int cantidad, long precio) {
		super();
		this.cod_material = cod_material;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
	}


}
