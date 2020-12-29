package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import Controller.Controller;

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

public class IniciarSesion_Admin extends JFrame {

	private JPanel contentPane;
	private JLabel txtLosAprendicesDe;
	private JTextField txtEmail;
	private JTextField txtPsw;
	private Controller controller;

	public static void main(String[] args) {
		Controller c = null;
		try {
			c = new Controller();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		new IniciarSesion_Admin(c);
	}

	/**
	 * Create the frame.
	 * @param controller 
	 */
	public IniciarSesion_Admin(Controller controller) 
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
		panel_central.setBounds(294, 232, 777, 408);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 25));
		lblEmail.setBounds(90, 171, 102, 27);
		panel_central.add(lblEmail);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 25));
		lblPassword.setBounds(90, 250, 155, 34);
		panel_central.add(lblPassword);

		txtEmail = new JTextField();
		txtEmail.setBounds(298, 167, 320, 31);
		panel_central.add(txtEmail);
		txtEmail.setColumns(10);

		txtPsw = new JTextField();
		txtPsw.setColumns(10);
		txtPsw.setBounds(298, 250, 320, 31);
		panel_central.add(txtPsw);
		
		JButton btnRegistrar = new JButton();
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RegistrarAdmin a = new RegistrarAdmin(controller);
			}
		});
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnRegistrar.setText("Registrarse");
		btnRegistrar.setBounds(951, 89, 286, 41);
		btnRegistrar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_superior.add(btnRegistrar);

		JButton btnEntrar = new JButton("Entrar\r\n");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (controller.EntrarAdministrador(txtEmail.getText(), txtPsw.getText())) {
						Principal_Administrador a = new Principal_Administrador(controller);
						setVisible(false);
						a.setVisible(true);
}
					else
					{
						JOptionPane.showMessageDialog(null,"No existe ningun Administrador con esos datos");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setBounds(367, 325, 180, 34);
		panel_central.add(btnEntrar);

	}

	

}
