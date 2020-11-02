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

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JLabel txtLosAprendicesDe;
	private JTextField txtEmail;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion();
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
	public IniciarSesion() {
		initComponents();
		this.setVisible(true);
}


public void initComponents()
{
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1423, 904);
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

	
	JButton btnEntrar_admin = new JButton();
	btnEntrar_admin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			IniciarSesion_Admin a= new IniciarSesion_Admin();
		}
	});
	btnEntrar_admin.setForeground(Color.BLACK);
	btnEntrar_admin.setBackground(Color.WHITE);
	btnEntrar_admin.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
	btnEntrar_admin.setText("Entrar como administradora");
	btnEntrar_admin.setBounds(1084, 86, 286, 41);
	btnEntrar_admin.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	panel_superior.add(btnEntrar_admin);
	
	
	JPanel panel_central = new JPanel();
	panel_central.setBackground(new Color(0, 102, 0));
	panel_central.setBounds(300, 276, 777, 455);
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
	lblIniciarSesion.setBounds(345, 75, 214, 42);
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
	btnEntrar.setBounds(367, 325, 180, 34);
	panel_central.add(btnEntrar);
	
	JButton btnRegistrarseComoEntrenador = new JButton("Registrarse como entrenador...");
	btnRegistrarseComoEntrenador.setForeground(Color.WHITE);
	btnRegistrarseComoEntrenador.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnRegistrarseComoEntrenador.setBackground(new Color(0, 102, 0));
	btnRegistrarseComoEntrenador.setBounds(331, 375, 261, 27);
	btnRegistrarseComoEntrenador.setBorder(null);
	panel_central.add(btnRegistrarseComoEntrenador);
	
	JButton btnRegistrarseComoJugador = new JButton("Registrarse como jugador...");
	btnRegistrarseComoJugador.setBounds(321, 408, 261, 20);
	panel_central.add(btnRegistrarseComoJugador);
	btnRegistrarseComoJugador.setForeground(Color.WHITE);
	btnRegistrarseComoJugador.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnRegistrarseComoJugador.setBorder(null);
	btnRegistrarseComoJugador.setBackground(new Color(0, 102, 0));
	
	btnEntrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			Entrar(txtEmail.getText(),txtPassword.getText());
		
			
		}
	});
	
	btnRegistrarseComoJugador.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			setVisible(false);
			RegistrarJugador r= new RegistrarJugador();
			r.setVisible(true);
		
			
		}
	});
	
	btnRegistrarseComoEntrenador.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			RegistrarEntrenador r= new RegistrarEntrenador();
			r.setVisible(true);
			
		}
	});

}

public void Entrar(String email, String psw)
{
		try {
		if (Gestor.getInstance().Entrar_Jugador(email, psw))
		{
			setVisible(false);
			Principal_Jugador a= new Principal_Jugador();
			a.setVisible(true);
		}
		else
		{
			try {
				if (Gestor.getInstance().Entrar_Entrenador(email, psw))
				{
					Principal_Entrenador a= new Principal_Entrenador();
					a.setVisible(true);
				}
				else
				{
					JOptionPane error= new JOptionPane("ERROR");
					error.setVisible(true);
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

}

}
