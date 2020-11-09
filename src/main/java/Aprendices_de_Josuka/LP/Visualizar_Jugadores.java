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
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;

public class Visualizar_Jugadores extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JLabel lblListaJugadores;
	private Date objDate;
	private List<Jugador> ListaJugador;
	private JList<String> listaJugadores1;
	private JPanel panel_scrollpane;
	private JPanel panel_central;
	private List<Jugador> ListaJugadores;
	private Categoria cat;
	private JList<String> JListaJugadores1;
	private JComboBox comboCategoria;

	private List<String> jugadores_lista;
	private Set<String> HashSet;

	private boolean MostrarJugadores;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnAnyadirEquipo;
	private JButton btnAnyadirInventario;
	private JButton btnVisualizarJugadores;
	private JButton btnVisualizarEntrenadores;
	private JButton btnVisualizarEquipos;
	private JButton btnGO;
	private JPanel PanelCentro;
	private JPanel pScrollPane;
	private JScrollPane scrollPane;

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
		panel_central.setBounds(0, 190, 1335, 633);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		lblListaJugadores = new JLabel("JUGADORES");
		lblListaJugadores.setForeground(Color.DARK_GRAY);
		lblListaJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		lblListaJugadores.setBounds(360, 39, 360, 38);
		panel_central.add(lblListaJugadores);
		
		btnGO = new JButton("GO!");
		btnGO.setBounds(1209, 39, 68, 38);
		panel_central.add(btnGO);
		
		jugadores_lista = new ArrayList<String>();
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
				RegistrarInventario r= new RegistrarInventario();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnAnyadirInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirInventario.setForeground(Color.WHITE);
		btnAnyadirInventario.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirInventario.setBackground(new Color(0, 102, 0));
		btnAnyadirInventario.setBounds(0, 116, 328, 58);
		panel.add(btnAnyadirInventario);
		
		btnVisualizarJugadores = new JButton("VISUALIZAR  JUGADORES");
		btnVisualizarJugadores.setEnabled(false);
		btnVisualizarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Jugadores r = new Visualizar_Jugadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarJugadores.setForeground(Color.WHITE);
		btnVisualizarJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarJugadores.setBackground(new Color(0, 102, 0));
		btnVisualizarJugadores.setBounds(0, 174, 328, 58);
		panel.add(btnVisualizarJugadores);
		
		btnVisualizarEntrenadores = new JButton("VISUALIZAR ENTRENADORES");
		btnVisualizarEntrenadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEntrenadores.setForeground(Color.WHITE);
		btnVisualizarEntrenadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEntrenadores.setBackground(new Color(0, 102, 0));
		btnVisualizarEntrenadores.setBounds(0, 232, 328, 58);
		panel.add(btnVisualizarEntrenadores);
		
		btnVisualizarEntrenadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Entrenadores r = new Visualizar_Entrenadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		
		btnVisualizarEquipos = new JButton("VISUALIZAR  EQUIPOS");
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
		
		PanelCentro = new JPanel();
		PanelCentro.setBackground(Color.WHITE);
		PanelCentro.setBounds(328, 83, 1007, 550);
		panel_central.add(PanelCentro);
		PanelCentro.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1007, 550);
		PanelCentro.add(scrollPane);
		
		pScrollPane = new JPanel();
		pScrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(pScrollPane);
		GridBagLayout gbl_pScrollPane = new GridBagLayout();
		gbl_pScrollPane.columnWidths = new int[]{0};
		gbl_pScrollPane.rowHeights = new int[]{0};
		gbl_pScrollPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pScrollPane.rowWeights = new double[]{Double.MIN_VALUE};
		pScrollPane.setLayout(gbl_pScrollPane);
		

		btnGO.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				InsertarJPanel();
			}
		});
		

		
//		MostrarEntrenadores();
		
	}
	
//	public void MostrarEntrenadores()
//	{
//		
//		try {
//			ListaJugadores=Gestor.getInstance().MostrarEntrenadores();
//			JListaJugadores1.setLayoutOrientation(JList.VERTICAL);
//			System.out.println("El tamanyo de la lista: "+ListaJugadores.size());
//			panel_central.repaint();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void InsertarJPanel() {
		pScrollPane.removeAll();
		int x = 0;
		int y = 50;
		try {
			ListaJugadores=Gestor.getInstance().MostrarJugadores((Categoria)comboCategoria.getSelectedItem());
			System.out.println("El tamanyo de la lista de jugadores es de: "+ListaJugadores.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < ListaJugadores.size(); i++) 
		{
			Panel_Jugador panel = new Panel_Jugador(ListaJugadores.get(i));
			panel.setVisible(true);
			GridBagConstraints gbc_lblFoto = new GridBagConstraints();
			gbc_lblFoto.ipadx = 1005;
			gbc_lblFoto.ipady = 130;
			gbc_lblFoto.gridx = x;
			gbc_lblFoto.gridy = y;
			pScrollPane.add(panel,gbc_lblFoto);

			y = y + 130;
		}
		pScrollPane.repaint();
		scrollPane.repaint();
		repaint();
	}
}
