package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aprendices_de_Josuka.DAO.DAO;
import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LN.Gestor;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Anyadir_Inventario extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JPanel panel_central;
	private ArrayList<String>ComponentesCombo;
	private JPanel panel_izquierdo;
	private JButton btnHome;
	private JButton btnAnyadirEquipo;
	private JButton AnyadirInventario;
	private JButton btnVisualizaJugadores;
	private JButton btnVisualizarEntrenadores;
	private JButton btnVisualizarEquipos;
	private JTextField txtCantidad;
	private JComboBox comboMaterial;
	private RegistrarEquipo r;
	private HashMap<Material, Integer> inventario;
	private List<Material>listaMat;


	/**
	 * Create the frame.
	 */
	public Anyadir_Inventario(RegistrarEquipo r, HashMap<Material, Integer> inventario) {
		initComponents();
		this.r=r;
		this.inventario=inventario;
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

		panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_central.setBounds(0, 190, 1335, 633);
		contentPane.add(panel_central);
		panel_central.setLayout(null);
		
		panel_izquierdo = new JPanel();
		panel_izquierdo.setLayout(null);
		panel_izquierdo.setForeground(new Color(0, 102, 0));
		panel_izquierdo.setBorder(null);
		panel_izquierdo.setBackground(new Color(0, 102, 0));
		panel_izquierdo.setBounds(0, 0, 328, 638);
		panel_central.add(panel_izquierdo);
		
		btnHome = new JButton("HOME");
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
		panel_izquierdo.add(btnHome);
		
		btnAnyadirEquipo = new JButton("AÑADIR EQUIPO");
		btnAnyadirEquipo.setEnabled(false);
		btnAnyadirEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirEquipo.setForeground(Color.WHITE);
		btnAnyadirEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirEquipo.setBackground(new Color(0, 102, 0));
		btnAnyadirEquipo.setBounds(0, 58, 328, 58);
		panel_izquierdo.add(btnAnyadirEquipo);
		
		AnyadirInventario = new JButton("AÑADIR INVENTARIO");
		AnyadirInventario.setHorizontalAlignment(SwingConstants.LEFT);
		AnyadirInventario.setForeground(Color.WHITE);
		AnyadirInventario.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		AnyadirInventario.setBackground(new Color(0, 102, 0));
		AnyadirInventario.setBounds(0, 116, 328, 58);
		panel_izquierdo.add(AnyadirInventario);
		
		btnVisualizaJugadores = new JButton("VISUALIZAR  JUGADORES");
		btnVisualizaJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Visualizar_Jugadores r = new Visualizar_Jugadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizaJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizaJugadores.setForeground(Color.WHITE);
		btnVisualizaJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizaJugadores.setBackground(new Color(0, 102, 0));
		btnVisualizaJugadores.setBounds(0, 174, 328, 58);
		panel_izquierdo.add(btnVisualizaJugadores);
		
		btnVisualizarEntrenadores = new JButton("VISUALIZAR  ENTRENADORES");
		btnVisualizarEntrenadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Visualizar_Entrenadores r = new Visualizar_Entrenadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarEntrenadores.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEntrenadores.setForeground(Color.WHITE);
		btnVisualizarEntrenadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEntrenadores.setBackground(new Color(0, 102, 0));
		btnVisualizarEntrenadores.setBounds(0, 232, 328, 58);
		panel_izquierdo.add(btnVisualizarEntrenadores);
		
		btnVisualizarEquipos = new JButton("VISUALIZAR  EQUIPOS");
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
		panel_izquierdo.add(btnVisualizarEquipos);
		
		comboMaterial = new JComboBox();
		comboMaterial.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		comboMaterial.setBounds(813, 173, 180, 30);
		panel_central.add(comboMaterial);
		RellenarCombo();
		
		JLabel lblMaterial = new JLabel("Material: ");
		lblMaterial.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblMaterial.setBounds(645, 173, 130, 30);
		panel_central.add(lblMaterial);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblCantidad.setBounds(645, 263, 130, 30);
		panel_central.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		txtCantidad.setBounds(813, 263, 50, 30);
		panel_central.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblUds = new JLabel("uds.");
		lblUds.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblUds.setBounds(885, 263, 50, 30);
		panel_central.add(lblUds);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Anyadir();
			}
		});
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(0, 128, 0));
		btnAceptar.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		btnAceptar.setBounds(737, 380, 126, 30);
		panel_central.add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnSalir.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		btnSalir.setBounds(1143, 538, 106, 43);
		panel_central.add(btnSalir);
	}
	
	
		
	public void RellenarCombo()
	{

		try {
			listaMat=Gestor.getInstance().ObtenerMaterial();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Material m: listaMat)
		{
			comboMaterial.addItem(m.getTipo());
		}
		
	}
	public void Anyadir()
	{
		int cantidad=0;
		try{
			cantidad=Integer.parseInt(txtCantidad.getText());
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Vuelve a introducir la cantidad");
			txtCantidad.setText("");
			return;
		}
		
		for(Material m:listaMat)
		{
			if(m.getTipo().equals(comboMaterial.getSelectedItem()))
					{
					
						int cant= m.getCantidad() - cantidad;
						if(cant<0) 
						{
							JOptionPane.showMessageDialog(null, "Vuelve a introducir la cantidad");
							txtCantidad.setText("");
							return;
						}
						m.setCantidad(cant);
						inventario.put(m,cantidad);
						txtCantidad.setText("");
						
						
					}
		}
		
	}
	
	
}
