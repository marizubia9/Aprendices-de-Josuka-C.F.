package ServiciosExternos;

import org.json.simple.JSONObject;
/**
 * @class Sancion_JSON
 * @brief Clase para parsear las sanciones de la raspberry
 * @author Alumno
 *
 */
public class Sancion_JSON
{
    JSONObject json_encoded;
/**
 * Constructor de la clase
 * @param json_encoded objeto a parsear
 */
    public Sancion_JSON(Object json_encoded)
    {
        this.json_encoded = (JSONObject) json_encoded;
    }
/**
 * Método para parsear el código de la sancion
 * @return el código de la sancion
 */
    public String getCode()
    {
        return (String) json_encoded.get("_Sancion__code");
    }
/**
 * Método para parsear el tipo de la sanción, puede ser FALTA, AGRESION o INSULTO
 * @return tipo de la sanción
 */
    public String getTipo()
    {
        return (String) json_encoded.get("_Sancion__tipo");
    }
/**
 * Parsea el DNI de la persona que cometió la sanción, puede ser tanto entrenador como jugador
 * @return el dni de la persona
 */
    public String getDNI()
    {
        return (String) json_encoded.get("_Sancion__dni");
    }
/**
 * Método para parsear el código del partido donde se tuvo lugar la sanción
 * @return el código del partido
 */
    public String getCodPartido()
    {
        return (String) json_encoded.get("_Sancion__cod_partido");
    }
}
