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
import Aprendices_de_Josuka.LD.Equipos_Ext;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LN.Gestor;
import Controller.Controller;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;


public class Clasificacion  extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JPanel panel_central;
	private List<Equipos_Ext> ListaEquipos;
	private JComboBox comboCategoria;
	private Controller controller;

	private List<String> jugadores_lista;
	private JPanel panel_izquierdo;
	private JButton btnHome;
	private JButton btnGO;
	private JPanel PanelCentro;
	private JPanel pScrollPane;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clasificacion frame = new Clasificacion(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param controller 
	 */
	public Clasificacion(Controller controller) 
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

		panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_central.setBounds(0, 190, 1278, 511);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

				
		btnGO = new JButton("GO!");
		btnGO.setBounds(1173, 39, 68, 38);
		panel_central.add(btnGO);
		
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
		
				
		comboCategoria = new JComboBox();
		comboCategoria.addItem(Categoria.ALEVIN);
		comboCategoria.addItem(Categoria.INFANTIL);
		comboCategoria.addItem(Categoria.CADETE);
		comboCategoria.addItem(Categoria.JUVENIL);
		comboCategoria.addItem(Categoria.SENIOR);
		
		comboCategoria.setBounds(1047, 45, 109, 26);
		panel_central.add(comboCategoria);
		
		PanelCentro = new JPanel();
		PanelCentro.setBackground(Color.WHITE);
		PanelCentro.setBounds(328, 83, 950, 429);
		panel_central.add(PanelCentro);
		PanelCentro.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 949, 409);
		PanelCentro.add(scrollPane);
		
		pScrollPane = new JPanel();
		pScrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(pScrollPane);
		GridBagLayout gbl_pScrollPane = new GridBagLayout();
		gbl_pScrollPane.columnWidths = new int[]{0};
		gbl_pScrollPane.rowHeights = new int[]{0};
		gbl_pScrollPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pScrollPane.rowWeights = new double[]{Double.MIN_VALUE};
		pScrollPane.setLayout(gbl_pScrollPane);
		

		btnGO.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				try {
					InsertarJPanel();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	
	public void InsertarJPanel() throws ParseException {
		pScrollPane.removeAll();
		int x = 0;
		int y = 50;
		try {
			ListaEquipos=controller.Clasificacion((Categoria) comboCategoria.getSelectedItem());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < ListaEquipos.size(); i++) 
		{
//			Panel_Jugador panel = new Panel_Jugador(ListaJugadores.get(i));
//			panel.setVisible(true);
			GridBagConstraints gbc_lblFoto = new GridBagConstraints();
			gbc_lblFoto.ipadx = 1005;
			gbc_lblFoto.ipady = 130;
			gbc_lblFoto.gridx = x;
			gbc_lblFoto.gridy = y;
//			pScrollPane.add(panel,gbc_lblFoto);

			y = y + 130;
		}
		pScrollPane.repaint();
		scrollPane.repaint();
		repaint();
	}
}