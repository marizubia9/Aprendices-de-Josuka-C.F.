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

	

	public  boolean Entrar_admin(String email, String psw) throws RemoteException {
		for (Administrador a : DAO.getInstance().getAdmin()) {
			if (a.getEmail().equals(email) && a.getPsw().equals(psw)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}








	

	


	
	




	public  List<Jugador> MostrarJugadores(Categoria cat) throws NumberFormatException, RemoteException
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


	
	
	
	

	@SuppressWarnings("rawtypes")
	
	
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
