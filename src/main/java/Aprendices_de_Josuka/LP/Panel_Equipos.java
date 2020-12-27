package Aprendices_de_Josuka.LP;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Jugador;

public class Panel_Equipos extends JPanel {

	private Equipos_Ext equipo;
	/**
	 * Create the panel.
	 */
	public Panel_Equipos(Equipos_Ext e) {
		
		equipo=e;
		
		Introducir_Datos();	
	
		
	}
	
	public void Introducir_Datos( )
	{
		System.out.println("entro al metodo");
		setVisible(true);
		setBackground(Color.WHITE);
		setSize(1005, 130);
		setLayout(null);
		
		JPanel pFoto = new JPanel();
		pFoto.setBackground(Color.WHITE);
		pFoto.setBounds(10, 11, 117, 108);
		add(pFoto);
		
		String nombre_completo = equipo.getNombre()+" "+equipo.getPuntuacion();
		JLabel lblNombre = new JLabel(nombre_completo);
		lblNombre.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(168, 11, 330, 31);
		add(lblNombre);
		
	
		
	}
}
