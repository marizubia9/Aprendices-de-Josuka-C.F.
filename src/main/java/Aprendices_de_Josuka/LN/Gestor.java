package Aprendices_de_Josuka.LN;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.json.simple.parser.ParseException;

import com.mysql.fabric.xmlrpc.base.Array;

import DAO.DAO;
import Gateway.Gateway;
import Aprendices_de_Josuka.LD.Administrador;
import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LD.Partido;
import Aprendices_de_Josuka.LD.Sancion;
import Aprendices_de_Josuka.LD.Tipo_Material;
import Aprendices_de_Josuka.LP.Pantalla_Principal;

public class Gestor {

	private static Gestor INSTANCE = new Gestor();
	
	public static Gestor getInstance()  {

		return INSTANCE;
	}

	public boolean Entrar_admin(String email, String psw) throws RemoteException {
		for (Administrador a : DAO.getInstance().getAdmin()) {
			if (a.getEmail().equals(email) && a.getPsw().equals(psw)) {
				return true;
			} 
		}
		return false;
	}

	public boolean getPartidos() throws ParseException {
		boolean bool;
		bool = Gateway.getInstance().partidos();
		
		return bool;
	}

	public List<Equipos_Ext> clasificacionAlevin() throws ParseException {
		HashSet<Equipos_Ext> equipos = Gateway.getInstance().getEquipos();
		List<Equipos_Ext> list = new ArrayList<Equipos_Ext>(equipos);
		List<Equipos_Ext> listaClasificacion = new ArrayList<Equipos_Ext>();
		Collections.sort(list, new Comparator<Equipos_Ext>() {
			@Override
			public int compare(Equipos_Ext p1, Equipos_Ext p2) {
				return new Integer((int) p2.getPuntuacion()).compareTo(new Integer((int) p1.getPuntuacion()));
			}

		});

		for (Equipos_Ext b : list) {
			if (b.getCategoria().toUpperCase().equals("ALEVIN")) {
				listaClasificacion.add(b);
			}
		}
		return listaClasificacion;
	}
	

	public boolean getSanciones() throws ParseException {
		boolean bool;
		bool = Gateway.getInstance().sanciones();
		
		return bool;
	}

	public boolean comprobarDNI(String dni) {
		boolean bool;
		if (dni.length() != 9) {
			bool = false;
		} else {
			bool = true;
		}
		return bool;
	}

}
