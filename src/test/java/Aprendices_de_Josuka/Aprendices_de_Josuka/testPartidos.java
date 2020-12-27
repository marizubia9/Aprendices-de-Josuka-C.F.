package Aprendices_de_Josuka.Aprendices_de_Josuka;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LD.Partido;
@RunWith(MockitoJUnitRunner.class)
public class testPartidos {
	
	@Mock
	Equipos_Ext eq1;
	@Mock
	Equipos_Ext eq2;
	@Mock
	Partido p;
	@Mock
	Equipo e;
	@Mock
	HashMap <Material, Integer> inventario;
	
	@Before
    public void setUp() {
		when(e.getInventario()).thenReturn(inventario);
        when(p.getEquipo_1()).thenReturn(eq1);
        when(p.getEquipo_2()).thenReturn(eq2);
        when(p.getCod_partido()).thenReturn("P01");
        
	}
	@Test
	public void test()
	{
		assertEquals(p.getEquipo_1(), eq1);
		assertEquals(p.getEquipo_2(), eq2);
		assertEquals(e.getInventario(), inventario);

	}

}
