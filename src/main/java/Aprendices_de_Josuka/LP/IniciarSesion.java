package Aprendices_de_Josuka.LP;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Jugador;
import Controller.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JTextField;
/**
 * @brief En esta clase se desarrolla la GUI para el inicio de sesion de los jugadores y entrenadores ya registrados
 * @author Alumno
 */
public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JLabel txtLosAprendicesDe;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private Controller controller;

	/**
	 * La primera ventana en lanzar, establece la conexión con el servidor.
	 */
	public static void main(String[] args) {
		Controller c = null;
		try {
			c = new Controller();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		new IniciarSesion(c);
	}

	/**
	 * Constructor de la ventana
	 * @param c el controller para utilizar el mismo todo el rato
	 */
	public IniciarSesion(Controller c) 
	{
		this.controller=c;
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
		panel_central.setBackground(new Color(0, 102, 0));
		panel_central.setBounds(249, 213, 804, 455);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 25));
		lblEmail.setBounds(110, 171, 92, 27);
		panel_central.add(lblEmail);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 25));
		lblPassword.setBounds(110, 250, 155, 34);
		panel_central.add(lblPassword);

		JLabel lblIniciarSesion = new JLabel("INICIAR SESION");
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 25));
		lblIniciarSesion.setBounds(353, 75, 214, 42);
		panel_central.add(lblIniciarSesion);

		txtEmail = new JTextField();
		txtEmail.setBounds(298, 167, 320, 31);
		panel_central.add(txtEmail);
		txtEmail.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(298, 250, 320, 31);
		panel_central.add(txtPassword);

		JButton btnEntrar = new JButton("Entrar\r\n");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setBounds(367, 315, 180, 30);
		panel_central.add(btnEntrar);

		JButton btnRegistrarseComoEntrenador = new JButton("Registrarse como entrenador");
		btnRegistrarseComoEntrenador.setForeground(Color.WHITE);
		btnRegistrarseComoEntrenador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRegistrarseComoEntrenador.setBackground(new Color(0, 102, 0));
		btnRegistrarseComoEntrenador.setBounds(331, 355, 261, 27);
		btnRegistrarseComoEntrenador.setBorder(null);
		panel_central.add(btnRegistrarseComoEntrenador);

		JButton btnRegistrarseComoJugador = new JButton("Registrarse como jugador");
		btnRegistrarseComoJugador.setBounds(331, 385, 261, 21);
		panel_central.add(btnRegistrarseComoJugador);
		btnRegistrarseComoJugador.setForeground(Color.WHITE);
		btnRegistrarseComoJugador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRegistrarseComoJugador.setBorder(null);
		btnRegistrarseComoJugador.setBackground(new Color(0, 102, 0));

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Entrar(txtEmail.getText(), txtPassword.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnRegistrarseComoJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				RegistrarJugador r = new RegistrarJugador(controller);
				r.setVisible(true);

			}
		});

		btnRegistrarseComoEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				RegistrarEntrenador r = new RegistrarEntrenador(controller);
				r.setVisible(true);

			}
		});

	}
	/**
	 * Cuando pulsa "Entrar" se ejecuta este método. Verifica la existencia de esos datos en la base de datos, y en caso de existir, le da paso a la aplicación
	 * @param email 
	 * @param psw
	 * @throws ParseException
	 */
	public void Entrar(String email, String psw) throws ParseException {
		try {
			if (controller.EntrarJugador(email, psw)) {
			
				Jugador j = controller.getJugador(email,psw);
				Principal_Jugador a = new Principal_Jugador(controller,j);
				a.setVisible(true);
				setVisible(false);
			} else if (controller.EntrarEntrenador(email, psw)) {
						Entrenador e = controller.getEntrenador(email,psw);
						Principal_Entrenador a = new Principal_Entrenador(controller, e);
						setVisible(false);
						a.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"ERROR");
						
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		

	}

}
