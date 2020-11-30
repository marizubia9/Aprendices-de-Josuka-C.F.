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
import Aprendices_de_Josuka.Controller.Controller;

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
	private Controller controller;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistrarEntrenador frame = new RegistrarEntrenador();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param controller 
	 */
	public RegistrarEntrenador(Controller controller) 
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

		lblNuevoEntrenador = new JLabel("NUEVO ENTRENADOR");
		lblNuevoEntrenador.setForeground(Color.DARK_GRAY);
		lblNuevoEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		lblNuevoEntrenador.setBounds(69, 16, 338, 38);
		panel_central.add(lblNuevoEntrenador);

		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblNombre.setBounds(393, 59, 115, 31);
		panel_central.add(lblNombre);

		lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.DARK_GRAY);
		lblApellido.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblApellido.setBounds(393, 106, 115, 31);
		panel_central.add(lblApellido);

		lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.DARK_GRAY);
		lblDni.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblDni.setBounds(393, 153, 115, 31);
		panel_central.add(lblDni);

		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setForeground(Color.DARK_GRAY);
		lblFechaDeNacimiento.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblFechaDeNacimiento.setBounds(393, 200, 260, 31);
		panel_central.add(lblFechaDeNacimiento);

		txtNombre = new JTextField();
		txtNombre.setBounds(551, 59, 260, 32);
		panel_central.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(551, 105, 260, 32);
		panel_central.add(txtApellido);

		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(551, 152, 260, 32);
		panel_central.add(txtDNI);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.DARK_GRAY);
		lblTelefono.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblTelefono.setBounds(393, 247, 146, 31);
		panel_central.add(lblTelefono);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.DARK_GRAY);
		lblCorreo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblCorreo.setBounds(393, 294, 260, 31);
		panel_central.add(lblCorreo);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(551, 250, 260, 32);
		panel_central.add(txtTelefono);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(551, 297, 260, 32);
		panel_central.add(txtCorreo);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setBackground(new Color(0, 102, 0));
		btnRegistrarse.setBounds(591, 407, 178, 38);
		panel_central.add(btnRegistrarse);

		JLabel lblPsw = new JLabel("Password");
		lblPsw.setForeground(Color.DARK_GRAY);
		lblPsw.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		lblPsw.setBounds(393, 341, 130, 31);
		panel_central.add(lblPsw);

		txtPsw = new JTextField();
		txtPsw.setColumns(10);
		txtPsw.setBounds(551, 341, 260, 32);
		panel_central.add(txtPsw);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(674, 200, 137, 31);
		panel_central.add(dateChooser);

		btnRegistrarse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				Date fecha_date = dateChooser.getDate();
				String DATE_FORMAT = "dd/MM/yyyy";
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				String fecha_S = sdf.format(fecha_date);
				String DNI = txtDNI.getText();
				int telefono = Integer.parseInt(txtTelefono.getText());
				String correo = txtCorreo.getText();
				String psw = txtPsw.getText();
				
				if(nombre.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Introduce correctamente el nombre");
				}
				else if(apellido.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Introduce correctamente el apellido");
				}
				else if(DNI.equals("")|DNI.length()!=9)
				{
					JOptionPane.showMessageDialog(null, "Introduce correctamente el DNI");
				}
				else if (txtTelefono.getText().equals("")|txtTelefono.getText().length()!=9)
				{
					JOptionPane.showMessageDialog(null, "Introduce correctamente el telefono");
				}
				else if (correo.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Introduce correctamente el correo");
				}
				else if (psw.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Introduce correctamente la contrasenya");
				}
				
				else
				{
				try {
					controller.RegistrarEntrenador(nombre, apellido, fecha_S, DNI, telefono, correo, psw, false);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtNombre.setText("");
				txtApellido.setText("");
				txtDNI.setText("");
				txtTelefono.setText("");
				txtCorreo.setText("");
				txtPsw.setText("");
				}

			}
		});
	}
}
