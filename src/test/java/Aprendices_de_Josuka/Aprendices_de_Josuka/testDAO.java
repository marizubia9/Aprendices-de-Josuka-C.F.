package Aprendices_de_Josuka.Aprendices_de_Josuka;

import static org.junit.Assert.*;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Aprendices_de_Josuka.LD.Administrador;
import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LD.Tipo_Material;
import DAO.DAO;
import Fachada.ServidorPrincipal;
import Fachada.itfFachada;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testDAO {

	private Jugador j;
	private Administrador a;
	private Entrenador e;
	private itfFachada fachada;
	private static String name = "//127.0.0.1:1099/ADJ";
	private Equipo eq;
	private Material m;
	
	  @BeforeClass
	    public static void setupClass() throws RemoteException, AlreadyBoundException {
		   	Registry registry = LocateRegistry.createRegistry((Integer.valueOf(1099)));
			registry.rebind(name, ServidorPrincipal.getInstance());

	    }
	
	@Before
	public void inicializar()
	{
		j=new Jugador("Nerea","Solabarrieta","29/11/1998","742839990",false, false, 665874596,"nerea@gmail.com","nerea", false, false);
		a= new Administrador("culis@gmail.com","4545");
		e= new Entrenador("inigo","esteban","25/04/1980","609100000",654789652,"inigo@gmail.com", "ini",0,false);
		List<Jugador> lista = new ArrayList<Jugador>();
		lista.add(j);
		m= new Material(Tipo_Material.Barreras,23,23);
//		HashMap<Material, Integer> hm = new HashMap<Material,Integer>();
//		hm.put(m, 2);
//		eq= new Equipo("ardoi",Categoria.ALEVIN,null,null,null);
	}
	
	
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250)
	public void a_escribirJugadores() throws RemoteException, NotBoundException
	{
		assertTrue(DAO.getInstance().guardarObjeto(j));
		Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
		fachada = (itfFachada) registry.lookup(name);
		assertTrue(fachada.EntrarJugador(j.getCorreo(),j.getPsw()));
	}
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250)
	public void a_escribirMaterial() throws RemoteException
	{
		assertTrue(DAO.getInstance().guardarObjeto(m));
	}
	
//	@Test
//	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
//	@Required ( max = 1200, average = 250)
//	public void a_escribirEquipo() throws RemoteException
//	{
//		assertTrue(DAO.getInstance().guardarObjeto(eq));
//	}
		
	@Test
	public void a_escribirAdmin() throws RemoteException, NotBoundException
	{
		assertTrue(DAO.getInstance().guardarObjeto(a));
		Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
		fachada = (itfFachada) registry.lookup(name);
		assertTrue(fachada.EntrarAdministrador(a.getEmail(), a.getPsw()));

	}
	
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250)
	public void a_escribirEntrenador() throws RemoteException, NotBoundException
	{
		assertTrue(DAO.getInstance().guardarObjeto(e));
		Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
		fachada = (itfFachada) registry.lookup(name);
		assertTrue(fachada.EntrarEntrenador(e.getCorreo(), e.getPsw()));
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
	
//	@Test
//	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
//	@Required ( max = 1200, average = 250)
//	public void leerEquipo() throws RemoteException
//	{
//		boolean esta= false;
//		for(Equipo e: DAO.getInstance().getEquipo())
//		{
//			if(e.getNombre().equals(eq.getNombre()))
//			{
//				esta=true;
//			}
//		}
//		assertTrue(esta);
//	}
	
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250)
	public void leerMaterial() throws RemoteException
	{
		boolean esta= false;
		for(Material mat: DAO.getInstance().getMaterial())
		{
			if(mat.getTipo().equals(m.getTipo()))
			{
				esta=true;
			}
		}
		assertTrue(esta);
	}
	
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250)
	public void modificarEntrenador() throws RemoteException, AlreadyBoundException, NotBoundException
	{
		long salario = 200;
		Entrenador entMod = null;
		Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
		fachada = (itfFachada) registry.lookup(name);
		fachada.ActualizarEntrenador(e, salario);
//		DAO.getInstance().ActualizarEntrenador(salario, e);
		for(Entrenador entre:fachada.getEntrenador())
		{
			if(entre.getDNI().equals(e.getDNI()))
			{
				 entMod=entre;
			}
		}
		assertNotEquals(entMod.getSalario(), e.getSalario());
		
	}
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250)
	public void modificarJugador() throws RemoteException, AlreadyBoundException, NotBoundException
	{
		Jugador jugMod = null;
		Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
		fachada = (itfFachada) registry.lookup(name);
		fachada.ActualizarJugador(j, false, false, true);
		for(Jugador jug:fachada.getJugador())
		{
			if(jug.getDNI().equals(j.getDNI()))
			{
				 jugMod=jug;
				 jug.isAsignado();
			}
		}
		assertNotEquals(jugMod.isCuota_pagada(), j.isCuota_pagada());
		
	}

	@Test
	public void v_eliminar() throws RemoteException
	{
		assertTrue(DAO.getInstance().EliminarAdmin(a));
		assertTrue(DAO.getInstance().EliminarEntrenador(e));
		assertTrue(DAO.getInstance().EliminarJugador(j));
		assertTrue(DAO.getInstance().EliminarMaterial(m));
//		assertTrue(DAO.getInstance().EliminarEquipo(eq));
	}
	

	
}
