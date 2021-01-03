/**
 * @package Remote
 * @brief Necesario para incorporar el patrón de diseño de serice locator.
 */
package Remote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Fachada.itfFachada;
/**
 * @class ServiceLocator
 * @brief Esta clase establece la conexion entre la fachada y controller
 * @author Alumno
 */
public class ServiceLocator {
	private itfFachada fachada;
	/**
	 * Establece la conexion con el servidor mediante el Set Service
	 * @throws RemoteException
	 */
	public void setService() throws RemoteException {
		String ip = "127.0.0.1";
		String port = "1099";
		String serviceName = "Aprendices-de-Josuka";

		if (System.getSecurityManager() == null) {

			System.setSecurityManager(new SecurityManager());
		}

		try {

			Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(port))));

			String name = "//" + ip + ":" + port + "/" + serviceName;
			fachada = (itfFachada) registry.lookup(name);
		} catch (Exception e) {

			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * Devuelve la referencia del servicio externo, es decir, de la fachada 
	 * @return la referencia de la fachada
	 */
	public itfFachada getService() {
		return fachada;
	}
}
