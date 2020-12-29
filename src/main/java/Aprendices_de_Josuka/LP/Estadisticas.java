package Aprendices_de_Josuka.LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Partido;
import Aprendices_de_Josuka.LD.Sancion;
import Controller.Controller;

public class Estadisticas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel txtLosAprendicesDe;
	private JButton btnHome;
	private JButton btnVerEstadisticas;
	private JButton btnClasificacion;
	private JButton btnVisualizarJugador;
	private JButton btnVisualziarEquipo;
	private JButton btnEditarJugador;
	private JLabel lblPartidosGanados;
	private JLabel lblCategoria;
	private JPanel panel_izquierdo;
	private Controller controller; 
	private JPanel PanelCentro;
	private JPanel pScrollPane;
	private JScrollPane scrollPane;
	private Jugador j;
	private List <Sancion> sanciones;
	private int partidosGanados;
	private JLabel lblSanciones;
	private JLabel lblNumSanciones;
	
	public Estadisticas(Controller controller, Jugador j) throws RemoteException, ParseException 
	{
		this.j = j;
		this.partidosGanados = controller.partidosGanados(j.getDNI());
		this.sanciones = controller.sancionesJugador(j.getDNI());
		this.controller=controller;
		initComponents();
		this.setVisible(true);
	}

	public void initComponents() throws ParseException, RemoteException {
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
		btnVerEstadisticas.setEnabled(false);
		btnVerEstadisticas.setHorizontalAlignment(SwingConstants.LEFT);
		btnVerEstadisticas.setForeground(Color.WHITE);
		btnVerEstadisticas.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVerEstadisticas.setBackground(new Color(0, 102, 0));
		btnVerEstadisticas.setBounds(0, 40, 328, 42);
		panel_izquierdo.add(btnVerEstadisticas);
		
		btnClasificacion = new JButton("VER CLASIFICACION");
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
		btnClasificacion.setBounds(0, 81, 328, 42);
		panel_izquierdo.add(btnClasificacion);
		
		btnVisualizarJugador = new JButton("VER FICHA");
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
		btnVisualizarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarJugador.setForeground(Color.WHITE);
		btnVisualizarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarJugador.setBackground(new Color(0, 102, 0));
		btnVisualizarJugador.setBounds(0, 202, 328, 42);
		panel_izquierdo.add(btnVisualizarJugador);
				
		btnVisualziarEquipo = new JButton("VISUALIZAR  EQUIPOS");
		btnVisualziarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Equipos_Jugador r = null;
				try {
					r = new Visualizar_Equipos_Jugador(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		
		btnEditarJugador = new JButton("EDITAR JUGADOR");
		btnEditarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{

			}
		});
		btnEditarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarJugador.setForeground(Color.WHITE);
		btnEditarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarJugador.setBackground(new Color(0, 102, 0));
		btnEditarJugador.setBounds(0, 120, 328, 42);
		panel_izquierdo.add(btnEditarJugador);
		
		lblCategoria = new JLabel("Partidos Ganados:");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lblCategoria.setBounds(338, 17, 185, 26);
		panel_central.add(lblCategoria);
		
		String partidos = String.valueOf(partidosGanados);
		lblPartidosGanados = new JLabel(partidos);
		lblPartidosGanados.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lblPartidosGanados.setBounds(543, 17, 109, 26);
		panel_central.add(lblPartidosGanados);
		
		lblNumSanciones = new JLabel("Numero sanciones:");
		lblNumSanciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumSanciones.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lblNumSanciones.setBounds(338, 30, 185, 26);
		panel_central.add(lblNumSanciones);
		
		String lbl = String.valueOf(sanciones.size());
		lblSanciones = new JLabel(lbl);
		lblSanciones.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		lblSanciones.setBounds(543, 30, 109, 26);
		panel_central.add(lblSanciones);
		
		PanelCentro = new JPanel();
		PanelCentro.setBackground(Color.WHITE);
		PanelCentro.setBounds(328, 83, 1007, 550);
		panel_central.add(PanelCentro);
		PanelCentro.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 951, 411);
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
		InsertarJPanel();
	}

	
	public void InsertarJPanel() throws ParseException, RemoteException {
		pScrollPane.removeAll();
		int x = 0;
		int y = 50;
	
		for (int i = 0; i < sanciones.size(); i++) 
		{
			Partido p = controller.sancionPartido(sanciones.get(i).getCod_partido());
			Panel_Sanciones panel = new Panel_Sanciones(sanciones.get(i), p);
			panel.setVisible(true);
			GridBagConstraints gbc_lblFoto = new GridBagConstraints();
			gbc_lblFoto.ipadx = 1005;
			gbc_lblFoto.ipady = 130;
			gbc_lblFoto.gridx = x;
			gbc_lblFoto.gridy = y;
			pScrollPane.add(panel,gbc_lblFoto);

			y = y + 80;
		}
		pScrollPane.repaint();
		scrollPane.repaint();
		repaint();
	}
}