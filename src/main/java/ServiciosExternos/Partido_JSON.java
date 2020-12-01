package ServiciosExternos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import org.json.simple.JSONObject;

public class Partido_JSON
{
    JSONObject json_encoded;

    public Partido_JSON(Object json_encoded)
    {
        this.json_encoded = (JSONObject) json_encoded;
    }

    public void print()
    {
        System.out.println(json_encoded.toJSONString());
    }


    public String getCode()
    {
        return (String) json_encoded.get("_Partido__code");
    }

    public long getResE1()
    {
        return (long) json_encoded.get("_Partido__resultado_e1");
    }

    public long getResE2()
    {
        return (long) json_encoded.get("_Partido__resultado_e2");
    }

    public String getEquipo1Nombre()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_1")).get("_Equipo__nombre");
    }

    public String getEquipo2Nombre()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_2")).get("_Equipo__nombre");
    }

    public String getEquipo1Categoria()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_1")).get("_Equipo__categoria");
    }

    public String getEquipo2Categoria()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_2")).get("_Equipo__categoria");
    }

    public String getEquipo1Code()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_1")).get("_Equipo__code");
    }

    public String getEquipo2Code()
    {
        return (String) ((JSONObject)json_encoded.get("_Partido__equipo_2")).get("_Equipo__code");
    }

     public long getEquipo1Puntuacion()
    {
        return (long) ((JSONObject)json_encoded.get("_Partido__equipo_1")).get("_Equipo__puntuacion");
    }

    public long getEquipo2Puntuacion()
    {
        return (long) ((JSONObject)json_encoded.get("_Partido__equipo_2")).get("_Equipo__puntuacion");
    }

    public String getDate()
    {
        return (String) json_encoded.get("_Partido__date");
    }

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

        // with hours -> change print format -> departure_date.format(formatter_new);
    }

}
