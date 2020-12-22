package Aprendices_de_Josuka.Aprendices_de_Josuka;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import Aprendices_de_Josuka.LD.Administrador;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LD.Tipo_Material;
import Aprendices_de_Josuka.LN.Gestor;
import DAO.DAO;



public class TestGestor {
	private Administrador a;
	private Administrador b;
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	@Before
	public void inicializar()
	{
		a= new Administrador("aaa@gmail.com","4545");
		b= new Administrador("bbb@gmail.com","4545");
	}
	
	@Test
	@PerfTest (invocations = 1000, threads = 20) // La anotación @PerfTest especifica los datos de ejecución, en el ejemplo 1000 veces con 20 hilos concurrentes.
	@Required ( max = 1200, average = 250) // La anotación @Required define que es tolerable un tiempo máximo de ejecución de 1.2 segundos y uno medio de 250 ms.
	public void testDni() throws RemoteException{
		assertTrue(Gestor.getInstance().comprobarDNI("123123123"));
		assertFalse(Gestor.getInstance().comprobarDNI("123123"));

	}
	@Test
	public void testClasificacionAlevin() throws ParseException{
	List<Equipos_Ext> lista = Gestor.getInstance().clasificacionAlevin();
	assertEquals(lista.get(0).getNombre(), "Zumaiako");
	}
	
	@Test
	public void entrarAdmin() throws RemoteException{
		DAO.getInstance().guardarObjeto(a);
		assertTrue(Gestor.getInstance().Entrar_admin(a.getEmail(), a.getPsw()));
		assertFalse(Gestor.getInstance().Entrar_admin(b.getEmail(), b.getPsw()));
		
	
	}
	@After
	public void v_eliminar() throws RemoteException
	{
		DAO.getInstance().EliminarAdmin(a);
		
	}
	
}
