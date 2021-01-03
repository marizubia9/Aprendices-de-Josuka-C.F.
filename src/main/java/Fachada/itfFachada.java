package Fachada;

import java.rmi.Remote;
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

public interface itfFachada extends Remote
{
	/**
	 * Verifica si el jugador existe en la base de datos para permitir el acceso a la aplicación
	 * @param email
	 * @param psw
	 * @return true si existe
	 * @throws RemoteException
	 */
	public boolean EntrarJugador(String email, String psw) throws RemoteException;
	/**
	 * Verifica si el entrenador existe en la base de datos para permitir el acceso a la aplicación
	 * @param email
	 * @param psw
	 * @return true si existe
	 * @throws RemoteException
	 */
	public boolean EntrarEntrenador(String email, String psw) throws RemoteException;
	/**
	 * Verifica si el administrador existe en la base de datos para permitir el acceso a la aplicación
	 * @param email
	 * @param psw
	 * @return true si existe
	 * @throws RemoteException
	 */
	public boolean EntrarAdministrador(String email, String psw) throws RemoteException;
	/**
	 * Crea un nuevo jugador en la base de datos
	 * @param nombre
	 * @param apellido
	 * @param fecha_S
	 * @param DNI
	 * @param telefono
	 * @param correo
	 * @param psw
	 * @return true si se crea correctamente
	 * @throws RemoteException
	 */
	public boolean RegistrarJugador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw) throws RemoteException;
	/**
	 * Registra un administrador en la base de datos
	 * @param correo
	 * @param psw
	 * @return true si se registra bien
	 * @throws RemoteException
	 */
	public boolean RegistrarAdmin(String correo, String psw) throws RemoteException;
	/**
	 * Registra un entrenador
	 * @param nombre
	 * @param apellido
	 * @param fecha_S
	 * @param DNI
	 * @param telefono
	 * @param correo
	 * @param psw
	 * @return true si se registra bien
	 * @throws RemoteException
	 */
	public boolean RegistrarEntrenador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw) throws RemoteException;
	/**
	 * Registra un nuevo equipo en la base de datos
	 * @param nombre
	 * @param cat
	 * @param entrenador
	 * @param lista_Jugadores
	 * @param inventario
	 * @return true si se registra bien
	 * @throws RemoteException
	 */
	public boolean RegistrarEquipo2(String nombre, Categoria cat, Entrenador entrenador, List<Jugador>lista_Jugadores, HashMap<Material, Integer> inventario) throws RemoteException;
	/**
	 * Registro de un nuevo inventario
	 * @param mat tipo material
	 * @param cantidad 
	 * @param precio
	 * @return true si se registra bien
	 * @throws RemoteException
	 */
	public boolean RegistrarInventario(Tipo_Material mat, int cantidad, long precio ) throws RemoteException;
	/**
	 * Devuelve la lista de todos los jugadores de la base de datos
	 * @return
	 * @throws RemoteException
	 */
	public List<Jugador>getJugador() throws RemoteException;
	/**
	 * Obtiene todos los datos del jugador segun su correo y contraseña
	 * @param correo
	 * @param psw
	 * @return jugador
	 * @throws RemoteException
	 */
	public Jugador getJug(String correo, String psw) throws RemoteException;
	/**
	 * Devuelve todos los datos de un entrenador segun correo y contraseña
	 * @param correo
	 * @param psw
	 * @return entrenador
	 * @throws RemoteException
	 */
	public Entrenador getEnt(String correo, String psw) throws RemoteException;
	/**
	 * Para obtener los datos del partido en el cual se cometieron una sanción
	 * @param codPartido
	 * @return partido
	 * @throws ParseException
	 * @throws RemoteException
	 */
	public Partido sancionPartido(String codPartido) throws ParseException, RemoteException;
	/**
	 * Calcula el número total de partidos ganados del equipo de un jugador o entrenador
	 * @param DNI del jugador o del entrenador
	 * @return suma de todos los partidos ganados
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public int partidosGanados(String DNI) throws RemoteException, ParseException;
	/**
	 * Modifica el correo y la contraseña de un jugador
	 * @param j jugador del cual los datos se modificaran 
	 * @param correo
	 * @param psw
	 * @return true si se ha realizado la modificación con existo
	 * @throws RemoteException
	 */
	public boolean modificarCorreo(Jugador j, String correo, String psw) throws RemoteException ;
	/**
	 * Mediante este método se obtiene una lista de todas las sanciones de una persona
	 * @param DNI del jugador o entrenador
	 * @return lista de sanciones
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public List<Sancion> sancionesPersona(String DNI) throws RemoteException, ParseException;
	/**
	 * Método para obtener los jugadores relacionados con un entrenador
	 * @param ent DNI del entrenador
	 * @return lista de jugadores
	 * @throws RemoteException
	 */
	public List<Jugador> misJugadores(String ent)throws RemoteException;
	/**
	 * Coge todos los partidos de la raspberry
	 * @return lista de partidos
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public List<Partido>getPartidos() throws RemoteException, ParseException;
	/**
	 * Este método sirve para mostrar los jugadores segun categoria
	 * @param c categoria
	 * @return lista de jugadores
	 * @throws RemoteException
	 */
	public List<Jugador> MostrarJugadores(Categoria c) throws RemoteException;
	public List<Entrenador> getEntrenador() throws RemoteException;
	public List<Equipo> getEquipos() throws RemoteException;
	public int getRanking(String dni) throws ParseException, RemoteException;
	public boolean modificarCorreoEntrenador(Entrenador j, String correo, String psw) throws RemoteException ;
	public List<Partido> jugadorPartido(List<Partido> partidos, String DNI) throws RemoteException, ParseException;
	public void ActualizarEquipoEntrenador(Entrenador ent)throws RemoteException;
	public List<Equipo>getEquiposFilter(Categoria cat) throws RemoteException;
	public  List<Material> getMaterial() throws RemoteException;
	public String ObtenerEquipoEntrenador(String entrenador)throws RemoteException;
	public int getEdad(String date)throws RemoteException;
	public String ObtenerEquipoJugador(Jugador jugador)throws RemoteException;
	public boolean ActualizarJugador(Jugador e, boolean reconocimiento, boolean lesionado, boolean cuota) throws RemoteException;
	public boolean ActualizarEntrenador(Entrenador e, long salario) throws RemoteException;
	public void ActualizarJugadorEquipo(List<Jugador> lista_Jugadores) throws RemoteException;
	public void ActualizarEquipo(Equipo equipo, HashMap<Material, Integer> inventario, List<Jugador> jugadores) throws RemoteException;
	public void ActualizarMaterial(Tipo_Material tipo, int cantidad, long precio)throws RemoteException;
	public  void AsignarInventario(Material m) throws RemoteException;
	public Entrenador equipoEntrenador (Equipo e) throws RemoteException;
	public List<Jugador> equipoJugadores (Equipo e)throws RemoteException;
	/**
	 * Devuelve una lista ordenada de los equipos de la liga según la categoria para hacer clasificación
	 * @param cat categoria 
	 * @return lista ordenada
	 * @throws RemoteException
	 * @throws org.json.simple.parser.ParseException
	 */
	public List <Equipos_Ext> clasificacion (Categoria cat)throws RemoteException, org.json.simple.parser.ParseException;
}
