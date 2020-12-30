package Fachada;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.json.simple.parser.ParseException;

import DAO.DAO;
import Gateway.Gateway;
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
import Aprendices_de_Josuka.LN.Gestor;

public class ServidorPrincipal extends UnicastRemoteObject implements itfFachada {
	private static final long serialVersionUID = 1L;
	private static ServidorPrincipal INSTANCE = null;

	private ServidorPrincipal() throws RemoteException {

	}

	public static ServidorPrincipal getInstance() throws RemoteException {
		synchronized (ServidorPrincipal.class) {
			if (INSTANCE == null) {
				INSTANCE = new ServidorPrincipal();
			}
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		String ip = "127.0.0.1";
		String port = "1099";
		String serviceName = "Aprendices-de-Josuka";
		itfFachada objServer = null;
		try {
			objServer = ServidorPrincipal.getInstance();
		
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + ip + ":" + port + "/" + serviceName;

		try {
			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(port)));
			registry.rebind(name, objServer);
			System.out.println("* Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public boolean EntrarJugador(String email, String psw) throws RemoteException {
		for (Jugador a : DAO.getInstance().getJugador()) {
			if (a.getCorreo().equals(email) && a.getPsw().equals(psw)) return true;
			 
		}
		return false;
	}

	public boolean EntrarEntrenador(String email, String psw) throws RemoteException {
		for (Entrenador a : DAO.getInstance().getEntrenador()) {
			if (a.getCorreo().equals(email) && a.getPsw().equals(psw))return true;
		}
		return false;
	}

	public  boolean EntrarAdministrador(String email, String psw) throws RemoteException {
		for (Administrador a : DAO.getInstance().getAdmin()) {
			if (a.getEmail().equals(email) && a.getPsw().equals(psw)) return true;
		
			}
		return false;
	}


	public boolean RegistrarJugador(String nombre, String apellido, String fecha_S, String DNI, int telefono,
			String correo, String psw) throws RemoteException {
		return DAO.getInstance().guardarObjeto(new Jugador(nombre, apellido, fecha_S, DNI, false, false, telefono, correo, psw,false,false));
	}

	public boolean RegistrarEntrenador(String nombre, String apellido, String fecha_S, String DNI, int telefono,
			String correo, String psw) throws RemoteException {
		return DAO.getInstance().guardarObjeto(new Entrenador(nombre, apellido, fecha_S, DNI, telefono, correo, psw, 0, false));
	}
	
	public boolean modificarCorreo(Jugador j, String correo, String psw) throws RemoteException {
		return DAO.getInstance().modificarCorreo(j, correo, psw);
	}
	
	public boolean RegistrarAdmin(String correo, String psw) throws RemoteException {
		return DAO.getInstance().guardarObjeto(new Administrador(correo, psw));
	}
	public List<Partido> getPartidos() throws ParseException, RemoteException
	{
		return Gateway.getInstance().search_partidos();
	}
//	public boolean RegistrarEquipo(Equipo e) throws RemoteException {
//		e.getInventario().forEach((m,c)->
//		{
//			int cantidad= m.getCantidad()-c;
//			m.setCantidad(cantidad);
//			try {
//				AsignarInventario(m);
//			} catch (RemoteException e1) {
//				e1.printStackTrace();
//			}
//		});
//		return DAO.getInstance().guardarObjeto(e);
//	}
	public boolean RegistrarEquipo2(String nombre, Categoria cat, Entrenador entrenador, List<Jugador>lista_Jugadores, HashMap<Material, Integer> inventario)throws RemoteException
	{
		inventario.forEach((m,c)->
		{
			int cantidad= m.getCantidad()-c;
			m.setCantidad(cantidad);
			try {
				AsignarInventario(m);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		});
		return DAO.getInstance().guardarObjeto(new Equipo (nombre, cat, entrenador, lista_Jugadores, inventario));
	}

	public boolean RegistrarInventario(Tipo_Material tipo, int cantidad, long precio) throws RemoteException {
		for(Material m: getMaterial())
		{
			if(m.getTipo().equals(tipo))
			{
				int cant= m.getCantidad()+cantidad;
				long p= (m.getPrecio()*m.getCantidad())+(precio)/cant;
				return DAO.getInstance().ModificarMaterial(tipo, cant, p);
				
			}
		}
		
		return DAO.getInstance().guardarObjeto(new Material(tipo, cantidad, precio));
	}

	public  void AsignarInventario(Material m) throws RemoteException
	{
		DAO.getInstance().ModificarMaterial(m.getTipo(), m.getCantidad(), m.getPrecio());
	}
	public List<Jugador>getJugador() throws RemoteException
	{
		return DAO.getInstance().getJugador();
	}
	public int partidosGanados(String DNI) throws RemoteException, ParseException
	{
		int i=0;
		Equipo equipo = null;
		for (Equipo e:DAO.getInstance().getEquipo())
		{
			for (Jugador j:e.getLista_jugador())
			{
				if (j.getDNI().equals(DNI))
				{
					equipo = e;
				}
			}
		}
		for (Partido p :Gateway.getInstance().search_partidos())
		{
			if(p.getEquipo_1().getNombre().toUpperCase().equals(equipo.getNombre().toUpperCase()))
			{
				if(p.getResultado_e1() > p.getResultado_e2())
				{
					i++;
				}
			}
			else if(p.getEquipo_2().getNombre().toUpperCase().equals(equipo.getNombre().toUpperCase()))
			{
				if(p.getResultado_e1() < p.getResultado_e2())
				{
					i++;
				}
			}
		}
		
		return i;
	}
	public List<Sancion> sancionesJugador(String DNI) throws RemoteException, ParseException
	{
		List <Sancion> sanciones = new ArrayList<Sancion>();
	
		for (Sancion s:Gateway.getInstance().search_sanciones())
		{
			if(s.getPersona().equals(DNI))
			{
				sanciones.add(s);
			}
			
		}
		return sanciones;
	}
	public Jugador getJug(String correo, String psw) throws RemoteException
	{
		Jugador j = null;
		for (Jugador a: DAO.getInstance().getJugador())
		{
			if(a.getCorreo().equals(correo))
			{
				if(a.getPsw().equals(psw))
			{
				j = new Jugador(a.getNombre(),a.getApellido(), a.getFecha_nacimiento(), a.getDNI(), a.isReconocimiento_medico(), a.isLesionado(), a.getTelefono(), a.getCorreo(), a.getPsw(), a.isCuota_pagada(), a.isAsignado() );
			}
			}
		}
		return j;	
		
	}
	public Entrenador getEnt(String correo, String psw) throws RemoteException
	{
		Entrenador j = null;
		for (Entrenador a: DAO.getInstance().getEntrenador())
		{
			if(a.getCorreo().equals(correo))
			{
				if(a.getPsw().equals(psw))
			{
				j = new Entrenador(a.getNombre(),a.getApellido(), a.getFecha_nacimiento(), a.getDNI(), a.getTelefono(), a.getCorreo(), a.getPsw(), a.getSalario(), a.isAsignado_equipo() );
			}
			}
		}
		return j;	
		
	}
	public List<Jugador> MostrarJugadores(Categoria c)throws RemoteException {
		int edad=0;
		List<Jugador> ListaJugadores1= new ArrayList<>();
		for (Jugador a : DAO.getInstance().getJugador()) {
			edad=getEdad(a.getFecha_nacimiento());
			
					if(c.equals(Categoria.ALEVIN)){
						if (edad==10||edad==11)ListaJugadores1.add(a);						
					}
					if(c.equals(Categoria.INFANTIL)){
						if (edad==12||edad==13)ListaJugadores1.add(a);
					}
					if(c.equals(Categoria.CADETE)){
						if (edad==14||edad==15)ListaJugadores1.add(a);	
					}
					if(c.equals(Categoria.JUVENIL)){
						if (edad==16||edad==17||edad==18)ListaJugadores1.add(a);
					}
					if(c.equals(Categoria.SENIOR)){
						if (edad>18)ListaJugadores1.add(a);
					}
		}
		return ListaJugadores1;
	}
	public int getEdad(String date)
	{
		StringTokenizer st= new StringTokenizer(date,"-");
		Integer[] fecha=new Integer[3];
		int i=0;
		while(st.hasMoreTokens()){
            String str=st.nextToken();
            fecha[i]=Integer.valueOf(str).intValue();
            i++;
        }
		int anyo=fecha[0];
		Calendar cal = Calendar.getInstance();
		int anyo_actual=cal.get(Calendar.YEAR);

		 return (anyo_actual-anyo);
	}
	public Partido sancionPartido(String codPartido) throws ParseException, RemoteException
	{
		Partido p = null;
		List <Partido> partidos = Gateway.getInstance().search_partidos();
		for(Partido partido: partidos)
		{
			if(partido.getCod_partido().equals(codPartido))
			{
				return p;
			}
		}
		return null;
		
	}

	public List<Entrenador> getEntrenador() throws RemoteException {
		return DAO.getInstance().getEntrenador();
	}

	public List<Equipo> getEquipos() throws RemoteException {
		return DAO.getInstance().getEquipo();
	}
	public List<Equipo>getEquiposFilter(Categoria cat) throws RemoteException
	{
		return getEquipos().stream().filter(e->e.getCategoria().equals(cat)).collect(Collectors.toList());
	}
	public  List<Material> getMaterial() throws RemoteException
	{
		return DAO.getInstance().getMaterial();
	}
	public boolean ActualizarJugador(Jugador e, boolean reconocimiento, boolean lesionado, boolean cuota) throws RemoteException
	{
		return DAO.getInstance().ActualizarJugador(e, reconocimiento, lesionado, cuota);
	}
	public boolean ActualizarEntrenador(Entrenador e, long salario) throws RemoteException
	{
		return DAO.getInstance().ActualizarEntrenador(salario, e);
	}
	public void ActualizarJugadorEquipo(List<Jugador> lista_Jugadores)throws RemoteException
	{
		DAO.getInstance().ActualizarEquipoJugador(lista_Jugadores);
	}
	public void ActualizarEquipo(Equipo equipo, HashMap inventario, List<Jugador> jugadores) throws RemoteException
	{
		DAO.getInstance().ActualizarEquipo(equipo, inventario, jugadores);
	}
	public void ActualizarMaterial(Tipo_Material tipo, int cantidad, long precio)throws RemoteException
	{
		DAO.getInstance().ModificarMaterial(tipo, cantidad, precio);
	}
	public String ObtenerEquipoEntrenador(Entrenador entrenador)throws RemoteException
	{
		for(Equipo e: getEquipos()){
			if(e.getEntrenador().equals(entrenador))return e.getNombre();
		}
		return "No tiene ningun equipo asignado";
	}
	public String ObtenerEquipoJugador(Jugador jugador)throws RemoteException
	{
		for(Equipo e: getEquipos()){
			for(Jugador j: e.getLista_jugador()){
				if(j.equals(jugador))return e.getNombre();
			}
		}
		return "No tiene ningun equipo asignado";
	}

	public void ModificarMaterial(List<Material> lista_material) throws RemoteException {
		
		
	}
	public List<Equipos_Ext> clasificacion(Categoria cat) throws ParseException
	{
		HashSet<Equipos_Ext> equipos = Gateway.getInstance().getEquipos();
		List<Equipos_Ext> list = new ArrayList<Equipos_Ext>(equipos);
		List<Equipos_Ext> listaClasificacion = new ArrayList<Equipos_Ext>();
		Collections.sort(list, new Comparator<Equipos_Ext>() {
			@Override
			public int compare(Equipos_Ext p1, Equipos_Ext p2) {
				return new Integer((int) p2.getPuntuacion()).compareTo(new Integer((int) p1.getPuntuacion()));
			}

		});

		for (Equipos_Ext b : list) {
			if (b.getCategoria().toUpperCase().equals(cat.name())) {
				listaClasificacion.add(b);
			}
		}
		return listaClasificacion;
	}


	
}
