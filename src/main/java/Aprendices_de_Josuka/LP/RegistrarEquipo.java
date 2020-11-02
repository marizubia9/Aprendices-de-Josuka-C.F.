package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
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
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

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
	private JPanel panel;
	private JButton button;
	private JLabel lblJugadores;
	private JList<String> listaJugadores1;
	private JPanel panel_scrollpane;
	private JButton btnAadirJugadorAl;
	private JButton btnMostrarJugadores;
	private JPanel panel_central;
	private JPanel panel_scrollpane12;

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
		setBounds(100, 100, 1351, 862);
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
		
		
	    panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_central.setBounds(-12, 190, 1401, 658);
		contentPane.add(panel_central);
		panel_central.setLayout(null);
		
		lblNuevoEquipo = new JLabel("NUEVO EQUIPO\r\n");
		lblNuevoEquipo.setForeground(Color.DARK_GRAY);
		lblNuevoEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		lblNuevoEquipo.setBounds(309, 45, 338, 38);
		panel_central.add(lblNuevoEquipo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblNombre.setBounds(396, 137, 115, 31);
		panel_central.add(lblNombre);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.DARK_GRAY);
		lblCategoria.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblCategoria.setBounds(396, 212, 115, 31);
		panel_central.add(lblCategoria);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(554, 137, 374, 32);
		panel_central.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnNuevoEquipo = new JButton("Registrar Equipo");
		btnNuevoEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		btnNuevoEquipo.setForeground(Color.WHITE);
		btnNuevoEquipo.setBackground(new Color(0, 102, 0));
		btnNuevoEquipo.setBounds(1075, 16, 241, 38);
		panel_central.add(btnNuevoEquipo);
		
		comboCategoria = new JComboBox();
		comboCategoria.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 17));
		comboCategoria.setBounds(554, 214, 374, 32);
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
		lblEntrenador.setBounds(396, 287, 135, 31);
		panel_central.add(lblEntrenador);
		
		comboEntrenador = new JComboBox();
		comboEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 17));
		comboEntrenador.setBounds(554, 286, 374, 32);
		
		
		for( Entrenador a: DAO.getInstance().getEntrenador())
		{		
			if(a.getAsignado_equipo()==false){
			comboEntrenador.addItem(a.getDNI());
			}
		}
		panel_central.add(comboEntrenador);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(0, 102, 0));
		panel.setBorder(null);
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(0, -19, 288, 661);
		panel_central.add(panel);
		
		button = new JButton("AÑADIR EQUIPO");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 25));
		button.setBackground(new Color(0, 102, 0));
		button.setBounds(0, 16, 288, 88);
		panel.add(button);
		

	      btnMostrarJugadores = new JButton("Mostrar Jugadores");
	      btnMostrarJugadores.setBackground(new Color(0, 102, 0));
	      btnMostrarJugadores.setForeground(Color.WHITE);
	      btnMostrarJugadores.setBounds(962, 217, 172, 29);
	      panel_central.add(btnMostrarJugadores);
	      
	      btnMostrarJugadores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	
					 MostrarJugadores();
		
				   			
					
				}
			});

		      

		
		btnNuevoEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			   
				
				
			}
		});
	}
	
	public void MostrarJugadores()
	{
		
		lblJugadores = new JLabel("Jugadores");
		lblJugadores.setForeground(Color.DARK_GRAY);
		lblJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblJugadores.setBounds(396, 374, 135, 31);
		panel_central.add(lblJugadores);

		 JPanel panel_scrollpane1 = new JPanel(new BorderLayout());
		 panel_scrollpane1.setLocation(554, 387);
		 panel_scrollpane1.setSize(180, 190);
	      List<String> myList = new ArrayList<>();
			for( Jugador a: DAO.getInstance().getJugador())
			{		
				if(a.getAsignado_equipo()==false){
					myList.add(a.getDNI());
				}
			}
	      final JList<String> list = new JList<String>(myList.toArray(new String[myList.size()]));
	      JScrollPane scrollPane = new JScrollPane();
	      scrollPane.setViewportView(list);
	      list.setLayoutOrientation(JList.VERTICAL);
	      panel_scrollpane1.add(scrollPane);
	      panel_central.add(panel_scrollpane1);
	      
			 panel_scrollpane12 = new JPanel(new BorderLayout());
			 panel_scrollpane12.setLocation(910, 387);
			 panel_scrollpane12.setSize(180, 190);
		      List<String> myList2 = new ArrayList<>();
		      final JList<String> list2 = new JList<String>(myList2.toArray(new String[myList2.size()]));
		      JScrollPane scrollPane2 = new JScrollPane();
		      scrollPane2.setViewportView(list2);
		      list2.setLayoutOrientation(JList.VERTICAL);
		      panel_scrollpane12.add(scrollPane2);
		      panel_central.add(panel_scrollpane12);
		      
		      btnAadirJugadorAl = new JButton("Añadir jugador\r\n");
		      btnAadirJugadorAl.setForeground(Color.WHITE);
		      btnAadirJugadorAl.setBackground(new Color(0, 102, 0));
		      btnAadirJugadorAl.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 16));
		      btnAadirJugadorAl.setBounds(743, 468, 158, 29);
		      panel_central.add(btnAadirJugadorAl);
		      panel_central.repaint();
		      
		      btnAadirJugadorAl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AnyadirJugador();
						
						
						
					}
				});
		     
	}
	
	public void AnyadirJugador()
	{
		
	}
}
