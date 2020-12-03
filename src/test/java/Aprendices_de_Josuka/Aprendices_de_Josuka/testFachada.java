package Aprendices_de_Josuka.Aprendices_de_Josuka;

import static org.junit.Assert.*;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import Aprendices_de_Josuka.LD.Administrador;
import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import DAO.DAO;
import Fachada.ServidorPrincipal;
import Fachada.itfFachada;
@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFachada {
	
	private Jugador j;
	private Entrenador e;
	private Administrador a;
	private itfFachada fachada;
	private static String name = "//127.0.0.1:1099/ADJ";
	private Equipo equipo;
	@Mock
	List<Jugador> jugadores;
	@Mock
	Entrenador entrenador;
	@Mock
	HashMap<Material,Integer> inventario;
	
	   @BeforeClass
	    public static void setupClass() throws RemoteException, AlreadyBoundException {
		   	Registry registry = LocateRegistry.createRegistry((Integer.valueOf(1099)));
			registry.rebind(name, ServidorPrincipal.getInstance());

	    }
	   @Before
	    public void setup()  {
			j=new Jugador("Nerea","Solabarrieta","29/11/1998","74000000",false, false, 665874596,"nerea@gmail.com","nerea", false, false);
			a= new Administrador("c@gmail.com","4545");
			e= new Entrenador("inigo","esteban","25/04/1980","609000000",654789652,"inigo@gmail.com", "ini",0,false);
			equipo = new Equipo("Antiguoko", Categoria.ALEVIN,entrenador,jugadores,inventario);
	   }
	    @Test
	    public void a_jugador() throws RemoteException, AlreadyBoundException, NotBoundException {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
	        assertTrue(fachada.RegistrarJugador(j.getNombre(),j.getApellido(), j.getFecha_nacimiento(), j.getDNI(), j.getTelefono(), j.getCorreo(), j.getPsw()));
	    }
	    @Test
	    public void entrarJugador() throws RemoteException, AlreadyBoundException, NotBoundException
	    {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
	        assertTrue(fachada.EntrarJugador(j.getCorreo(), j.getPsw()));
	    }
		@Test
		public void v_eliminar() throws RemoteException
		{
			assertTrue(DAO.getInstance().EliminarJugador(j));

		}
		@Test
		public void getEdad() throws RemoteException, NotBoundException,AlreadyBoundException
		{
			Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
			assertEquals(fachada.getEdad("29/11/1998"), 22);

		}
		
	    @Test
	    public void a_admin()  {
	        assertTrue(DAO.getInstance().guardarObjeto(a));
	    }
	    @Test
	    public void entrarAdministrador() throws RemoteException, AlreadyBoundException, NotBoundException
	    {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
//	        assertTrue(fachada.EntrarAdministrador(a.getEmail(), a.getPsw()));
	    }
		@Test
		public void v_eliminarAdmin() throws RemoteException
		{
			assertTrue(DAO.getInstance().EliminarAdmin(a));

		}
		
	    @Test
	    public void a_entrenador() throws RemoteException, AlreadyBoundException, NotBoundException {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
	        assertTrue(fachada.RegistrarEntrenador(e.getNombre(),e.getApellido(), e.getFecha_nacimiento(), e.getDNI(), e.getTelefono(), e.getCorreo(), e.getPsw()));
	    }
	    @Test
	    public void entrarEntrenador() throws RemoteException, AlreadyBoundException, NotBoundException
	    {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
	        assertTrue(fachada.EntrarEntrenador(e.getCorreo(), e.getPsw()));
	    }
		@Test
		public void v_eliminarEntrenador() throws RemoteException
		{
			assertTrue(DAO.getInstance().EliminarEntrenador(e));

		}
		
		@Test
	    public void a_equipo() throws RemoteException, AlreadyBoundException, NotBoundException {
//	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
//			fachada = (itfFachada) registry.lookup(name);
//	        assertTrue(fachada.RegistrarEquipo(equipo));
//	        assertTrue(DAO.getInstance().guardarObjeto(equipo));
	    }


}
