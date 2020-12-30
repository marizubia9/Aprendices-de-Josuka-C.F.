package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import DAO.DAO;
import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Equipo;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LD.Tipo_Material;
import Aprendices_de_Josuka.LN.Gestor;
import Controller.Controller;

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
	private JButton btnAnyadirInventario;
	private JButton btnVisualizarJugador;
	private JButton btnVisualizarEntrenador;
	private JButton btnVisualziarEquipo;
	private JButton btnEditarEntrenador;
	private JButton btnEditarEquipo;
	private JButton btnEditarJugador;
	private JTextField txtCantidad;
	private JComboBox<Tipo_Material> comboMaterial;
	private RegistrarEquipo r;
	private HashMap<Material, Integer> inventario;
	private List<Material>listaMat;
	private Controller controller;


	/**
	 * Create the frame.
	 */
	public Anyadir_Inventario(Controller controller,RegistrarEquipo r, HashMap<Material, Integer> inventario) 
	{
		this.controller=controller;
		initComponents();
		this.r=r;
		this.inventario=inventario;
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
		
		panel_central = new JPanel();
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

		
		btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Principal_Administrador pa = null;
				try {
					pa = new Principal_Administrador(controller);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
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
		btnAnyadirEquipo.setEnabled(false);
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
		btnEditarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EditarEntrenador r = new EditarEntrenador(controller);
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
			public void actionPerformed(ActionEvent e) {
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
			public void actionPerformed(ActionEvent e) {
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
		
		comboMaterial = new JComboBox();
		comboMaterial.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		comboMaterial.setBounds(813, 173, 180, 30);
		panel_central.add(comboMaterial);
		RellenarCombo();
		
		JLabel lblMaterial = new JLabel("Material: ");
		lblMaterial.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblMaterial.setBounds(696, 173, 77, 30);
		panel_central.add(lblMaterial);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblCantidad.setBounds(696, 263, 77, 30);
		panel_central.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		txtCantidad.setBounds(813, 263, 50, 30);
		panel_central.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblUds = new JLabel("uds.");
		lblUds.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblUds.setBounds(885, 263, 50, 30);
		panel_central.add(lblUds);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Anyadir();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(0, 128, 0));
		btnAceptar.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		btnAceptar.setBounds(737, 380, 126, 30);
		panel_central.add(btnAceptar);
		
	
	}
	
	
		
	public void RellenarCombo()
	{

		try {
			listaMat=controller.getMaterial();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Material m: listaMat)
		{
			comboMaterial.addItem(m.getTipo());
		}
		
	}
	public void Anyadir() throws RemoteException
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
						System.out.println(m.getTipo());
						System.out.println(cantidad);
						r.AsignarMaterial(m, cantidad);
						r.setVisible(true);
						setVisible(false);
						
					}
		}
		
	}
	
	
}
