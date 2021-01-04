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
/**
 * @class Panel_Equipos
 * @brief En esta clase se crea un panel para mostrar por pantalla cada equipo, para luego poder introducirlo en otras ventanas
 * @author Alumno
 *
 */

public class Panel_Equipos extends JPanel {

	private Equipos_Ext equipo;
	private int num;
	
	/**
	 * Constructor
	 * @param e
	 * @param i
	 */
	public Panel_Equipos(Equipos_Ext e, int i) {
		num = i;
		equipo=e;
		
		Introducir_Datos();	
	
		
	}
	/**
	 * Se inicializan los componentes del panel y se introducen los datos correspondientes
	 */
	public void Introducir_Datos( )
	{
		setVisible(true);
		setBackground(Color.WHITE);
		setSize(1005, 130);
		setLayout(null);
		
		JPanel pFoto = new JPanel();
		pFoto.setBackground(Color.WHITE);
		pFoto.setBounds(10, 11, 117, 108);
		add(pFoto);
		
		
		JLabel lblNumero = new JLabel(String.valueOf(num+1));
		lblNumero.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblNumero.setBackground(Color.WHITE);
		lblNumero.setBounds(168, 11, 50, 31);
		add(lblNumero);
		
		String nombre_completo = equipo.getNombre()+" "+equipo.getPuntuacion();
		JLabel lblNombre = new JLabel(nombre_completo);
		lblNombre.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(238, 11, 330, 31);
		add(lblNombre);
		
	
		
	}
}
