package Aprendices_de_Josuka.LP;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aprendices_de_Josuka.DAO.DAO;
import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LN.Gestor;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.LayoutManager;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;

public class Visualizar_Jugadores extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JLabel lblListaJugadores;
	private JPanel panel_central;
	private JList<String> JListaJugadoresInfantil;
	private JList<String> JListaJugadoresCadete;
	private JList<String> JListaJugadoresJuvenil;
	private JList<String> JListaJugadoresSenior;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnAnyadirEquipo;
	private JButton btnAnyadirInventario;
	private JButton btnVisualizarJugadores;
	private JButton btnVisualizarEntrenadores;
	private JButton btnVisualizarEquipos;
	private JComboBox comboCategoria;
	private JButton btnGO;
	private JPanel pCentral;
	private JScrollPane scrollPane;
	private JPanel pScrollPane;
	private List<Jugador> ListaJugadores;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualizar_Jugadores frame = new Visualizar_Jugadores();
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
	public Visualizar_Jugadores() {
		initComponents();
		this.setVisible(true);
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1351, 862);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_superior = new JPanel();
		panel_superior.setBounds(0, 0, 1335, 189);
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
		panel_central.setBounds(0, 190, 1335, 633);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		lblListaJugadores = new JLabel("JUGADORES");
		lblListaJugadores.setForeground(Color.DARK_GRAY);
		lblListaJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		lblListaJugadores.setBounds(348, 45, 360, 38);
		panel_central.add(lblListaJugadores);
		ListaJugadores = new ArrayList<>();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(0, 102, 0));
		panel.setBorder(null);
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(0, 0, 328, 638);
		panel_central.add(panel);
		
		btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal_Administrador pa= new Principal_Administrador();
				pa.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnHome.setBackground(new Color(0, 102, 0));
		btnHome.setBounds(0, 0, 328, 58);
		panel.add(btnHome);
		
		btnAnyadirEquipo = new JButton("AÑADIR EQUIPO");
		btnAnyadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrarEquipo r = new RegistrarEquipo();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnAnyadirEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirEquipo.setForeground(Color.WHITE);
		btnAnyadirEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirEquipo.setBackground(new Color(0, 102, 0));
		btnAnyadirEquipo.setBounds(0, 58, 328, 58);
		panel.add(btnAnyadirEquipo);
		
		btnAnyadirInventario = new JButton("AÑADIR INVENTARIO");
		btnAnyadirInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnyadirInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirInventario.setForeground(Color.WHITE);
		btnAnyadirInventario.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirInventario.setBackground(new Color(0, 102, 0));
		btnAnyadirInventario.setBounds(0, 116, 328, 58);
		panel.add(btnAnyadirInventario);
		
		btnVisualizarJugadores = new JButton("VISUALIZAR  JUGADORES");
		btnVisualizarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		btnVisualizarJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarJugadores.setForeground(Color.WHITE);
		btnVisualizarJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarJugadores.setBackground(new Color(0, 102, 0));
		btnVisualizarJugadores.setBounds(0, 174, 328, 58);
		panel.add(btnVisualizarJugadores);
		
		btnVisualizarEntrenadores = new JButton("VISUALIZAR  ENTRENADORES");
		btnVisualizarEntrenadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Entrenadores r = new Visualizar_Entrenadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarEntrenadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEntrenadores.setForeground(Color.WHITE);
		btnVisualizarEntrenadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEntrenadores.setBackground(new Color(0, 102, 0));
		btnVisualizarEntrenadores.setBounds(0, 232, 328, 58);
		panel.add(btnVisualizarEntrenadores);
		
		btnVisualizarEquipos = new JButton("VISUALIZAR  EQUIPOS");
		btnVisualizarEquipos.setEnabled(false);
		btnVisualizarEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Equipos r = new Visualizar_Equipos();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarEquipos.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEquipos.setForeground(Color.WHITE);
		btnVisualizarEquipos.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEquipos.setBackground(new Color(0, 102, 0));
		btnVisualizarEquipos.setBounds(0, 290, 328, 58);
		panel.add(btnVisualizarEquipos);
		
		comboCategoria = new JComboBox();
		comboCategoria.addItem(Categoria.ALEVIN);
		comboCategoria.addItem(Categoria.INFANTIL);
		comboCategoria.addItem(Categoria.CADETE);
		comboCategoria.addItem(Categoria.JUVENIL);
		comboCategoria.addItem(Categoria.SENIOR);
		
		comboCategoria.setBounds(1083, 45, 109, 26);
		panel_central.add(comboCategoria);
		
		JLabel lblSeleccionaUnaCategoria = new JLabel("Selecciona una categoria:");
		lblSeleccionaUnaCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeleccionaUnaCategoria.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lblSeleccionaUnaCategoria.setBounds(878, 45, 185, 26);
		panel_central.add(lblSeleccionaUnaCategoria);
		
		btnGO = new JButton("GO!");
		btnGO.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				IntroducirPaneles();
			}
		});
		btnGO.setBounds(1209, 39, 68, 38);
		panel_central.add(btnGO);
		
		pCentral = new JPanel();
		pCentral.setBounds(326, 101, 1009, 532);
		panel_central.add(pCentral);
		pCentral.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1009, 532);
		pCentral.add(scrollPane);
		
		pScrollPane = new JPanel();
		scrollPane.setViewportView(pScrollPane);
		GridBagLayout gbl_pScrollPane = new GridBagLayout();
		gbl_pScrollPane.columnWidths = new int[]{0};
		gbl_pScrollPane.rowHeights = new int[]{0};
		gbl_pScrollPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pScrollPane.rowWeights = new double[]{Double.MIN_VALUE};
		pScrollPane.setLayout(gbl_pScrollPane);
		
		
		
	}
	public void IntroducirPaneles()
	{
		pScrollPane.removeAll();
		int x = 0;
		int y = 50;
		try {
			ListaJugadores.clear();
			ListaJugadores=Gestor.getInstance().MostrarJugadores((Categoria)comboCategoria.getSelectedItem());
			System.out.println("El tamanyo de la lista de entrenadores es de: "+ListaJugadores.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < ListaJugadores.size(); i++) 
		{
			Panel_Jugador panel = new Panel_Jugador(ListaJugadores.get(i));
			panel.setVisible(true);
			GridBagConstraints gbc_lblFoto = new GridBagConstraints();
			gbc_lblFoto.ipadx = 1009;
			gbc_lblFoto.ipady = 130;
			gbc_lblFoto.gridx = x;
			gbc_lblFoto.gridy = y;
			pScrollPane.add(panel,gbc_lblFoto);
			y +=130;

		}
		pScrollPane.repaint();
		scrollPane.repaint();
		pCentral.repaint();
		repaint();
	}
	
}
