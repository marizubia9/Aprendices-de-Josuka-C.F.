package DAO;

import java.util.List;

import Aprendices_de_Josuka.LD.Administrador;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;

public interface itfDAO {
	public void guardarObjeto(Object objeto);

	public void cerrarConexion();

	public List<Administrador> getAdmin();

	public List<Jugador> getJugador();

	public List<Entrenador> getEntrenador();

	public List<Equipo> getEquipo();

}
