package Aprendices_de_Josuka.Aprendices_de_Josuka;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Fachada.itfFachada;
import Aprendices_de_Josuka.LP.IniciarSesion;
import Controller.Controller;
import Fachada.ServidorPrincipal;

public class testConexion 
{
//		private Controller c;
//	   @BeforeClass
//	    public static void setupClass() throws RemoteException, AlreadyBoundException  
//	   {
//		   FailOnThreadViolationRepaintManager.install();
//
//	        Registry registry = LocateRegistry.createRegistry(1099);
//	        registry.bind("ADJ", ServidorPrincipal.getInstance());
//	    }
//	   
//	   @Test
//	    public void EntrarJugador() throws RemoteException, AlreadyBoundException, NotBoundException 
//	   {
//		   Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
//		   c=(Controller) registry.lookup("ADJ");
//		   IniciarSesion cliente = new IniciarSesion (c);
//		   
//	       Assert.assertEquals(12,cliente);
//	    }
//	

}
