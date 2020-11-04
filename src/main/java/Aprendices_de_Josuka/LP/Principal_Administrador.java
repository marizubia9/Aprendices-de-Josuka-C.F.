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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

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
		panel_central.setBounds(0, 187, 1325, 636);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		JPanel panel_izquierdo = new JPanel();
		panel_izquierdo.setBorder(null);
		panel_izquierdo.setForeground(new Color(0, 102, 0));
		panel_izquierdo.setBackground(new Color(0, 102, 0));
		panel_izquierdo.setBounds(0, 0, 328, 638);
		panel_central.add(panel_izquierdo);
		panel_izquierdo.setLayout(null);
		
		JButton button = new JButton("HOME");
		button.setEnabled(false);
		button.setBounds(0, 0, 328, 58);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		button.setBackground(new Color(0, 102, 0));
		panel_izquierdo.add(button);
		
				btnAnadirEquipo = new JButton("AÑADIR EQUIPO");
				btnAnadirEquipo.setBounds(0, 58, 328, 58);
				btnAnadirEquipo.setHorizontalAlignment(SwingConstants.LEFT);
				panel_izquierdo.add(btnAnadirEquipo);
				btnAnadirEquipo.setForeground(Color.WHITE);
				btnAnadirEquipo.setBackground(new Color(0, 102, 0));
				btnAnadirEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
				
						btnAnadirEquipo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
				
								
								RegistrarEquipo r = new RegistrarEquipo();
								r.setVisible(true);
								setVisible(false);
				
							}
						});
		
		btnanyadirInventario = new JButton("AÑADIR INVENTARIO");
		btnanyadirInventario.setBounds(0, 116, 328, 58);
		btnanyadirInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnanyadirInventario.setForeground(Color.WHITE);
		btnanyadirInventario.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnanyadirInventario.setBackground(new Color(0, 102, 0));
		panel_izquierdo.add(btnanyadirInventario);
		
		btnanyadirInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				RegistrarInventario r = new RegistrarInventario();
				r.setVisible(true);
				setVisible(false);
			}
		});
		
		btnVisualizarJugadores = new JButton("VISUALIZAR  JUGADORES");
		btnVisualizarJugadores.setBounds(0, 174, 328, 58);
		btnVisualizarJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarJugadores.setForeground(Color.WHITE);
		btnVisualizarJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarJugadores.setBackground(new Color(0, 102, 0));
		panel_izquierdo.add(btnVisualizarJugadores);
		
		btnVisualizarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Jugadores r = new Visualizar_Jugadores();
				r.setVisible(true);
				setVisible(false);
				
				

			}
		});
		
		btnVisualizarEntrenadores = new JButton("VISUALIZAR  ENTRENADORES");
		btnVisualizarEntrenadores.setBounds(0, 232, 328, 58);
		btnVisualizarEntrenadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEntrenadores.setForeground(Color.WHITE);
		btnVisualizarEntrenadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEntrenadores.setBackground(new Color(0, 102, 0));
		panel_izquierdo.add(btnVisualizarEntrenadores);
		
		btnVisualizarEntrenadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Entrenadores r = new Visualizar_Entrenadores();
				r.setVisible(true);
				setVisible(false);
				

			}
		});
		
		btnVisualizarEquipos = new JButton("VISUALIZAR  EQUIPOS");
		btnVisualizarEquipos.setBounds(0, 290, 328, 58);
		btnVisualizarEquipos.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEquipos.setForeground(Color.WHITE);
		btnVisualizarEquipos.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEquipos.setBackground(new Color(0, 102, 0));
		panel_izquierdo.add(btnVisualizarEquipos);
		
		btnVisualizarEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				Visualizar_Equipos r = new Visualizar_Equipos();
				r.setVisible(true);
				setVisible(false);


			}
		});
		
		JLabel label = new JLabel("");
		label.setBounds(0, 348, 328, 58);
		panel_izquierdo.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 406, 328, 58);
		panel_izquierdo.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 464, 328, 58);
		panel_izquierdo.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(0, 522, 328, 58);
		panel_izquierdo.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 580, 328, 58);
		panel_izquierdo.add(label_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(328, 0, 997, 638);
		panel_central.add(panel);

	}
}
