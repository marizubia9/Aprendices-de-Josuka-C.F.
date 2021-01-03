package ServiciosExternos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import org.json.simple.JSONObject;
/**
 * Clase para parsear los partidos de la raspberry
 * @author Alumno
 *
 */
public class Partido_JSON
{
    JSONObject json_encoded;
    /**
     * Constructor de la clase
     * @param json_encoded objeto que se va a parsear
     */
    public Partido_JSON(Object json_encoded)
    {
        this.json_encoded = (JSONObject) json_encoded;
    }
    /**
     * Método para crear correspondencia del código del partido
     * @return el código del partido
     */
    public String getCode()
    {
        return (String) json_encoded.get("_Partido__code");
    }
    /**
     * Método para crear correspondencia del resultado del primer equipo
     * @return el resultado del primer equipo
     */
    public long getResE1()
    {
        return (long) json_encoded.get("_Partido__resultado_e1");
    }
    /**
     * Método para crear correspondencia del resultado del segundo equipo
     * @return el resultado del segundo equipo
     */
    public long getResE2()
    {
        return (long) json_encoded.get("_Partido__resultado_e2");
    }
    /**
     * Método para crear correspondencia del nombre del primer equipo
     * @return el nombre del primer equipo
     */
    public String getEquipo1Nombre()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_1")).get("_Equipo__nombre");
    }
    /**
     * Método para crear correspondencia del nombre del segundo equipo
     * @return el nombre del segundo equipo
     */
    public String getEquipo2Nombre()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_2")).get("_Equipo__nombre");
    }
    /**
     * Método para parsear la categoria del primer equipo
     * @return la categoria del primer equipo
     */
    public String getEquipo1Categoria()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_1")).get("_Equipo__categoria");
    }
    /**
     * Método para parsear la categoria del segundo equipo
     * @return la categoria del segundo equipo
     */
    public String getEquipo2Categoria()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_2")).get("_Equipo__categoria");
    }
    /**
     * Método para parsear el código del primer equipo
     * @return el código del primer equipo
     */
    public String getEquipo1Code()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_1")).get("_Equipo__code");
    }
    /**
     * Método para parsear el código del segundo equipo
     * @return el código del segundo equipo
     */
    public String getEquipo2Code()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_2")).get("_Equipo__code");
    }
    /**
     * Método para parsear la puntuación del primer equipo
     * @return la puntuación del equipo uno
     */
     public long getEquipo1Puntuacion()
    {
        return (long) ((JSONObject)json_encoded.get("_Partido__equipo_1")).get("_Equipo__puntuacion");
    }
/**
 * Método para parsear la puntuación del segundo equipo
 * @return la puntuación del equipo dos
 */
    public long getEquipo2Puntuacion()
    {
        return (long) ((JSONObject)json_encoded.get("_Partido__equipo_2")).get("_Equipo__puntuacion");
    }
    /**
     * Método para crear correspondencia de la fecha del partido
     * @return la fecha del partido
     */
    public String getDate()
    {
        return (String) json_encoded.get("_Partido__date");
    }
	/**
	 * Este método sirve para parsear las fechas que se consiguen de la raspberry, pues son string y hay que convertirlos en LocalDateTime
	 * @param withHours booleano para coger horas
	 * @return devuelve la fecha formateada
	 */
    public LocalDateTime getDate(boolean withHours )
    {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd [[HH][:mm][:ss]]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
                .toFormatter();

        return LocalDateTime.parse(getDate(), formatter); // get rid of milliseconds
    }

}
