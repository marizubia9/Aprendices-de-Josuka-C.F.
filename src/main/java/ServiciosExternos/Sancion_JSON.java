package ServiciosExternos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import org.json.simple.JSONObject;

public class Sancion_JSON
{
    JSONObject json_encoded;

    public Sancion_JSON(Object json_encoded)
    {
        this.json_encoded = (JSONObject) json_encoded;
    }

    public void print()
    {
        System.out.println(json_encoded.toJSONString());
    }


    public String getCode()
    {
        return (String) json_encoded.get("_Sancion__code");
    }

    public String getTipo()
    {
        return (String) json_encoded.get("_Sancion__tipo");
    }

    public String getDNI()
    {
        return (String) json_encoded.get("_Sancion__dni");
    }

    public String getCodPartido()
    {
        return (String) json_encoded.get("_Sancion__cod_partido");
    }
}
