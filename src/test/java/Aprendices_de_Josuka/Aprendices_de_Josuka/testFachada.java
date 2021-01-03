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

import org.json.simple.parser.ParseException;
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
import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LD.Sancion;
import Aprendices_de_Josuka.LD.Tipo_Material;
import DAO.DAO;
import Fachada.ServidorPrincipal;
import Fachada.itfFachada;
/**
 * @class testFachada
 * @brief Clase donde se hara el testeo de la fachada (gestor)
 * @author Alumno
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFachada {
	
	private Jugador j;
	private Entrenador e;
	private Administrador a;
	private itfFachada fachada;
	private static String name = "//127.0.0.1:1099/ADJ";
	private Equipo equipo;
	private List<String> jugadores;
	private Material m;
	private	HashMap<String,Integer> inventario;
		/**
		 * Método que permite establecer la conexión con el servidor
		 * @throws RemoteException
		 * @throws AlreadyBoundException
		 */
	   @BeforeClass
	    public static void setupClass() throws RemoteException, AlreadyBoundException {
		   	Registry registry = LocateRegistry.createRegistry((Integer.valueOf(1099)));
			registry.rebind(name, ServidorPrincipal.getInstance());

	    }
	   /**
	    * Inicializa los objetos
	    */
	   @Before
	    public void setup()  {
			j=new Jugador("Nerea","Solabarrieta","29/11/1998","74000000",false, false, 665874596,"nerea@gmail.com","nerea", false, false);
			a= new Administrador("c@gmail.com","4545");
			e= new Entrenador("inigo","esteban","25/04/1980","609000000",654789652,"inigo@gmail.com", "ini",0,false);
			m = new Material(Tipo_Material.Petos, 2,3);
			jugadores = new ArrayList <String>();
			jugadores.add("74000000");
			inventario = new HashMap<String, Integer>();
			inventario.put(m.getTipo().name(), 3);
			equipo = new Equipo("Antiguoko", Categoria.ALEVIN,"609000000",jugadores,inventario);
	   }
	   /**
	    * Hace pruebas con los partidos del servicio externo
	    * @throws ParseException
	    * @throws RemoteException
	    * @throws NotBoundException
	    */
	   @Test
		public void partidos() throws ParseException, RemoteException, NotBoundException
		{
		   Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
		   fachada = (itfFachada) registry.lookup(name);
		   List <Equipos_Ext> equipos = fachada.clasificacion(Categoria.ALEVIN);
		   assertEquals(equipos.get(0).getNombre(), "Zumaiako");
		   assertEquals(fachada.getRanking("123123123"),1);
		   assertEquals(fachada.partidosGanados("123123123"),2);
		  
			
		}
	   /**
	    * Testea el registro de nuevo material
	    * @throws RemoteException
	    * @throws NotBoundException
	    */
	   @Test
	   public void material() throws RemoteException, NotBoundException
	   {
		   Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
		   fachada = (itfFachada) registry.lookup(name);
		   assertTrue(fachada.RegistrarInventario(m.getTipo(), 5, 5));
		   
	   }
	   /**
	    * Hace pruebas con las sanciones del servicio externo
	    * @throws ParseException
	    * @throws RemoteException
	    * @throws NotBoundException
	    */
		@Test
		public void sanciones() throws ParseException, RemoteException, NotBoundException
		{
			Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
			List <Sancion> sanciones = fachada.sancionesPersona("123123123");
			assertEquals(sanciones.size(), 1);
		}
		/**
		 * Simula el registro de un jugador
		 * @throws RemoteException
		 * @throws AlreadyBoundException
		 * @throws NotBoundException
		 */
	    @Test
	    public void a_jugador() throws RemoteException, AlreadyBoundException, NotBoundException {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
	        assertTrue(fachada.RegistrarJugador(j.getNombre(),j.getApellido(), j.getFecha_nacimiento(), j.getDNI(), j.getTelefono(), j.getCorreo(), j.getPsw()));
	    }
	    /**
	     * Prueba si el jugador creado puede entrar bien a la aplicación
	     * @throws RemoteException
	     * @throws AlreadyBoundException
	     * @throws NotBoundException
	     */
	    @Test
	    public void entrarJugador() throws RemoteException, AlreadyBoundException, NotBoundException
	    {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
	        assertTrue(fachada.EntrarJugador(j.getCorreo(), j.getPsw()));
	        assertEquals(fachada.getJug(j.getCorreo(), j.getPsw()).getNombre(), j.getNombre());
	    }
	    /**
	     * Elimina el jugador de la base de datos
	     * @throws RemoteException
	     */
		@Test
		public void v_eliminar() throws RemoteException
		{
			assertTrue(DAO.getInstance().EliminarJugador(j));

		}
		/**
		 * Comprueba que el método devuelva la edad correctamente
		 * @throws RemoteException
		 * @throws NotBoundException
		 * @throws AlreadyBoundException
		 */
		@Test
		public void getEdad() throws RemoteException, NotBoundException,AlreadyBoundException
		{
			Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
			assertEquals(fachada.getEdad("1998-11-29"), 23);

		}
		/**
		 * Registra un administrador
		 * @throws RemoteException
		 * @throws NotBoundException
		 */
		
	    @Test
	    public void a_admin() throws RemoteException, NotBoundException  {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
	        assertTrue(fachada.RegistrarAdmin(a.getEmail(), a.getPsw()));
	    }
	    /**
	     * Simula la entrada del admin registrado en la aplicación
	     * @throws RemoteException
	     * @throws AlreadyBoundException
	     * @throws NotBoundException
	     */
	    @Test
	    public void entrarAdministrador() throws RemoteException, AlreadyBoundException, NotBoundException
	    {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
	        assertTrue(fachada.EntrarAdministrador(a.getEmail(), a.getPsw()));
	    }
	    /**
	     * Elimina el admin de la base de datos
	     * @throws RemoteException
	     */
		@Test
		public void v_eliminarAdmin() throws RemoteException
		{
			assertTrue(DAO.getInstance().EliminarAdmin(a));

		}
		/**
		 * Elimina el material creado
		 * @throws RemoteException
		 */
		@Test
		public void v_eliminarMaterial() throws RemoteException
		{
			assertTrue(DAO.getInstance().EliminarMaterial(m));

		}
		/**
		 * Registra un nuevo entrenador
		 * @throws RemoteException
		 * @throws AlreadyBoundException
		 * @throws NotBoundException
		 */
	    @Test
	    public void a_entrenador() throws RemoteException, AlreadyBoundException, NotBoundException {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
	        assertTrue(fachada.RegistrarEntrenador(e.getNombre(),e.getApellido(), e.getFecha_nacimiento(), e.getDNI(), e.getTelefono(), e.getCorreo(), e.getPsw()));
	    }
	    /**
	     * El entrenador nuevo entra a la aplicación
	     * @throws RemoteException
	     * @throws AlreadyBoundException
	     * @throws NotBoundException
	     */
	    @Test
	    public void entrarEntrenador() throws RemoteException, AlreadyBoundException, NotBoundException
	    {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
	        assertTrue(fachada.EntrarEntrenador(e.getCorreo(), e.getPsw()));
	        assertEquals(fachada.getEnt(e.getCorreo(), e.getPsw()), e);

	    }
	    /**
	     * Se elimina el entrenador de la base de datos
	     * @throws RemoteException
	     */
		@Test
		public void v_eliminarEntrenador() throws RemoteException
		{
			assertTrue(DAO.getInstance().EliminarEntrenador(e));

		}
		
		/**
		 * Se actualizan los datos del entrenador
		 * @throws RemoteException
		 * @throws NotBoundException
		 */
		@Test
		public void v_actualizarEntrenador() throws RemoteException, NotBoundException
		{
			Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
			
			assertTrue(fachada.ActualizarEntrenador(e, 1200));
			e.setCorreo("eee@gmail.com");
			e.setPsw("ertu");
			assertTrue(fachada.modificarCorreoEntrenador(e, "eee@gmail.com", "ertu"));
		}
		/**
		 * Se actualizan los datos del jugador
		 * @throws RemoteException
		 * @throws NotBoundException
		 */
		@Test
		public void v_actualizarJugador() throws RemoteException, NotBoundException
		{
			Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			fachada = (itfFachada) registry.lookup(name);
			fachada.ActualizarJugador(j, true, true, true);
			assertTrue(fachada.ActualizarJugador(j, true, true, true));
			j.setCorreo("eee@gmail.com");
			j.setPsw("ertu");
			assertTrue(fachada.modificarCorreo(j, "eee@gmail.com", "ertu"));
		}


}
