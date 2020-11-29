package Controller;

import java.rmi.RemoteException;
import java.util.List;

import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Tipo_Material;
import Aprendices_de_Josuka.LN.Gestor;
import Aprendices_de_Josuka.LP.Pantalla_Principal;
import Remote.ServiceLocator;

public class Controller 
{
	private ServiceLocator rsl = null;

	public Controller() throws RemoteException {

		rsl = new ServiceLocator();
		rsl.setService();
		new Pantalla_Principal(this);
	}
	
	public boolean EntrarJugador (String email, String psw) throws RemoteException
	{
		return rsl.getService().EntrarJugador(email, psw);
	}
	public boolean EntrarEntrenador (String email, String psw) throws RemoteException
	{
		return rsl.getService().EntrarEntrenador(email, psw);
	}
	public boolean EntrarAdministrador (String email, String psw) throws RemoteException
	{
		return rsl.getService().EntrarAdministrador(email, psw);
	}
	public void RegistrarJugador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw) throws RemoteException
	{
		rsl.getService().RegistrarJugador(nombre, apellido, fecha_S, DNI, telefono, correo, psw);
	}
	public void RegistrarEntrenador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw, boolean isAsignado) throws RemoteException
	{
		rsl.getService().RegistrarEntrenador(nombre, apellido, fecha_S, DNI, telefono, correo, psw, isAsignado);
	}
	public List<Jugador> MostrarJugadores(Categoria c) throws RemoteException
	{
		return rsl.getService().MostrarJugadores(c);
	}
	public void RegistrarEquipo(Equipo e) throws RemoteException
	{
		rsl.getService().RegistrarEquipo(e);;
	}
	public void ActualizarJugadorEquipo(List<Jugador> lista_Jugadores) throws RemoteException
	{
		rsl.getService().ActualizarJugadorEquipo(lista_Jugadores);
	}
	public List<Entrenador> getEntrenador() throws RemoteException
	{
		return rsl.getService().getEntrenador();
	}
	public void RegistrarInventario(Tipo_Material mat, int cantidad, long precio ) throws RemoteException
	{
		rsl.getService().RegistrarInventario(mat, cantidad, precio);
	}
	public List<Equipo> getEquipos() throws RemoteException
	{
		return rsl.getService().getEquipos();
	}

}
