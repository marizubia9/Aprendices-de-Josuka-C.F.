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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Partido;
import Controller.Controller;

public class EditarDatosEntrenador extends JFrame {

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
	private Entrenador j;
	private JTextField txtCorreo;
	private JTextField txtPsw;
	private JButton btnModificar;

	
	
	
	public EditarDatosEntrenador(Controller controller, Entrenador j) throws RemoteException, ParseException 
	{
		this.j = j;
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
				Principal_Entrenador a = null;
				try {
					a = new Principal_Entrenador(controller, j);
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

				
				Clasificacion_Entrenador r = null;
				try {
					r = new Clasificacion_Entrenador(controller, j);
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
		btnVisualizarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FichaEntrenador v = null;
				try {
					v = new FichaEntrenador(controller, j);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				v.setVisible(true);
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
				
				
			}
		});
		btnVisualziarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualziarEquipo.setForeground(Color.WHITE);
		btnVisualziarEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualziarEquipo.setBackground(new Color(0, 102, 0));
		btnVisualziarEquipo.setBounds(0, 162, 328, 42);
		panel_izquierdo.add(btnVisualziarEquipo);
		
		
		btnEditarJugador = new JButton("EDITAR DATOS");
		btnEditarJugador.setEnabled(false);
		btnEditarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarJugador.setForeground(Color.WHITE);
		btnEditarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarJugador.setBackground(new Color(0, 102, 0));
		btnEditarJugador.setBounds(0, 120, 328, 42);
		panel_izquierdo.add(btnEditarJugador);
		
		JLabel lblTit = new JLabel("MODIFICAR DATOS");
		lblTit.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		lblTit.setBounds(450, 50, 250, 100);
		panel_central.add(lblTit);
		
		
		JLabel lblNombre = new JLabel("Nuevo Email");
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblNombre.setBounds(450, 160, 250, 26);
		panel_central.add(lblNombre);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(700, 160, 260, 32);
		panel_central.add(txtCorreo);
		
		
		JLabel lblPsw = new JLabel("Nueva Contraseña");
		lblPsw.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblPsw.setBounds(450, 190, 250, 26);
		panel_central.add(lblPsw);
		
		txtPsw = new JTextField();
		txtPsw.setColumns(10);
		txtPsw.setBounds(700, 190, 260, 32);
		panel_central.add(txtPsw);
		
		btnModificar = new JButton("Guardar");
		btnModificar.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(0, 102, 0));
		btnModificar.setBounds(470, 400, 200, 38);
		panel_central.add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			try {
				modificar();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		
		
	
	}
	public void modificar() throws RemoteException, ParseException
	{
		String correo = txtCorreo.getText();
		String psw = txtPsw.getText();
		if (correo.equals("") || psw.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Introduzca los datos");
		}
		else
		{
			if (controller.modificarCorreoEntrenador(j, correo, psw))
			{
				JOptionPane.showMessageDialog(null, "Cambios guardados");
				Principal_Entrenador p= new Principal_Entrenador(controller, j);
				p.setVisible(true);
				setVisible(false);
			}
		}
		
	}
}