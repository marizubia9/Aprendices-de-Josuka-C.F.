package Gateway;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Partido;
import Aprendices_de_Josuka.LD.Sancion;
import ServiciosExternos.Partido_JSON;
import ServiciosExternos.Sancion_JSON;

public interface itfGateway
{
	public List<Partido> search_partidos() throws ParseException;
	public List<Sancion> search_sanciones() throws ParseException;
	public ArrayList<Partido> convertir_partidos(List<Partido_JSON> json);
	public ArrayList<Sancion> convertir_sanciones(List<Sancion_JSON> json);
	public HashSet<Equipos_Ext> getEquipos()  throws ParseException;
	public boolean partidos() throws ParseException;
	public boolean sanciones() throws ParseException;
}