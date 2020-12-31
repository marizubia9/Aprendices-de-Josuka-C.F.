package Aprendices_de_Josuka.LP;


import javax.swing.JPanel;

import DAO.DAO;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Partido;
import Aprendices_de_Josuka.LD.Sancion;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

public class Panel_Sanciones extends JPanel {
	private Sancion sancion;
	private Partido partido;
	/**
	 * Create the panel.
	 */
	public Panel_Sanciones(Sancion p, Partido partido) {
		this.partido = partido;
		this.sancion=p;
		Introducir_Datos();
	}
	public void Introducir_Datos()
	{
		setVisible(true);
		setBackground(Color.WHITE);
		setSize(1005, 130);
		setLayout(null);
		
		JPanel pFoto = new JPanel();
		pFoto.setBackground(Color.WHITE);
		pFoto.setBounds(10, 11, 117, 108);
		add(pFoto);
		
		String cat =sancion.getTipo().toString();
		JLabel lblCat= new JLabel(cat);
		lblCat.setFont(new Font("Malgun Gothic", Font.PLAIN, 18));
		lblCat.setBackground(Color.WHITE);
		lblCat.setBounds(160, 11, 150, 31);
		add(lblCat);
		

		JLabel lblNombre = new JLabel(partido.getEquipo_1().getNombre());
		lblNombre.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(320, 11, 150, 31);
		add(lblNombre);
		
		String res1 = String.valueOf(partido.getResultado_e1());
		JLabel lblR1= new JLabel(res1);
		lblR1.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblR1.setBackground(Color.WHITE);
		lblR1.setBounds(470, 11, 50, 31);
		add(lblR1);
		
		JLabel lblA = new JLabel("-");
		lblA.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblA.setBackground(Color.WHITE);
		lblA.setBounds(520, 11, 50, 31);
		add(lblA);
		
		String eq2= partido.getEquipo_2().getNombre();
		JLabel lblDNI = new JLabel(eq2);
		lblDNI.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblDNI.setBounds(570, 11, 150, 31);
		add(lblDNI);
		
		String res2 = String.valueOf(partido.getResultado_e2());
		JLabel lblR2= new JLabel(res2);
		lblR2.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblR2.setBackground(Color.WHITE);
		lblR2.setBounds(730, 11, 50, 31);
		add(lblR2);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String fecha = String.valueOf(partido.getFecha().format(formatter));
		JLabel lblFecha= new JLabel(fecha);
		lblFecha.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblFecha.setBackground(Color.WHITE);
		lblFecha.setBounds(780, 11, 250, 31);
		add(lblFecha);
		
		
		
	}
}