package Aprendices_de_Josuka.LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
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
import Aprendices_de_Josuka.LN.Gestor;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class EditarEquipo extends JFrame{
	private JPanel contentPane;
	private JLabel lblLosAprendicesDe;
	private List<Equipo>Lista_Equipos;
	private List<String> Lista_Jugadores;
	
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
		panel_central.setBounds(0, 173, 1278, 528);
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
			public void actionPerformed(ActionEvent e) 
			{
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
		btnAceptar.setBounds(1138, 457, 125, 38);
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
		lblNombre.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblNombre.setBounds(495, 107, 69, 20);
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
				VisualizarJugadoresCategoria();
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
		lblNombreEquipo.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblNombreEquipo.setBounds(613, 122, 220, 26);
		panel_central.add(lblNombreEquipo);
		
		JLabel lblJugadores = new JLabel("Jugadores:");
		lblJugadores.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblJugadores.setBounds(509, 143, 88, 26);
		panel_central.add(lblJugadores);
		
		JLabel lblInventario = new JLabel("Inventario:");
		lblInventario.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblInventario.setBounds(509, 363, 88, 20);
		panel_central.add(lblInventario);
		
		JPanel panel = new JPanel();
		panel.setBounds(597, 185, 266, 162);
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
		panel_1.setBounds(971, 185, 266, 162);
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
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		btnEliminar.setBackground(new Color(0, 128, 0));
		btnEliminar.setBounds(878, 213, 69, 38);
		panel_central.add(btnEliminar);
		
		btnAnyadir = new JButton("<<");
		btnAnyadir.setForeground(Color.WHITE);
		btnAnyadir.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		btnAnyadir.setBackground(new Color(0, 128, 0));
		btnAnyadir.setBounds(878, 289, 69, 38);
		panel_central.add(btnAnyadir);
		
		JLabel lblSeleccioneLosJugadores = new JLabel("Seleccione los jugadores que quiera anyadir:");
		lblSeleccioneLosJugadores.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblSeleccioneLosJugadores.setBounds(958, 146, 320, 26);
		panel_central.add(lblSeleccioneLosJugadores);
		modelo_categoria=new DefaultListModel(); 

	}
	
	public void VisualizarEquipos()
	{
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
	
	public void VisualizarJugadoresCategoria()
	{
		if (Lista_Jugadores.size()!=0)
		{
		Lista_Jugadores.clear();
		}
		
		try 
		{
			
			for(Jugador a : Gestor.getInstance().MostrarJugadores((Categoria)comboCategoria.getSelectedItem()))
			{
				Lista_Jugadores.add(a.toString());
			}
		} catch (RemoteException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Lista_Jugadores.size() == 0)return;
		else
		{
		System.out.println("tamanyo de la lista" + Lista_Jugadores.size());
		Lista_Jugadores.forEach(j->modelo2.addElement(j));
		list_JugadoresAnyadir = new JList<String>(Lista_Jugadores.toArray(new String[Lista_Jugadores.size()]));
		list_JugadoresAnyadir.setModel(modelo2);
		pScrollPane_1.repaint();
		}
	}
	public void MostrarInformacion()
	{
		if (Lista_Equipos.size()==0)return;
		else{
			for(Equipo e: Lista_Equipos)
			{
				if(e.toString().equals(comboEquipo.getSelectedItem().toString()))
				{
					lblNombreEquipo.setText(e.getNombre());
					
					e.getLista_jugador().forEach(j->modelo.addElement(j));
					list_JugadoresEquipo.setModel(modelo);
					pScrollPane.repaint();
				}

			}
		}
	}
	
	public void Guardar()
	{
	
	}
}
