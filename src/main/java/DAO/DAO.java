/**
 * @brief En este paquete estan incluidas todas las clases que tienen relacion con la base de datos
 * @author Alumno
 * @package DAO
 */
package DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import Aprendices_de_Josuka.LD.Administrador;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LD.Tipo_Material;
/**
 * @class DAO
 * @brief en esta clase se desarrollan todos los metodos para hacer transacciones con la base de datos
 * @author Alumno
 *
 */
public class DAO {
	private static PersistenceManager persistentManager;
	private static Transaction transaction;
	private static PersistenceManagerFactory persistentManagerFactory;
	private static DAO INSTANCE = new DAO();
	/**
	 * Constructor. Se inicia la conexion.
	 */
	private DAO() {

		persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
	}
	/**
	 * Patrón singleton
	 * @return un new del DAO
	 */
	public static DAO getInstance() {

		return INSTANCE;
	}
	/**
	 * Se guardan los objetos en la base de datos en funcion de su tipo
	 * @param objeto
	 * @return un boolean que informa sobre si el objeto se ha guardado correctamente (true) o no (false)
	 */
	public boolean guardarObjeto(Object objeto) {
		try {
			if (objeto instanceof Jugador) {
				objeto = new Jugador(((Jugador) objeto).getNombre(), ((Jugador) objeto).getApellido(),
						((Jugador) objeto).getFecha_nacimiento(), ((Jugador) objeto).getDNI(),
						((Jugador) objeto).isReconocimiento_medico(), ((Jugador) objeto).isLesionado(),
						((Jugador) objeto).getTelefono(), ((Jugador) objeto).getCorreo(), ((Jugador) objeto).getPsw(),
						((Jugador) objeto).isCuota_pagada(),((Jugador) objeto).isAsignado());
				persistentManager.makePersistent(objeto);
				return true;
			}
			if (objeto instanceof Entrenador) 
			{
				objeto = new Entrenador(((Entrenador) objeto).getNombre(), ((Entrenador) objeto).getApellido(),
						((Entrenador) objeto).getFecha_nacimiento(), ((Entrenador) objeto).getDNI(),
						((Entrenador) objeto).getTelefono(), ((Entrenador) objeto).getCorreo(),
						((Entrenador) objeto).getPsw(), ((Entrenador) objeto).getSalario(),
						((Entrenador) objeto).isAsignado_equipo());
				persistentManager.makePersistent(objeto);
				return true;
			}
			if (objeto instanceof Equipo) 
			{
				objeto = new Equipo(((Equipo) objeto).getNombre(), ((Equipo) objeto).getCategoria(),
						((Equipo) objeto).getDni_entrenador(),((Equipo) objeto).getLista_jugador(),
						((Equipo) objeto).getInventario());
				persistentManager.makePersistent(objeto);
				return true;
			}
			if (objeto instanceof Material) {
				objeto = new Material(((Material)(Material) objeto).getTipo(),((Material) objeto).getCantidad(), ((Material) objeto).getPrecio());
				persistentManager.makePersistent(objeto);
				return true;
			}
			if (objeto instanceof Administrador) {
				objeto = new Administrador(((Administrador) objeto).getEmail(),((Administrador) objeto).getPsw());
				persistentManager.makePersistent(objeto);
				return true;
			}
				
		} catch (Exception ex) {
			
			System.err.println("* Exception inserting data into db: " + ex.getMessage());
			return false;
		}

		finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
		return false;
	}
	/**
	 * Metodo para obtener la lista completa del inventario registrada
	 * @return el inventario registrado en la base de datos
	 */
	public List<Material>getMaterial()
	{
		Extent<Material> extent = persistentManager.getExtent(Material.class, false);
		List<Material> materiales = new ArrayList<Material>();
		for (Material p : extent) {
			materiales.add(p);
		}
		extent.closeAll();
		return materiales;
	}
	/**
	 * Metodo para modificar el inventario
	 * @param tipo
	 * @param cantidad
	 * @param precio
	 * @return un boolean que informa sobre si el material se ha modificado correctamente (true) o no (false)
	 */
	public boolean ModificarMaterial(Tipo_Material tipo, int cantidad, long precio)
	{
		try {
		Material m= persistentManager.getObjectById(Material.class, tipo);
		m.setCantidad(cantidad);
		m.setPrecio(precio);
		return true;
		} catch (Exception ex) {

			System.err.println("* Exception modifying data into db: " + ex.getMessage());
		}
		finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
		return false;
	}
	/**
	 * Metodo para leer los administradores registrados
	 * @return la lista de administradores
	 */
	public List<Administrador> getAdmin() {
		// TODO Auto-generated method stub
		Extent<Administrador> extent = persistentManager.getExtent(Administrador.class, false);
		List<Administrador> administradores = new ArrayList<Administrador>();

		for (Administrador p : extent) {
			administradores.add(p);
		}
		extent.closeAll();
		return administradores;
	}

