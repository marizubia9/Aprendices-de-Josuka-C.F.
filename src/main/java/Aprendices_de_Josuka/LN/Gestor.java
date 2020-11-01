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
	
	public static void RegistrarJugador(String nombre, String apellido, Date fecha_nacimiento, String DNI, boolean reconocimiento_medico,
			boolean estado, int telefono, String correo,String password,  boolean cuota_pagada)
	{
		Jugador j= new Jugador (nombre, apellido, fecha_nacimiento, DNI, reconocimiento_medico, estado, telefono, correo,password, cuota_pagada);	
		DAO.getInstance().guardarObjeto(j);
	}
	
	public static void RegistrarEntrenador(String nombre, String apellido, Date fecha_nacimiento, String DNI, int telefono, String correo,String password)
	{
		Entrenador e= new Entrenador (nombre, apellido, fecha_nacimiento, DNI, telefono, correo,password, 0);	
		DAO.getInstance().guardarObjeto(e);
	}


}
