package Aprendices_de_Josuka.Aprendices_de_Josuka;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Aprendices_de_Josuka.LD.Administrador;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Jugador;
import DAO.DAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testDAO {

	private Jugador j;
	private Administrador a;
	private Entrenador e;
	
	@Before
	public void inicializar()
	{
		j=new Jugador("Nerea","Solabarrieta","29/11/1998","hg45045",false, false, 665874596,"nerea@gmail.com","nerea", false, false);
		a= new Administrador("maider@gmail.com","4545");
		e= new Entrenador("inigo","esteban","25/04/1980","74uig74",654789652,"inigo@gmail.com", "ini",0,false);
	}
	
	
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250)
	public void a_escribirJugadores() throws RemoteException
	{
		assertTrue(DAO.getInstance().guardarObjeto(j));
	}
	
	@Test
	public void a_escribirAdmin() throws RemoteException
	{
		assertTrue(DAO.getInstance().guardarObjeto(a));
	}
	
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250)
	public void a_escribirEntrenador() throws RemoteException
	{
		assertTrue(DAO.getInstance().guardarObjeto(e));
	}
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250)
	public void leerJugador() throws RemoteException
	{
		boolean esta= false;
		for(Jugador jug: DAO.getInstance().getJugador())
		{
			if(jug.getDNI().equals(j.getDNI()))
			{
				esta=true;
			}
		}
		assertTrue(esta);
	}
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250)
	public void leerAdmin() throws RemoteException
	{
		boolean esta= false;
		for(Administrador ad: DAO.getInstance().getAdmin())
		{
			if(ad.getEmail().equals(a.getEmail()))
			{
				esta=true;
			}
		}
		assertTrue(esta);
	}
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250)
	public void leerEntrenador() throws RemoteException
	{
		boolean esta= false;
		for(Entrenador ent: DAO.getInstance().getEntrenador())
		{
			if(ent.getDNI().equals(e.getDNI()))
			{
				esta=true;
			}
		}
		assertTrue(esta);
	}
	@Test
	public void v_eliminar() throws RemoteException
	{
		assertTrue(DAO.getInstance().EliminarAdmin(a));
		assertTrue(DAO.getInstance().EliminarEntrenador(e));
		assertTrue(DAO.getInstance().EliminarJugador(j));
	}
	

	
}
