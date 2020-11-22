package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.maven.model.Model;

import Aprendices_de_Josuka.DAO.DAO;
import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LN.Gestor;

import java.awt.Color;
import java.awt.Container;

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
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
	private HashMap<Material, Integer> inventario;
	private JScrollPane scrollPane_Jugadores1;
	private JList<String> JListaJugadores1;
	private JList<String> JListaJugadores2;
	private JScrollPane scrollPane2;
	private List<Jugador> lista_Jugadores;
	private List<String> jugadores_lista;
	private Set<String> HashSet;

	private boolean MostrarJugadores;
	private JPanel panel_izquierdo;
	private JButton btnHome;
	private JButton btnAnyadirEquipo;
	private JButton btnAnyadirInventario;
	private JButton btnVisualizarJugador;
	private JButton btnVisualizarEntrenador;
	private JButton btnVisualziarEquipo;
	private JButton btnEditarEntrenador;
	private JButton buttonEliminar;
	private JButton btnEditarEquipo;
	private JButton btnEditarJugador;

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

	/**
	 * Creacion de todos los objetos visuales de la pantalla.
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 740);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_superior = new JPanel();
		panel_superior.setBounds(0, 0, 1278, 173);
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
		txtLosAprendicesDe.setBounds(45, 39, 702, 89);
		panel_superior.add(txtLosAprendicesDe);
		txtLosAprendicesDe.setColumns(10);

		panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_central.setBounds(0, 173, 1278, 528);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		lblNuevoEquipo = new JLabel("NUEVO EQUIPO\r\n");
		lblNuevoEquipo.setForeground(Color.DARK_GRAY);
		lblNuevoEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 24));
		lblNuevoEquipo.setBounds(385, 16, 338, 38);
		panel_central.add(lblNuevoEquipo);

		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblNombre.setBounds(395, 77, 115, 31);
		panel_central.add(lblNombre);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.DARK_GRAY);
		lblCategoria.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblCategoria.setBounds(395, 136, 115, 31);
		panel_central.add(lblCategoria);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		txtNombre.setBounds(554, 80, 189, 32);
		panel_central.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setText("");

		JButton btnAnyadir = new JButton("Anadir Inventario");
		btnAnyadir.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		btnAnyadir.setForeground(Color.WHITE);
		btnAnyadir.setBackground(new Color(0, 102, 0));
		btnAnyadir.setBounds(1112, 39, 151, 48);
		panel_central.add(btnAnyadir);

		comboCategoria = new JComboBox();
		comboCategoria.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		comboCategoria.setBounds(554, 138, 189, 32);
		comboCategoria.addItem(Categoria.ALEVIN);
		comboCategoria.addItem(Categoria.INFANTIL);
		comboCategoria.addItem(Categoria.CADETE);
		comboCategoria.addItem(Categoria.JUVENIL);
		comboCategoria.addItem(Categoria.SENIOR);

		panel_central.add(comboCategoria);

		JLabel lblEntrenador = new JLabel("Entrenador");
		lblEntrenador.setForeground(Color.DARK_GRAY);
		lblEntrenador.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblEntrenador.setBounds(396, 199, 135, 31);
		panel_central.add(lblEntrenador);

		comboEntrenador = new JComboBox();
		comboEntrenador.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		comboEntrenador.setBounds(554, 201, 189, 32);
		RellenarEntrenadores();

		panel_central.add(comboEntrenador);

		btnMostrarJugadores = new JButton("Mostrar Jugadores");
		btnMostrarJugadores.setBackground(new Color(0, 102, 0));
		btnMostrarJugadores.setForeground(Color.WHITE);
		btnMostrarJugadores.setBounds(765, 140, 135, 29);
		panel_central.add(btnMostrarJugadores);

		jugadores_lista = new ArrayList<String>();
		lblJugadores = new JLabel("Jugadores");
		lblJugadores.setForeground(Color.DARK_GRAY);
		lblJugadores.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblJugadores.setBounds(395, 261, 135, 31);
		panel_central.add(lblJugadores);

		btnAnyadirJugador = new JButton(">>");
		btnAnyadirJugador.setForeground(Color.WHITE);
		btnAnyadirJugador.setBackground(new Color(0, 102, 0));
		btnAnyadirJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 16));
		btnAnyadirJugador.setBounds(749, 303, 158, 29);
		panel_central.add(btnAnyadirJugador);
		ListaJugadores1 = new ArrayList<>();

		panel_izquierdo = new JPanel();
		panel_izquierdo.setLayout(null);
		panel_izquierdo.setForeground(new Color(0, 102, 0));
		panel_izquierdo.setBorder(null);
		panel_izquierdo.setBackground(new Color(0, 102, 0));
		panel_izquierdo.setBounds(0, 0, 328, 528);
		panel_central.add(panel_izquierdo);

		btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Principal_Administrador pa = new Principal_Administrador();
				pa.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnHome.setBackground(new Color(0, 102, 0));
		btnHome.setBounds(0, 0, 328, 42);
		panel_izquierdo.add(btnHome);

		btnAnyadirEquipo = new JButton("AÑADIR EQUIPO");
		btnAnyadirEquipo.setEnabled(false);
		btnAnyadirEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirEquipo.setForeground(Color.WHITE);
		btnAnyadirEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirEquipo.setBackground(new Color(0, 102, 0));
		btnAnyadirEquipo.setBounds(0, 40, 328, 42);
		panel_izquierdo.add(btnAnyadirEquipo);

		btnAnyadirInventario = new JButton("AÑADIR INVENTARIO");
		btnAnyadirInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RegistrarMaterial r = new RegistrarMaterial();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnAnyadirInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirInventario.setForeground(Color.WHITE);
		btnAnyadirInventario.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirInventario.setBackground(new Color(0, 102, 0));
		btnAnyadirInventario.setBounds(0, 81, 328, 42);
		panel_izquierdo.add(btnAnyadirInventario);

		btnVisualizarJugador = new JButton("VISUALIZAR  JUGADORES");
		btnVisualizarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Visualizar_Jugadores r = new Visualizar_Jugadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarJugador.setForeground(Color.WHITE);
		btnVisualizarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarJugador.setBackground(new Color(0, 102, 0));
		btnVisualizarJugador.setBounds(0, 202, 328, 42);
		panel_izquierdo.add(btnVisualizarJugador);

		btnVisualizarEntrenador = new JButton("VISUALIZAR  ENTRENADORES");
		btnVisualizarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Visualizar_Entrenadores r = new Visualizar_Entrenadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEntrenador.setForeground(Color.WHITE);
		btnVisualizarEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEntrenador.setBackground(new Color(0, 102, 0));
		btnVisualizarEntrenador.setBounds(0, 121, 328, 42);
		panel_izquierdo.add(btnVisualizarEntrenador);

		btnVisualziarEquipo = new JButton("VISUALIZAR  EQUIPOS");
		btnVisualziarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Visualizar_Equipos r = new Visualizar_Equipos();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualziarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualziarEquipo.setForeground(Color.WHITE);
		btnVisualziarEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualziarEquipo.setBackground(new Color(0, 102, 0));
		btnVisualziarEquipo.setBounds(0, 162, 328, 42);
		panel_izquierdo.add(btnVisualziarEquipo);

		btnEditarEntrenador = new JButton("EDITAR ENTRENADOR");
		btnEditarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EditarEntrenador r = new EditarEntrenador();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnEditarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarEntrenador.setForeground(Color.WHITE);
		btnEditarEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarEntrenador.setBackground(new Color(0, 102, 0));
		btnEditarEntrenador.setBounds(0, 243, 328, 42);
		panel_izquierdo.add(btnEditarEntrenador);

		btnEditarEquipo = new JButton("EDITAR EQUIPO");
		btnEditarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarEquipo r = new EditarEquipo();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnEditarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarEquipo.setForeground(Color.WHITE);
		btnEditarEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarEquipo.setBackground(new Color(0, 102, 0));
		btnEditarEquipo.setBounds(0, 281, 328, 42);
		panel_izquierdo.add(btnEditarEquipo);

		btnEditarJugador = new JButton("EDITAR JUGADOR");
		btnEditarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarJugador r = new EditarJugador();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnEditarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarJugador.setForeground(Color.WHITE);
		btnEditarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarJugador.setBackground(new Color(0, 102, 0));
		btnEditarJugador.setBounds(0, 322, 328, 42);
		panel_izquierdo.add(btnEditarJugador);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(0, 128, 0));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Introduce el nombre del equipo");
				} else if (HashSet == null) {
					JOptionPane.showMessageDialog(null, "Introduce jugadores");
				} else if (inventario == null) {
					JOptionPane.showMessageDialog(null, "Asigna material al equipo");
				}

				else {
					Anyadir_Equipo();
					txtNombre.setText("");
					MostrarJugadores();
					RellenarEntrenadores();
					scrollPane2.repaint();
					comboEntrenador.removeAllItems();
					scrollPane2.repaint();
					panel_central.repaint();
					JListaJugadores1.removeAll();
				}

			}
		});
		btnAceptar.setBounds(1138, 457, 125, 38);
		panel_central.add(btnAceptar);
		scrollPane_Jugadores1 = new JScrollPane();
		scrollPane_Jugadores1.setBounds(554, 261, 180, 190);
		panel_central.add(scrollPane_Jugadores1);

		panel_scrollpane1 = new JPanel(new BorderLayout());
		scrollPane_Jugadores1.setColumnHeaderView(panel_scrollpane1);
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(922, 261, 180, 190);
		panel_central.add(scrollPane2);

		// Creamos Jlist2 en este caso vacio
		panel_scrollpane2 = new JPanel(new BorderLayout());
		scrollPane2.setColumnHeaderView(panel_scrollpane2);

		buttonEliminar = new JButton("<<");
		buttonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarJugadores();
			}
		});
		buttonEliminar.setForeground(Color.WHITE);
		buttonEliminar.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 16));
		buttonEliminar.setBackground(new Color(0, 102, 0));
		buttonEliminar.setBounds(749, 375, 158, 29);
		panel_central.add(buttonEliminar);

		// Con este boton se muestran los JList de jugadores
		btnMostrarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Vaciamos la lista que utilizaremos mas tarde
				jugadores_lista.clear();
				MostrarJugadores();
				panel_central.repaint();
			}
		});
		
		btnAnyadirJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasarJugadores();
			}
		});
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Anyadir_Material();
			}
		});
	}

	public void MostrarJugadores() {
		vaciarJList();
		ListaJugadores1.clear();
		try {
			for (Jugador a : Gestor.getInstance().MostrarJugadores((Categoria) comboCategoria.getSelectedItem())) {
				ListaJugadores1.add(a.toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JListaJugadores1 = new JList<String>(ListaJugadores1.toArray(new String[ListaJugadores1.size()]));
		scrollPane_Jugadores1.setViewportView(JListaJugadores1);
		JListaJugadores1.setLayoutOrientation(JList.VERTICAL);
		scrollPane_Jugadores1.repaint();
		panel_central.repaint();

	}

	public void PasarJugadores() {
		String valor = JListaJugadores1.getSelectedValue();
		jugadores_lista.add(valor);
		HashSet = new HashSet<String>(jugadores_lista);
		jugadores_lista.clear();
		jugadores_lista.addAll(HashSet);
		JListaJugadores2 = new JList<String>(jugadores_lista.toArray(new String[jugadores_lista.size()]));
		scrollPane2.setViewportView(JListaJugadores2);
		JListaJugadores2.setLayoutOrientation(JList.VERTICAL);
		scrollPane2.repaint();
		panel_central.repaint();
	}

	public void EliminarJugadores() {
		jugadores_lista.remove(JListaJugadores2.getSelectedIndex());
		JListaJugadores2 = new JList<String>(jugadores_lista.toArray(new String[jugadores_lista.size()]));
		scrollPane2.setViewportView(JListaJugadores2);
		JListaJugadores2.setLayoutOrientation(JList.VERTICAL);
		scrollPane2.repaint();
		panel_central.repaint();
	}

	public void vaciarJList() {
		jugadores_lista.clear();
		JListaJugadores2 = new JList<String>(jugadores_lista.toArray(new String[jugadores_lista.size()]));
		scrollPane2.setViewportView(JListaJugadores2);
		JListaJugadores2.setLayoutOrientation(JList.VERTICAL);
		scrollPane2.repaint();
		panel_central.repaint();
	}

	public void Anyadir_Material() {
		inventario = new HashMap<Material, Integer>();
		Anyadir_Inventario a = new Anyadir_Inventario(this, inventario);
		a.setVisible(true);
		setVisible(false);
	}

	public void Anyadir_Equipo() 
	{
		Entrenador entrenador = null;
		lista_Jugadores = new ArrayList<Jugador>();
		for (Entrenador i : ListaEntrenador) {
			if (i.toString().equals(comboEntrenador.getSelectedItem())) {
				entrenador = i;
				entrenador.setAsignado_equipo(true);
			}
		}
		try {
			for (Jugador j : Gestor.getInstance().MostrarJugadores((Categoria) comboCategoria.getSelectedItem())) {
				for (String i : jugadores_lista) {
					if (j.toString().equals(i)) {
						lista_Jugadores.add(j);
					}
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			Equipo e = new Equipo(txtNombre.getText(), (Categoria) comboCategoria.getSelectedItem(), entrenador,
					lista_Jugadores, inventario);
			Gestor.getInstance().RegistrarEquipo(e);
			Gestor.getInstance().ActualizarJugadorEquipo(lista_Jugadores);
			txtNombre.setText("");
			vaciarJList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void RellenarEntrenadores() {
		ListaEntrenador = DAO.getInstance().getEntrenador();
		for (Entrenador a : ListaEntrenador) {
			if (!a.isAsignado_equipo()) {
				comboEntrenador.addItem(a.toString());
			}
		}
	}
}
