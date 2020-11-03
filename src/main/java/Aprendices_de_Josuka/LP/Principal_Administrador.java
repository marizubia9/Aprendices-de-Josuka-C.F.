package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aprendices_de_Josuka.LN.Gestor;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Principal_Administrador extends JFrame {

	private JPanel contentPane;
	private JLabel txtLosAprendicesDe;
	private JButton btnAnadirEquipo;
	private JButton btnanyadirInventario;
	private JButton btnVisualizarJugadores;
	private JButton btnVisualizarEntrenadores;
	private JButton btnVisualizarEquipos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_Administrador frame = new Principal_Administrador();
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
	public Principal_Administrador() {
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
		panel_superior.setBounds(0, 0, 1401, 189);
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
		panel_central.setBounds(0, 187, 1329, 661);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		JPanel panel_izquierdo = new JPanel();
		panel_izquierdo.setBorder(null);
		panel_izquierdo.setForeground(new Color(0, 102, 0));
		panel_izquierdo.setBackground(new Color(0, 102, 0));
		panel_izquierdo.setBounds(0, 0, 328, 661);
		panel_central.add(panel_izquierdo);
		panel_izquierdo.setLayout(null);

		btnAnadirEquipo = new JButton("AÑADIR EQUIPO");
		btnAnadirEquipo.setBounds(0, 0, 328, 70);
		panel_izquierdo.add(btnAnadirEquipo);
		btnAnadirEquipo.setForeground(Color.WHITE);
		btnAnadirEquipo.setBackground(new Color(0, 102, 0));
		btnAnadirEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		
		btnanyadirInventario = new JButton("AÑADIR INVENTARIO");
		btnanyadirInventario.setForeground(Color.WHITE);
		btnanyadirInventario.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnanyadirInventario.setBackground(new Color(0, 102, 0));
		btnanyadirInventario.setBounds(0, 73, 328, 70);
		panel_izquierdo.add(btnanyadirInventario);
		
		btnVisualizarJugadores = new JButton("VISUALIZAR  JUGADORES");
		btnVisualizarJugadores.setForeground(Color.WHITE);
		btnVisualizarJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarJugadores.setBackground(new Color(0, 102, 0));
		btnVisualizarJugadores.setBounds(0, 147, 328, 70);
		panel_izquierdo.add(btnVisualizarJugadores);
		
		btnVisualizarEntrenadores = new JButton("VISUALIZAR  ENTRENADORES");
		btnVisualizarEntrenadores.setForeground(Color.WHITE);
		btnVisualizarEntrenadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEntrenadores.setBackground(new Color(0, 102, 0));
		btnVisualizarEntrenadores.setBounds(0, 220, 328, 70);
		panel_izquierdo.add(btnVisualizarEntrenadores);
		
		btnVisualizarEquipos = new JButton("VISUALIZAR  EQUIPOS");
		btnVisualizarEquipos.setForeground(Color.WHITE);
		btnVisualizarEquipos.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEquipos.setBackground(new Color(0, 102, 0));
		btnVisualizarEquipos.setBounds(0, 294, 328, 70);
		panel_izquierdo.add(btnVisualizarEquipos);

		btnAnadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				RegistrarEquipo r = new RegistrarEquipo();
				r.setVisible(true);
				setVisible(false);

			}
		});
		
		btnanyadirInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				RegistrarInventario r = new RegistrarInventario();
				r.setVisible(true);

			}
		});
		
		btnVisualizarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				
				

			}
		});
		
		btnVisualizarEntrenadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				

			}
		});
		
		btnVisualizarEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);


			}
		});

	}
}
