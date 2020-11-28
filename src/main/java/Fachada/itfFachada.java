package Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface itfFachada extends Remote
{
	public boolean EntrarJugador(String email, String psw) throws RemoteException;
	public boolean EntrarEntrenador(String email, String psw) throws RemoteException;
}
