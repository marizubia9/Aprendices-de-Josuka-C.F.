package Aprendices_de_Josuka.LP;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import DAO.DAO;
import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LN.Gestor;
import Controller.Controller;

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

public class Visualizar_Equipos_Jugador extends JFrame {

	private JPanel contentPane;
	private JLabel txtLosAprendicesDe;
	private JPanel panel_central;
	private JPanel panel_izquierdo;
	private JButton btnHome;
	private JButton btnVisualizarJugador;
	private JButton btnVisualziarEquipo;
	private JButton btnEditarJugador;
	private JButton btnGO;
	private JComboBox<Categoria> comboCategoria;
	private JLabel lblCategoria;
	private JPanel pScrollPaneJ;
	private JComboBox<String> comboEquipos;
	private List<Equipo>Lista_Equipos;
	private JScrollPane scrollPaneJ;
	private JScrollPane scrollPane_i;
	private JPanel panel_i;
	private JPanel pScrollPane_i ;
	private JLabel lbl_Entrenador;
	private JButton btnVerEstadisticas;
	private JButton btnClasificacion;
	private Controller controller; 
	private Jugador j;
	
	
	public Visualizar_Equipos_Jugador(Controller controller, Jugador j) throws RemoteException, ParseException 
	{
		this.j = j;
		this.controller=controller;
		initComponents();
		this.setVisible(true);
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 1300, 740);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_superior = new JPanel();
		panel_superior.setBounds(0, 0, 1278, 189);
		panel_superior.setBackground(new Color(0, 102, 0));
		contentPane.add(panel_superior);
		panel_superior.setLayout(null);

