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
	private JLabel lblJugadores;
	private JList<String> listaJugadores1;
	private JPanel panel_scrollpane;
	private JButton btnAnyadirJugador;
	private JButton btnMostrarJugadores;
	private JPanel panel_central;
	private JPanel panel_scrollpane2;
	private JPanel panel_scrollpane1;
	private List<String> ListaJugadores1;
	private Categoria cat;
	private JScrollPane scrollPane_Jugadores1;
	private JList<String> JListaJugadores1;
	private JList<String> JListaJugadores2;
	private JScrollPane scrollPane2;

	private List<String> jugadores_lista;
	private Set<String> HashSet;

	private boolean MostrarJugadores;
	private JPanel panel_izquierdo;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;

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
		panel_central.setBounds(0, 190, 1389, 633);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		lblNuevoEquipo = new JLabel("NUEVO EQUIPO\r\n");
		lblNuevoEquipo.setForeground(Color.DARK_GRAY);
		lblNuevoEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		lblNuevoEquipo.setBounds(385, 44, 338, 38);
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
		comboCategoria.addItem(Categoria.ALEVIN);
		comboCategoria.addItem(Categoria.INFANTIL);
		comboCategoria.addItem(Categoria.CADETE);
		comboCategoria.addItem(Categoria.JUVENIL);
		comboCategoria.addItem(Categoria.SENIOR);

		panel_central.add(comboCategoria);

		JLabel lblEntrenador = new JLabel("Entrenador");
		lblEntrenador.setForeground(Color.DARK_GRAY);
		lblEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblEntrenador.setBounds(396, 287, 135, 31);
		panel_central.add(lblEntrenador);

		comboEntrenador = new JComboBox();
		comboEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 17));
		comboEntrenador.setBounds(554, 286, 374, 32);

		for (Entrenador a : DAO.getInstance().getEntrenador()) {
			if (!a.isAsignado_equipo()) {
				String nombre_completo= a.getNombre()+" "+a.getApellido();
				comboEntrenador.addItem(nombre_completo);
			}
		}
		panel_central.add(comboEntrenador);

		btnMostrarJugadores = new JButton("Mostrar Jugadores");
		btnMostrarJugadores.setBackground(new Color(0, 102, 0));
		btnMostrarJugadores.setForeground(Color.WHITE);
		btnMostrarJugadores.setBounds(962, 217, 172, 29);
		panel_central.add(btnMostrarJugadores);

		jugadores_lista = new ArrayList<String>();
		// Creamos lblJugadores
		lblJugadores = new JLabel("Jugadores");
		lblJugadores.setForeground(Color.DARK_GRAY);
		lblJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblJugadores.setBounds(396, 374, 135, 31);
		panel_central.add(lblJugadores);
		
		btnAnyadirJugador = new JButton(">>");
		btnAnyadirJugador.setForeground(Color.WHITE);
		btnAnyadirJugador.setBackground(new Color(0, 102, 0));
		btnAnyadirJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 16));
		btnAnyadirJugador.setBounds(743, 468, 158, 29);
		panel_central.add(btnAnyadirJugador);


		// Creamos el Jlist1 y lo rellenamos con la lista de los
		// jugadores
		panel_scrollpane1 = new JPanel(new BorderLayout());
		panel_scrollpane1.setLocation(554, 387);
		panel_scrollpane1.setSize(180, 190);
		ListaJugadores1 = new ArrayList<>();
		scrollPane_Jugadores1 = new JScrollPane();
		panel_scrollpane1.add(scrollPane_Jugadores1);
		panel_central.add(panel_scrollpane1);
		
		
		// Creamos Jlist2 en este caso vacio
		panel_scrollpane2 = new JPanel(new BorderLayout());
		panel_scrollpane2.setLocation(910, 387);
		panel_scrollpane2.setSize(180, 190);
		