	/**
	 * Metodo para leer los jugadores registrados
	 * @return la lista de jugadores
	 */
	public List<Jugador> getJugador() {

		Extent<Jugador> extent = persistentManager.getExtent(Jugador.class, false);
		List<Jugador> jugadores = new ArrayList<Jugador>();

		for (Jugador p : extent) {
			jugadores.add(p);
		}
		extent.closeAll();

		return jugadores;
	}
	
	/**
	 * Metodo para leer los entrenadores registrados
	 * @return la lista de entrenadores
	 */
	public List<Entrenador> getEntrenador() {
		// TODO Auto-generated method stub
		Extent<Entrenador> extent = persistentManager.getExtent(Entrenador.class, false);
		List<Entrenador> entrenadores = new ArrayList<Entrenador>();

		for (Entrenador p : extent) {
			entrenadores.add(p);
		}
		extent.closeAll();
		return entrenadores;
	}
	
	/**
	 * Metodo para leer los equipos registrados
	 * @return la lista de equipos
	 */
	public List<Equipo> getEquipo() {
		// TODO Auto-generated method stub
		Extent<Equipo> extent = persistentManager.getExtent(Equipo.class, false);
		List<Equipo> equipos = new ArrayList<Equipo>();

		for (Equipo p : extent) {
			equipos.add(p);
		}
		extent.closeAll();
		return equipos;
	}
	/**
	 * Metodo para modificar los entrenadores (de la parte de administrador)
	 * @param salario
	 * @param entrenador
	 * @return un boolean que informa sobre si el entrenador se ha modificado correctamente (true) o no (false)
	 */
	public boolean ActualizarEntrenador(Long salario, Entrenador entrenador)
	{
		
		try {
		Entrenador e= persistentManager.getObjectById(Entrenador.class, entrenador.getDNI());
		e.setSalario(salario);
		return true;
		
		} catch (Exception ex) {

			System.err.println("* Exception modifying data into db: " + ex.getMessage());
		}
		finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
		return false;
	}
	/**
	 * Metodo para modificar los jugadores (de la parte de administrador)
	 * @param jugador
	 * @param reconocimiento
	 * @param lesionado
	 * @param cuota
	 * @return un boolean que informa sobre si el jugador se ha modificado correctamente (true) o no (false)
	 */
	public boolean ActualizarJugador(Jugador jugador, boolean reconocimiento, boolean lesionado, boolean cuota)
	{
		
		try {
		Jugador j= persistentManager.getObjectById(Jugador.class, jugador.getDNI());
		j.setReconocimiento_medico(reconocimiento);
		j.setLesionado(lesionado);
		j.setCuota_pagada(cuota);
		return true;
		
		} catch (Exception ex) {

			System.err.println("* Exception modifying data into db: " + ex.getMessage());
		}
		finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
		return false;
	}
	/**
	 * Metodo para modificar los jugadores (parte jugador)
	 * @param jugador
	 * @param correo
	 * @param psw
	 * @return un boolean que informa sobre si el jugador se ha modificado correctamente (true) o no (false)
	 */
	public boolean modificarCorreo(Jugador jugador, String correo, String psw)
	{
		
		try {
		Jugador j= persistentManager.getObjectById(Jugador.class, jugador.getDNI());
		j.setCorreo(correo);
		j.setPsw(psw);
		return true;
		
		} catch (Exception ex) {

			System.err.println("* Exception modifying data into db: " + ex.getMessage());
		}
		finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
		return false;
	}
	/**
	 * Metodo para modificar los entrenadores (parte entrenador)
	 * @param e
	 * @param correo
	 * @param psw
	 * @return un boolean que informa sobre si el entrenador se ha modificado correctamente (true) o no (false)
	 */
	public boolean modificarCorreoEntrenador(Entrenador e, String correo, String psw)
	{
		
		try {
		Entrenador ent= persistentManager.getObjectById(Entrenador.class, e.getDNI());
		ent.setCorreo(correo);
		ent.setPsw(psw);
		return true;
		
		} catch (Exception ex) {

			System.err.println("* Exception modifying data into db: " + ex.getMessage());
		}
		finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
		return false;
	}
	/**
	 * Metodo para modificar los jugadores de un equipo
	 * @param jugadores
	 */
	public void ActualizarEquipoJugador(List<Jugador> jugadores)
	{
		try {
			for (Jugador j: jugadores)
			{
				
				Jugador jugador= persistentManager.getObjectById(Jugador.class, j.getDNI());
				jugador.setAsignado(true);
			}
		} catch (Exception ex) {

			System.err.println("* Exception modifying data into db: " + ex.getMessage());
		}
		finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	/**
	 * Metodo para modificar el boolean asignado a un entrenador
	 * @param ent
	 */
	public void ActualizarEquipoEntrenador(Entrenador ent)
	{
		try {
		
				Entrenador e= persistentManager.getObjectById(Entrenador.class, ent.getDNI());
				e.setAsignado_equipo(true);
			
		} catch (Exception ex) {

			System.err.println("* Exception modifying data into db: " + ex.getMessage());
		}
		finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	/**
	 * Metodo para modificar un equipo
	 * @param equipo
	 * @param inventario
	 * @param jugadores
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void ActualizarEquipo(Equipo equipo, HashMap inventario, List<String> jugadores)
	{
		try
		{
		Equipo e= persistentManager.getObjectById(Equipo.class, equipo.getNombre());
		e.setInventario(inventario);
		e.setLista_jugador(jugadores);
		}
		catch (Exception ex) {

			System.err.println("* Exception modifying data into db: " + ex.getMessage());
		}
		finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	/**
	 * Metodo para modificar el inventario
	 * @param lista_material
	 */
	public void ActualizarMaterial (List<Material> lista_material)
	{
		try 
		{
			for (Material m: lista_material)
			{
			m= persistentManager.getObjectById(Material.class, m.getTipo());
			m.setCantidad(m.getCantidad());
			}
		} catch (Exception ex) {

				System.err.println("* Exception modifying data into db: " + ex.getMessage());
			}
			finally {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			}
	}
	/**
	 * Metodo para eliminar un administrador registrado
	 * @param a
	 * @return un boolean que informa sobre si el administrador se ha eliminado correctamente (true) o no (false)
	 */
	public boolean EliminarAdmin (Administrador a)
	{
		Extent<Administrador> extent = persistentManager.getExtent(Administrador.class, false);
		List <Administrador> admins = new ArrayList <Administrador>();
		for (Administrador ad: extent){
			admins.add(ad);
		}
		extent.closeAll();
		
		try{
			for (Administrador ad : admins){
				if(ad.getEmail().equals(a.getEmail()))
				{ 
					Administrador eliminar = persistentManager.getObjectById(Administrador.class, a.getEmail());
					persistentManager.deletePersistent(eliminar);
					return true;
				}	
			}
			
		} catch (Exception ex) {

				System.err.println("* Exception deleting data into db: " + ex.getMessage());
			}
			finally {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			}
		return false;
	}
	/**
	 * Metodo para eliminar un jugador registrado
	 * @param j
	 * @return un boolean que informa sobre si el jugador se ha eliminado correctamente (true) o no (false)
	 */
	public boolean EliminarJugador (Jugador j)
	{
		Extent<Jugador> extent = persistentManager.getExtent(Jugador.class, false);
		List <Jugador> jugadores = new ArrayList <Jugador>();
		for (Jugador ad: extent){
			jugadores.add(ad);
		}
		extent.closeAll();
		
		try{
			for (Jugador ad : jugadores){
				if(ad.getDNI().equals(j.getDNI()))
				{ 
					Jugador eliminar = persistentManager.getObjectById(Jugador.class, j.getDNI());
					persistentManager.deletePersistent(eliminar);
					return true;
				}	
			}
			
		} catch (Exception ex) {

				System.err.println("* Exception deleting data into db: " + ex.getMessage());
				return false;
			}
			finally {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			}
		return false;
	}
	/**
	 * Metodo para eliminar un entrenador registrado
	 * @param e
	 * @return un boolean que informa sobre si el entrenador se ha eliminado correctamente (true) o no (false)
	 */
	public boolean EliminarEntrenador (Entrenador e)
	{
		Extent<Entrenador> extent = persistentManager.getExtent(Entrenador.class, false);
		List <Entrenador> enrenadores = new ArrayList <Entrenador>();
		for (Entrenador ad: extent){
			enrenadores.add(ad);
		}
		extent.closeAll();
		
		try{
			for (Entrenador ad : enrenadores){
				if(ad.getDNI().equals(e.getDNI()))
				{ 
					Entrenador eliminar = persistentManager.getObjectById(Entrenador.class, e.getDNI());
					persistentManager.deletePersistent(eliminar);
					return true;
				}	
			}
			
		} catch (Exception ex) {

				System.err.println("* Exception deleting data into db: " + ex.getMessage());
			}
			finally {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			}
		return false;
	}
	/**
	 * Metodo para eliminar un equipo
	 * @param e
	 * @return un boolean que informa sobre si el equipo se ha eliminado correctamente (true) o no (false)
	 */
	public boolean EliminarEquipo(Equipo e)
	{
		Extent<Equipo> extent = persistentManager.getExtent(Equipo.class, false);
		List <Equipo> equipos = new ArrayList <Equipo>();
		for (Equipo ad: extent){
			equipos.add(ad);
		}
		extent.closeAll();
		
		try{
			for (Equipo ad : equipos){
				if(ad.getNombre().equals(e.getNombre()))
				{ 
					Equipo eliminar = persistentManager.getObjectById(Equipo.class, e.getNombre());
					persistentManager.deletePersistent(eliminar);
					return true;
				}	
			}
			
		} catch (Exception ex) {

				System.err.println("* Exception deleting data into db: " + ex.getMessage());
			}
			finally {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			}
		return false;
	}
	/**
	 * Metodo para eliminar el material registrado
	 * @param e
	 * @return un boolean que informa sobre si el material se ha eliminado correctamente (true) o no (false)
	 */
	public boolean EliminarMaterial(Material e)
	{
		Extent<Material> extent = persistentManager.getExtent(Material.class, false);
		List <Material> materiales = new ArrayList <Material>();
		for (Material ad: extent){
			materiales.add(ad);
		}
		extent.closeAll();
		
		try{
			for (Material ad : materiales){
				if(ad.getTipo().equals(e.getTipo()))
				{ 
					Material eliminar = persistentManager.getObjectById(Material.class, e.getTipo());
					persistentManager.deletePersistent(eliminar);
					return true;
				}	
			}
			
		} catch (Exception ex) {

				System.err.println("* Exception deleting data into db: " + ex.getMessage());
			}
			finally {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			}
		return false;
	}
	/**
	 * Metodo para cerrar la conexion con la base de datos
	 */
	public void cerrarConexion() {
		persistentManager.close();

	}
}
