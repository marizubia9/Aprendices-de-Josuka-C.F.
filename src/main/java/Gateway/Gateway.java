package Gateway;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Partido;
import Aprendices_de_Josuka.LD.Sancion;
import Aprendices_de_Josuka.LD.Tipo_Sancion;
import ServiciosExternos.Partido_JSON;
import ServiciosExternos.Partidos_parameters;
import ServiciosExternos.RestClient;
import ServiciosExternos.Sancion_JSON;
/**
 * Clase Gateway, se conectara con la raspberry de partidos y sanciones. Además, implementará la interfaz del gateway
 * @author Alumno
 *
 */
public class Gateway implements itfGateway {
	private static String port = "5000";
	private static String hostname = "127.0.0.1";
	private String path = "/";
	private RestClient<Partidos_parameters> client;
	private Response response;
	private static final Gateway INSTANCE = new Gateway();
	/**
	 * Constructor vacio para crear el Gateway
	 */
	private Gateway() {
	}
	/**
	 * Mediante este método se incorpora el patrón Singleton, para instanciar el objeto una unica vez
	 * @return devolverá el objeto Gateway
	 */
	public static Gateway getInstance() {
		return INSTANCE;
	}

	@Override
	public List<Partido> search_partidos() throws ParseException {
		path = "/Partidos/Search_Partidos";
        client = new RestClient<Partidos_parameters>(hostname, port);
        response = null;
        try {
            response = 
                    client.makePostRequest(
                            client.createInvocationBuilder(path) , new Partidos_parameters()
                    
            );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }

        // JSON SIMPLE PARSER STUFF...
        List<Partido_JSON> myPartidosArray;

        String json_string = response.readEntity(String.class);
        JSONParser myParser = new JSONParser();
        JSONArray partidosArray = (JSONArray) myParser.parse( json_string );
       
        myPartidosArray = (List) partidosArray.stream()
                .map( element -> new Partido_JSON( element))
                .collect(Collectors.toList()
        );
        return convertir_partidos(myPartidosArray);

	}

	@Override
	public boolean partidos() throws ParseException
	{
		List <Partido> partidos = search_partidos();
		if(partidos.size() != 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean sanciones() throws ParseException
	{
		List <Sancion> sanciones = search_sanciones();
		if(sanciones.size() != 0)
		{
			return true;
		}
		return false;
	}
	@Override
	public ArrayList<Partido> convertir_partidos(List<Partido_JSON> json) {
		ArrayList<Partido> Lista_partidos= new ArrayList<Partido>();
		json.stream().forEach(element -> {
			Equipos_Ext equipo1 = new Equipos_Ext(element.getEquipo1Code(), element.getEquipo1Nombre(), element.getEquipo1Puntuacion(), element.getEquipo1Categoria());
			Equipos_Ext equipo2 = new Equipos_Ext(element.getEquipo2Code(), element.getEquipo2Nombre(), element.getEquipo2Puntuacion(), element.getEquipo2Categoria());
			Partido v = new Partido(element.getCode(), element.getDate(true), element.getResE1(), element.getResE2(),equipo1, equipo2);
		
	
			Lista_partidos.add(v);
		});

		return Lista_partidos;
	}
	
	@Override
	public HashSet<Equipos_Ext> getEquipos() throws ParseException {

		HashSet<Equipos_Ext> Lista_equipos = new HashSet<Equipos_Ext>();
		List<Partido> partidos = search_partidos();
		partidos.stream().forEach(element -> {
			Lista_equipos.add(element.getEquipo_1());
			Lista_equipos.add(element.getEquipo_2());
		});

		return Lista_equipos;
	}
	
	@Override
	public List<Sancion> search_sanciones() throws ParseException {
		path = "/Sanciones/Search_Sanciones";
        System.out.println("Trying POST at " + path + " (Search All sanciones message)");
        client = new RestClient<Partidos_parameters>(hostname, port);
        response = null;
        try {
            response = 
                    client.makePostRequest(
                            client.createInvocationBuilder(path) , new Partidos_parameters()
                    
            );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }

        // JSON SIMPLE PARSER STUFF...
        List<Sancion_JSON> mySancionesArray;

        String json_string = response.readEntity(String.class);
        JSONParser myParser = new JSONParser();
        JSONArray sancionesArray = (JSONArray) myParser.parse( json_string );

        // Lambda expression to print array
       

        mySancionesArray = (List) sancionesArray.stream()
                .map( element -> new Sancion_JSON( element))
                .collect(Collectors.toList()
        );
        return  convertir_sanciones(mySancionesArray);

	}

	
	@Override
	public ArrayList<Sancion> convertir_sanciones(List<Sancion_JSON> json) {
		ArrayList<Sancion> Lista_sanciones= new ArrayList<Sancion>();
		json.stream().forEach(element -> {
			if(element.getTipo().equals("FALTA"))
			{
				Sancion v = new Sancion(element.getCode(), Tipo_Sancion.FALTA, element.getDNI(), element.getCodPartido());
				Lista_sanciones.add(v);
			}
			else if(element.getTipo().equals("INSULTO"))
			{
				Sancion v = new Sancion(element.getCode(), Tipo_Sancion.INSULTO, element.getDNI(), element.getCodPartido());
				Lista_sanciones.add(v);
			}
			else if(element.getTipo().equals("AGRESION"))
			{
				Sancion v = new Sancion(element.getCode(), Tipo_Sancion.AGRESION, element.getDNI(), element.getCodPartido());
				Lista_sanciones.add(v);
			}
			
		});

		return Lista_sanciones;
	}

}