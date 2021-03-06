package Aprendices_de_Josuka.LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Controller.Controller;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * @class EditarEquipo
 * @brief En esta clase se desarrolla la GUI para que el administrador pueda parte de la informacion del equipo
 * @author Alumno
 *
 */
public class EditarEquipo extends JFrame{
	private JPanel contentPane;
	private JLabel lblLosAprendicesDe;
	private List<Equipo>Lista_Equipos;
	private List<Jugador> Lista_Jugadores;
	private List<Material> Lista_Material;
	private HashMap inventario;
	
	private JPanel panel_central;

	private JPanel panel_izquierdo;
	private JButton btnHome;
	private JButton btnAnyadirEquipo;
	private JButton btnAnyadirInventario;
	private JButton btnVisualizarJugador;
	private JButton btnVisualizarEntrenador;
	private JButton btnVisualziarEquipo;
	private JComboBox<Categoria> comboCategoria;
	private JComboBox<String> comboEquipo;
	private JLabel lblNombreEquipo;
	private JScrollPane scrollPane;
	private JPanel pScrollPane;
	private JList<Jugador> list_JugadoresEquipo;
	private JList<Jugador> list_JugadoresAnyadir;
	private DefaultListModel<Jugador> modelo;
	private DefaultListModel<Jugador> modelo2;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JPanel pScrollPane_1;
	private JButton btnEditarEntrenador;
	private JButton btnEditarEquipo;
	private JButton btnEditarJugador;
	private JButton btnEliminar;
	private JButton btnAnyadir;
	private JLabel lblBalones;
	private JLabel lblConos;
	private JLabel lblBarreras;
	private JLabel lblPicas;
	private JLabel lblBotellas;
	private JLabel lblPetos;
	private JLabel lblVallas;
	private JTextField textFieldBalones;
	private JTextField textFieldBarreras;
	private JTextField textFieldBotellas;
	private JTextField textFieldConos;
	private JTextField textFieldPetos;
	private JTextField textFieldPicas;
	private JTextField textFieldVallas;
	private Controller controller;




