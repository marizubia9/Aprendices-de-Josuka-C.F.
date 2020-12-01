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

	private static Gestor INSTANCE = null;
	
	public static Gestor getInstance() throws RemoteException {
		synchronized (Gestor.class) {
			if (INSTANCE == null) {
				INSTANCE = new Gestor();
			}
		}
		return INSTANCE;
	}

	public boolean Entrar_admin(String email, String psw) throws RemoteException {
		for (Administrador a : DAO.getInstance().getAdmin()) {
			if (a.getEmail().equals(email) && a.getPsw().equals(psw)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public List<Partido> getPartidos() throws ParseException {
		List<Partido> lista = Gateway.getInstance().getPartidos();
		HashSet<Equipos_Ext> equipos = Gateway.getInstance().getEquipos();
		for (Equipos_Ext a : equipos) {
			System.out.println(a.getCod() + " " + a.getNombre() + " " + a.getCategoria() + " " + a.getPuntuacion());
		}
		return lista;
	}

	public void clasificacion() throws ParseException {
		HashSet<Equipos_Ext> equipos = Gateway.getInstance().getEquipos();
		List<Equipos_Ext> list = new ArrayList<Equipos_Ext>(equipos);
		Collections.sort(list, new Comparator<Equipos_Ext>() {
			@Override
			public int compare(Equipos_Ext p1, Equipos_Ext p2) {
				return new Integer((int) p2.getPuntuacion()).compareTo(new Integer((int) p1.getPuntuacion()));
			}

		});
		System.out.println("----------------------------------------------------");
		System.out.println("CLASIFICACION ALEVIN");
		for (Equipos_Ext b : list) {
			if (b.getCategoria().toUpperCase().equals("ALEVIN")) {
				System.out.println(b.getCod() + " " + b.getNombre() + " " + b.getPuntuacion());
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println("CLASIFICACION CADETE");
		for (Equipos_Ext b : list) {
			if (b.getCategoria().toUpperCase().equals("CADETE")) {
				System.out.println(b.getCod() + " " + b.getNombre() + " " + b.getPuntuacion());
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println("CLASIFICACION INFANTIL");
		for (Equipos_Ext b : list) {

			if (b.getCategoria().toUpperCase().equals("INFANTIL")) {
				System.out.println(b.getCod() + " " + b.getNombre() + " " + b.getPuntuacion());
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println("CLASIFICACION SENIOR");
		for (Equipos_Ext b : list) {

			if (b.getCategoria().toUpperCase().equals("SENIOR")) {
				System.out.println(b.getCod() + " " + b.getNombre() + " " + b.getPuntuacion());
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println("CLASIFICACION JUVENIL");
		for (Equipos_Ext b : list) {

			if (b.getCategoria().toUpperCase().equals("JUVENIL")) {
				System.out.println(b.getCod() + " " + b.getNombre() + " " + b.getPuntuacion());
			}
		}

	}

	public List<Sancion> getSanciones() throws ParseException {
		List<Sancion> lista = Gateway.getInstance().getSanciones();
		for (Sancion a : lista) {
			System.out.println(a.getCodigo() + " " + a.getPersona() + " " + a.getTipo() + " " + a.getCod_partido());
		}
		return lista;
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
