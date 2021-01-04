/**
 * @package Controller
 * @brief Necesario para incorporar el patron de diseño del controller
 */
package Controller;
/**
 * En esta clase se delegan los metodos a la fachada
 */
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LD.Partido;
import Aprendices_de_Josuka.LD.Sancion;
import Aprendices_de_Josuka.LD.Tipo_Material;
import Remote.ServiceLocator;

public class Controller {
	private ServiceLocator rsl = null;
	/**
	 * Constructor
	 * @throws RemoteException
	 */
	public Controller() throws RemoteException {

		rsl = new ServiceLocator();
		rsl.setService();

	}
	/**
	 * Metodo que devuelve la lista de partidos de la fachada
	 * @return lista de partidos
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public List <Partido> getPartidos()throws RemoteException, ParseException
	{
		return rsl.getService().getPartidos();
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de inicio de sesion del jugador
	 * @param email
	 * @param psw
	 * @return un boolean que informa sobre si el jugador ha entrado bien el la aplicacion (true) o no (false)
	 * @throws RemoteException
	 */
	public boolean EntrarJugador(String email, String psw) throws RemoteException {
		return rsl.getService().EntrarJugador(email, psw);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada que obtiene la lista de los equipos obtenidos de la raspberry 
	 * @param cat
	 * @return la lista de los equipos obtenidos de la raspberry
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public List<Equipos_Ext> Clasificacion(Categoria cat) throws RemoteException, ParseException {
		return rsl.getService().clasificacion(cat);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de inicio de sesion del entrenador
	 * @param email
	 * @param psw
	 * @return un boolean que informa sobre si el entrenador ha entrado bien el la aplicacion (true) o no (false)
	 * @throws RemoteException
	 */
	public boolean EntrarEntrenador(String email, String psw) throws RemoteException {
		return rsl.getService().EntrarEntrenador(email, psw);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de inicio de sesion del entrenador administrador
	 * @param email
	 * @param psw
	 * @return un boolean que informa sobre si el administrador ha entrado bien el la aplicacion (true) o no (false)
	 * @throws RemoteException
	 */
	public boolean EntrarAdministrador(String email, String psw) throws RemoteException {
		return rsl.getService().EntrarAdministrador(email, psw);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de registrarse del jugador
	 * @param nombre
	 * @param apellido
	 * @param fecha_S
	 * @param DNI
	 * @param telefono
	 * @param correo
	 * @param psw
	 * @return un boolean que informa sobre si el jugador se ha registrado bien el la aplicacion (true) o no (false)
	 * @throws RemoteException
	 */
	public boolean RegistrarJugador(String nombre, String apellido, String fecha_S, String DNI, int telefono,
			String correo, String psw) throws RemoteException {
		
		return rsl.getService().RegistrarJugador(nombre, apellido, fecha_S, DNI, telefono, correo, psw);

	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de registrarse del entrenador
	 * @param nombre
	 * @param apellido
	 * @param fecha_S
	 * @param DNI
	 * @param telefono
	 * @param correo
	 * @param psw
	 * @param isAsignado
	 * @throws RemoteException
	 */
	public void RegistrarEntrenador(String nombre, String apellido, String fecha_S, String DNI, int telefono,
			String correo, String psw, boolean isAsignado) throws RemoteException {
		rsl.getService().RegistrarEntrenador(nombre, apellido, fecha_S, DNI, telefono, correo, psw);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de registrarse del administrador
	 * @param correo
	 * @param psw
	 * @throws RemoteException
	 */
	public void RegistrarAdmin(String correo, String psw) throws RemoteException {
		rsl.getService().RegistrarAdmin(correo, psw);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de registro de equipo
	 * @param nombre
	 * @param cat
	 * @param entrenador
	 * @param lista_Jugadores
	 * @param inventario
	 * @return boolean que informa sobre si el equipo se ha guardado bien (true) o no (false)
	 * @throws RemoteException
	 */
	public boolean RegistrarEquipo2(String nombre, Categoria cat, Entrenador entrenador, List<Jugador>lista_Jugadores, HashMap<Material, Integer> inventario) throws RemoteException{
		
		return rsl.getService().RegistrarEquipo2(nombre, cat, entrenador, lista_Jugadores, inventario);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de registro de inventario
	 * @param mat
	 * @param cantidad
	 * @param precio
	 * @throws RemoteException
	 */
	public void RegistrarInventario(Tipo_Material mat, int cantidad, long precio) throws RemoteException {
		rsl.getService().RegistrarInventario(mat, cantidad, precio);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener los partidos ganados
	 * @param DNI
	 * @return
	 * @throws RemoteException
	 * @throws ParseException
	 */
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener los partidos ganados
	 * @param DNI
	 * @return
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public int partidosGanados(String DNI) throws RemoteException, ParseException {
		return rsl.getService().partidosGanados(DNI);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener la lista de las sanciones 
	 * @param DNI
	 * @return lista de sanciones
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public List<Sancion> sancionesPersona(String DNI) throws RemoteException, ParseException {
		return rsl.getService().sancionesPersona(DNI);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener la lista de los jugadores de un entrenador
	 * @param ent
	 * @return lista de los jugadores de un entrenador
	 * @throws RemoteException
	 */
	public List<Jugador> misJugadores(String ent)throws RemoteException
	{
		return rsl.getService().misJugadores(ent);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de modificar el correo y la contrasenya de un jugador 
	 * @param j
	 * @param correo
	 * @param psw
	 * @return un boolean que informa si se ha modificado correctamente (true) o no (false)
	 * @throws RemoteException
	 */
	public boolean modificarCorreo(Jugador j, String correo, String psw) throws RemoteException
	{
		return rsl.getService().modificarCorreo(j, correo, psw);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de modificar el correo y la contrasenya de un jugador
	 * @param j
	 * @param correo
	 * @param psw
	 * @return un boolean que informa si se ha modificado correctamente (true) o no (false)
	 * @throws RemoteException
	 */
	public boolean modificarCorreoEntrenador(Entrenador j, String correo, String psw) throws RemoteException
	{
		return rsl.getService().modificarCorreoEntrenador(j, correo, psw);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de leer un jugador 
	 * @param correo
	 * @param psw
	 * @return el jugador
	 * @throws RemoteException
	 */
	public Jugador getJugador(String correo, String psw) throws RemoteException
	{
		return rsl.getService().getJug(correo,psw);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de la fachada de leer un entrenador
	 * @param correo
	 * @param psw
	 * @return el entrenador
	 * @throws RemoteException
	 */
	public Entrenador getEntrenador(String correo, String psw) throws RemoteException
	{
		return rsl.getService().getEnt(correo,psw);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de leer jugadores de una categoria
	 * @param c
	 * @return la lista de jugadores
	 * @throws RemoteException
	 */
	public List<Jugador> MostrarJugadores(Categoria c) throws RemoteException {
		return rsl.getService().MostrarJugadores(c);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener el puesto del ranking
	 * @param dni
	 * @return un int con el puesto del ranking
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public int getRanking(String dni)throws RemoteException, ParseException 
	{
		return rsl.getService().getRanking(dni);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener la lista de jugadores de un equipo
	 * @param e
	 * @return la lista de jugadores de un equipo
	 * @throws RemoteException
	 */
	public List<Jugador> equipoJugadores(Equipo e) throws RemoteException {
		return rsl.getService().equipoJugadores(e);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener el entrenador de un equipo
	 * @param e
	 * @return el entrenador de un equipo
	 * @throws RemoteException
	 */
	public Entrenador equipoEntrenador(Equipo e) throws RemoteException {
		return rsl.getService().equipoEntrenador(e);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener en que partido se ha realizado una sancion
	 * @param cod
	 * @return un partido en el que se haya realizado una sancion
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public Partido sancionPartido(String cod) throws RemoteException, ParseException {
		return rsl.getService().sancionPartido(cod);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener una lista de partidos jugados por un jugador
	 * @param partidos
	 * @param DNI
	 * @return una lista de partidos 
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public List<Partido> jugadorPartido(List <Partido> partidos, String DNI) throws RemoteException, ParseException {
		return rsl.getService().jugadorPartido(partidos, DNI);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener una lista de entrenadores
	 * @return una lista de entrenadores
	 * @throws RemoteException
	 */
	public List<Entrenador> getEntrenador() throws RemoteException {
		return rsl.getService().getEntrenador();
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener inventario
	 * @return una lista de inventario 
	 * @throws RemoteException
	 */
	public List<Material> getMaterial() throws RemoteException {
		return rsl.getService().getMaterial();
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener equipos
	 * @return lista de equipos 
	 * @throws RemoteException
	 */
	public List<Equipo> getEquipos() throws RemoteException {
		return rsl.getService().getEquipos();
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener el nombre del equipo de un jugador
	 * @param jugador
	 * @return un String con el nombre de un equipo
	 * @throws RemoteException
	 */
	public String ObtenerEquipoJugador(Jugador jugador) throws RemoteException {
		return rsl.getService().ObtenerEquipoJugador(jugador);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de filtrar los equipos por categoria
	 * @param cat
	 * @return la lista de equipos filtrada
	 * @throws RemoteException
	 */
	public List<Equipo>getEquiposFilter(Categoria cat) throws RemoteException
	{
		return rsl.getService().getEquiposFilter(cat);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de obtener el nombre del equipo de un entrenador
	 * @param entrenador
	 * @return un string con el nombre del equipo de un entrenador
	 * @throws RemoteException
	 */
	public String ObtenerEquipoEntrenador(String entrenador)throws RemoteException
	{
		return rsl.getService().ObtenerEquipoEntrenador(entrenador);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de actualizar la lista de jugadores de un equipo
	 * @param lista_Jugadores
	 * @throws RemoteException
	 */
	public void ActualizarJugadorEquipo(List<Jugador> lista_Jugadores) throws RemoteException {
		rsl.getService().ActualizarJugadorEquipo(lista_Jugadores);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de modificar la informacion del jugador que ha editado el administrador
	 * @param e
	 * @param reconocimiento
	 * @param lesionado
	 * @param cuota
	 * @throws RemoteException
	 */
	public void ActualizarJugador(Jugador e, boolean reconocimiento, boolean lesionado, boolean cuota)
			throws RemoteException {
		rsl.getService().ActualizarJugador(e, reconocimiento, lesionado, cuota);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de modificar la informacion del entrenador que ha editado el administrador
	 * @param e
	 * @param salario
	 * @throws RemoteException
	 */
	public void ActualizarEntrenador(Entrenador e, long salario) throws RemoteException
	{
		rsl.getService().ActualizarEntrenador(e, salario);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de modificar la informacion del equipo que ha editado el administrador
	 * @param equipo
	 * @param inventario
	 * @param jugadores
	 * @throws RemoteException
	 */
	public void ActualizarEquipo(Equipo equipo, HashMap<Material, Integer> inventario, List<Jugador> jugadores) throws RemoteException
	{
		rsl.getService().ActualizarEquipo(equipo, inventario, jugadores);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de modificar el entrenador de un equipo
	 * @param e
	 * @throws RemoteException
	 */
	public void ActualizarEquipoEntrenador(Entrenador e) throws RemoteException
	{
		rsl.getService().ActualizarEquipoEntrenador(e);
	}
	/**
	 * Metodo que hace la llamada al metodo de la fachada de modificar el inventario asignado a un equipo
	 * @param m
	 * @throws RemoteException
	 */
	public  void AsignarInventario(Material m) throws RemoteException
	{
		rsl.getService().AsignarInventario(m);
	}
	
}
