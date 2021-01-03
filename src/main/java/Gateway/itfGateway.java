package Gateway;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Partido;
import Aprendices_de_Josuka.LD.Sancion;
import ServiciosExternos.Partido_JSON;
import ServiciosExternos.Sancion_JSON;
/**
 * @class itfGateway
 * @brief Interfaz del Gateway donde se establecen todos los métodos que tendrá el Gateway
 * @author Alumno
 */
public interface itfGateway
{
	/**
	 * Método para obtener la lista de partidos de la raspberry
	 * @return devuelve la lista
	 * @throws ParseException
	 */
	public List<Partido> search_partidos() throws ParseException;
	/**
	 * Método para obtener la lista de sanciones de la raspberry
	 * @return devuelve la lista
	 * @throws ParseException
	 */
	public List<Sancion> search_sanciones() throws ParseException;
	/**
	 * Parsea el contenido de la raspberry (Partido_JSON) al objeto Partido de la aplicación
	 * @param json lista de partidos a parsear
	 * @return lista de partidos parseado
	 */
	public ArrayList<Partido> convertir_partidos(List<Partido_JSON> json);
	/**
	 * Parsea el contenido de la raspberry (Sancion_JSON) al objeto Sancion de la aplicación
	 * @param json lista de sanciones a parsear
	 * @return lista de sanciones parseado
	 */
	public ArrayList<Sancion> convertir_sanciones(List<Sancion_JSON> json);
	/**
	 * Los partidos tienen dos equipos, mediante este método se obtiene la lista de todos los equipos externos. Donde algunos corresponderán con los equipos del club de futbol. Así, se podrá calcular la clasificación
	 * @return devuelve una lista de los equipos
	 * @throws ParseException
	 */
	public HashSet<Equipos_Ext> getEquipos()  throws ParseException;
	/**
	 * Método para ver si las listas de partidos de la raspberry está vacía o no
	 * @return true si la lista está llena, false si no
	 * @throws ParseException
	 */
	public boolean partidos() throws ParseException;
	/**
	 * Método para ver si las listas de sanciones de la raspberry está vacía o no
	 * @return true si la lista está llena, false si no
	 * @throws ParseException
	 */
	public boolean sanciones() throws ParseException;
}