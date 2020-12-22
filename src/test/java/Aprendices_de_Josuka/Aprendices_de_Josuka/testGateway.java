package Aprendices_de_Josuka.Aprendices_de_Josuka;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import Aprendices_de_Josuka.LN.Gestor;

public class testGateway {
	
//	@Before
//	public void inicializar() throws IOException
//	{
//		String[] cmd = {"python","launch_AprendicesDeJosuka_partidos.py","--host", "127.0.0.1", "--port", "5000"};
//	    Runtime.getRuntime().exec(cmd);
//	}
	@Test
	public void partidos() throws ParseException
	{
		assertTrue(Gestor.getInstance().getPartidos());
	}
	@Test
	public void sanciones() throws ParseException
	{
		assertTrue(Gestor.getInstance().getSanciones());
	}
}
