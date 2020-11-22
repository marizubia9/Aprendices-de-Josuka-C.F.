package Aprendices_de_Josuka.LD;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@PersistenceCapable
public class Sancion {

	@PrimaryKey
	private String codigo;
	private String persona;
	private Tipo_Sancion tipo;
	private String cod_partido;


	public Sancion(String codigo, Tipo_Sancion tipo,String persona, String cod_partido) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.persona = persona;
		this.cod_partido = cod_partido;
	}


}
