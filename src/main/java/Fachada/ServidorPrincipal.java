package Fachada;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Tipo_Material;
import Aprendices_de_Josuka.LN.Gestor;

public class ServidorPrincipal extends UnicastRemoteObject implements itfFachada
{
	private static final long serialVersionUID = 1L;
	private static ServidorPrincipal INSTANCE = null;

	private ServidorPrincipal() throws RemoteException 
	{

	}

	public static ServidorPrincipal getInstance() throws RemoteException {
		synchronized (ServidorPrincipal.class) {
			if (INSTANCE == null) {
				INSTANCE = new ServidorPrincipal();
			}
		}
		return INSTANCE;
	}

	public static void main(String[] args) 
	{	
		String ip = "127.0.0.1";
		String port = "1099";
		String serviceName = "AprendicesDeJosuka";
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
	
	public boolean EntrarJugador(String email, String psw) throws RemoteException
	{
		return Gestor.getInstance().Entrar_Jugador(email, psw);
		
	}
	public boolean EntrarEntrenador(String email, String psw) throws RemoteException
	{
		return Gestor.getInstance().Entrar_Entrenador(email, psw);	
	}
	public boolean EntrarAdministrador (String email, String psw)throws RemoteException
	{
		return Gestor.getInstance().Entrar_admin(email, psw);
	}
	public void RegistrarJugador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw) throws RemoteException
	{
		Gestor.getInstance().RegistrarJugador(nombre, apellido, fecha_S, DNI, telefono, correo, psw);
	}
	public void RegistrarEntrenador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw, boolean isAsignado) throws RemoteException
	{
		Gestor.getInstance().RegistrarEntrenador(nombre, apellido, fecha_S, DNI, telefono, correo, psw,
			isAsignado);
	}
	public List<Jugador> MostrarJugadores(Categoria c) throws RemoteException
	{
		return Gestor.getInstance().MostrarJugadores(c);
	}
	public void RegistrarEquipo(Equipo e) throws RemoteException
	{
		Gestor.getInstance().RegistrarEquipo(e);
	}
	public void ActualizarJugadorEquipo(List<Jugador> lista_Jugadores) throws RemoteException
	{
		Gestor.getInstance().ActualizarJugadorEquipo(lista_Jugadores);
	}
	public List<Entrenador> getEntrenador() throws RemoteException
	{
		return Gestor.getInstance().getEntrenador();
	}
	public List<Equipo> getEquipos() throws RemoteException
	{
		return Gestor.getInstance().getEquipos();
	}
	public void RegistrarInventario(Tipo_Material mat, int cantidad, long precio ) throws RemoteException
	{
		Gestor.getInstance().RegistrarInventario(mat, cantidad, precio);
	}
}
