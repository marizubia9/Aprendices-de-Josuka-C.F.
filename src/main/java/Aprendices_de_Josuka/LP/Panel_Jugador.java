package Aprendices_de_Josuka.LP;

import javax.swing.JPanel;

import Aprendices_de_Josuka.DAO.DAO;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Jugador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

public class Panel_Jugador extends JPanel {

	private Jugador jugador;
	/**
	 * Create the panel.
	 */
	public Panel_Jugador(Jugador j) {
		
		jugador=j;
		Introducir_Datos();
	}
	
	public void Introducir_Datos()
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
		
		String nombre_completo = jugador.getNombre()+" "+jugador.getApellido();
		JLabel lblNombre = new JLabel(nombre_completo);
		lblNombre.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(168, 11, 330, 31);
		add(lblNombre);
		
		JLabel lblDNI = new JLabel(jugador.getDNI());
		lblDNI.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		lblDNI.setBounds(168, 55, 164, 20);
		add(lblDNI);
		String asignado="SIN ASIGNAR";
		if(!jugador.getEquipo().equals(null)) asignado= jugador.getEquipo().getNombre();
		JLabel lblAsignado = new JLabel(asignado);
		lblAsignado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAsignado.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		lblAsignado.setBounds(771, 21, 104, 31);
		add(lblAsignado);
		
		int edad=0;
		StringTokenizer st= new StringTokenizer(jugador.getFecha_nacimiento(),"/");
		Integer[] fecha=new Integer[3];
		int i=0;
		while(st.hasMoreTokens()){
			String str=st.nextToken();
			fecha[i]=Integer.valueOf(str).intValue();
			i++;
		       }
		int anyo=fecha[2];
		Calendar cal = Calendar.getInstance();
		int anyo_actual=cal.get(Calendar.YEAR);
		edad=anyo_actual-anyo;
		
		JLabel lblEdad = new JLabel(edad +" urte");
		lblEdad.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		lblEdad.setBounds(508, 11, 104, 31);
		add(lblEdad);
		
		
	}
}
