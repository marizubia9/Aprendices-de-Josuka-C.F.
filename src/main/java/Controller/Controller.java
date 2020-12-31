package Controller;

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
import Aprendices_de_Josuka.LP.Pantalla_Principal;
import Remote.ServiceLocator;

public class Controller {
	private ServiceLocator rsl = null;

	public Controller() throws RemoteException {

		rsl = new ServiceLocator();
		rsl.setService();

	}
	public List <Partido> getPartidos()throws RemoteException, ParseException
	{
		return rsl.getService().getPartidos();
	}
	public boolean EntrarJugador(String email, String psw) throws RemoteException {
		return rsl.getService().EntrarJugador(email, psw);
	}
	
	public List<Equipos_Ext> Clasificacion(Categoria cat) throws RemoteException, ParseException {
		return rsl.getService().clasificacion(cat);
	}

	public boolean EntrarEntrenador(String email, String psw) throws RemoteException {
		return rsl.getService().EntrarEntrenador(email, psw);
	}

	public boolean EntrarAdministrador(String email, String psw) throws RemoteException {
		return rsl.getService().EntrarAdministrador(email, psw);
	}

	public boolean RegistrarJugador(String nombre, String apellido, String fecha_S, String DNI, int telefono,
			String correo, String psw) throws RemoteException {
		
		return rsl.getService().RegistrarJugador(nombre, apellido, fecha_S, DNI, telefono, correo, psw);

	}

	public void RegistrarEntrenador(String nombre, String apellido, String fecha_S, String DNI, int telefono,
			String correo, String psw, boolean isAsignado) throws RemoteException {
		rsl.getService().RegistrarEntrenador(nombre, apellido, fecha_S, DNI, telefono, correo, psw);
	}
	public void RegistrarAdmin(String correo, String psw) throws RemoteException {
		rsl.getService().RegistrarAdmin(correo, psw);
	}

//	public boolean RegistrarEquipo(Equipo e) throws RemoteException {
//		return rsl.getService().RegistrarEquipo(e);
//	}
	public boolean RegistrarEquipo2(String nombre, Categoria cat, Entrenador entrenador, List<Jugador>lista_Jugadores, HashMap<Material, Integer> inventario) throws RemoteException{
		
		return rsl.getService().RegistrarEquipo2(nombre, cat, entrenador, lista_Jugadores, inventario);
	}

	public void RegistrarInventario(Tipo_Material mat, int cantidad, long precio) throws RemoteException {
		rsl.getService().RegistrarInventario(mat, cantidad, precio);
	}
	
	public int partidosGanados(String DNI) throws RemoteException, ParseException {
		return rsl.getService().partidosGanados(DNI);
	}
	
	public List<Sancion> sancionesPersona(String DNI) throws RemoteException, ParseException {
		return rsl.getService().sancionesPersona(DNI);
	}
	public List<Jugador> misJugadores(String ent)throws RemoteException
	{
		return rsl.getService().misJugadores(ent);
	}
	public boolean modificarCorreo(Jugador j, String correo, String psw) throws RemoteException
	{
		return rsl.getService().modificarCorreo(j, correo, psw);
	}
	public boolean modificarCorreoEntrenador(Entrenador j, String correo, String psw) throws RemoteException
	{
		return rsl.getService().modificarCorreoEntrenador(j, correo, psw);
	}
	
	public Jugador getJugador(String correo, String psw) throws RemoteException
	{
		return rsl.getService().getJug(correo,psw);
	}
	
	public Entrenador getEntrenador(String correo, String psw) throws RemoteException
	{
		return rsl.getService().getEnt(correo,psw);
	}

	public List<Jugador> MostrarJugadores(Categoria c) throws RemoteException {
		return rsl.getService().MostrarJugadores(c);
	}
	public int getRanking(String dni)throws RemoteException, ParseException 
	{
		return rsl.getService().getRanking(dni);
	}
	public List<Jugador> equipoJugadores(Equipo e) throws RemoteException {
		return rsl.getService().equipoJugadores(e);
	}
	public Entrenador equipoEntrenador(Equipo e) throws RemoteException {
		return rsl.getService().equipoEntrenador(e);
	}
	public Partido sancionPartido(String cod) throws RemoteException, ParseException {
		return rsl.getService().sancionPartido(cod);
	}
	public List<Partido> jugadorPartido(List <Partido> partidos, String DNI) throws RemoteException, ParseException {
		return rsl.getService().jugadorPartido(partidos, DNI);
	}
	public List<Entrenador> getEntrenador() throws RemoteException {
		return rsl.getService().getEntrenador();
	}

	public List<Material> getMaterial() throws RemoteException {
		return rsl.getService().getMaterial();
	}

	public List<Equipo> getEquipos() throws RemoteException {
		return rsl.getService().getEquipos();
	}

	public String ObtenerEquipoJugador(Jugador jugador) throws RemoteException {
		return rsl.getService().ObtenerEquipoJugador(jugador);
	}
	public List<Equipo>getEquiposFilter(Categoria cat) throws RemoteException
	{
		return rsl.getService().getEquiposFilter(cat);
	}
	public String ObtenerEquipoEntrenador(String entrenador)throws RemoteException
	{
		return rsl.getService().ObtenerEquipoEntrenador(entrenador);
	}
	public void ActualizarJugadorEquipo(List<Jugador> lista_Jugadores) throws RemoteException {
		rsl.getService().ActualizarJugadorEquipo(lista_Jugadores);
	}

	public void ActualizarJugador(Jugador e, boolean reconocimiento, boolean lesionado, boolean cuota)
			throws RemoteException {
		rsl.getService().ActualizarJugador(e, reconocimiento, lesionado, cuota);
	}
	public void ActualizarEntrenador(Entrenador e, long salario) throws RemoteException
	{
		rsl.getService().ActualizarEntrenador(e, salario);
	}
	public void ActualizarEquipo(Equipo equipo, HashMap<Material, Integer> inventario, List<Jugador> jugadores) throws RemoteException
	{
		rsl.getService().ActualizarEquipo(equipo, inventario, jugadores);
	}
	public void ActualizarEquipoEntrenador(Entrenador e) throws RemoteException
	{
		rsl.getService().ActualizarEquipoEntrenador(e);
	}
	public  void AsignarInventario(Material m) throws RemoteException
	{
		rsl.getService().AsignarInventario(m);
	}
	
}
