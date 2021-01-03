package Aprendices_de_Josuka.LP;

import java.awt.Color;
import java.awt.Font;
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
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Partido;
import Controller.Controller;
/**
 * Enseña al jugador su ficha
 * @author Alumno
 *
 */
public class FichaJugador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel txtLosAprendicesDe;
	private JButton btnHome;
	private JButton btnVerEstadisticas;
	private JButton btnClasificacion;
	private JButton btnVisualizarJugador;
	private JButton btnVisualziarEquipo;
	private JButton btnEditarJugador;
	private JPanel panel_izquierdo;
	private Controller controller; 
	private Jugador j;
	
	/**
	 * Constructor
	 * @param controller
	 * @param j el jugador que esta dentro de la aplicación
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public FichaJugador(Controller controller, Jugador j) throws RemoteException, ParseException 
	{
		this.j = j;
		this.controller=controller;
		initComponents();
		this.setVisible(true);
	}
	/**
	 * Inicia componentes
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
		btnVisualizarJugador.setEnabled(false);
		btnVisualizarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarJugador.setForeground(Color.WHITE);
		btnVisualizarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarJugador.setBackground(new Color(0, 102, 0));
		btnVisualizarJugador.setBounds(0, 202, 328, 42);
		panel_izquierdo.add(btnVisualizarJugador);
				
		btnVisualziarEquipo = new JButton("VISUALIZAR  EQUIPOS");
		btnVisualziarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Equipos_Jugador v = null;
				try {
					v = new Visualizar_Equipos_Jugador(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				v.setVisible(true);
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
				EditarDatos v = null;
				try {
					v = new EditarDatos(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				v.setVisible(true);
				setVisible(false);

			}
		});
		btnEditarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarJugador.setForeground(Color.WHITE);
		btnEditarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarJugador.setBackground(new Color(0, 102, 0));
		btnEditarJugador.setBounds(0, 120, 328, 42);
		panel_izquierdo.add(btnEditarJugador);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblNombre.setBounds(450, 28,250, 26);
		panel_central.add(lblNombre);
		
		JLabel lblNombre2 = new JLabel(j.getNombre());
		lblNombre2.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblNombre2.setBounds(710, 28, 250, 26);
		panel_central.add(lblNombre2);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblApellido.setBounds(450, 60, 250, 26);
		panel_central.add(lblApellido);
		
		JLabel lblApellido2 = new JLabel(j.getApellido());
		lblApellido2.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblApellido2.setBounds(710, 60, 250, 26);
		panel_central.add(lblApellido2);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblDNI.setBounds(450, 90, 250, 26);
		panel_central.add(lblDNI);
		
		JLabel lblDNI2 = new JLabel(j.getDNI());
		lblDNI2.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblDNI2.setBounds(710, 90, 250, 26);
		panel_central.add(lblDNI2);
		
		JLabel lblFechaNcto = new JLabel("Fecha de nacimiento");
		lblFechaNcto.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblFechaNcto.setBounds(450, 120, 250, 26);
		panel_central.add(lblFechaNcto);
		
		JLabel lblFecha = new JLabel(j.getFecha_nacimiento());
		lblFecha.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblFecha.setBounds(710, 120, 250, 26);
		panel_central.add(lblFecha);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblCorreo.setBounds(450, 150, 250, 26);
		panel_central.add(lblCorreo);
		
		JLabel lblCorreo2 = new JLabel(j.getCorreo());
		lblCorreo2.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblCorreo2.setBounds(710, 150, 250, 26);
		panel_central.add(lblCorreo2);
		
		JLabel lblTelef = new JLabel("Telefono");
		lblTelef.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblTelef.setBounds(450, 180, 250, 26);
		panel_central.add(lblTelef);
		
		JLabel lblTelef2 = new JLabel(String.valueOf(j.getTelefono()));
		lblTelef2.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblTelef2.setBounds(710, 180, 250, 26);
		panel_central.add(lblTelef2);
	
		
		
	
	}
}