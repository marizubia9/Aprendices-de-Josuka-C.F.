package Aprendices_de_Josuka.LN;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

import Aprendices_de_Josuka.DAO.DAO;
import Aprendices_de_Josuka.LD.Administrador;
import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
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

	public static boolean Entrar_admin(String email, String psw) {
		for (Administrador a : DAO.getInstance().getAdmin()) {
			if (a.getEmail().equals(email) && a.getPsw().equals(psw)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean Entrar_Jugador(String email, String psw) {

		for (Jugador a : DAO.getInstance().getJugador()) {
			if (a.getCorreo().equals(email) && a.getPsw().equals(psw)) {

				return true;
			} else {

				return false;
			}
		}
		return false;
	}

	public static boolean Entrar_Entrenador(String email, String psw) {
		for (Entrenador a : DAO.getInstance().getEntrenador()) {
			if (a.getCorreo().equals(email) && a.getPsw().equals(psw)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static void RegistrarJugador(String nombre, String apellido, String fecha_nacimiento, String DNI,
			int telefono, String correo, String password, boolean Asignado_equipo) {
		Jugador j = new Jugador(nombre, apellido, fecha_nacimiento, DNI, false, false, telefono, correo, password,
				false, Asignado_equipo);
		DAO.getInstance().guardarObjeto(j);
	}

	public static void RegistrarEntrenador(String nombre, String apellido, String fecha_nacimiento, String DNI,
			int telefono, String correo, String password, boolean asignado) {
		Entrenador e = new Entrenador(nombre, apellido, fecha_nacimiento, DNI, telefono, correo, password, 0, asignado);
		DAO.getInstance().guardarObjeto(e);
	}

	public List<Jugador> MostrarJugadores(Categoria cat)
	{
		int edad=0;
		List<Jugador> ListaJugadores1= new ArrayList<>();
		for (Jugador a : DAO.getInstance().getJugador()) {
			if (!a.isAsignado_equipo()) 
			{
				StringTokenizer st= new StringTokenizer(a.getFecha_nacimiento(),"/");
				Integer[] fecha=new Integer[3];
				int i=0;
				while(st.hasMoreTokens()){
		            String str=st.nextToken();
		            fecha[i]=Integer.valueOf(str).intValue();
		            i++;
		        }
				int anyo=fecha[2];
				Calendar cal = Calendar.getInstance();
				int anyo_actual=cal.get(Calendar.YEAR);
				edad=anyo_actual-anyo;
					if(cat==Categoria.ALEVIN)
						{
						if (edad==10||edad==11)
						{
							
							ListaJugadores1.add(a);
						}
							
						}
					if(cat==Categoria.INFANTIL)
					{
					if (edad==12||edad==13)
					{
						String nombre_completo= a.getNombre()+" "+a.getApellido();
						ListaJugadores1.add(a);
					}
						
					}
					if(cat==Categoria.CADETE)
					{
					if (edad==14||edad==15)
					{
						String nombre_completo= a.getNombre()+" "+a.getApellido();
						ListaJugadores1.add(a);
					}
						
					}
					if(cat==Categoria.JUVENIL)
					{
					if (edad==16||edad==17||edad==18)
					{
						String nombre_completo= a.getNombre()+" "+a.getApellido();
						ListaJugadores1.add(a);
					}
						
					}
					if(cat==Categoria.SENIOR)
					{
					if (edad>18)
					{
						String nombre_completo= a.getNombre()+" "+a.getApellido();
						ListaJugadores1.add(a);
					}
						
					}
				
			}
			
		}
		return ListaJugadores1;
	}
	
	public List<Entrenador> MostrarEntrenadores()
	{
		return DAO.getInstance().getEntrenador();
		
	}
	
	public List<String> MostrarEquipos()
	{
		List<String> ListaEquipos= new ArrayList<>();
		for (Equipo a : DAO.getInstance().getEquipo()) {
			String nombre_completo= a.getNombre();
			ListaEquipos.add(nombre_completo);
		}
		return ListaEquipos;
		
	}
	
	
}
