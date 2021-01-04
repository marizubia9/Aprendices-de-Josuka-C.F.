/**
 * @package Aprendices_de_Josuka.LD
 * @brief Todos los objetos que tendrá la aplicación
 */
package Aprendices_de_Josuka.LD;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import lombok.Getter;
import lombok.Setter;
/**
 * @class Administrador
 * @brief Esta clase define objetos de tipo administrador.
 * @author Alumno
 *
 */
@Getter
@Setter
@PersistenceCapable
public class Administrador  {

	@PrimaryKey
	private String email;
	private String psw;

	public Administrador(String email, String psw) {
		super();
		this.email = email;
		this.psw = psw;
	}



}
