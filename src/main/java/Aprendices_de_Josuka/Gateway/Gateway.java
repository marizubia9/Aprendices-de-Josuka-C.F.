package Aprendices_de_Josuka.Gateway;

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
import Aprendices_de_Josuka.ServiciosExternos.Partido_JSON;
import Aprendices_de_Josuka.ServiciosExternos.Partidos_parameters;
import Aprendices_de_Josuka.ServiciosExternos.RestClient;

public class Gateway implements itfGateway {
	private static String port = "5000";
	private static String hostname = "127.0.0.1";
	private String path = "/";
	private RestClient<Partidos_parameters> client;
	private Response response;
	private static final Gateway INSTANCE = new Gateway();

	private Gateway() {
	}

	public static Gateway getInstance() {
		return INSTANCE;
	}
	@Override
	public List<Partido_JSON> search_partidos() throws ParseException {
		path = "/Partidos/Search_Partidos";
        System.out.println("Trying POST at " + path + " (Search All partido message)");
        System.out.println("CURL call: curl http://127.0.0.1:5000//Partidos/Search_Partidos -d '{ }' -X POST -H \"Content-Type: application/json\" -v");
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

        // Lambda expression to print array
        partidosArray.stream().forEach(
                element -> System.out.println(element)
        );

        // Lambda expression to map JSONObjects inside JSONArray to flight objects
        myPartidosArray = (List) partidosArray.stream()
                .map( element -> new Partido_JSON( element))
                .collect(Collectors.toList()
        );

        System.out.println("Number of partidos collected:");


        return myPartidosArray;

	}
	@Override
	public ArrayList<Partido> convertir(List<Partido_JSON> json) {
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
	public List<Partido> getPartidos() throws ParseException {

		List<Partido_JSON> lista_json = search_partidos();
		List<Partido> partidos = convertir(lista_json);
		
		return  partidos;
	}
	
	@Override
	public HashSet<Equipos_Ext> getEquipos() throws ParseException {

		HashSet<Equipos_Ext> Lista_equipos = new HashSet<Equipos_Ext>();
		List<Partido_JSON> lista_json = search_partidos();
		List<Partido> partidos = convertir(lista_json);
		partidos.stream().forEach(element -> {
			Lista_equipos.add(element.getEquipo_1());
			Lista_equipos.add(element.getEquipo_2());
		});

		return Lista_equipos;
	}

}