		txtLosAprendicesDe = new JLabel();
		txtLosAprendicesDe.setBackground(new Color(0, 102, 0));
		txtLosAprendicesDe.setForeground(Color.WHITE);
		txtLosAprendicesDe.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 40));
		txtLosAprendicesDe.setText("LOS APRENDICES DE JOSUKA C.F.");
		txtLosAprendicesDe.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtLosAprendicesDe.setBounds(46, 57, 702, 89);
		panel_superior.add(txtLosAprendicesDe);

		JPanel panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_central.setBounds(0, 187, 1278, 497);
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
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnHome.setBackground(new Color(0, 102, 0));
		btnHome.setBounds(0, 0, 328, 42);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Principal_Jugador a = null;
				try {
					a = new Principal_Jugador(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				a.setVisible(true);
			}
		});
		panel_izquierdo.add(btnHome);
		
		btnVerEstadisticas = new JButton("VER ESTADISTICAS");
		btnVerEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				Estadisticas es = null;
				try {
					es = new Estadisticas(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				es.setVisible(true);
				setVisible(false);

			}
		});
		btnVerEstadisticas.setHorizontalAlignment(SwingConstants.LEFT);
		btnVerEstadisticas.setForeground(Color.WHITE);
		btnVerEstadisticas.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVerEstadisticas.setBackground(new Color(0, 102, 0));
		btnVerEstadisticas.setBounds(0, 40, 328, 42);
		panel_izquierdo.add(btnVerEstadisticas);
		
		btnClasificacion = new JButton("VER CLASIFICACION");
		btnClasificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				Clasificacion_Jugador r = null;
				try {
					r = new Clasificacion_Jugador(controller, j);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
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
		btnClasificacion.setBounds(0, 81, 328, 42);
		panel_izquierdo.add(btnClasificacion);
		
		btnVisualizarJugador = new JButton("VER FICHA");
		btnVisualizarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarJugador.setForeground(Color.WHITE);
		btnVisualizarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarJugador.setBackground(new Color(0, 102, 0));
		btnVisualizarJugador.setBounds(0, 202, 328, 42);
		
		btnVisualizarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FichaJugador f = null;
				try {
					f = new FichaJugador(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				f.setVisible(true);
				setVisible(false);
			}
		});
		panel_izquierdo.add(btnVisualizarJugador);
				
		btnVisualziarEquipo = new JButton("VISUALIZAR  EQUIPOS");
		btnVisualziarEquipo.setEnabled(false);
		btnVisualziarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualziarEquipo.setForeground(Color.WHITE);
		btnVisualziarEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualziarEquipo.setBackground(new Color(0, 102, 0));
		btnVisualziarEquipo.setBounds(0, 162, 328, 42);
		panel_izquierdo.add(btnVisualziarEquipo);
		
		
		btnEditarJugador = new JButton("EDITAR JUGADOR");
		btnEditarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EditarDatos ed = null;
				try {
					ed = new EditarDatos(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ed.setVisible(true);
				setVisible(false);

			}
		});
		btnEditarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarJugador.setForeground(Color.WHITE);
		btnEditarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarJugador.setBackground(new Color(0, 102, 0));
		btnEditarJugador.setBounds(0, 120, 328, 42);
		panel_izquierdo.add(btnEditarJugador);
		
		btnGO = new JButton("GO!");
		btnGO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RellenarCombo();
			}
		});
		btnGO.setBounds(669, 11, 68, 38);
		panel_central.add(btnGO);
		
		comboCategoria = new JComboBox<Categoria>();
		comboCategoria.addItem(Categoria.ALEVIN);
		comboCategoria.addItem(Categoria.INFANTIL);
		comboCategoria.addItem(Categoria.CADETE);
		comboCategoria.addItem(Categoria.JUVENIL);
		comboCategoria.addItem(Categoria.SENIOR);
		comboCategoria.setBounds(543, 17, 109, 26);
		panel_central.add(comboCategoria);
		
		lblCategoria = new JLabel("Selecciona una categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lblCategoria.setBounds(338, 17, 185, 26);
		panel_central.add(lblCategoria);
		
		pScrollPaneJ = new JPanel();
		pScrollPaneJ.setBounds(465, 239, 227, 241);
		panel_central.add(pScrollPaneJ);
		pScrollPaneJ.setLayout(new BorderLayout(0, 0));
		
		scrollPaneJ = new JScrollPane();
		pScrollPaneJ.add(scrollPaneJ, BorderLayout.CENTER);
		
		JPanel panel_J = new JPanel();
		scrollPaneJ.setViewportView(panel_J);
		
		JLabel lblEquipo = new JLabel("Selecciona un equipo:");
		lblEquipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEquipo.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lblEquipo.setBounds(338, 64, 185, 26);
		panel_central.add(lblEquipo);
		
		comboEquipos = new JComboBox<String>();
		comboEquipos.setBounds(543, 66, 109, 26);
		panel_central.add(comboEquipos);
		
		
		JButton btnGO2 = new JButton("GO!");
		btnGO2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarJugadores();
				MostrarInventario();
			}
		});
		btnGO2.setBounds(669, 60, 68, 38);
		panel_central.add(btnGO2);
		


		
		JLabel lblEntrenador = new JLabel("Entrenador:");
		lblEntrenador.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lblEntrenador.setBounds(371, 169, 109, 32);
		panel_central.add(lblEntrenador);
		
		lbl_Entrenador = new JLabel();
		lbl_Entrenador.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lbl_Entrenador.setBounds(465, 172, 299, 26);
		panel_central.add(lbl_Entrenador);
		
		JLabel lblJugadores = new JLabel("Jugadores:");
		lblJugadores.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lblJugadores.setBounds(371, 212, 109, 32);
		panel_central.add(lblJugadores);
		
		JLabel lblInventario = new JLabel("Inventario:");
		lblInventario.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lblInventario.setBounds(814, 215, 88, 26);
		panel_central.add(lblInventario);
		
		pScrollPane_i = new JPanel();
		pScrollPane_i.setBounds(895, 239, 227, 241);
		panel_central.add(pScrollPane_i);
		pScrollPane_i.setLayout(new BorderLayout(0, 0));
		
		scrollPane_i = new JScrollPane();
		pScrollPane_i.add(scrollPane_i, BorderLayout.CENTER);
		
		panel_i = new JPanel();
		scrollPane_i.setViewportView(panel_i);
	
	}
	
	public void RellenarCombo()
	{
		
		try {
			Lista_Equipos=controller.getEquipos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Lista_Equipos.forEach(e->
		{
			if(e.getCategoria().equals((Categoria)comboCategoria.getSelectedItem())) comboEquipos.addItem(e.getNombre());
		});
	}
	
	public void MostrarJugadores()
	{
		
		Equipo e=null;
		for(Equipo a:Lista_Equipos)
		{
			if(a.getNombre().equals(comboEquipos.getSelectedItem().toString())) 
				e=a; 
		}
		lbl_Entrenador.setText(e.getEntrenador().toString());
		ArrayList <String> ListaNombres= new ArrayList<String>();
		e.getLista_jugador().forEach(a->ListaNombres.add(a.toString()));
		JList<String> JListaJugadores=new JList<String>(ListaNombres.toArray(new String[ListaNombres.size()]));
		scrollPaneJ.setViewportView(JListaJugadores);
		JListaJugadores.setLayoutOrientation(JList.VERTICAL);
		scrollPaneJ.repaint();
		pScrollPaneJ.repaint();
		panel_central.repaint();
		
	}
	
	public void MostrarInventario()
	{
		Equipo e=null;
		for(Equipo a:Lista_Equipos)
		{
			if(a.getNombre().equals(comboEquipos.getSelectedItem())) 
				e=a; 
		}
		ArrayList <String> ListaNombres= new ArrayList<String>();
		e.getInventario().forEach((m,c)->ListaNombres.add(c+" "+m.getTipo()));
		JList<String> JListaInventario=new JList<String>(ListaNombres.toArray(new String[ListaNombres.size()]));
		scrollPane_i.setViewportView(JListaInventario);
		JListaInventario.setLayoutOrientation(JList.VERTICAL);
		scrollPane_i.repaint();
		pScrollPane_i.repaint();
		panel_central.repaint();
		
		
		
	}
}