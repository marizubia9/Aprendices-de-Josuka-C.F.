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
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton btnGO;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
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
		
		button = new JButton("HOME");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Principal_Administrador pa= new Principal_Administrador();
				pa.setVisible(true);
				setVisible(false);
			}
		});
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		button.setBackground(new Color(0, 102, 0));
		button.setBounds(0, 0, 328, 58);
		panel.add(button);
		
		button_1 = new JButton("AÑADIR EQUIPO");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrarEquipo r = new RegistrarEquipo();
				r.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		button_1.setBackground(new Color(0, 102, 0));
		button_1.setBounds(0, 58, 328, 58);
		panel.add(button_1);
		
		button_2 = new JButton("AÑADIR INVENTARIO");
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		button_2.setBackground(new Color(0, 102, 0));
		button_2.setBounds(0, 116, 328, 58);
		panel.add(button_2);
		
		button_3 = new JButton("VISUALIZAR  JUGADORES");
		button_3.setEnabled(false);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Jugadores r = new Visualizar_Jugadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		button_3.setHorizontalAlignment(SwingConstants.LEFT);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		button_3.setBackground(new Color(0, 102, 0));
		button_3.setBounds(0, 174, 328, 58);
		panel.add(button_3);
		
		button_4 = new JButton("VISUALIZAR ENTRENADORES");
		button_4.setHorizontalAlignment(SwingConstants.LEFT);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		button_4.setBackground(new Color(0, 102, 0));
		button_4.setBounds(0, 232, 328, 58);
		panel.add(button_4);
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Entrenadores r = new Visualizar_Entrenadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		
		button_5 = new JButton("VISUALIZAR  EQUIPOS");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Equipos r = new Visualizar_Equipos();
				r.setVisible(true);
				setVisible(false);
			}
		});
		button_5.setHorizontalAlignment(SwingConstants.LEFT);
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		button_5.setBackground(new Color(0, 102, 0));
		button_5.setBounds(0, 290, 328, 58);
		panel.add(button_5);
		
		comboCategoria = new JComboBox();
		comboCategoria.addItem(Categoria.ALEVIN);
		comboCategoria.addItem(Categoria.INFANTIL);
		comboCategoria.addItem(Categoria.CADETE);
		comboCategoria.addItem(Categoria.JUVENIL);
		comboCategoria.addItem(Categoria.SENIOR);
		
		comboCategoria.setBounds(1083, 45, 109, 26);
		panel_central.add(comboCategoria);
		
		label = new JLabel("");
		label.setBounds(0, 348, 328, 58);
		panel.add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(0, 406, 328, 58);
		panel.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(0, 464, 328, 58);
		panel.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(0, 522, 328, 58);
		panel.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setBounds(0, 580, 328, 58);
		panel.add(label_4);
		
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
