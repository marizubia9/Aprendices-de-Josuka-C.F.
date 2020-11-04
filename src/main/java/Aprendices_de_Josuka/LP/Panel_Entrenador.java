package Aprendices_de_Josuka.LP;

import javax.swing.JPanel;

import Aprendices_de_Josuka.LD.Entrenador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

public class Panel_Entrenador extends JPanel {

	private Entrenador entrenador;
	/**
	 * Create the panel.
	 */
	public Panel_Entrenador(Entrenador e) {
		System.out.println("entro al constructor");
		entrenador=e;
		Introducir_Datos();
	}
	
	public void Introducir_Datos()
	{
		System.out.println("Entro al metodo");
		setVisible(true);
		setBackground(Color.WHITE);
		setSize(1005, 130);
		setLayout(null);
		
		JPanel pFoto = new JPanel();
		pFoto.setBackground(Color.WHITE);
		pFoto.setBounds(10, 11, 117, 108);
		add(pFoto);
		
		String nombre_completo = entrenador.getNombre()+" "+entrenador.getApellido();
		JLabel lblNombre = new JLabel(nombre_completo);
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(168, 11, 330, 31);
		add(lblNombre);
		
		JLabel lblDNI = new JLabel(entrenador.getDNI());
		lblDNI.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDNI.setBounds(168, 55, 164, 20);
		add(lblDNI);
		String asignado="LIBRE";
		if(entrenador.isAsignado_equipo()) asignado= "ASIGNADO";
		JLabel lblAsignado = new JLabel(asignado);
		lblAsignado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAsignado.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblAsignado.setBounds(771, 21, 104, 31);
		add(lblAsignado);
		
		String Salario = entrenador.getSalario()+" Euros";
		JLabel lblSalario = new JLabel(Salario);
		lblSalario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalario.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblSalario.setBounds(675, 76, 200, 31);
		add(lblSalario);
	}
}