	/**
	 * Constructor
	 * @param c
	 */
	public EditarEquipo(Controller c) {
		this.controller = c;
		initComponents();
		this.setVisible(true);
	}
	/**
	 * Se inicializan los componentes
	 */
	public void initComponents() {
		Lista_Equipos= new ArrayList<>();
		Lista_Jugadores= new ArrayList<>();
		Lista_Material = new ArrayList<>();
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

		lblLosAprendicesDe = new JLabel("LOS APRENDICES DE JOSUKA C.F.");
		lblLosAprendicesDe.setBackground(new Color(0, 102, 0));
		lblLosAprendicesDe.setForeground(Color.WHITE);
		lblLosAprendicesDe.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 40));
		lblLosAprendicesDe.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		lblLosAprendicesDe.setBounds(45, 39, 702, 89);
		panel_superior.add(lblLosAprendicesDe);

		panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_central.setBounds(0, 173, 1278, 511);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

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
				
				Principal_Administrador pa = null;
				try {
					pa = new Principal_Administrador(controller);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		btnAnyadirEquipo = new JButton("ANADIR EQUIPO");
		btnAnyadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RegistrarEquipo r = new RegistrarEquipo(controller);
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnAnyadirEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirEquipo.setForeground(Color.WHITE);
		btnAnyadirEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirEquipo.setBackground(new Color(0, 102, 0));
		btnAnyadirEquipo.setBounds(0, 40, 328, 42);
		panel_izquierdo.add(btnAnyadirEquipo);
		
		btnAnyadirInventario = new JButton("ANADIR INVENTARIO");
		btnAnyadirInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				RegistrarMaterial r = new RegistrarMaterial(controller);
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
			
				Visualizar_Jugadores r = new Visualizar_Jugadores(controller);
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
			
				Visualizar_Entrenadores r = new Visualizar_Entrenadores(controller);
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
				
				Visualizar_Equipos r = new Visualizar_Equipos(controller);
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
				
				EditarEntrenador r = new EditarEntrenador(controller);
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
		btnEditarEquipo.setEnabled(false);
		btnEditarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarEquipo.setForeground(Color.WHITE);
		btnEditarEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarEquipo.setBackground(new Color(0, 102, 0));
		btnEditarEquipo.setBounds(0, 281, 328, 42);
		panel_izquierdo.add(btnEditarEquipo);
		
		btnEditarJugador = new JButton("EDITAR JUGADOR");
		btnEditarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EditarJugador r = new EditarJugador(controller);
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
		
		JButton btnClasificacion = new JButton("VER CLASIFICACION");
		btnClasificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				Clasificacion r = null;
				try {
					r = new Clasificacion(controller);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnClasificacion.setHorizontalAlignment(SwingConstants.LEFT);
		btnClasificacion.setForeground(Color.WHITE);
		btnClasificacion.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnClasificacion.setBackground(new Color(0, 102, 0));
		btnClasificacion.setBounds(0, 364, 328, 42);
		panel_izquierdo.add(btnClasificacion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(0, 128, 0));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Guardar();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(1138, 437, 125, 38);
		panel_central.add(btnAceptar);
		
		JLabel lblSeleccioneCategoria = new JLabel("Seleccione la categoria");
		lblSeleccioneCategoria.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblSeleccioneCategoria.setBounds(343, 16, 182, 20);
		panel_central.add(lblSeleccioneCategoria);
		
		comboCategoria = new JComboBox<Categoria>();
		comboCategoria.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		comboCategoria.setBounds(547, 13, 246, 26);
		panel_central.add(comboCategoria);
		comboCategoria.addItem(Categoria.ALEVIN);
		comboCategoria.addItem(Categoria.INFANTIL);
		comboCategoria.addItem(Categoria.CADETE);
		comboCategoria.addItem(Categoria.JUVENIL);
		comboCategoria.addItem(Categoria.SENIOR);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 16));
		lblNombre.setBounds(944, 28, 69, 20);
		panel_central.add(lblNombre);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VisualizarEquipos();
				panel_izquierdo.repaint();
				
			}
		});
		btnGo.setBounds(816, 14, 69, 29);
		panel_central.add(btnGo);
		

		JLabel lblSeleccioneEquipo = new JLabel("Seleccione el equipo:");
		lblSeleccioneEquipo.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblSeleccioneEquipo.setBounds(343, 50, 182, 23);
		panel_central.add(lblSeleccioneEquipo);
		
		JButton btnGO2 = new JButton("GO!");
		btnGO2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarInformacion();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panel_izquierdo.repaint();
			}
		});
		btnGO2.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnGO2.setBounds(816, 48, 69, 29);
		panel_central.add(btnGO2);
		
		comboEquipo = new JComboBox<String>();
		comboEquipo.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		comboEquipo.setBounds(547, 50, 246, 26);
		panel_central.add(comboEquipo);
		
		lblNombreEquipo = new JLabel("");
		lblNombreEquipo.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		lblNombreEquipo.setBounds(1043, 28, 220, 26);
		panel_central.add(lblNombreEquipo);
		
		JLabel lblJugadores = new JLabel("Jugadores:");
		lblJugadores.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblJugadores.setBounds(509, 92, 88, 26);
		panel_central.add(lblJugadores);
		
		JLabel lblInventario = new JLabel("Inventario:");
		lblInventario.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblInventario.setBounds(509, 313, 88, 20);
		panel_central.add(lblInventario);
		
		JPanel panel = new JPanel();
		panel.setBounds(597, 124, 266, 162);
		panel_central.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		pScrollPane = new JPanel();
		pScrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(pScrollPane);
		pScrollPane.setLayout(new BorderLayout(0, 0));
		
		list_JugadoresEquipo = new JList();
		list_JugadoresEquipo.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		pScrollPane.add(list_JugadoresEquipo, BorderLayout.CENTER);
		modelo = new DefaultListModel(); 
		
		panel_1 = new JPanel();
		panel_1.setBounds(968, 124, 266, 162);
		panel_central.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		pScrollPane_1 = new JPanel();
		pScrollPane.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(pScrollPane_1);
		pScrollPane_1.setLayout(new BorderLayout(0, 0));
		
		list_JugadoresAnyadir = new JList();
		list_JugadoresAnyadir.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		pScrollPane_1.add(list_JugadoresAnyadir, BorderLayout.CENTER);
		modelo2 = new DefaultListModel(); 
		
		btnEliminar = new JButton(">>");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EliminarJugadores();
			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		btnEliminar.setBackground(new Color(0, 128, 0));
		btnEliminar.setBounds(878, 151, 69, 38);
		panel_central.add(btnEliminar);
		
		btnAnyadir = new JButton("<<");
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AnyadirJugadores();
			}
		});
		btnAnyadir.setForeground(Color.WHITE);
		btnAnyadir.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		btnAnyadir.setBackground(new Color(0, 128, 0));
		btnAnyadir.setBounds(878, 222, 69, 38);
		panel_central.add(btnAnyadir);
		
		JLabel lblSeleccioneLosJugadores = new JLabel("Seleccione los jugadores que quiera anyadir:");
		lblSeleccioneLosJugadores.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblSeleccioneLosJugadores.setBounds(958, 92, 320, 26);
		panel_central.add(lblSeleccioneLosJugadores);
		
		lblBalones = new JLabel("Balones");
		lblBalones.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblBalones.setBounds(612, 313, 69, 20);
		panel_central.add(lblBalones);
		
		lblConos = new JLabel("Conos");
		lblConos.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblConos.setBounds(612, 457, 69, 20);
		panel_central.add(lblConos);
		
		lblBarreras = new JLabel("Barreras");
		lblBarreras.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblBarreras.setBounds(612, 364, 69, 20);
		panel_central.add(lblBarreras);
		
		lblPicas = new JLabel("Picas");
		lblPicas.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblPicas.setBounds(878, 364, 69, 20);
		panel_central.add(lblPicas);
		
		lblBotellas = new JLabel("Botellas");
		lblBotellas.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblBotellas.setBounds(612, 411, 69, 20);
		panel_central.add(lblBotellas);
		
		lblPetos = new JLabel("Petos");
		lblPetos.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblPetos.setBounds(878, 313, 69, 20);
		panel_central.add(lblPetos);
		
		lblVallas = new JLabel("Vallas");
		lblVallas.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblVallas.setBounds(878, 411, 69, 20);
		panel_central.add(lblVallas);
		
		textFieldBalones = new JTextField();
		textFieldBalones.setBounds(719, 311, 109, 26);
		panel_central.add(textFieldBalones);
		textFieldBalones.setColumns(10);
		
		textFieldBarreras = new JTextField();
		textFieldBarreras.setBounds(719, 362, 109, 26);
		panel_central.add(textFieldBarreras);
		textFieldBarreras.setColumns(10);
		
		textFieldBotellas = new JTextField();
		textFieldBotellas.setBounds(719, 409, 109, 26);
		panel_central.add(textFieldBotellas);
		textFieldBotellas.setColumns(10);
		
		textFieldConos = new JTextField();
		textFieldConos.setBounds(719, 455, 109, 26);
		panel_central.add(textFieldConos);
		textFieldConos.setColumns(10);
		
		textFieldPetos = new JTextField();
		textFieldPetos.setBounds(968, 311, 109, 26);
		panel_central.add(textFieldPetos);
		textFieldPetos.setColumns(10);
		
		textFieldPicas = new JTextField();
		textFieldPicas.setBounds(968, 362, 109, 26);
		panel_central.add(textFieldPicas);
		textFieldPicas.setColumns(10);
		
		textFieldVallas = new JTextField();
		textFieldVallas.setBounds(968, 409, 109, 26);
		panel_central.add(textFieldVallas);
		textFieldVallas.setColumns(10);
		new DefaultListModel(); 

	}
	/**
	 * Se visualizan los equipos disponibles
	 */
	public void VisualizarEquipos()
	{
		comboEquipo.removeAllItems();
		Lista_Equipos.clear();
		try {
			Lista_Equipos=controller.getEquiposFilter((Categoria)comboCategoria.getSelectedItem());
			for(Equipo e:Lista_Equipos)
			{
				comboEquipo.addItem(e.toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Se muestra la informacion del equipo
	 * @throws RemoteException
	 */
	public void MostrarInformacion() throws RemoteException
	{
		textFieldBalones.setText("0");
		textFieldBarreras.setText("0");
		textFieldBotellas.setText("0");
		textFieldConos.setText("0");
		textFieldPetos.setText("0");
		textFieldPicas.setText("0");
		textFieldVallas.setText("0");
		list_JugadoresEquipo.removeAll();
		list_JugadoresAnyadir.removeAll();
		modelo.removeAllElements();
		modelo2.removeAllElements();
		if (Lista_Equipos.size()==0)return;
		else
		{
			Lista_Jugadores.clear();
			try 
			{
				Lista_Jugadores=controller.MostrarJugadores((Categoria)comboCategoria.getSelectedItem());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(Equipo e: Lista_Equipos)
			{
				if(e.toString().equals(comboEquipo.getSelectedItem().toString()))
				{
					lblNombreEquipo.setText(e.getNombre());
					inventario=e.getInventario();
					try 
					{
						Lista_Material=controller.getMaterial();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for(Material m:Lista_Material)
					{
					if(inventario.containsKey(m))
					{
						if(m.getTipo().toString().equals("Balones"))
						{
							textFieldBalones.setText(inventario.get(m).toString());
						}
						if(m.getTipo().toString().equals("Barreras"))
						{
							textFieldBarreras.setText(inventario.get(m).toString());
						}
						if(m.getTipo().toString().equals("Botellas"))
						{
							textFieldBotellas.setText(inventario.get(m).toString());
						}
						if(m.getTipo().toString().equals("Conos"))
						{
							textFieldConos.setText(inventario.get(m).toString());
						}
						if(m.getTipo().toString().equals("Petos"))
						{
							textFieldPetos.setText(inventario.get(m).toString());
						}
						if(m.getTipo().toString().equals("Picas"))
						{
							textFieldPicas.setText(inventario.get(m).toString());
						}
						if(m.getTipo().toString().equals("Vallas"))
						{
							textFieldVallas.setText(inventario.get(m).toString());
						}
					}
					}
					List <Jugador> jugadores = controller.equipoJugadores(e);
					jugadores.forEach(q->modelo.addElement(q));
					list_JugadoresEquipo.setModel(modelo);
					pScrollPane.repaint();
					
				}

			}
			for(Jugador j: Lista_Jugadores)
			{
				modelo2.addElement(j);
			}
			list_JugadoresAnyadir.setModel(modelo2);
			pScrollPane_1.repaint();
		}
	}
	/**
	 * Se anyaden los jugadores seleccionados
	 */
	public void AnyadirJugadores()
	{
		//falta joptionpane si no hay ninguno seleccionado o por defecto que se seleccione uno
		Jugador anyadido = (Jugador) list_JugadoresAnyadir.getSelectedValue();
		modelo2.remove(list_JugadoresAnyadir.getSelectedIndex());
		list_JugadoresAnyadir.removeAll();
		list_JugadoresAnyadir.setModel(modelo2);
		pScrollPane_1.repaint();

		modelo.addElement(anyadido);
		list_JugadoresEquipo.setModel(modelo);
		pScrollPane.repaint();			
	}
	/**
	 * Se eliminan los jugadores seleccionados
	 */
	public void EliminarJugadores()
	{
		//falta joptionpane si no hay ninguno seleccionado o por defecto que se seleccione uno
		Jugador eliminado = (Jugador) list_JugadoresEquipo.getSelectedValue();
		modelo.remove(list_JugadoresEquipo.getSelectedIndex());
		list_JugadoresEquipo.removeAll();
		list_JugadoresEquipo.setModel(modelo);
		pScrollPane.repaint();

		modelo2.addElement(eliminado);
		list_JugadoresAnyadir.setModel(modelo2);
		pScrollPane_1.repaint();
	}
	/**
	 * Se guardan los cambios efectuados
	 * @throws RemoteException
	 */
	public void Guardar() throws RemoteException
	{
		Equipo equipo= null;
		List<Integer> cantidadMaterial=ActualizarMaterial();
		for(Equipo e: Lista_Equipos)
		{
		if(comboEquipo.getSelectedItem().toString().equals(e.toString()))
		{
			equipo= e;
		}
		}
		for(Material m:Lista_Material)
		{
			if(m.getTipo().toString().equals("Balones"))
			{
				inventario.put(m, cantidadMaterial.get(0));
			}
			if(m.getTipo().toString().equals("Barreras"))
			{
				inventario.put(m, cantidadMaterial.get(0));
			}
			if(m.getTipo().toString().equals("Botellas"))
			{
				inventario.put(m, cantidadMaterial.get(0));
			}
			if(m.getTipo().toString().equals("Conos"))
			{
				inventario.put(m, cantidadMaterial.get(0));
			}
			if(m.getTipo().toString().equals("Petos"))
			{
				inventario.put(m, cantidadMaterial.get(0));
			}
			if(m.getTipo().toString().equals("Picas"))
			{
				inventario.put(m, cantidadMaterial.get(0));
			}
			if(m.getTipo().toString().equals("Vallas"))
			{
				inventario.put(m, cantidadMaterial.get(0));
			}
			
		
		}
			
		for(int i = 0 ; i < modelo2.size();i++)
		{
			Lista_Jugadores.add((Jugador) (list_JugadoresAnyadir.getModel().getElementAt(i)));
			
		}
		

		Lista_Jugadores.clear();
		for(int i = 0 ; i < modelo.size();i++)
		{
			Lista_Jugadores.add((Jugador) (list_JugadoresEquipo.getModel().getElementAt(i)));
			
		}
		try 
		{
			controller.ActualizarEquipo(equipo, inventario, Lista_Jugadores);
			MostrarInformacion();
		} 
		catch (RemoteException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Se actualiza el material del equipo con los cambios efectuados
	 * @return la lista del material actualizada
	 * @throws RemoteException
	 */
	public List<Integer> ActualizarMaterial() throws RemoteException
	{
		int balones=Integer.parseInt(textFieldBalones.getText());
		int barreras=Integer.parseInt(textFieldBarreras.getText());
		int botellas=Integer.parseInt(textFieldBotellas.getText());
		int conos=Integer.parseInt(textFieldConos.getText());
		int petos=Integer.parseInt(textFieldPetos.getText());
		int picas=Integer.parseInt(textFieldPicas.getText());
		int vallas=Integer.parseInt(textFieldVallas.getText());

		List<Integer> material = new ArrayList();
		material.add(0, balones);;
		material.add(1, barreras);
		material.add(2, botellas);
		material.add(3,conos);
		material.add(4,petos);
		material.add(5,picas);
		material.add(6, vallas);
			
		for (Material m: Lista_Material)
		{
			if(m.getTipo().toString().equals("Balones"))
			{
				if(balones != 0 || balones <= m.getCantidad())
				{
					balones = m.getCantidad()-balones;
					m.setCantidad(balones);
				}
				else if (balones ==0)
				{
					balones = m.getCantidad();
					m.setCantidad(balones);
				}
				else if(balones>m.getCantidad())
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de balones");
					MostrarInformacion();
				}
			}
			if(m.getTipo().toString().equals("Barreras"))
			{
				if(barreras != 0 || barreras <= m.getCantidad())
				{
					barreras = m.getCantidad()-barreras;
					m.setCantidad(barreras);
				}
				else if(barreras == 0)
				{
					barreras = m.getCantidad();
					m.setCantidad(barreras);
				}
				else if(barreras>m.getCantidad())
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de barreras");
					MostrarInformacion();
				}
					
			}
			if(m.getTipo().toString().equals("Botellas"))
			{
				if(botellas != 0 || botellas <= m.getCantidad())
				{
					botellas = m.getCantidad()-botellas;
					m.setCantidad(botellas);
				}
				else if(botellas == 0)
				{
					botellas = m.getCantidad();
					m.setCantidad(botellas);
				}
				else if(botellas>m.getCantidad())
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de botellas");
					MostrarInformacion();
				}
				
			}
			if(m.getTipo().toString().equals("Conos"))
			{
				if(conos != 0 || conos <= m.getCantidad())
				{
					conos = m.getCantidad()-conos;
					m.setCantidad(conos);
				}
				else if(conos == 0)
				{
					conos = m.getCantidad();
					m.setCantidad(conos);
				}
				else if(conos>m.getCantidad())
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de conos");
					MostrarInformacion();
				}
			}if(m.getTipo().toString().equals("Petos"))
			{
				if(petos != 0 || petos <= m.getCantidad())
				{
					petos = m.getCantidad()-petos;
					m.setCantidad(petos);
				}
				else if(petos == 0)
				{
					petos = m.getCantidad();
					m.setCantidad(petos);
				}
				else if(petos>m.getCantidad())
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de petos");
					MostrarInformacion();
				}
			}if(m.getTipo().toString().equals("Picas"))
			{
				if(picas != 0 || picas <= m.getCantidad())
				{
					picas = m.getCantidad()-picas;
					m.setCantidad(picas);
				}
				else if(picas == 0)
				{
					picas = m.getCantidad();
					m.setCantidad(picas);
				}
				else if(picas>m.getCantidad())
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de picas");
					MostrarInformacion();
				}
				
			}
			if(m.getTipo().toString().equals("Vallas"))
			{
				if(vallas != 0 || vallas <= m.getCantidad())
				{
					vallas = m.getCantidad()-vallas;
					m.setCantidad(vallas);
				}
				else if(vallas == 0)
				{
					vallas = m.getCantidad();
					m.setCantidad(vallas);
				}
				else if(vallas>m.getCantidad())
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de vallas");
					MostrarInformacion();
				}
			}	
		}
		for(Material mat: Lista_Material )
		{
			try {
				controller.AsignarInventario(mat);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return material;
		
		
		
	}

}



