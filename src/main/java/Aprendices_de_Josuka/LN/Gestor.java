package Aprendices_de_Josuka.LN;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.json.simple.parser.ParseException;

import com.mysql.fabric.xmlrpc.base.Array;

import Aprendices_de_Josuka.DAO.DAO;
import Aprendices_de_Josuka.Gateway.Gateway;
import Aprendices_de_Josuka.LD.Administrador;
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

	public  boolean Entrar_admin(String email, String psw) {
		for (Administrador a : DAO.getInstance().getAdmin()) {
			if (a.getEmail().equals(email) && a.getPsw().equals(psw)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public  boolean Entrar_Jugador(String email, String psw) {

		for (Jugador a : DAO.getInstance().getJugador()) {
			if (a.getCorreo().equals(email) && a.getPsw().equals(psw)) {

				return true;
			} else {

				return false;
			}
		}
		return false;
	}

	public  boolean Entrar_Entrenador(String email, String psw) {
		for (Entrenador a : DAO.getInstance().getEntrenador()) {
			if (a.getCorreo().equals(email) && a.getPsw().equals(psw)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public  void RegistrarJugador(String nombre, String apellido, String fecha_nacimiento, String DNI,
			int telefono, String correo, String password) {
		Jugador j = new Jugador(nombre, apellido, fecha_nacimiento, DNI, false, false, telefono, correo, password,false,false);
		DAO.getInstance().guardarObjeto(j);
	}

	public  void RegistrarEntrenador(String nombre, String apellido, String fecha_nacimiento, String DNI,
			int telefono, String correo, String password, boolean asignado) {
		Entrenador e = new Entrenador(nombre, apellido, fecha_nacimiento, DNI, telefono, correo, password, 0, asignado);
		DAO.getInstance().guardarObjeto(e);
	}
	public  void RegistrarEquipo(Equipo e)
	{
		
		e.getInventario().forEach((m,c)->
		{
			int cantidad= m.getCantidad()-c;
			m.setCantidad(cantidad);
			AsignarInventario(m);
		});
		DAO.getInstance().guardarObjeto(e);
	}
	
	public  void RegistrarInventario( Tipo_Material tipo,int cantidad,long precio ) 
	{
		Material m= new Material(tipo, cantidad, precio);
		for(Material mat: ObtenerMaterial())
		{
			if(mat.getTipo().equals(tipo))
			{
				int cant= mat.getCantidad()+cantidad;
				long p= (mat.getPrecio()*mat.getCantidad())+(precio)/cant;
				DAO.getInstance().ModificarMaterial(tipo, cant, p);
				return;
			}
		}
		
		DAO.getInstance().guardarObjeto(m);
	}
	
	public  void AsignarInventario(Material m)
	{
		for(Material mat: ObtenerMaterial())
		{
			if(mat.getTipo().equals(m.getTipo()))
			{
				DAO.getInstance().ModificarMaterial(m.getTipo(), m.getCantidad(), m.getPrecio());
			}
		}
	}

	public  List<Material> ObtenerMaterial()
	{
		return DAO.getInstance().getMaterial();
	}
	
	public  List<Equipo> getEquipos()
	{
		return DAO.getInstance().getEquipo();
	}
	public List<Equipo>getEquiposFilter(Categoria cat)
	{
		return getEquipos().stream().filter(e->e.getCategoria().equals(cat)).collect(Collectors.toList());
	}
	public List<Jugador>getJugador()
	{
		return DAO.getInstance().getJugador();
	}

	public  List<Jugador> MostrarJugadores(Categoria cat)
	{
		int edad=0;
		List<Jugador> ListaJugadores1= new ArrayList<>();
		for (Jugador a : DAO.getInstance().getJugador()) 
		{

			if (!a.isAsignado()) 
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
						if (edad==12||edad==13)ListaJugadores1.add(a);
					}
					if(cat==Categoria.CADETE)
					{
						if (edad==14||edad==15)ListaJugadores1.add(a);	
					}
					if(cat==Categoria.JUVENIL)
					{
						if (edad==16||edad==17||edad==18)ListaJugadores1.add(a);
					}
					if(cat==Categoria.SENIOR)
					{
						if (edad>18)ListaJugadores1.add(a);
					}

			
			}
			
		}
		return ListaJugadores1;
	}
	
	public List<Entrenador> MostrarEntrenadores()
	{
		return DAO.getInstance().getEntrenador();
		
	}
	

	public String ObtenerEquipoEntrenador(Entrenador entrenador)
	{

		for(Equipo e: getEquipos())
		{
			if(e.getEntrenador().equals(entrenador))
				return e.getNombre();
		}
		
		return "No tiene ningun equipo asignado";
	}
	public void ActualizarEntrenador(Entrenador e, long salario)
	{
		DAO.getInstance().ActualizarEntrenador(salario, e);
	}
	public void ActualizarJugador(Jugador e, boolean reconocimiento, boolean lesionado, boolean cuota)
	{
		DAO.getInstance().ActualizarJugador(e, reconocimiento, lesionado, cuota);
	}
	public void ActualizarJugadorEquipo(List<Jugador> lista_Jugadores)
	{
		DAO.getInstance().ActualizarEquipoJugador(lista_Jugadores);
	}
	public String ObtenerEquipoJugador(Jugador jugador)
	{

		for(Equipo e: getEquipos())
		{
			for(Jugador j: e.getLista_jugador())
			{
				if(j.equals(jugador))
				{
					return e.getNombre();
				}
			}
		}
		
		return "No tiene ningun equipo asignado";
	}
	public  List<Jugador> getJugadores(Categoria cat)
	{
		int edad=0;
		List<Jugador> ListaJugadores1= new ArrayList<>();
		for (Jugador a : DAO.getInstance().getJugador()) {
			
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
						if (edad==12||edad==13)ListaJugadores1.add(a);
					}
					if(cat==Categoria.CADETE)
					{
						if (edad==14||edad==15)ListaJugadores1.add(a);	
					}
					if(cat==Categoria.JUVENIL)
					{
						if (edad==16||edad==17||edad==18)ListaJugadores1.add(a);
					}
					if(cat==Categoria.SENIOR)
					{
						if (edad>18)ListaJugadores1.add(a);
					}
				
			
			
		}
		return ListaJugadores1;
	}
	public void ActualizarMaterial(Tipo_Material tipo, int cantidad, long precio)
	{
		DAO.getInstance().ModificarMaterial(tipo, cantidad, precio);
	}
	@SuppressWarnings("rawtypes")
	public void ActualizarEquipo(Equipo equipo, HashMap inventario, List<Jugador> jugadores)
	{
		DAO.getInstance().ActualizarEquipo(equipo, inventario, jugadores);
	}
	
	public List<Partido> getPartidos() throws ParseException{
		List<Partido> lista = Gateway.getInstance().getPartidos();
		HashSet <Equipos_Ext> equipos = Gateway.getInstance().getEquipos();
		for(Equipos_Ext a: equipos)
		{
			System.out.println(a.getCod() + " " +a.getNombre() + " " +a.getCategoria() + " "+ a.getPuntuacion());
		}
		return lista;
	}
	
	public void clasificacion() throws ParseException
	{
		HashSet <Equipos_Ext> equipos = Gateway.getInstance().getEquipos();
		List<Equipos_Ext> list = new ArrayList<Equipos_Ext>(equipos);
		Collections.sort(list, new Comparator<Equipos_Ext>() {
			@Override
			public int compare(Equipos_Ext p1, Equipos_Ext p2) {
				return new Integer((int) p2.getPuntuacion()).compareTo(new Integer((int) p1.getPuntuacion()));
			}

		});
		System.out.println("----------------------------------------------------");
		System.out.println("CLASIFICACION ALEVIN");
		for(Equipos_Ext b: list)
		{
			if(b.getCategoria().toUpperCase().equals("ALEVIN"))
			{
				System.out.println(b.getCod() + " " + b.getNombre() + " " + b.getPuntuacion());
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println("CLASIFICACION CADETE");
		for(Equipos_Ext b: list)
		{
			if(b.getCategoria().toUpperCase().equals("CADETE"))
			{
				System.out.println(b.getCod() + " " + b.getNombre() + " " + b.getPuntuacion());
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println("CLASIFICACION INFANTIL");
		for(Equipos_Ext b: list)
		{

			if(b.getCategoria().toUpperCase().equals("INFANTIL"))
			{
				System.out.println(b.getCod() + " " + b.getNombre() + " " + b.getPuntuacion());
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println("CLASIFICACION SENIOR");
		for(Equipos_Ext b: list)
		{

			if(b.getCategoria().toUpperCase().equals("SENIOR"))
			{
				System.out.println(b.getCod() + " " + b.getNombre() + " " + b.getPuntuacion());
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println("CLASIFICACION JUVENIL");
		for(Equipos_Ext b: list)
		{

			if(b.getCategoria().toUpperCase().equals("JUVENIL"))
			{
				System.out.println(b.getCod() + " " + b.getNombre() + " " + b.getPuntuacion());
			}
		}
		
		
	}
	
	public List<Sancion> getSanciones() throws ParseException{
		List<Sancion> lista = Gateway.getInstance().getSanciones();
		for(Sancion a: lista)
		{
			System.out.println(a.getCodigo() + " " +a.getPersona() + " " +a.getTipo() + " "+ a.getCod_partido());
		}
		return lista;
	}

	public void ModificarMaterial(List<Material> lista_material)
	{
		
	}
	public boolean comprobarDNI (String dni)
	{
		boolean bool;
		if (dni.length() != 9)
		{
			bool = false;
		}
		else{
			bool = true;
		}
		return bool;
	}
}
