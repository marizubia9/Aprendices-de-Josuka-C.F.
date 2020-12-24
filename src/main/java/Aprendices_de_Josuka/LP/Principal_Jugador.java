package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import java.awt.Color;

public class Principal_Jugador extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_Jugador frame = new Principal_Jugador();
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
	public Principal_Jugador() {
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
		btnHome.setEnabled(false);
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnHome.setBackground(new Color(0, 102, 0));
		btnHome.setBounds(0, 0, 328, 42);
		panel_izquierdo.add(btnHome);
		
		btnVerEstadisticas = new JButton("VER ESTADISTICAS");
		btnVerEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
//				RegistrarEquipo r = new RegistrarEquipo(controller);
//				r.setVisible(true);
//				setVisible(false);
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
//
//				
//				RegistrarMaterial r = new RegistrarMaterial(controller);
//				r.setVisible(true);
//				setVisible(false);
			}
		});
		btnClasificacion.setHorizontalAlignment(SwingConstants.LEFT);
		btnClasificacion.setForeground(Color.WHITE);
		btnClasificacion.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnClasificacion.setBackground(new Color(0, 102, 0));
		btnClasificacion.setBounds(0, 81, 328, 42);
		panel_izquierdo.add(btnClasificacion);
		
		btnVisualizarJugador = new JButton("VISUALIZAR JUGADORES");
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
		
		JLabel label = new JLabel("");
		label.setBounds(0, 348, 328, 58);
		panel_izquierdo.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 406, 328, 58);
		panel_izquierdo.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 464, 328, 31);
		panel_izquierdo.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(0, 522, 328, 58);
		panel_izquierdo.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 580, 328, 58);
		panel_izquierdo.add(label_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(328, 0, 997, 495);
		panel_central.add(panel);

	}
	}

