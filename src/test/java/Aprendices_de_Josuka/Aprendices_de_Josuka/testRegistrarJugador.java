package Aprendices_de_Josuka.Aprendices_de_Josuka;

import static org.assertj.swing.core.matcher.JButtonMatcher.withName;
import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Aprendices_de_Josuka.LP.RegistrarJugador;
import Controller.Controller;
import Fachada.ServidorPrincipal;
import Fachada.itfFachada;
import Remote.ServiceLocator;
public class testRegistrarJugador {
	
	private FrameFixture window;
	private RegistrarJugador frame;
	private Controller c;
	 	@BeforeClass
	    public static void setUpOnce() throws RemoteException, AlreadyBoundException {
	        FailOnThreadViolationRepaintManager.install();

	        Registry registry = LocateRegistry.createRegistry(1099);
	        registry.bind("ADJ", ServidorPrincipal.getInstance());
	    }
	    @Before
	    public void setUp() throws IOException, NotBoundException {
	    	Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(1099))));
			itfFachada fachada = (itfFachada) registry.lookup("ADJ");
	        frame = GuiActionRunner.execute(() -> new RegistrarJugador(null));
	        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        window = new FrameFixture(frame);
	        window.resizeTo(frame.getSize());
	        window.show();
	    }
	    @After
	    public void tearDown() {
	        window.cleanUp();
	    }
	    @Test
	    public void RegistrarJugador() {                
	        window.textBox("nombre").enterText("Maider");
	        window.textBox("apellido").enterText("Dorron");
	        window.textBox("DNI").enterText("3123");
	        window.textBox("telefono").enterText("908790980");
	        window.textBox("correo").enterText("Maider@gmail.com");
	        window.textBox("psw").enterText("uapa");        
	        window.button(withName("registrar")).click();       
	        //realiza la comparación de resultados
	        assertFalse(frame.guardar());       
	    }
}
