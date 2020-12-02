package Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LD.Tipo_Material;
import Aprendices_de_Josuka.LN.Gestor;

public interface itfFachada extends Remote
{
	public boolean EntrarJugador(String email, String psw) throws RemoteException;
	public boolean EntrarEntrenador(String email, String psw) throws RemoteException;
	public boolean EntrarAdministrador(String email, String psw) throws RemoteException;
	public boolean RegistrarJugador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw) throws RemoteException;
	public void RegistrarEntrenador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw) throws RemoteException;
	public void RegistrarEquipo(Equipo e) throws RemoteException;
	public void RegistrarInventario(Tipo_Material mat, int cantidad, long precio ) throws RemoteException;
	public List<Jugador>getJugador() throws RemoteException;
	public List<Jugador> MostrarJugadores(Categoria c) throws RemoteException;
	public List<Entrenador> getEntrenador() throws RemoteException;
	public List<Equipo> getEquipos() throws RemoteException;
	public List<Equipo>getEquiposFilter(Categoria cat) throws RemoteException;
	public  List<Material> getMaterial() throws RemoteException;
	public String ObtenerEquipoEntrenador(Entrenador entrenador)throws RemoteException;
	public String ObtenerEquipoJugador(Jugador jugador)throws RemoteException;
	public void ActualizarJugador(Jugador e, boolean reconocimiento, boolean lesionado, boolean cuota) throws RemoteException;
	public void ActualizarEntrenador(Entrenador e, long salario) throws RemoteException;
	public void ActualizarJugadorEquipo(List<Jugador> lista_Jugadores) throws RemoteException;
	public void ActualizarEquipo(Equipo equipo, HashMap inventario, List<Jugador> jugadores) throws RemoteException;
	public void ActualizarMaterial(Tipo_Material tipo, int cantidad, long precio)throws RemoteException;
	public void ModificarMaterial(List<Material> lista_material)throws RemoteException;;
	public  void AsignarInventario(Material m) throws RemoteException;
}
