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

public class VisualizarEquipos extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JLabel lblListaEquipos;
	private Date objDate;
	private List<Entrenador> ListaEntrenador;
	private JPanel panel;
	private JButton button;
	private JList<String> listaJugadores1;
	private JPanel panel_scrollpane;
	private JPanel panel_central;
	private JPanel panel_scrollpane1;
	private List<String> ListaEquipos;
	private Categoria cat;
	private JScrollPane scrollPane_Equipos1;
	private JList<String> JListaEquipos1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarEquipos frame = new VisualizarEquipos();
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
	public VisualizarEquipos() {
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

		panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_central.setBounds(-12, 190, 1401, 658);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		lblListaEquipos = new JLabel("ENTRENADORES");
		lblListaEquipos.setForeground(Color.DARK_GRAY);
		lblListaEquipos.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		lblListaEquipos.setBounds(309, 45, 360, 38);
		panel_central.add(lblListaEquipos);

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
		panel_scrollpane1 = new JPanel(new BorderLayout());
		panel_scrollpane1.setForeground(Color.DARK_GRAY);
		panel_scrollpane1.setBackground(Color.LIGHT_GRAY);
		panel_scrollpane1.setLocation(600, 120);
		panel_scrollpane1.setSize(450, 430);
		ListaEquipos = new ArrayList<>();
		scrollPane_Equipos1 = new JScrollPane();
		panel_scrollpane1.add(scrollPane_Equipos1);
		panel_central.add(panel_scrollpane1);

		MostrarEquipos();

	}

	public void MostrarEquipos() {

		try {
			ListaEquipos = Gestor.getInstance().MostrarEquipos();
			JListaEquipos1 = new JList<String>(ListaEquipos.toArray(new String[ListaEquipos.size()]));
			scrollPane_Equipos1.setViewportView(JListaEquipos1);
			JListaEquipos1.setLayoutOrientation(JList.VERTICAL);
			scrollPane_Equipos1.repaint();
			System.out.println("El tamanyo de la lista: " + ListaEquipos.size());
			panel_central.repaint();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
