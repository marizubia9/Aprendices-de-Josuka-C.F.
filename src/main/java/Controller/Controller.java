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
import Aprendices_de_Josuka.LD.Tipo_Material;
import Aprendices_de_Josuka.LN.Gestor;
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

	public void RegistrarEquipo(Equipo e) throws RemoteException {
		rsl.getService().RegistrarEquipo(e);
	}

	public void RegistrarInventario(Tipo_Material mat, int cantidad, long precio) throws RemoteException {
		rsl.getService().RegistrarInventario(mat, cantidad, precio);
	}
	
	public Jugador getJugador(String correo, String psw) throws RemoteException
	{
		return rsl.getService().getJug(correo,psw);
	}

	public List<Jugador> MostrarJugadores(Categoria c) throws RemoteException {
		return rsl.getService().MostrarJugadores(c);
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
	public String ObtenerEquipoEntrenador(Entrenador entrenador)throws RemoteException
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
	public void ActualizarEquipo(Equipo equipo, HashMap inventario, List<Jugador> jugadores) throws RemoteException
	{
		rsl.getService().ActualizarEquipo(equipo, inventario, jugadores);
	}
	public  void AsignarInventario(Material m) throws RemoteException
	{
		rsl.getService().AsignarInventario(m);
	}
	
}
