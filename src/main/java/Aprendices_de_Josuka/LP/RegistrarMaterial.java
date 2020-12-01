package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Tipo_Material;
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

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class RegistrarMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JLabel lblNuevoInventario;
	private Date objDate;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JComboBox comboBox;
	private JButton btnHome;
	private JButton btnAnyadirEquipo;
	private JButton btnAnyadirInventario;
	private JButton btnVisualizarJugador;
	private JButton btnVisualizarEntrenador;
	private JButton btnVisualziarEquipo;
	private JButton btnEditarEntrenador;
	private JButton btnEditarEquipo;
	private JButton btnEditarJugador;
	private JPanel panel_izquierdo;
	private Controller controller;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistrarMaterial frame = new RegistrarMaterial();
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
	public RegistrarMaterial(Controller controller) 
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

		lblNuevoInventario = new JLabel("NUEVO MATERIAL");
		lblNuevoInventario.setForeground(Color.DARK_GRAY);
		lblNuevoInventario.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		lblNuevoInventario.setBounds(364, 29, 338, 38);
		panel_central.add(lblNuevoInventario);

		JButton btnRegistrarse = new JButton("ANADIR");
		btnRegistrarse.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 23));
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setBackground(new Color(0, 102, 0));
		btnRegistrarse.setBounds(686, 399, 154, 38);
		panel_central.add(btnRegistrarse);
		
		panel_izquierdo = new JPanel();
		panel_izquierdo.setLayout(null);
		panel_izquierdo.setForeground(new Color(0, 102, 0));
		panel_izquierdo.setBorder(null);
		panel_izquierdo.setBackground(new Color(0, 102, 0));
		panel_izquierdo.setBounds(0, 0, 328, 528);
		panel_central.add(panel_izquierdo);
		
		btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal_Administrador pa= new Principal_Administrador(controller);
				pa.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnHome.setBackground(new Color(0, 102, 0));
		btnHome.setBounds(0, 0, 328, 42);
		panel_izquierdo.add(btnHome);
		
		btnAnyadirEquipo = new JButton("AÑADIR EQUIPO");
		btnAnyadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RegistrarEquipo r = new RegistrarEquipo(controller);
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnAnyadirEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirEquipo.setForeground(Color.WHITE);
		btnAnyadirEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirEquipo.setBackground(new Color(0, 102, 0));
		btnAnyadirEquipo.setBounds(0, 40, 328, 42);
		panel_izquierdo.add(btnAnyadirEquipo);
		
		btnAnyadirInventario = new JButton("AÑADIR INVENTARIO");
		btnAnyadirInventario.setEnabled(false);
		btnAnyadirInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirInventario.setForeground(Color.WHITE);
		btnAnyadirInventario.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirInventario.setBackground(new Color(0, 102, 0));
		btnAnyadirInventario.setBounds(0, 81, 328, 42);
		panel_izquierdo.add(btnAnyadirInventario);
		
		btnVisualizarJugador = new JButton("VISUALIZAR  JUGADORES");
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
		
		btnVisualizarEntrenador = new JButton("VISUALIZAR  ENTRENADORES");
		btnVisualizarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Visualizar_Entrenadores r = new Visualizar_Entrenadores(controller);
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEntrenador.setForeground(Color.WHITE);
		btnVisualizarEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEntrenador.setBackground(new Color(0, 102, 0));
		btnVisualizarEntrenador.setBounds(0, 121, 328, 42);
		panel_izquierdo.add(btnVisualizarEntrenador);
		
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
		
		btnEditarEntrenador = new JButton("EDITAR ENTRENADOR");
		btnEditarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditarEntrenador r = new EditarEntrenador();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnEditarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarEntrenador.setForeground(Color.WHITE);
		btnEditarEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarEntrenador.setBackground(new Color(0, 102, 0));
		btnEditarEntrenador.setBounds(0, 243, 328, 42);
		panel_izquierdo.add(btnEditarEntrenador);
		
		btnEditarEquipo = new JButton("EDITAR EQUIPO");
		btnEditarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EditarEquipo r = new EditarEquipo();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnEditarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarEquipo.setForeground(Color.WHITE);
		btnEditarEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarEquipo.setBackground(new Color(0, 102, 0));
		btnEditarEquipo.setBounds(0, 281, 328, 42);
		panel_izquierdo.add(btnEditarEquipo);
		
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
		
		JLabel lblPrecio = new JLabel("Precio total:");
		lblPrecio.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblPrecio.setBounds(596, 304, 140, 38);
		panel_central.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(790, 310, 100, 38);
		panel_central.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblCantidad.setBounds(596, 206, 126, 38);
		panel_central.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(790, 210, 100, 38);
		panel_central.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblUds = new JLabel("uds.");
		lblUds.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblUds.setBounds(905, 209, 61, 37);
		panel_central.add(lblUds);
		
		JLabel lblEu = new JLabel("Eu");
		lblEu.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblEu.setBounds(905, 307, 61, 37);
		panel_central.add(lblEu);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblTipo.setBounds(596, 112, 98, 38);
		panel_central.add(lblTipo);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		comboBox.setBounds(680, 112, 216, 43);
		panel_central.add(comboBox);
		comboBox.addItem(Tipo_Material.Balones);
		comboBox.addItem(Tipo_Material.Barreras);
		comboBox.addItem(Tipo_Material.Conos);
		comboBox.addItem(Tipo_Material.Petos);
		comboBox.addItem(Tipo_Material.Picas);
		comboBox.addItem(Tipo_Material.Vallas);
		

		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear_Material();
			}
		});
	}
	
	public void crear_Material()
	{
		int cantidad=0;
		long precio=0;
		
		try
		{
			cantidad =Integer.parseInt(txtCantidad.getText());
		} catch(Exception e)
		{
			txtCantidad.setText("");
			JOptionPane.showMessageDialog(null, "Vuelve a introducir la cantidad");		
			return;
		}
	
		try
		{
			precio =Long.parseLong(txtPrecio.getText());
		} catch(Exception e)
		{
			txtPrecio.setText("");
			JOptionPane.showMessageDialog(null, "Vuelve a introducir el precio");	
			return;
		}
		try {
			
			controller.RegistrarInventario((Tipo_Material)comboBox.getSelectedItem(), cantidad, precio);
			this.txtCantidad.setText("");
			this.txtPrecio.setText("");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
