package Aprendices_de_Josuka.LN;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.HashSet;

import Aprendices_de_Josuka.DAO.DAO;
import Aprendices_de_Josuka.LD.Administrador;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LP.Pantalla_Principal;


public class Gestor {

	private static Gestor INSTANCE = null;

	
	public static Gestor getInstance() throws RemoteException {
		synchronized (Gestor.class) {
			if (INSTANCE == null) {
				INSTANCE = new Gestor();
			}
		}
		return INSTANCE;
	}
	public static boolean Entrar_admin(String email, String psw)
	{
		for( Administrador a: DAO.getInstance().getAdmin())
		{
			if (a.getEmail().equals(email)&&a.getPsw().equals(psw))
			{
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public static boolean Entrar_Jugador(String email, String psw)
	{

		for( Jugador a: DAO.getInstance().getJugador())
		{
			if (a.getCorreo().equals(email)&&a.getPsw().equals(psw))
			{
			
				return true;
			}
			else {
				
				return false;
			}
		}
		return false;
	}
	
	public static boolean Entrar_Entrenador(String email, String psw)
	{
		for( Entrenador a: DAO.getInstance().getEntrenador())
		{
			if (a.getCorreo().equals(email)&&a.getPsw().equals(psw))
			{
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	public static void RegistrarJugador(String nombre, String apellido, String fecha_nacimiento, String DNI, int telefono, String correo,String password, boolean Asignado_equipo)
	{
		Jugador j= new Jugador (nombre, apellido, fecha_nacimiento, DNI, false, false, telefono, correo,password, false, Asignado_equipo);	
		DAO.getInstance().guardarObjeto(j);
	}
	
	public static void RegistrarEntrenador(String nombre, String apellido, String fecha_nacimiento, String DNI, int telefono, String correo,String password, boolean asignado)
	{
		Entrenador e= new Entrenador (nombre, apellido, fecha_nacimiento, DNI, telefono, correo,password, 0, asignado);	
		DAO.getInstance().guardarObjeto(e);
	}


}
