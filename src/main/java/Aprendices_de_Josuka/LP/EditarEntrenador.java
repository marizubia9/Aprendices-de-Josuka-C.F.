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
import javax.swing.JTextArea;

public class EditarEntrenador extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private Date objDate;
	private List<Entrenador> ListaEntrenadores;
	private JList<String> listaJugadores1;
	private JPanel panel_scrollpane;
	private JPanel panel_central;
	private List<String> ListaJugadores1;
	private HashMap<Material,Integer> inventario;
	private JList<String> JListaJugadores1;
	private JList<String> JListaJugadores2;
	private List<Jugador>lista_Jugadores;
	private List<String> jugadores_lista;
	private Set<String> HashSet;

	private boolean MostrarJugadores;
	private JPanel panel_izquierdo;
	private JButton btnHome;
	private JButton btnAnyadirEquipo;
	private JButton btnAnyadirInventario;
	private JButton btnVisualizarJugador;
	private JButton btnVisualizarEntrenador;
	private JButton btnVisualziarEquipo;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblNombreEntrenador;
	private JLabel lblDni;
	private JLabel lblDNIEntrenador;
	private JLabel lblEquipo;
	private JLabel lblSalario;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextField textField;
	private Entrenador entrenador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarEntrenador frame = new EditarEntrenador();
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
	public EditarEntrenador() {
		initComponents();
		this.setVisible(true);
	}

	public void initComponents() {
		entrenador = new Entrenador("", "", "", "", 0, "", "", 0, false);
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

		jugadores_lista = new ArrayList<String>();
		ListaJugadores1 = new ArrayList<>();
		
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
		
		btnAnyadirInventario = new JButton("AÑADIR INVENTARIO");
		btnAnyadirInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnyadirInventario.setForeground(Color.WHITE);
		btnAnyadirInventario.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAnyadirInventario.setBackground(new Color(0, 102, 0));
		btnAnyadirInventario.setBounds(0, 116, 328, 58);
		panel_izquierdo.add(btnAnyadirInventario);
		
		btnVisualizarJugador = new JButton("VISUALIZAR  JUGADORES");
		btnVisualizarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Visualizar_Jugadores r = new Visualizar_Jugadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarJugador.setForeground(Color.WHITE);
		btnVisualizarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarJugador.setBackground(new Color(0, 102, 0));
		btnVisualizarJugador.setBounds(0, 174, 328, 58);
		panel_izquierdo.add(btnVisualizarJugador);
		
		btnVisualizarEntrenador = new JButton("VISUALIZAR  ENTRENADORES");
		btnVisualizarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Visualizar_Entrenadores r = new Visualizar_Entrenadores();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarEntrenador.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarEntrenador.setForeground(Color.WHITE);
		btnVisualizarEntrenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualizarEntrenador.setBackground(new Color(0, 102, 0));
		btnVisualizarEntrenador.setBounds(0, 232, 328, 58);
		panel_izquierdo.add(btnVisualizarEntrenador);
		
		btnVisualziarEquipo = new JButton("VISUALIZAR  EQUIPOS");
		btnVisualziarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Equipos r = new Visualizar_Equipos();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualziarEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualziarEquipo.setForeground(Color.WHITE);
		btnVisualziarEquipo.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnVisualziarEquipo.setBackground(new Color(0, 102, 0));
		btnVisualziarEquipo.setBounds(0, 290, 328, 58);
		panel_izquierdo.add(btnVisualziarEquipo);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(0, 128, 0));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnAceptar.setBounds(1138, 457, 125, 38);
		panel_central.add(btnAceptar);
		
		JLabel lblSeleccioneElEntrenador = new JLabel("Seleccione el entrenador");
		lblSeleccioneElEntrenador.setBounds(343, 16, 182, 20);
		panel_central.add(lblSeleccioneElEntrenador);
		
		comboBox = new JComboBox();
		comboBox.setBounds(547, 13, 157, 26);
		panel_central.add(comboBox);
		IntroducirEntrenadores();
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(529, 147, 69, 20);
		panel_central.add(lblNombre);
		
		JLabel lblNombreEntrenador = new JLabel(entrenador.getNombre());
		lblNombreEntrenador.setBounds(632, 147, 182, 20);
		panel_central.add(lblNombreEntrenador);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(529, 198, 69, 20);
		panel_central.add(lblApellido);
		
		JLabel lblApellidoEntrenador = new JLabel(entrenador.getApellido());
		lblApellidoEntrenador.setBounds(632, 198, 182, 20);
		panel_central.add(lblApellidoEntrenador);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(529, 93, 69, 20);
		panel_central.add(lblDni);
		
		lblDNIEntrenador = new JLabel(entrenador.getDNI());
		lblDNIEntrenador.setBounds(632, 93, 69, 20);
		panel_central.add(lblDNIEntrenador);
		
		lblSalario = new JLabel("Salario");
		lblSalario.setBounds(529, 251, 69, 20);
		panel_central.add(lblSalario);
		
		lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(529, 302, 69, 20);
		panel_central.add(lblEquipo);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(632, 299, 138, 26);
		panel_central.add(comboBox_1);
		
		
		String salario;
		salario=Integer.toString((int) entrenador.getSalario());
		textField = new JTextField();
		textField.setBounds(631, 248, 146, 26);
		panel_central.add(textField);
		textField.setColumns(10);
		
		JButton btnGo = new JButton("GO!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VisualizarEntrenadores();
				panel_izquierdo.repaint();
				VisualizarEntrenadores();
				Prueba();
			}
		});
		btnGo.setBounds(724, 12, 69, 29);
		panel_central.add(btnGo);
		
	}
	
	public void IntroducirEntrenadores()
	{
		ListaEntrenadores= new ArrayList();
		String dniEntrenador;
		try 
		{
			ListaEntrenadores=Gestor.getInstance().MostrarEntrenadores();
			for(int i=0; i<ListaEntrenadores.size();i++)
			{
				dniEntrenador=ListaEntrenadores.get(i).getDNI();
				comboBox.addItem(dniEntrenador);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void VisualizarEntrenadores()
	{
		try {
			ListaEntrenadores=Gestor.getInstance().MostrarEntrenadores();
			for(int i=0; i<ListaEntrenadores.size();i++)
			{
				String dni=comboBox.getSelectedItem().toString();
				if(dni.equals(ListaEntrenadores.get(i).getDNI().toString()))
				{
					entrenador = new Entrenador (ListaEntrenadores.get(i).getNombre(), ListaEntrenadores.get(i).getApellido(), ListaEntrenadores.get(i).getFecha_nacimiento(),ListaEntrenadores.get(i).getDNI(),ListaEntrenadores.get(i).getTelefono(), ListaEntrenadores.get(i).getCorreo(), ListaEntrenadores.get(i).getPsw(), ListaEntrenadores.get(i).getSalario(),ListaEntrenadores.get(i).isAsignado_equipo());
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Prueba()
	{
		System.out.println(entrenador.getDNI());
		
	}
}
