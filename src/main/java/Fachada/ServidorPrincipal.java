package Fachada;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import DAO.DAO;
import Aprendices_de_Josuka.LD.Administrador;
import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
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
			System.out.println("2");
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
			 else return false;
		}
		return false;
	}

	public boolean EntrarEntrenador(String email, String psw) throws RemoteException {
		for (Entrenador a : DAO.getInstance().getEntrenador()) {
			if (a.getCorreo().equals(email) && a.getPsw().equals(psw))return true;
			else return false;
		}
		return false;
	}

	public  boolean EntrarAdministrador(String email, String psw) throws RemoteException {
		for (Administrador a : DAO.getInstance().getAdmin()) {
			if (a.getEmail().equals(email) && a.getPsw().equals(psw)) return true;
			 else return false;
			}
		return false;
	}


	public boolean RegistrarJugador(String nombre, String apellido, String fecha_S, String DNI, int telefono,
			String correo, String psw) throws RemoteException {
		return DAO.getInstance().guardarObjeto(new Jugador(nombre, apellido, fecha_S, DNI, false, false, telefono, correo, psw,false,false));
	}

	public void RegistrarEntrenador(String nombre, String apellido, String fecha_S, String DNI, int telefono,
			String correo, String psw) throws RemoteException {
		DAO.getInstance().guardarObjeto(new Entrenador(nombre, apellido, fecha_S, DNI, telefono, correo, psw, 0, false));
	}

	public void RegistrarEquipo(Equipo e) throws RemoteException {
		e.getInventario().forEach((m,c)->
		{
			int cantidad= m.getCantidad()-c;
			m.setCantidad(cantidad);
			try {
				AsignarInventario(m);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		});
		DAO.getInstance().guardarObjeto(e);
	}

	public void RegistrarInventario(Tipo_Material tipo, int cantidad, long precio) throws RemoteException {
		for(Material m: getMaterial())
		{
			if(m.getTipo().equals(tipo))
			{
				int cant= m.getCantidad()+cantidad;
				long p= (m.getPrecio()*m.getCantidad())+(precio)/cant;
				DAO.getInstance().ModificarMaterial(tipo, cant, p);
				return;
			}
		}
		
		DAO.getInstance().guardarObjeto(new Material(tipo, cantidad, precio));
	}

	public  void AsignarInventario(Material m) throws RemoteException
	{
		DAO.getInstance().ModificarMaterial(m.getTipo(), m.getCantidad(), m.getPrecio());
	}
	public List<Jugador>getJugador() throws RemoteException
	{
		return DAO.getInstance().getJugador();
	}
	public List<Jugador> MostrarJugadores(Categoria c)throws RemoteException {
		int edad=0;
		List<Jugador> ListaJugadores1= new ArrayList<>();
		for (Jugador a : DAO.getInstance().getJugador()) {
			edad=getEdad(a.getFecha_nacimiento());
			
					if(c==Categoria.ALEVIN){
						if (edad==10||edad==11)ListaJugadores1.add(a);						
					}
					if(c==Categoria.INFANTIL){
						if (edad==12||edad==13)ListaJugadores1.add(a);
					}
					if(c==Categoria.CADETE){
						if (edad==14||edad==15)ListaJugadores1.add(a);	
					}
					if(c==Categoria.JUVENIL){
						if (edad==16||edad==17||edad==18)ListaJugadores1.add(a);
					}
					if(c==Categoria.SENIOR){
						if (edad>18)ListaJugadores1.add(a);
					}
		}
		return ListaJugadores1;
	}
	public int getEdad(String date)
	{
		StringTokenizer st= new StringTokenizer(date,"/");
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
		 return (anyo_actual-anyo);
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
	public void ActualizarJugador(Jugador e, boolean reconocimiento, boolean lesionado, boolean cuota) throws RemoteException
	{
		DAO.getInstance().ActualizarJugador(e, reconocimiento, lesionado, cuota);
	}
	public void ActualizarEntrenador(Entrenador e, long salario) throws RemoteException
	{
		DAO.getInstance().ActualizarEntrenador(salario, e);
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
}
