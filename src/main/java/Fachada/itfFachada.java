package Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Equipos_Ext;
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
	public boolean RegistrarEntrenador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw) throws RemoteException;
	public boolean RegistrarEquipo(Equipo e) throws RemoteException;
	public boolean RegistrarInventario(Tipo_Material mat, int cantidad, long precio ) throws RemoteException;
	public List<Jugador>getJugador() throws RemoteException;
	public List<Jugador> MostrarJugadores(Categoria c) throws RemoteException;
	public List<Entrenador> getEntrenador() throws RemoteException;
	public List<Equipo> getEquipos() throws RemoteException;
	public List<Equipo>getEquiposFilter(Categoria cat) throws RemoteException;
	public  List<Material> getMaterial() throws RemoteException;
	public String ObtenerEquipoEntrenador(Entrenador entrenador)throws RemoteException;
	public int getEdad(String date)throws RemoteException;
	public String ObtenerEquipoJugador(Jugador jugador)throws RemoteException;
	public boolean ActualizarJugador(Jugador e, boolean reconocimiento, boolean lesionado, boolean cuota) throws RemoteException;
	public boolean ActualizarEntrenador(Entrenador e, long salario) throws RemoteException;
	public void ActualizarJugadorEquipo(List<Jugador> lista_Jugadores) throws RemoteException;
	public void ActualizarEquipo(Equipo equipo, HashMap inventario, List<Jugador> jugadores) throws RemoteException;
	public void ActualizarMaterial(Tipo_Material tipo, int cantidad, long precio)throws RemoteException;
	public void ModificarMaterial(List<Material> lista_material)throws RemoteException;;
	public  void AsignarInventario(Material m) throws RemoteException;
	public List <Equipos_Ext> clasificacion (Categoria cat)throws RemoteException, org.json.simple.parser.ParseException;
}
