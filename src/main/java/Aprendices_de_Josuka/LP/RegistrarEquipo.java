package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aprendices_de_Josuka.DAO.DAO;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LN.Gestor;


import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.JComboBox;

public class RegistrarEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JLabel lblNuevoEquipo;
	private JLabel lblNombre;
	private JLabel lblCategoria;
	private JTextField txtNombre;
	private Date objDate;
	private JComboBox comboCategoria;
	private List<Entrenador> ListaEntrenador;
	private JComboBox comboEntrenador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEquipo frame = new RegistrarEquipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrarEquipo() {
		initComponents();
		this.setVisible(true);
	}
	
	public void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1423, 904);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_superior = new JPanel();
		panel_superior.setBounds(0, 0, 1401, 189);
		panel_superior.setBackground(new Color(0, 102, 0));
		contentPane.add(panel_superior);
		panel_superior.setLayout(null);
		
		txtLosAprendicesDe = new JTextField();
		txtLosAprendicesDe.setEditable(false);
		txtLosAprendicesDe.setBackground(new Color(0, 102, 0));
		txtLosAprendicesDe.setForeground(Color.WHITE);
		txtLosAprendicesDe.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 40));
		txtLosAprendicesDe.setText("LOS APRENDICES DE JOSUKA C.F.");
		txtLosAprendicesDe.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtLosAprendicesDe.setBounds(46, 57, 702, 89);
		panel_superior.add(txtLosAprendicesDe);
		txtLosAprendicesDe.setColumns(10);
		
		
		JPanel panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_central.setBounds(0, 190, 1401, 658);
		contentPane.add(panel_central);
		panel_central.setLayout(null);
		
		lblNuevoEquipo = new JLabel("NUEVO EQUIPO\r\n");
		lblNuevoEquipo.setForeground(Color.DARK_GRAY);
		lblNuevoEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		lblNuevoEquipo.setBounds(68, 45, 338, 38);
		panel_central.add(lblNuevoEquipo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblNombre.setBounds(115, 124, 115, 31);
		panel_central.add(lblNombre);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.DARK_GRAY);
		lblCategoria.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblCategoria.setBounds(115, 198, 115, 31);
		panel_central.add(lblCategoria);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(273, 124, 374, 32);
		panel_central.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnNuevoEquipo = new JButton("Registrar Equipo");
		btnNuevoEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		btnNuevoEquipo.setForeground(Color.WHITE);
		btnNuevoEquipo.setBackground(new Color(0, 102, 0));
		btnNuevoEquipo.setBounds(745, 551, 241, 38);
		panel_central.add(btnNuevoEquipo);
		
		comboCategoria = new JComboBox();
		comboCategoria.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 17));
		comboCategoria.setBounds(273, 201, 374, 32);
		comboCategoria.addItem("InfantilTxiki");
		comboCategoria.addItem("InfantilHonor");
		comboCategoria.addItem("CadeteHonor");
		comboCategoria.addItem("CadeteVasca");
		comboCategoria.addItem("JuvenilVasca");
		comboCategoria.addItem("JuvenilNacional");
		comboCategoria.addItem("JuvenilDivisionDeHonor");
		panel_central.add(comboCategoria);
		
		JLabel lblEntrenador = new JLabel("Entrenador");
		lblEntrenador.setForeground(Color.DARK_GRAY);
		lblEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblEntrenador.setBounds(115, 271, 135, 31);
		panel_central.add(lblEntrenador);
		
		comboEntrenador = new JComboBox();
		comboEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 17));
		comboEntrenador.setBounds(273, 274, 374, 32);
		
		
		for( Entrenador a: DAO.getInstance().getEntrenador())
		{		
			comboEntrenador.addItem(a.getDNI());
		}
		panel_central.add(comboEntrenador);
		
	

		
		btnNuevoEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
			    

				
			}
		});
	}
}
