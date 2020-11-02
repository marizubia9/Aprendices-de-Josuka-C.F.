package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LN.Gestor;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Date;

import javax.swing.JLabel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class RegistrarEntrenador extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEntrenador frame = new RegistrarEntrenador();
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
	public RegistrarEntrenador() {
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
		panel_central.setBounds(0, 190, 1401, 658);
		contentPane.add(panel_central);
		panel_central.setLayout(null);
		
		lblNuevoEntrenador = new JLabel("NUEVO ENTRENADOR");
		lblNuevoEntrenador.setForeground(Color.DARK_GRAY);
		lblNuevoEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		lblNuevoEntrenador.setBounds(68, 45, 338, 38);
		panel_central.add(lblNuevoEntrenador);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblNombre.setBounds(113, 97, 115, 31);
		panel_central.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.DARK_GRAY);
		lblApellido.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblApellido.setBounds(113, 163, 115, 31);
		panel_central.add(lblApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.DARK_GRAY);
		lblDni.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblDni.setBounds(113, 235, 115, 31);
		panel_central.add(lblDni);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setForeground(Color.DARK_GRAY);
		lblFechaDeNacimiento.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblFechaDeNacimiento.setBounds(113, 307, 260, 31);
		panel_central.add(lblFechaDeNacimiento);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(271, 97, 260, 32);
		panel_central.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(271, 166, 260, 32);
		panel_central.add(txtApellido);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(271, 235, 260, 32);
		panel_central.add(txtDNI);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.DARK_GRAY);
		lblTelefono.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblTelefono.setBounds(113, 378, 260, 31);
		panel_central.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.DARK_GRAY);
		lblCorreo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblCorreo.setBounds(113, 458, 260, 31);
		panel_central.add(lblCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(271, 378, 260, 32);
		panel_central.add(txtTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(271, 457, 260, 32);
		panel_central.add(txtCorreo);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setBackground(new Color(0, 102, 0));
		btnRegistrarse.setBounds(745, 551, 178, 38);
		panel_central.add(btnRegistrarse);
		
		JLabel lblPsw = new JLabel("Password");
		lblPsw.setForeground(Color.DARK_GRAY);
		lblPsw.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblPsw.setBounds(113, 536, 260, 31);
		panel_central.add(lblPsw);
		
		txtPsw = new JTextField();
		txtPsw.setColumns(10);
		txtPsw.setBounds(271, 535, 260, 32);
		panel_central.add(txtPsw);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(394, 307, 137, 31);
		panel_central.add(dateChooser);
		
		
		btnRegistrarse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nombre=txtNombre.getText();
				String apellido=txtApellido.getText();
				Date fecha= new Date(1);
				String DNI=txtDNI.getText();
				int telefono=Integer.parseInt(txtTelefono.getText());
				String correo=txtCorreo.getText();
				String psw = txtPsw.getText();

			try {
				Gestor.getInstance().RegistrarEntrenador(nombre, apellido, fecha, DNI, telefono, correo, psw);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	

				
			}
		});
	}
}
