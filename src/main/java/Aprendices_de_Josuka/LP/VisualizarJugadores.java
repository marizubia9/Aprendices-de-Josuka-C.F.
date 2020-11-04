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
import java.awt.LayoutManager;

public class VisualizarJugadores extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JLabel lblListaJugadores;
	private JPanel panel;
	private JButton button;
	private JPanel panel_central;
	private JPanel panel_scrollpaneAlevin;
	private List<String> ListaJugadores;
	private JScrollPane scrollPane_JugadoresAlevin;
	private JList<String> JListaJugadoresAlevin;
	private JPanel panel_scrollpaneInfantil;
	private JScrollPane scrollPane_JugadoresInfantil;
	private JList<String> JListaJugadoresInfantil;
	private JPanel panel_scrollpaneCadete;
	private JScrollPane scrollPane_JugadoresCadete;
	private JList<String> JListaJugadoresCadete;
	private JPanel panel_scrollpaneJuvenil;
	private JScrollPane scrollPane_JugadoresJuvenil;
	private JList<String> JListaJugadoresJuvenil;
	private JPanel panel_scrollpaneSenior;
	private JScrollPane scrollPane_JugadoresSenior;
	private JList<String> JListaJugadoresSenior;
	private JLabel lblCadete;
	private JLabel lblJuvenil;
	private JLabel lblSenior;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarJugadores frame = new VisualizarJugadores();
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
	public VisualizarJugadores() {
		initComponents();
		this.setVisible(true);
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1499, 903);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_superior = new JPanel();
		panel_superior.setBounds(0, 0, 1477, 189);
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
		panel_central.setBounds(-12, 190, 1498, 658);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		lblListaJugadores = new JLabel("JUGADORES");
		lblListaJugadores.setForeground(Color.DARK_GRAY);
		lblListaJugadores.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		lblListaJugadores.setBounds(309, 45, 360, 38);
		panel_central.add(lblListaJugadores);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(0, 102, 0));
		panel.setBorder(null);
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(0, -19, 288, 661);
		panel_central.add(panel);

		button = new JButton("ANYADIR EQUIPO");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 25));
		button.setBackground(new Color(0, 102, 0));
		button.setBounds(0, 16, 288, 88);
		panel.add(button);

		


		// Creamos el Jlist1 y lo rellenamos con la lista de los
		// jugadores
		panel_scrollpaneAlevin = new JPanel(new BorderLayout());
		panel_scrollpaneAlevin.setForeground(Color.DARK_GRAY);
		panel_scrollpaneAlevin.setBackground(Color.LIGHT_GRAY);
		panel_scrollpaneAlevin.setLocation(300, 150);
		panel_scrollpaneAlevin.setSize(220, 403);
		ListaJugadores = new ArrayList<>();
		scrollPane_JugadoresAlevin = new JScrollPane();
		panel_scrollpaneAlevin.add(scrollPane_JugadoresAlevin);
		panel_central.add(panel_scrollpaneAlevin);
		
		panel_scrollpaneInfantil = new JPanel((LayoutManager) null);
		panel_scrollpaneInfantil.setForeground(Color.DARK_GRAY);
		panel_scrollpaneInfantil.setBackground(Color.WHITE);
		panel_scrollpaneInfantil.setBounds(540, 150, 220, 403);
		panel_central.add(panel_scrollpaneInfantil);
		panel_scrollpaneInfantil.setLayout(new BorderLayout());
		
		scrollPane_JugadoresInfantil = new JScrollPane();
		panel_scrollpaneInfantil.add(scrollPane_JugadoresInfantil, BorderLayout.NORTH);
		
		JListaJugadoresInfantil = new JList<String>();
		JListaJugadoresInfantil.setLayoutOrientation(JList.VERTICAL);
		panel_scrollpaneInfantil.add(JListaJugadoresInfantil, BorderLayout.SOUTH);
		
		panel_scrollpaneCadete = new JPanel((LayoutManager) null);
		panel_scrollpaneCadete.setForeground(Color.DARK_GRAY);
		panel_scrollpaneCadete.setBackground(Color.WHITE);
		panel_scrollpaneCadete.setBounds(780, 150, 220, 403);
		panel_central.add(panel_scrollpaneCadete);
		panel_scrollpaneCadete.setLayout(new BorderLayout());
		
		scrollPane_JugadoresCadete = new JScrollPane();
		panel_scrollpaneCadete.add(scrollPane_JugadoresCadete, BorderLayout.NORTH);
		
		JListaJugadoresCadete = new JList<String>();
		JListaJugadoresCadete.setLayoutOrientation(JList.VERTICAL);
		panel_scrollpaneCadete.add(JListaJugadoresCadete, BorderLayout.SOUTH);
		
		panel_scrollpaneJuvenil = new JPanel((LayoutManager) null);
		panel_scrollpaneJuvenil.setForeground(Color.DARK_GRAY);
		panel_scrollpaneJuvenil.setBackground(Color.WHITE);
		panel_scrollpaneJuvenil.setBounds(1020, 150, 220, 403);
		panel_central.add(panel_scrollpaneJuvenil);
		panel_scrollpaneJuvenil.setLayout(new BorderLayout());
		
		scrollPane_JugadoresJuvenil = new JScrollPane();
		panel_scrollpaneJuvenil.add(scrollPane_JugadoresJuvenil, BorderLayout.NORTH);
		
		JListaJugadoresJuvenil = new JList<String>();
		JListaJugadoresJuvenil.setLayoutOrientation(JList.VERTICAL);
		panel_scrollpaneJuvenil.add(JListaJugadoresJuvenil, BorderLayout.SOUTH);
		
		panel_scrollpaneSenior = new JPanel((LayoutManager) null);
		panel_scrollpaneSenior.setForeground(Color.DARK_GRAY);
		panel_scrollpaneSenior.setBackground(Color.WHITE);
		panel_scrollpaneSenior.setBounds(1260, 150, 220, 403);
		panel_central.add(panel_scrollpaneSenior);
		panel_scrollpaneSenior.setLayout(new BorderLayout());
		
		scrollPane_JugadoresSenior = new JScrollPane();
		panel_scrollpaneSenior.add(scrollPane_JugadoresSenior, BorderLayout.NORTH);
		
		JListaJugadoresSenior = new JList<String>();
		JListaJugadoresSenior.setLayoutOrientation(JList.VERTICAL);
		panel_scrollpaneSenior.add(JListaJugadoresSenior, BorderLayout.SOUTH);
		
		JLabel lblAlevin = new JLabel("ALEVIN");
		lblAlevin.setForeground(Color.DARK_GRAY);
		lblAlevin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		lblAlevin.setBounds(346, 107, 139, 38);
		panel_central.add(lblAlevin);
		
		JLabel lblInfantil = new JLabel("INFANTIL");
		lblInfantil.setForeground(Color.DARK_GRAY);
		lblInfantil.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		lblInfantil.setBounds(594, 107, 139, 38);
		panel_central.add(lblInfantil);
		
		lblCadete = new JLabel("CADETE");
		lblCadete.setForeground(Color.DARK_GRAY);
		lblCadete.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		lblCadete.setBounds(835, 107, 139, 38);
		panel_central.add(lblCadete);
		
		lblJuvenil = new JLabel("JUVENIL");
		lblJuvenil.setForeground(Color.DARK_GRAY);
		lblJuvenil.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		lblJuvenil.setBounds(1062, 107, 139, 38);
		panel_central.add(lblJuvenil);
		
		lblSenior = new JLabel("SENIOR");
		lblSenior.setForeground(Color.DARK_GRAY);
		lblSenior.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		lblSenior.setBounds(1305, 107, 139, 38);
		panel_central.add(lblSenior);
		
		MostrarJugadores();
		
	}
	
	public void MostrarJugadores()
	{
		
		try {
			ListaJugadores=Gestor.getInstance().MostrarJugadores(Categoria.ALEVIN);
			JListaJugadoresAlevin = new JList<String>();
			scrollPane_JugadoresAlevin.setViewportView(JListaJugadoresAlevin);
			JListaJugadoresAlevin.setLayoutOrientation(JList.VERTICAL);
			scrollPane_JugadoresAlevin.repaint();
			panel_central.repaint();
			
			ListaJugadores.clear();
			ListaJugadores=Gestor.getInstance().MostrarJugadores(Categoria.INFANTIL);
			JListaJugadoresInfantil = new JList<String>();
			scrollPane_JugadoresInfantil.setViewportView(JListaJugadoresInfantil);
			JListaJugadoresInfantil.setLayoutOrientation(JList.VERTICAL);
			scrollPane_JugadoresInfantil.repaint();
			panel_central.repaint();
			
			ListaJugadores.clear();
			ListaJugadores=Gestor.getInstance().MostrarJugadores(Categoria.CADETE);
			JListaJugadoresCadete = new JList<String>();
			scrollPane_JugadoresCadete.setViewportView(JListaJugadoresCadete);
			JListaJugadoresCadete.setLayoutOrientation(JList.VERTICAL);
			scrollPane_JugadoresCadete.repaint();
			panel_central.repaint();
			
			ListaJugadores.clear();
			ListaJugadores=Gestor.getInstance().MostrarJugadores(Categoria.JUVENIL);
			JListaJugadoresJuvenil = new JList<String>();
			scrollPane_JugadoresJuvenil.setViewportView(JListaJugadoresJuvenil);
			JListaJugadoresJuvenil.setLayoutOrientation(JList.VERTICAL);
			scrollPane_JugadoresJuvenil.repaint();
			panel_central.repaint();
			
			ListaJugadores.clear();
			ListaJugadores=Gestor.getInstance().MostrarJugadores(Categoria.SENIOR);
			JListaJugadoresSenior = new JList<String>();
			scrollPane_JugadoresSenior.setViewportView(JListaJugadoresSenior);
			JListaJugadoresSenior.setLayoutOrientation(JList.VERTICAL);
			scrollPane_JugadoresSenior.repaint();
			panel_central.repaint();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
