package Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Tipo_Material;
import Aprendices_de_Josuka.LN.Gestor;

public interface itfFachada extends Remote
{
	public boolean EntrarJugador(String email, String psw) throws RemoteException;
	public boolean EntrarEntrenador(String email, String psw) throws RemoteException;
	public boolean EntrarAdministrador(String email, String psw) throws RemoteException;
	public void RegistrarJugador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw) throws RemoteException;
	public void RegistrarEntrenador (String nombre, String apellido, String fecha_S, String DNI, int telefono, String correo, String psw, boolean isAsignado) throws RemoteException;
	public List<Jugador> MostrarJugadores(Categoria c) throws RemoteException;
	public void RegistrarEquipo(Equipo e) throws RemoteException;
	public void ActualizarJugadorEquipo(List<Jugador> lista_Jugadores) throws RemoteException;
	public List<Entrenador> getEntrenador() throws RemoteException;
	public void RegistrarInventario(Tipo_Material mat, int cantidad, long precio ) throws RemoteException;
	public List<Equipo> getEquipos() throws RemoteException;
}
