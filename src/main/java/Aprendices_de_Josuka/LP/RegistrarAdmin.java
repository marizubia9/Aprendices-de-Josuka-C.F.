package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LN.Gestor;
import Controller.Controller;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class RegistrarAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JLabel lblNuevoEntrenador;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblFechaDeNacimiento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtPsw;
	private Controller controller;


	/**
	 * Create the frame.
	 * @param controller 
	 */
	public RegistrarAdmin(Controller controller) 
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

		JPanel panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_central.setBounds(0, 190, 1278, 494);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		lblNuevoEntrenador = new JLabel("NUEVO ADMINISTRADOR");
		lblNuevoEntrenador.setForeground(Color.DARK_GRAY);
		lblNuevoEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 26));
		lblNuevoEntrenador.setBounds(69, 16, 338, 38);
		panel_central.add(lblNuevoEntrenador);

		lblNombre = new JLabel("Correo");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblNombre.setBounds(373, 59, 115, 31);
		panel_central.add(lblNombre);

		lblApellido = new JLabel("Contraseña");
		lblApellido.setForeground(Color.DARK_GRAY);
		lblApellido.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblApellido.setBounds(373, 106, 115, 31);
		panel_central.add(lblApellido);

		

		txtNombre = new JTextField();
		txtNombre.setBounds(551, 59, 260, 32);
		panel_central.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(551, 105, 260, 32);
		panel_central.add(txtApellido);

		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setBackground(new Color(0, 102, 0));
		btnRegistrarse.setBounds(591, 407, 178, 38);
		panel_central.add(btnRegistrarse);

	

		btnRegistrarse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				String correo = txtNombre.getText();
				String psw = txtApellido.getText();
				
				
				if(correo.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Introduce correctamente el correo");
				}
				else if(psw.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Introduce correctamente el password");
				}
				
				
				else
				{
				try {
					controller.RegistrarAdmin(correo, psw);
					Principal_Administrador p = new Principal_Administrador(controller);
					p.setVisible(true);
					setVisible(false);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtNombre.setText("");
				txtApellido.setText("");
		
				}

			}
		});
	}
}
