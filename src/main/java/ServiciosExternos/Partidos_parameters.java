package ServiciosExternos;

import java.time.*;
import java.time.format.DateTimeFormatter;

import lombok.Data;
/**
 *  @class Partidos_parameters
 *  @brief Clase que contiene los parametros de los partidos y sus getters y setters
 * @author Alumno
 */
@Data
public class Partidos_parameters implements DF_Printable
{
    private String equipo1_name;
    private String equipo2_name;
    private int res_e1;
    private int res_e2;
    private String date;
	/**
	 * Imprime los parametros de los partidos
	 */
    @Override
    public void print()
    {
        System.out.println(
                "Printing Partido_parameters" + "\n" +
                 "Equipo1_name: " + getEquipo1_name() + "\n" +
                 "Equipo2_name: " + getEquipo2_name() + "\n" +
                 "res_e1: " + getRes_e1()+ "\n" +
                 "res_e2: " + getRes_e2() + "\n" +
                 "Date: " + getDate() + "\n"
        );
    }
}
