package ServiciosExternos;

import lombok.Data;
/**
 * @class Sanciones_parameters
 * @brief Clase que contiene los atributos de las sanciones, con sus getters y setters mediante el plugin de Lombok. Implementa DF_Printable para imprimir el contenido de cada sancion
 * @author Alumno
 */
@Data
public class Sanciones_parameters implements DF_Printable
{
    private String codigo;
    private String tipo;
    private String dni;
    private String cod_partido;

 /**
  * Imprime el contenido de las sanciones de la raspberry
  */
    @Override
    public void print()
    {
        System.out.println(
                "Printing Sancion_parameters" + "\n" +
                 "cod: " + getCodigo() + "\n" +
                 "Tipo: " + getTipo() + "\n" +
                 "Dni: " + getDni()+ "\n" +
                 "Cod partido: " + getCod_partido() + "\n"
        );
    }
}
