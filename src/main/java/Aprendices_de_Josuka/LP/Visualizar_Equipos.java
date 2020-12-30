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

public class Visualizar_Equipos extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JPanel panel_central;
	private List<Jugador> ListaJugadores;
	private JPanel panel_izquierdo;
	private JButton btnHome;
	private JButton btnAnyadirEquipo;
	private JButton btnAnyadirInventario;
	private JButton btnVisualizarJugador;
	private JButton btnVisualizarEntrenador;
	private JButton btnVisualziarEquipo;
	private JButton btnEditarEntrenador;
	private JButton btnEditarEquipo;
	private JButton btnEditarJugador;
	private JButton btnGO;
	private JComboBox<Categoria> comboCategoria;
	private JLabel lblCategoria;
	private JLabel lblCategoria_sel;
	private JPanel pScrollPaneJ;
	private JComboBox<String> comboEquipos;
	private List<Equipo>Lista_Equipos;
	private JScrollPane scrollPaneJ;
	private JScrollPane scrollPane_i;
	private JPanel panel_i;
	private JPanel pScrollPane_i ;
	private JLabel lbl_Entrenador;
	private Controller controller;


	/**
	 * Create the frame.
	 * @param controller 
	 */
	public Visualizar_Equipos(Controller controller) 
	{
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
		panel_central.setBounds(0, 190, 1278, 511);
		contentPane.add(panel_central);
		panel_central.setLayout(null);
		ListaJugadores = new ArrayList<>();
		
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
		
		btnAnyadirEquipo = new JButton("AÑADIR EQUIPO");
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
		
		btnAnyadirInventario = new JButton("AÑADIR INVENTARIO");
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
		btnVisualziarEquipo.setEnabled(false);
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
		btnEditarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EditarEquipo r = new EditarEquipo(controller);
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
		
		btnGO = new JButton("GO!");
		btnGO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RellenarCombo();
			}
		});
		btnGO.setBounds(669, 11, 68, 38);
		panel_central.add(btnGO);
		
		comboCategoria = new JComboBox();
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
				try {
					MostrarJugadores();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
	
	public void MostrarJugadores() throws RemoteException
	{
		
		Equipo e=null;
		for(Equipo a:Lista_Equipos)
		{
			if(a.getNombre().equals(comboEquipos.getSelectedItem().toString())) 
				e=a; 
		}
		Entrenador en = controller.equipoEntrenador(e);
		lbl_Entrenador.setText(en.toString());
		ArrayList <String> ListaNombres= new ArrayList<String>();
		List <Jugador> jugadores = controller.equipoJugadores(e);
		jugadores.forEach(a->ListaNombres.add(a.toString()));
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
		e.getInventario().forEach((m,c)->ListaNombres.add(c+" "+m));
		JList<String> JListaInventario=new JList<String>(ListaNombres.toArray(new String[ListaNombres.size()]));
		scrollPane_i.setViewportView(JListaInventario);
		JListaInventario.setLayoutOrientation(JList.VERTICAL);
		scrollPane_i.repaint();
		pScrollPane_i.repaint();
		panel_central.repaint();
		
		
		
	}
}
