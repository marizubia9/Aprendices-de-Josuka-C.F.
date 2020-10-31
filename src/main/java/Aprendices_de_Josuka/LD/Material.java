package Aprendices_de_Josuka.LD;

public class Material {

	private String cod_material;
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

	public String getCod_material() {
		return cod_material;
	}

	public void setCod_material(String cod_material) {
		this.cod_material = cod_material;
	}

	public Tipo_Material getTipo() {
		return tipo;
	}

	public void setTipo(Tipo_Material tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}
	
	
	
}
