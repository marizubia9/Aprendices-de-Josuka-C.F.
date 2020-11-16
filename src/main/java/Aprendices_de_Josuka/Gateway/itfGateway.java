package Aprendices_de_Josuka.Gateway;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Partido;
import Aprendices_de_Josuka.ServiciosExternos.Partido_JSON;

public interface itfGateway
{
	public List<Partido_JSON> search_partidos() throws ParseException;
	public ArrayList<Partido> convertir(List<Partido_JSON> json);
	public List<Partido> getPartidos()throws ParseException;
	public HashSet<Equipos_Ext> getEquipos()  throws ParseException;
}