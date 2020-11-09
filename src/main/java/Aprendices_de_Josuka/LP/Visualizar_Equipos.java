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
import java.awt.LayoutManager;
import javax.swing.SwingConstants;

public class Visualizar_Equipos extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JLabel lblListaJugadores;
	private JPanel panel_central;
	private List<Jugador> ListaJugadores;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnAnyadirEquipo;
	private JButton btnAnyadirInventario;
	private JButton btnVisualizarJugadores;
	private JButton btnVisualizarEntrenadores;
	private JButton btnVisualizarEquipos;
	private JButton btnGO;
	private JComboBox comboCategoria;
	private JLabel lblCategoria;
	private JLabel lblCategoria_sel;
	private JPanel pExterior;
	private JScrollPane scrollPane;
	private JPanel pScrollPane;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualizar_Equipos frame = new Visualizar_Equipos();
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
	public Visualizar_Equipos() {
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
				RegistrarMaterial r= new RegistrarMaterial();
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
		btnVisualizarEquipos.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEquipos.setForeground(Color.WHITE);
		btnVisualizarEquipos.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEquipos.setBackground(new Color(0, 102, 0));
		btnVisualizarEquipos.setBounds(0, 290, 328, 58);
		panel.add(btnVisualizarEquipos);
		
		btnGO = new JButton("GO!");
		btnGO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarJugadores();
			}
		});
		btnGO.setBounds(1212, 33, 68, 38);
		panel_central.add(btnGO);
		
		comboCategoria = new JComboBox();
		comboCategoria.addItem(Categoria.ALEVIN);
		comboCategoria.addItem(Categoria.INFANTIL);
		comboCategoria.addItem(Categoria.CADETE);
		comboCategoria.addItem(Categoria.JUVENIL);
		comboCategoria.addItem(Categoria.SENIOR);
		comboCategoria.setBounds(1086, 39, 109, 26);
		panel_central.add(comboCategoria);
		
		lblCategoria = new JLabel("Selecciona una categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lblCategoria.setBounds(881, 39, 185, 26);
		panel_central.add(lblCategoria);
		
		pExterior = new JPanel();
		pExterior.setBounds(684, 209, 300, 394);
		panel_central.add(pExterior);
		pExterior.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 300, 394);
		pExterior.add(scrollPane);
		
		pScrollPane = new JPanel();
		scrollPane.setViewportView(pScrollPane);
		
		
		
		
		
	}
	
	public void MostrarJugadores()
	{
		String cat=null;
		if(((Categoria)comboCategoria.getSelectedItem()).equals(Categoria.ALEVIN)) cat="ALEVIN";
		if(((Categoria)comboCategoria.getSelectedItem()).equals(Categoria.INFANTIL)) cat="INFANTIL";
		if(((Categoria)comboCategoria.getSelectedItem()).equals(Categoria.CADETE)) cat="CADETE";
		if(((Categoria)comboCategoria.getSelectedItem()).equals(Categoria.JUVENIL)) cat="JUVENIL";
		if(((Categoria)comboCategoria.getSelectedItem()).equals(Categoria.SENIOR)) cat="SENIOR";
		
		lblCategoria_sel = new JLabel();
		lblCategoria_sel.setBounds(654, 94, 228, 45);
		panel_central.add(lblCategoria_sel);
		
		
		
		try {
			ListaJugadores=Gestor.getInstance().MostrarJugadores((Categoria)comboCategoria.getSelectedItem());
			ArrayList <String> ListaNombres= new ArrayList();
			
			for(Jugador a: ListaJugadores)
			{
				String nombre_completo=a.getNombre()+" "+a.getApellido();
				ListaNombres.add(nombre_completo);
			}
			JList JListaJugadores=new JList<String>(ListaNombres.toArray(new String[ListaNombres.size()]));
			scrollPane.setViewportView(JListaJugadores);
			JListaJugadores.setLayoutOrientation(JList.VERTICAL);
			scrollPane.repaint();
			pExterior.repaint();
//			
//			ListaJugadores.clear();
//			ListaJugadores=Gestor.getInstance().MostrarJugadores(Categoria.INFANTIL);
//			JListaJugadoresInfantil = new JList<String>();
//			scrollPane_JugadoresInfantil.setViewportView(JListaJugadoresInfantil);
//			JListaJugadoresInfantil.setLayoutOrientation(JList.VERTICAL);
//			scrollPane_JugadoresInfantil.repaint();
//			panel_central.repaint();
//			
//			ListaJugadores.clear();
//			ListaJugadores=Gestor.getInstance().MostrarJugadores(Categoria.CADETE);
//			JListaJugadoresCadete = new JList<String>();
//			scrollPane_JugadoresCadete.setViewportView(JListaJugadoresCadete);
//			JListaJugadoresCadete.setLayoutOrientation(JList.VERTICAL);
//			scrollPane_JugadoresCadete.repaint();
//			panel_central.repaint();
//			
//			ListaJugadores.clear();
//			ListaJugadores=Gestor.getInstance().MostrarJugadores(Categoria.JUVENIL);
//			JListaJugadoresJuvenil = new JList<String>();
//			scrollPane_JugadoresJuvenil.setViewportView(JListaJugadoresJuvenil);
//			JListaJugadoresJuvenil.setLayoutOrientation(JList.VERTICAL);
//			scrollPane_JugadoresJuvenil.repaint();
//			panel_central.repaint();
//			
//			ListaJugadores.clear();
//			ListaJugadores=Gestor.getInstance().MostrarJugadores(Categoria.SENIOR);
//			JListaJugadoresSenior = new JList<String>();
//			scrollPane_JugadoresSenior.setViewportView(JListaJugadoresSenior);
//			JListaJugadoresSenior.setLayoutOrientation(JList.VERTICAL);
//			scrollPane_JugadoresSenior.repaint();
			panel_central.repaint();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
