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

public class RegistrarInventario extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JLabel lblNuevoInventario;
	private Date objDate;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarInventario frame = new RegistrarInventario();
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
	public RegistrarInventario() {
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
		panel_central.setBounds(0, 190, 1335, 633);
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
		btnRegistrarse.setBounds(1115, 562, 154, 38);
		panel_central.add(btnRegistrarse);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(0, 102, 0));
		panel.setBorder(null);
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(0, 0, 328, 638);
		panel_central.add(panel);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal_Administrador pa= new Principal_Administrador();
				pa.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnHome.setBackground(new Color(0, 102, 0));
		btnHome.setBounds(0, 0, 328, 58);
		panel.add(btnHome);
		
		JButton btnAnyadirEquipo = new JButton("AÑADIR EQUIPO");
		btnAnyadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEquipo r = new RegistrarEquipo();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnAnyadirEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirEquipo.setForeground(Color.WHITE);
		btnAnyadirEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirEquipo.setBackground(new Color(0, 102, 0));
		btnAnyadirEquipo.setBounds(0, 58, 328, 58);
		panel.add(btnAnyadirEquipo);
		
		JButton btnAnyadirInventario = new JButton("AÑADIR INVENTARIO");
		btnAnyadirInventario.setEnabled(false);
		btnAnyadirInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirInventario.setForeground(Color.WHITE);
		btnAnyadirInventario.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirInventario.setBackground(new Color(0, 102, 0));
		btnAnyadirInventario.setBounds(0, 116, 328, 58);
		panel.add(btnAnyadirInventario);
		
		JButton btnVisualizarJugadores = new JButton("VISUALIZAR  JUGADORES");
		btnVisualizarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visualizar_Jugadores r = new Visualizar_Jugadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarJugadores.setForeground(Color.WHITE);
		btnVisualizarJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarJugadores.setBackground(new Color(0, 102, 0));
		btnVisualizarJugadores.setBounds(0, 174, 328, 58);
		panel.add(btnVisualizarJugadores);
		
		JButton btnVisualizarEntrenadores = new JButton("VISUALIZAR  ENTRENADORES");
		btnVisualizarEntrenadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visualizar_Entrenadores v= new Visualizar_Entrenadores();
				v.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarEntrenadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEntrenadores.setForeground(Color.WHITE);
		btnVisualizarEntrenadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEntrenadores.setBackground(new Color(0, 102, 0));
		btnVisualizarEntrenadores.setBounds(0, 232, 328, 58);
		panel.add(btnVisualizarEntrenadores);
		
		JButton btnVisualizarEquipos = new JButton("VISUALIZAR  EQUIPOS");
		btnVisualizarEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visualizar_Equipos r = new Visualizar_Equipos();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarEquipos.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEquipos.setForeground(Color.WHITE);
		btnVisualizarEquipos.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEquipos.setBackground(new Color(0, 102, 0));
		btnVisualizarEquipos.setBounds(0, 290, 328, 58);
		panel.add(btnVisualizarEquipos);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblNombre.setBounds(448, 136, 106, 38);
		panel_central.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(564, 136, 216, 38);
		panel_central.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblPrecio.setBounds(448, 324, 106, 38);
		panel_central.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(564, 324, 100, 38);
		panel_central.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblCantidad.setBounds(448, 421, 106, 38);
		panel_central.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(564, 421, 100, 38);
		panel_central.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblUds = new JLabel("uds.");
		lblUds.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblUds.setBounds(674, 422, 61, 37);
		panel_central.add(lblUds);
		
		JLabel lblEu = new JLabel("Eu");
		lblEu.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblEu.setBounds(674, 325, 61, 37);
		panel_central.add(lblEu);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblTipo.setBounds(448, 225, 106, 38);
		panel_central.add(lblTipo);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		comboBox.setBounds(564, 225, 216, 43);
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
			
			Gestor.getInstance().RegistrarInventario(txtNombre.getText(), (Tipo_Material)comboBox.getSelectedItem(), cantidad, precio);
			this.txtCantidad.setText("");
			this.txtNombre.setText("");
			this.txtPrecio.setText("");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
