package Aprendices_de_Josuka.Aprendices_de_Josuka;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import Aprendices_de_Josuka.LD.*;
import DAO.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class testDAO {

	private Jugador j;
	private Administrador a;
	private Entrenador e;
	
	@Before
	public void inicializar()
	{
		j=new Jugador("Nerea","Solabarrieta","29/11/1998","7777",false, false, 665874596,"nerea@gmail.com","nerea", false, false);
		a= new Administrador("nero@gmail.com","1234");
		e= new Entrenador("inigo","esteban","25/04/1980","8888",654789652,"inigo@gmail.com", "ini",0,false);
	}
	
	
	@Test
	public void escribirJugadores() throws RemoteException
	{
		assertTrue(DAO.getInstance().guardarObjeto(j));
	}
	@Test
	public void escribirAdmin() throws RemoteException
	{
		assertTrue(DAO.getInstance().guardarObjeto(a));
	}
	@Test
	public void escribirEntrenador() throws RemoteException
	{
		assertTrue(DAO.getInstance().guardarObjeto(e));
	}



	@After
	public void eliminar() throws RemoteException
	{
		DAO.getInstance().EliminarAdmin(a);
		DAO.getInstance().EliminarEntrenador(e);
		DAO.getInstance().EliminarJugador(j);
	}

	
}
