package Controller;

import java.rmi.RemoteException;

import Aprendices_de_Josuka.LP.Pantalla_Principal;
import Remote.ServiceLocator;

public class Controller 
{
	private ServiceLocator rsl = null;

	public Controller() throws RemoteException {

		rsl = new ServiceLocator();
		rsl.setService();
		new Pantalla_Principal(this);
	}
	
	public boolean EntrarJugador (String email, String psw) throws RemoteException
	{
		return rsl.getService().EntrarJugador(email, psw);
	}
	public boolean EntrarEntrenador (String email, String psw) throws RemoteException
	{
		return rsl.getService().EntrarEntrenador(email, psw);
	}

}
