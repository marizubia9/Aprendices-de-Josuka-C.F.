package Aprendices_de_Josuka.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import Aprendices_de_Josuka.LD.Administrador;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LN.Gestor;



public class DAO implements itfDAO {
	private static PersistenceManager persistentManager;
	private static Transaction transaction;
	private static PersistenceManagerFactory persistentManagerFactory;
	private static Gestor g;
	private static final DAO INSTANCE = new DAO();

	private DAO() {
	}

	public static DAO getInstance() {

		persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		return INSTANCE;
	}

	@SuppressWarnings("unchecked")
	public void guardarObjeto(Object objeto) {
		try {
			if (objeto instanceof Jugador)
			{
					objeto = new Jugador(((Jugador) objeto).getNombre(),((Jugador) objeto).getApellido(),((Jugador) objeto).getFecha_nacimiento(),((Jugador) objeto).getDNI(), ((Jugador) objeto).isReconocimiento_medico(),((Jugador) objeto).isEstado(),((Jugador) objeto).getTelefono(),((Jugador) objeto).getCorreo(), ((Jugador) objeto).getPsw(),((Jugador) objeto).isCuota_pagada());
					persistentManager.makePersistent(objeto);
			}
			if (objeto instanceof Entrenador)
			{	
					objeto = new Entrenador(((Entrenador) objeto).getNombre(),((Entrenador) objeto).getApellido(),((Entrenador) objeto).getFecha_nacimiento(),
							((Entrenador) objeto).getDNI(),((Entrenador) objeto).getTelefono(),((Entrenador) objeto).getCorreo(), ((Entrenador) objeto).getPsw(),((Entrenador) objeto).getSalario());
					persistentManager.makePersistent(objeto);
			}


			} catch (Exception ex) {
			
			System.err.println("* Exception inserting data into db: " + ex.getMessage());
		}

		finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}

	}

	@Override
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
	
	@Override
	public List<Jugador> getJugador() {
	
		// TODO Auto-generated method stub
		Extent<Jugador> extent = persistentManager.getExtent(Jugador.class, false);
		List<Jugador> jugadores = new ArrayList<Jugador>();

		for (Jugador p : extent) {
			jugadores.add(p);
		}
		extent.closeAll();
	
		return jugadores;
	}
	
	@Override
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
//	@Override
//	public List<Usuario> getUsuarios() {
//		// TODO Auto-generated method stub
//		Extent<Usuario> extent = persistentManager.getExtent(Usuario.class, false);
//		List<Usuario> usuarios= new ArrayList<Usuario>();
//
//		for (Usuario p : extent) {
//			usuarios.add(p);
//		}
//		extent.closeAll();
//		return usuarios;
//	}
//	@Override
//	public List<Reserva> getReservas() {
//		// TODO Auto-generated method stub
//		Extent<Reserva> extent = persistentManager.getExtent(Reserva.class, false);
//		List<Reserva> reservas = new ArrayList<Reserva>();
//
//		for (Reserva p : extent) {
//			reservas.add(p);
//		}
//		extent.closeAll();
//		return reservas;
//	}

	@Override
	public void cerrarConexion() 
	{
		persistentManager.close();

	}
	
//	public Usuario BuscarUsuario(String email)
//	{
//		List <Usuario> usuarios = getUsuarios();
//		Usuario usuario=null;
//		for (Usuario u: usuarios){
//			if (u.getEmail().equals(email))
//			{
//				usuario = new Usuario(u.getNomUsuario(), u.getApe(), u.getEmail(), u.getPassword(), u.getAeropuerto());
//			}
//		}
//		return usuario;
//	}

}
