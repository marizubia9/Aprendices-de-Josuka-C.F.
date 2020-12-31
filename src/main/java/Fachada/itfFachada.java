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
	public boolean EntrarJugador(String email, String psw) throws RemoteException;
	public boolean EntrarEntrenador(String email, String psw) throws RemoteException;
	public boolean EntrarAdministrador(String email, String psw) throws RemoteException;
	public boolean RegistrarJugador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw) throws RemoteException;
	public boolean RegistrarAdmin(String correo, String psw) throws RemoteException;
	public boolean RegistrarEntrenador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw) throws RemoteException;
	public boolean RegistrarEquipo2(String nombre, Categoria cat, Entrenador entrenador, List<Jugador>lista_Jugadores, HashMap<Material, Integer> inventario) throws RemoteException;
	public boolean RegistrarInventario(Tipo_Material mat, int cantidad, long precio ) throws RemoteException;
	public List<Jugador>getJugador() throws RemoteException;
	public Jugador getJug(String correo, String psw) throws RemoteException;
	public Entrenador getEnt(String correo, String psw) throws RemoteException;
	public Partido sancionPartido(String codPartido) throws ParseException, RemoteException;
	public int partidosGanados(String DNI) throws RemoteException, ParseException;
	public boolean modificarCorreo(Jugador j, String correo, String psw) throws RemoteException ;
	public List<Sancion> sancionesPersona(String DNI) throws RemoteException, ParseException;
	public List<Jugador> misJugadores(String ent)throws RemoteException;
	public List<Partido>getPartidos() throws RemoteException, ParseException;
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
	public List <Equipos_Ext> clasificacion (Categoria cat)throws RemoteException, org.json.simple.parser.ParseException;
}
