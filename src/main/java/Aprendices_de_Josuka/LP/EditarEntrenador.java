package Aprendices_de_Josuka.LP;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Entrenador;
import Controller.Controller;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class EditarEntrenador extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private Date objDate;
	private List<Entrenador> ListaEntrenadores;
	private JPanel panel_scrollpane;
	private JPanel panel_central;

	private JPanel panel_izquierdo;
	private JButton btnHome;
	private JButton btnAnyadirEquipo;
	private JButton btnAnyadirInventario;
	private JButton btnVisualizarJugador;
	private JButton btnVisualizarEntrenador;
	private JButton btnVisualziarEquipo;
	private JButton btnClasificacion;
	private JLabel lblNombreEntrenador;
	private JLabel lblDni;
	private JLabel lblDNIEntrenador;
	private JLabel lblEquipo;
	private JLabel lblSalario;
	private JComboBox<String> comboEntrenador;
	private JTextField txtSalario;
	private JLabel lblApellidoEntrenador;
	private JLabel lblEquipoEntrenador;
	private JButton btnEditarEntrenador;
	private JButton btnEditarEquipo;
	private JButton btnEditarJugador;
	private Controller controller;
	


	/**
	 * Create the frame.
	 */
	public EditarEntrenador(Controller c) 
	{
		this.controller = c;
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
		panel_superior.setBounds(0, 0, 1278, 173);
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
		txtLosAprendicesDe.setBounds(45, 39, 702, 89);
		panel_superior.add(txtLosAprendicesDe);
		txtLosAprendicesDe.setColumns(10);

		panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_central.setBounds(0, 173, 1278, 528);
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
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal_Administrador pa = null;
				try {
					pa = new Principal_Administrador(controller);
				} catch (RemoteException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		btnAnyadirInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				RegistrarMaterial r = new RegistrarMaterial(controller);
				r.setVisible(true);
				setVisible(false);
			}
		});
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
		btnEditarEntrenador.setEnabled(false);
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
				EditarEquipo r = new EditarEquipo(controller);
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
		
		btnClasificacion = new JButton("VER CLASIFICACION");
		btnClasificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				Clasificacion r = null;
				try {
					r = new Clasificacion(controller);
				} catch (ParseException e1) {
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
		btnClasificacion.setBounds(0, 364, 328, 42);
		panel_izquierdo.add(btnClasificacion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(0, 128, 0));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Guardar();
			}
		});
		btnAceptar.setBounds(1138, 427, 125, 38);
		panel_central.add(btnAceptar);
		
		JLabel lblSeleccioneElEntrenador = new JLabel("Seleccione el entrenador");
		lblSeleccioneElEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblSeleccioneElEntrenador.setBounds(343, 16, 182, 20);
		panel_central.add(lblSeleccioneElEntrenador);
		
		comboEntrenador = new JComboBox<String>();
		comboEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		comboEntrenador.setBounds(547, 13, 246, 26);
		panel_central.add(comboEntrenador);
		IntroducirEntrenadores();
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblNombre.setBounds(529, 147, 69, 20);
		panel_central.add(lblNombre);
		
		lblNombreEntrenador = new JLabel("");
		lblNombreEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblNombreEntrenador.setBounds(632, 147, 182, 20);
		panel_central.add(lblNombreEntrenador);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblApellido.setBounds(529, 198, 69, 20);
		panel_central.add(lblApellido);
		
		lblApellidoEntrenador = new JLabel("");
		lblApellidoEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblApellidoEntrenador.setBounds(632, 198, 182, 20);
		panel_central.add(lblApellidoEntrenador);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblDni.setBounds(529, 93, 69, 20);
		panel_central.add(lblDni);
		
		lblDNIEntrenador = new JLabel("");
		lblDNIEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblDNIEntrenador.setBounds(632, 93, 161, 20);
		panel_central.add(lblDNIEntrenador);
		
		lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblSalario.setBounds(529, 251, 69, 20);
		panel_central.add(lblSalario);
		
		lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblEquipo.setBounds(529, 302, 69, 20);
		panel_central.add(lblEquipo);
		
		
		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		txtSalario.setBounds(631, 248, 146, 26);
		panel_central.add(txtSalario);
		txtSalario.setColumns(10);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VisualizarEntrenadores();
				panel_izquierdo.repaint();
				VisualizarEntrenadores();
			}
		});
		btnGo.setBounds(816, 14, 69, 29);
		panel_central.add(btnGo);
		
		lblEquipoEntrenador = new JLabel("");
		lblEquipoEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lblEquipoEntrenador.setBounds(632, 308, 182, 20);
		panel_central.add(lblEquipoEntrenador);
		VisualizarEntrenadores();
		
	}
	
	public void IntroducirEntrenadores()
	{
		ListaEntrenadores= new ArrayList<Entrenador>();
		
		try 
		{
			ListaEntrenadores=controller.getEntrenador();
			ListaEntrenadores.forEach(e->comboEntrenador.addItem(e.toString()));
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void VisualizarEntrenadores()
	{
			ListaEntrenadores.forEach(e->{
			if(comboEntrenador.getSelectedItem().toString().equals(e.toString()))
			{
				lblDNIEntrenador.setText(e.getDNI());
				lblNombreEntrenador.setText(e.getNombre());
				lblApellidoEntrenador.setText(e.getApellido());
				txtSalario.setText(String.valueOf(e.getSalario()));
				try {
					lblEquipoEntrenador.setText(controller.ObtenerEquipoEntrenador(e.getDNI()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void Guardar()
	{
		for(Entrenador e:ListaEntrenadores){
			if(comboEntrenador.getSelectedItem().toString().equals(e.toString()))
			{ long salario=0;
				try
				{
					 salario= Long.parseLong(txtSalario.getText());
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Vuelve a introducir el salario");
					txtSalario.setText("");
				}
				
						
				try {
					controller.ActualizarEntrenador(e, salario);
					lblApellidoEntrenador.setText("");
					lblNombreEntrenador.setText("");
					lblDNIEntrenador.setText("");
					txtSalario.setText("");
					lblEquipoEntrenador.setText("");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
			}
	}
}
