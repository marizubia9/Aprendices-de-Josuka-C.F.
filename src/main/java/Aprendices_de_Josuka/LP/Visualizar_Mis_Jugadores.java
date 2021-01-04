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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Jugador;
import Controller.Controller;
/**
 * @class Visualizar_Mis_Jugadores
 * @brief En esta clase se desarrolla la GUI que se encarga de mostrar a cada entrenador sus jugadores
 * @author Alumno
 *
 */
public class Visualizar_Mis_Jugadores extends JFrame {

	private JPanel contentPane;
	private JLabel txtLosAprendicesDe;
	private Controller controller;

	private JPanel panel_izquierdo;
	private JButton btnHome;
	private JButton btnVisualizarJugador;
	private JButton btnVisualziarEquipo;
	private JButton btnEditarJugador;
	private JPanel PanelCentro;
	private JPanel pScrollPane;
	private JScrollPane scrollPane;
	private Entrenador j;
	private List<Jugador> misJugadores;

	
	/**
	 * Constructor de la clase
	 * @param controller para la conexión RMI con el servidor
	 * @param j el entrenador que está utilizando la aplicación
	 * @throws RemoteException 
	 */
	public Visualizar_Mis_Jugadores(Controller controller, Entrenador j) throws RemoteException 
	{
		this.j = j;
		this.controller=controller;
		this.misJugadores = controller.misJugadores(j.getDNI());
		initComponents();
		this.setVisible(true);
	}
	/**
	 * Se inicializan los componentes
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
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Principal_Entrenador c = null;
				try {
					c = new Principal_Entrenador(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				c.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnHome.setBackground(new Color(0, 102, 0));
		btnHome.setBounds(0, 0, 328, 42);
		panel_izquierdo.add(btnHome);
		
		JButton btnVerEstadisticas = new JButton("VER ESTADISTICAS");
		btnVerEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EstadisticasEntrenador c = null;
				try {
					c = new EstadisticasEntrenador(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				c.setVisible(true);
				setVisible(false);
			}
		});
		btnVerEstadisticas.setHorizontalAlignment(SwingConstants.LEFT);
		btnVerEstadisticas.setForeground(Color.WHITE);
		btnVerEstadisticas.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVerEstadisticas.setBackground(new Color(0, 102, 0));
		btnVerEstadisticas.setBounds(0, 40, 328, 42);
		panel_izquierdo.add(btnVerEstadisticas);
		
		JButton btnClasificacion = new JButton("VER CLASIFICACION");
		btnClasificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Clasificacion_Entrenador c = null;
				try {
					c = new Clasificacion_Entrenador(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				c.setVisible(true);
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
				FichaEntrenador c = null;
				try {
					c = new FichaEntrenador(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				c.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarJugador.setForeground(Color.WHITE);
		btnVisualizarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarJugador.setBackground(new Color(0, 102, 0));
		btnVisualizarJugador.setBounds(0, 202, 328, 42);
		panel_izquierdo.add(btnVisualizarJugador);
				
		
		
		btnEditarJugador = new JButton("EDITAR DATOS");
		btnEditarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EditarDatosEntrenador c = null;
				try {
					c = new EditarDatosEntrenador(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				c.setVisible(true);
				setVisible(false);
				
			}
		});
		btnEditarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarJugador.setForeground(Color.WHITE);
		btnEditarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarJugador.setBackground(new Color(0, 102, 0));
		btnEditarJugador.setBounds(0, 120, 328, 42);
		panel_izquierdo.add(btnEditarJugador);
		
		JButton btnVerMisJugadores = new JButton("VER MIS JUGADORES");
		btnVerMisJugadores.setEnabled(false);
		btnVerMisJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnVerMisJugadores.setForeground(Color.WHITE);
		btnVerMisJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVerMisJugadores.setBackground(new Color(0, 102, 0));
		btnVerMisJugadores.setBounds(0, 162, 328, 42);
		panel_izquierdo.add(btnVerMisJugadores);
		
		JLabel lblMisJugadores = new JLabel("MIS JUGADORES");
		lblMisJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		lblMisJugadores.setBounds(400, 45, 200, 26);
		panel_central.add(lblMisJugadores);
		
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

	/**
	 * Inserta un panel para mostrar todos los jugadores relacionados al entrenador en cuestion
	 */
	public void InsertarJPanel() {
		pScrollPane.removeAll();
		int x = 0;
		int y = 50;
		
		for (int i = 0; i < misJugadores.size(); i++) 
		{
			Panel_Jugador panel = new Panel_Jugador(misJugadores.get(i));
			panel.setVisible(true);
			GridBagConstraints gbc_lblFoto = new GridBagConstraints();
			gbc_lblFoto.ipadx = 1005;
			gbc_lblFoto.ipady = 130;
			gbc_lblFoto.gridx = x;
			gbc_lblFoto.gridy = y;
			pScrollPane.add(panel,gbc_lblFoto);

			y = y + 70;
		}
		pScrollPane.repaint();
		scrollPane.repaint();
		repaint();
	}
}
