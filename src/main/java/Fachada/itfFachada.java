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
/**
 * @interface itfFachada
 * @brief interfaz que contiene todos los métodos que implementará el servidor
 * @author Alumno
 *
 */
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
	/**
	 * Método para obtener todos los entrenadores almacenados en la base de datos
	 * @return devuelve lista de entrenadores
	 * @throws RemoteException
	 */
	public List<Entrenador> getEntrenador() throws RemoteException;
	/**
	 * Mediante este método se obtienen todos los equipos de la base de datos que pertenecen al club
	 * @return lista de equipos
	 * @throws RemoteException
	 */
	public List<Equipo> getEquipos() throws RemoteException;
	/**
	 * Método para calcular el puesto en el que se encuentra un equipo
	 * @param dni del jugador/entrenador del cual se quiere conocer el ranking
	 * @return devuelve el número del puesto
	 * @throws ParseException
	 * @throws RemoteException
	 */
	public int getRanking(String dni) throws ParseException, RemoteException;
	/**
	 * Mediante este método se modifican el correo y la contraseña del entrenador
	 * @param j el objeto entrenador a modificar
	 * @param correo
	 * @param psw
	 * @return devuelve un true si la modificación se realiza con éxito
	 * @throws RemoteException
	 */
	public boolean modificarCorreoEntrenador(Entrenador j, String correo, String psw) throws RemoteException ;
	/**
	 * Con este método se obtienen los partidos de un jugador
	 * @param partidos lista de todos los partidos
	 * @param DNI del jugador del cual se quieren conocer sus partidos
	 * @return devuelve lista de partidos
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public List<Partido> jugadorPartido(List<Partido> partidos, String DNI) throws RemoteException, ParseException;
	/**
	 * Mediante este método se actualizan los entrenadores, estableciendo así su asignación
	 * @param ent
	 * @throws RemoteException
	 */
	public void ActualizarEquipoEntrenador(Entrenador ent)throws RemoteException;
	/**
	 * Es un método mediante la cual se filtran los equipos dependiendo de la categoria
	 * @param cat categoria por la cual se filtrará
	 * @return lista filtrada
	 * @throws RemoteException
	 */
	public List<Equipo>getEquiposFilter(Categoria cat) throws RemoteException;
	/**
	 * Obtiene la lista de materiales desde la base de datos 
	 * @return devuelve la lista
	 * @throws RemoteException
	 */
	public  List<Material> getMaterial() throws RemoteException;
	/**
	 * Mediante este método se obtiene el equipo asignado al entrenador
	 * @param entrenador dni del entrenador
	 * @return devuelve el nombre del equipo
	 * @throws RemoteException
	 */
	public String ObtenerEquipoEntrenador(String entrenador)throws RemoteException;
	/**
	 * Calcula la edad en base a una fecha, para así clasificar los jugadores en categorias
	 * @param date fecha de nacimiento
	 * @return devuelve años
	 * @throws RemoteException
	 */
	public int getEdad(String date)throws RemoteException;
	/**
	 * Obtiene, mediante este metodo, el equipo en el que juega un jugador
	 * @param jugador el jugador en cuestión
	 * @return devuelve el nombre del equipo
	 * @throws RemoteException
	 */
	public String ObtenerEquipoJugador(Jugador jugador)throws RemoteException;
	/**
	 * Método para actualizar el estado del jugador, tanto médico como de su cuota
	 * @param e jugador al que se le actualizarán los datos
	 * @param reconocimiento si ha superado el reconocimiento médico o no
 	 * @param lesionado si esta lesionado o no
 	 * @param cuota si ha pagado la cuota o no
	 * @return devuelve true si se ha modificado correctamente
	 * @throws RemoteException
	 */
	public boolean ActualizarJugador(Jugador e, boolean reconocimiento, boolean lesionado, boolean cuota) throws RemoteException;
	/**
	 * Mediante este método se actualizará el salario de un entrenador
	 * @param e entrenador al que se le actualizarán los datos
	 * @param salario nuevo salario
	 * @return devuelve true si se ha modificado correctamente
	 * @throws RemoteException
	 */
	public boolean ActualizarEntrenador(Entrenador e, long salario) throws RemoteException;
	/**
	 * Cuando un equipo se crea y se añaden jugadores a este, se ejecuta este metodo para actualizar el estado de los jugadores a ASIGNADO
	 * @param lista_Jugadores jugadores a los que se les actualizará el estado
	 * @throws RemoteException
	 */
	public void ActualizarJugadorEquipo(List<Jugador> lista_Jugadores) throws RemoteException;
	/**
	 * Método mediante la cual se actualizan los datos de un equipo
	 * @param equipo al cual se le modificarán los datos
	 * @param inventario nuevo inventario
	 * @param jugadores nuevos jugadores
	 * @throws RemoteException
	 */
	public void ActualizarEquipo(Equipo equipo, HashMap<Material, Integer> inventario, List<Jugador> jugadores) throws RemoteException;
	/**
	 * Este método sirve para modificar el material
	 * @param tipo de material
	 * @param cantidad
	 * @param precio
	 * @throws RemoteException
	 */
	public void ActualizarMaterial(Tipo_Material tipo, int cantidad, long precio)throws RemoteException;
	/**
	 * Cuando se asigna un material a un equipo, hay que reducir el inventario del club. Es lo que se hace en este método mediante la conexión a la base de datos
	 * @param m material a modificar
	 * @throws RemoteException
	 */
	public  void AsignarInventario(Material m) throws RemoteException;
	/**
	 * Mediante este método se obtiene el entrenador asignado a un equipo concreto
	 * @param e el equipo en cuestión
	 * @return devuelve el entrenador
	 * @throws RemoteException
	 */
	public Entrenador equipoEntrenador (Equipo e) throws RemoteException;
	/**
	 * Este método sirve para obtener los DNIs de los jugadores asignados a un equipo
	 * @param e el equipo
	 * @return devuelve la lista de jugadores
	 * @throws RemoteException
	 */
	public List<Jugador> equipoJugadores (Equipo e)throws RemoteException;
	/**
	 * Devuelve una lista ordenada de los equipos de la liga según la categoria para hacer clasificación
	 * @param cat categoria 
	 * @return lista ordenada
	 * @throws RemoteException
	 * @throws org.json.simple.parser.ParseException
	 */
	public List <Equipos_Ext> clasificacion (Categoria cat)throws RemoteException, ParseException;
}
