package Aprendices_de_Josuka.LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LN.Gestor;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
	private JComboBox comboCategoria;
	private JComboBox comboEquipo;
	private JLabel lblNombreEquipo;
	private JScrollPane scrollPane;
	private JPanel pScrollPane;
	private JList list_JugadoresEquipo;
	private JList list_JugadoresAnyadir;
	private DefaultListModel modelo;
	private DefaultListModel modelo2;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JPanel pScrollPane_1;
	private DefaultListModel modelo_categoria;
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


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarEquipo frame = new EditarEquipo();
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
	public EditarEquipo() {
		initComponents();
		this.setVisible(true);
	}

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
				
				Principal_Administrador pa= new Principal_Administrador();
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
		btnAnyadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RegistrarEquipo r = new RegistrarEquipo();
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
			public void actionPerformed(ActionEvent e) 
			{
				Guardar();
			}
		});
		btnAceptar.setBounds(1138, 437, 125, 38);
		panel_central.add(btnAceptar);
		
		JLabel lblSeleccioneCategoria = new JLabel("Seleccione la categoria");
		lblSeleccioneCategoria.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblSeleccioneCategoria.setBounds(343, 16, 182, 20);
		panel_central.add(lblSeleccioneCategoria);
		
		comboCategoria = new JComboBox();
		comboCategoria.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		comboCategoria.setBounds(547, 13, 246, 26);
		panel_central.add(comboCategoria);
		comboCategoria.addItem(Categoria.ALEVIN);
		comboCategoria.addItem(Categoria.INFANTIL);
		comboCategoria.addItem(Categoria.CADETE);
		comboCategoria.addItem(Categoria.JUVENIL);
		comboCategoria.addItem(Categoria.SENIOR);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		lblNombre.setBounds(944, 28, 69, 20);
		panel_central.add(lblNombre);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
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
				MostrarInformacion();
				panel_izquierdo.repaint();
			}
		});
		btnGO2.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnGO2.setBounds(816, 48, 69, 29);
		panel_central.add(btnGO2);
		
		comboEquipo = new JComboBox();
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
		modelo_categoria=new DefaultListModel(); 

	}
	
	public void VisualizarEquipos()
	{
		comboEquipo.removeAllItems();
		Lista_Equipos.clear();
		try {
			Lista_Equipos=Gestor.getInstance().getEquiposFilter((Categoria)comboCategoria.getSelectedItem());
			for(Equipo e:Lista_Equipos)
			{
				comboEquipo.addItem(e.toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void MostrarInformacion()
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
				Lista_Jugadores=Gestor.getInstance().MostrarJugadores((Categoria)comboCategoria.getSelectedItem());
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
						Lista_Material=Gestor.getInstance().ObtenerMaterial();
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
					e.getLista_jugador().forEach(j->modelo.addElement(j));
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
	public void Guardar()
	{
		Equipo equipo=new Equipo("", null, null, null, null);
		for(int i=0;i<Lista_Equipos.size();i++)
		{
		if(comboEquipo.getSelectedItem().toString().equals(Lista_Equipos.get(i).getNombre()))
		{
			equipo= Lista_Equipos.get(i);
		}
		}
		System.out.println(equipo.toString());
		for(Material m:Lista_Material)
		{
			if(equipo.getInventario().containsKey(m))
			{
			if(m.getTipo().toString().equals("Balones"))
			{
				int totalBalones=m.getCantidad();
				long precio=0;
				int balones=Integer.parseInt(textFieldBalones.getText());
				System.out.println(equipo.getInventario().get(m));
				System.out.println(balones);
				if(balones<=totalBalones ||equipo.getInventario().get(m)==balones||balones==0)
				{
					System.out.println(equipo.getInventario().get(m));
					inventario.put(m, equipo.getInventario().get(m));
					precio=m.getPrecio();
					try 
					{
						Gestor.getInstance().ActualizarMaterial(m.getTipo(), totalBalones, precio);
					} catch (RemoteException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(equipo.getInventario().get(m)!=balones)
				{
				totalBalones=totalBalones-balones;
				precio=(totalBalones*m.getPrecio())/m.getCantidad();
				try 
				{
					Gestor.getInstance().ActualizarMaterial(m.getTipo(), totalBalones, precio);
				} catch (RemoteException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				
				else 
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de balones");
					MostrarInformacion();
					return;
				}
			}
			
			if(m.getTipo().toString().equals("Barreras"))
			{
				int totalBarreras=m.getCantidad();
				long precio=0;
				int barreras=Integer.parseInt(textFieldBarreras.getText());
				if(barreras<=totalBarreras ||equipo.getInventario().get(m)==barreras||barreras==0)
				{
					inventario.put(m, equipo.getInventario().get(m));
					precio=m.getPrecio();
				
				if(equipo.getInventario().get(m)!=barreras)
				{
				totalBarreras=totalBarreras-barreras;
				precio=(totalBarreras*m.getPrecio())/m.getCantidad();
				}
				
				try 
				{
					Gestor.getInstance().ActualizarMaterial(m.getTipo(), totalBarreras, precio);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de barreras");
					MostrarInformacion();
					return;
				}
			}
			if(m.getTipo().toString().equals("Botellas"))
			{
				int totalBotellas=m.getCantidad();
				long precio=0;
				int botellas=Integer.parseInt(textFieldBotellas.getText());
				if(botellas<=totalBotellas ||equipo.getInventario().get(m)==botellas||botellas==0)
				{
					inventario.put(m, equipo.getInventario().get(m));
					precio=m.getPrecio();
				
				if(equipo.getInventario().get(m)!=botellas)
				{
					totalBotellas=totalBotellas-botellas;
					precio=(totalBotellas*m.getPrecio())/m.getCantidad();
				}
				
				try 
				{
					Gestor.getInstance().ActualizarMaterial(m.getTipo(), totalBotellas, precio);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de botellas");
					MostrarInformacion();
					return;
				}
			}
			if(m.getTipo().toString().equals("Conos"))
			{
				int totalConos=m.getCantidad();
				long precio=0;
				int conos=Integer.parseInt(textFieldConos.getText());
				if(conos<=totalConos ||equipo.getInventario().get(m)==conos||conos==0)
				{
					inventario.put(m, equipo.getInventario().get(m));
					precio=m.getPrecio();
				
				if(equipo.getInventario().get(m)!= conos)
				{
					totalConos=totalConos-conos;
				precio=(totalConos*m.getPrecio())/m.getCantidad();
				}
				
				try 
				{
					Gestor.getInstance().ActualizarMaterial(m.getTipo(), totalConos, precio);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de botellas");
					MostrarInformacion();
					return;
				}
			}
			if(m.getTipo().toString().equals("Petos"))
			{
				int totalPetos=m.getCantidad();
				long precio=0;
				int petos=Integer.parseInt(textFieldPetos.getText());
				if(petos<=totalPetos ||equipo.getInventario().get(m)==petos||petos==0)
				{
					inventario.put(m, equipo.getInventario().get(m));
					precio=m.getPrecio();
				
				if(equipo.getInventario().get(m)!=petos)
				{
					totalPetos=totalPetos-petos;
				precio=(totalPetos*m.getPrecio())/m.getCantidad();
				}
				
				try 
				{
					Gestor.getInstance().ActualizarMaterial(m.getTipo(), totalPetos, precio);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de petos");
					MostrarInformacion();
					return;
				}
			}
			if(m.getTipo().toString().equals("Picas"))
			{
				int totalPicas=m.getCantidad();
				long precio=0;
				int picas=Integer.parseInt(textFieldPicas.getText());
				if(picas<=totalPicas ||equipo.getInventario().get(m)==picas||picas==0)
				{
					inventario.put(m, equipo.getInventario().get(m));
					precio=m.getPrecio();
				
				if(equipo.getInventario().get(m)!=picas)
				{
					totalPicas=totalPicas-picas;
				precio=(totalPicas*m.getPrecio())/m.getCantidad();
				}
				
				try 
				{
					Gestor.getInstance().ActualizarMaterial(m.getTipo(), totalPicas, precio);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de picas");
					MostrarInformacion();
					return;
				}
			}
			if(m.getTipo().toString().equals("Vallas"))
			{
				int totalVallas=m.getCantidad();
				long precio=0;
				int vallas=Integer.parseInt(textFieldVallas.getText());
				if(vallas<=totalVallas ||equipo.getInventario().get(m)==vallas||vallas==0)
				{
					inventario.put(m, equipo.getInventario().get(m));
					precio=m.getPrecio();
				
				if(equipo.getInventario().get(m)!=vallas)
				{
					totalVallas=totalVallas-vallas;
				precio=(totalVallas*m.getPrecio())/m.getCantidad();
				}
				
				try 
				{
					Gestor.getInstance().ActualizarMaterial(m.getTipo(), totalVallas, precio);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Introduce una cantidad menor de vallas");
					MostrarInformacion();
					return;
				}
			}
			}
			
		}
			
		for(int i = 0 ; i < modelo2.size();i++)
		{
			Lista_Jugadores.add((Jugador) (list_JugadoresAnyadir.getModel().getElementAt(i)));
		}
		for(Jugador j: Lista_Jugadores )
		{
			j.setAsignado_equipo(false);
		}

		Lista_Jugadores.clear();
		for(int i = 0 ; i < modelo.size();i++)
		{
			Lista_Jugadores.add((Jugador) (list_JugadoresEquipo.getModel().getElementAt(i)));
		}
		for(Jugador j: Lista_Jugadores )
		{
			j.setAsignado_equipo(true);
		}
		try 
		{
			for(Material m:Lista_Material)
			{
			System.out.println(inventario.get(m));
			}
			Gestor.getInstance().ActualizarEquipo(equipo, inventario, Lista_Jugadores);
			MostrarInformacion();
		} 
		catch (RemoteException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
//	public void EliminarJugadores2()
//	{
//		System.out.println("e modelo1: " + modelo.size());
//		System.out.println("e modelo2: " + modelo2.size());
//		Jugador eliminado = null;
//		for(Equipo e: Lista_Equipos)
//		{
//			if(e.toString().equals(comboEquipo.getSelectedItem().toString()))
//			{
//				for(int i = 0; i<modelo.size();i++)
//				{
//				if(modelo.get(list_JugadoresEquipo.getSelectedIndex()).equals(e.getLista_jugador().get(i)))
//				{
//				eliminado =e.getLista_jugador().get(i);
//				}
//				}
//			}
//		}
//		modelo.remove(list_JugadoresEquipo.getSelectedIndex());
//		list_JugadoresEquipo.removeAll();
//		list_JugadoresEquipo.setModel(modelo);
//		pScrollPane.repaint();
//
//		modelo2.addElement(eliminado);
//		list_JugadoresAnyadir.setModel(modelo2);
//		pScrollPane_1.repaint();
//	}