//		List<String> myList2 = new ArrayList<>();
//		final JList<String> list2 = new JList<String>(myList2.toArray(new String[myList2.size()]));
		scrollPane2 = new JScrollPane();
		panel_scrollpane2.add(scrollPane2);
		panel_central.add(panel_scrollpane2);
		
		panel_izquierdo = new JPanel();
		panel_izquierdo.setLayout(null);
		panel_izquierdo.setForeground(new Color(0, 102, 0));
		panel_izquierdo.setBorder(null);
		panel_izquierdo.setBackground(new Color(0, 102, 0));
		panel_izquierdo.setBounds(0, 0, 328, 638);
		panel_central.add(panel_izquierdo);
		
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
		panel_izquierdo.add(button);
		
		button_1 = new JButton("AÑADIR EQUIPO");
		button_1.setEnabled(false);
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		button_1.setBackground(new Color(0, 102, 0));
		button_1.setBounds(0, 58, 328, 58);
		panel_izquierdo.add(button_1);
		
		button_2 = new JButton("AÑADIR INVENTARIO");
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		button_2.setBackground(new Color(0, 102, 0));
		button_2.setBounds(0, 116, 328, 58);
		panel_izquierdo.add(button_2);
		
		button_3 = new JButton("VISUALIZAR  JUGADORES");
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
		panel_izquierdo.add(button_3);
		
		button_4 = new JButton("VISUALIZAR  ENTRENADORES");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Visualizar_Entrenadores r = new Visualizar_Entrenadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		button_4.setHorizontalAlignment(SwingConstants.LEFT);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		button_4.setBackground(new Color(0, 102, 0));
		button_4.setBounds(0, 232, 328, 58);
		panel_izquierdo.add(button_4);
		
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
		panel_izquierdo.add(button_5);
		
		label = new JLabel("");
		label.setBounds(0, 348, 328, 58);
		panel_izquierdo.add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(0, 406, 328, 58);
		panel_izquierdo.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(0, 464, 328, 58);
		panel_izquierdo.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(0, 522, 328, 58);
		panel_izquierdo.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setBounds(0, 580, 328, 58);
		panel_izquierdo.add(label_4);
		
		// Con este boton se muestran los JList de jugadores
		btnMostrarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Vaciamos la lista que utilizaremos más tarde
				jugadores_lista.clear();
				MostrarJugadores();
				


				

				
				panel_central.repaint();

//				 Pasamos un jugador de una lista a otra
				btnAnyadirJugador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PasarJugadores();
//						// Anyadimos a la lista para insertar en JList2 el valor
//						// seleccionado en JList1
//						String valor =  ListaJugadores1.getSelectedValue();
//						jugadores_lista.add(valor);
//
//						panel_scrollpane2.removeAll();
//						panel_scrollpane2 = new JPanel(new BorderLayout());
//						panel_scrollpane2.setLocation(910, 387);
//						panel_scrollpane2.setSize(180, 190);
//
//						final JList<String> list2 = new JList<String>(
//								jugadores_lista.toArray(new String[jugadores_lista.size()]));
//
//						JScrollPane scrollPane2 = new JScrollPane();
//						scrollPane2.setViewportView(list2);
//						list2.setLayoutOrientation(JList.VERTICAL);
//						panel_scrollpane2.add(scrollPane2);
//						panel_central.add(panel_scrollpane2);
//
//						btnAnyadirJugador = new JButton("Añadir jugador\r\n");
//						btnAnyadirJugador.setForeground(Color.WHITE);
//						btnAnyadirJugador.setBackground(new Color(0, 102, 0));
//						btnAnyadirJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 16));
//						btnAnyadirJugador.setBounds(743, 468, 158, 29);
//						panel_central.add(btnAnyadirJugador);
//						panel_scrollpane1.repaint();
//						panel_central.repaint();
//						contentPane.repaint();
//
					}
				});

			}
		});

		btnNuevoEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
	
	public void MostrarJugadores()
	{
	
		try {
			for(Jugador a : Gestor.getInstance().MostrarJugadores((Categoria)comboCategoria.getSelectedItem())){
				String nombre_completo= a.getNombre()+" "+a.getApellido();
				ListaJugadores1.add(nombre_completo);
			}
			JListaJugadores1 = new JList<String>(ListaJugadores1.toArray(new String[ListaJugadores1.size()]));
			scrollPane_Jugadores1.setViewportView(JListaJugadores1);
			JListaJugadores1.setLayoutOrientation(JList.VERTICAL);
			scrollPane_Jugadores1.repaint();
			System.out.println("El tamanyo de la lista: "+ListaJugadores1.size());
			panel_central.repaint();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void PasarJugadores()
	{
		String valor =  JListaJugadores1.getSelectedValue();
		jugadores_lista.add(valor);
		HashSet= new HashSet<String>(jugadores_lista);
		jugadores_lista.clear();
		jugadores_lista.addAll(HashSet);
		JListaJugadores2 = new JList<String>(jugadores_lista.toArray(new String[jugadores_lista.size()]));
		scrollPane2.setViewportView(JListaJugadores2);
		JListaJugadores2.setLayoutOrientation(JList.VERTICAL);
		scrollPane2.repaint();
		panel_central.repaint();
	}

}
