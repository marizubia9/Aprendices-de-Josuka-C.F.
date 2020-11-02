package Aprendices_de_Josuka.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtLosAprendicesDe;
	private JButton txtEntrar;
	private JTextField txtInfantiles;
	private JTextField txtCadetes;
	private JTextField txtJuveniles;
	private JPanel panel_barra_infantil;
	private JPanel panel_barra_cadetes;
	private JPanel panel_barra_juveniles;
	private JTextField txtInfantilTxiki;
	private JTextField txtInfantilHonor;
	private JTextField txtCadeteHonor;
	private JTextField txtCadeteVasca;
	private JTextField txtJuvenilVasca;
	private JTextField txtJuvenilNacional;
	private JTextField txtJuvenilCadeteDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_Principal frame = new Pantalla_Principal();
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
	public Pantalla_Principal() {
		initComponents();
		this.setVisible(true);
	}
	
	public void initComponents()
	{
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
		
		txtEntrar = new JButton();
		txtEntrar.setForeground(Color.WHITE);
		txtEntrar.setBackground(new Color(153, 204, 0));
		txtEntrar.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		txtEntrar.setText("Entrar");
		txtEntrar.setBounds(1160, 108, 149, 38);
		txtEntrar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_superior.add(txtEntrar);
		
		
		JPanel panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_central.setBounds(213, 365, 991, 250);
		contentPane.add(panel_central);
		panel_central.setLayout(null);

		
		txtInfantiles = new JTextField();
		txtInfantiles.setForeground(Color.DARK_GRAY);
		txtInfantiles.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		txtInfantiles.setBackground(Color.WHITE);
		txtInfantiles.setText("INFANTILES");
		txtInfantiles.setBounds(84, 29, 197, 37);
		txtInfantiles.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_central.add(txtInfantiles);
		txtInfantiles.setColumns(10);
		
		txtCadetes = new JTextField();
		txtCadetes.setText("CADETES");
		txtCadetes.setForeground(Color.DARK_GRAY);
		txtCadetes.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		txtCadetes.setColumns(10);
		txtCadetes.setBackground(Color.WHITE);
		txtCadetes.setBounds(411, 29, 197, 37);
		txtCadetes.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_central.add(txtCadetes);
		
		txtJuveniles = new JTextField();
		txtJuveniles.setText("JUVENILES");
		txtJuveniles.setForeground(Color.DARK_GRAY);
		txtJuveniles.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		txtJuveniles.setColumns(10);
		txtJuveniles.setBackground(Color.WHITE);
		txtJuveniles.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtJuveniles.setBounds(709, 29, 197, 37);
		panel_central.add(txtJuveniles);
		
		panel_barra_infantil = new JPanel();
		panel_barra_infantil.setBackground(new Color(153, 204, 0));
		panel_barra_infantil.setForeground(new Color(153, 204, 0));
		panel_barra_infantil.setBounds(94, 70, 150, 5);
		panel_central.add(panel_barra_infantil);
		
		panel_barra_cadetes = new JPanel();
		panel_barra_cadetes.setForeground(new Color(153, 204, 0));
		panel_barra_cadetes.setBackground(new Color(153, 204, 0));
		panel_barra_cadetes.setBounds(405, 70, 150, 5);
		panel_central.add(panel_barra_cadetes);
		
		panel_barra_juveniles = new JPanel();
		panel_barra_juveniles.setForeground(new Color(153, 204, 0));
		panel_barra_juveniles.setBackground(new Color(153, 204, 0));
		panel_barra_juveniles.setBounds(709, 70, 150, 5);
		panel_central.add(panel_barra_juveniles);
		
		txtInfantilTxiki = new JTextField();
		txtInfantilTxiki.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		txtInfantilTxiki.setForeground(Color.GRAY);
		txtInfantilTxiki.setBackground(new Color(255, 255, 255));
		txtInfantilTxiki.setText("Infantil Txiki");
		txtInfantilTxiki.setBounds(104, 91, 146, 26);
		txtInfantilTxiki.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_central.add(txtInfantilTxiki);
		txtInfantilTxiki.setColumns(10);
		
		txtInfantilHonor = new JTextField();
		txtInfantilHonor.setText("Infantil Honor");
		txtInfantilHonor.setForeground(Color.GRAY);
		txtInfantilHonor.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		txtInfantilHonor.setColumns(10);
		txtInfantilHonor.setBackground(Color.WHITE);
		txtInfantilHonor.setBounds(98, 133, 146, 26);
		txtInfantilHonor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_central.add(txtInfantilHonor);
		
		txtCadeteHonor = new JTextField();
		txtCadeteHonor.setText("Cadete Honor");
		txtCadeteHonor.setForeground(Color.GRAY);
		txtCadeteHonor.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		txtCadeteHonor.setColumns(10);
		txtCadeteHonor.setBackground(Color.WHITE);
		txtCadeteHonor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtCadeteHonor.setBounds(411, 91, 146, 26);
		panel_central.add(txtCadeteHonor);
		
		txtCadeteVasca = new JTextField();
		txtCadeteVasca.setText("Cadete Vasca\r\n");
		txtCadeteVasca.setForeground(Color.GRAY);
		txtCadeteVasca.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		txtCadeteVasca.setColumns(10);
		txtCadeteVasca.setBackground(Color.WHITE);
		txtCadeteVasca.setBounds(409, 133, 146, 26);
		txtCadeteVasca.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_central.add(txtCadeteVasca);
		
		txtJuvenilVasca = new JTextField();
		txtJuvenilVasca.setText("Juvenil Vasca");
		txtJuvenilVasca.setForeground(Color.GRAY);
		txtJuvenilVasca.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		txtJuvenilVasca.setColumns(10);
		txtJuvenilVasca.setBackground(Color.WHITE);
		txtJuvenilVasca.setBounds(713, 91, 146, 26);
		txtJuvenilVasca.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_central.add(txtJuvenilVasca);
		
		txtJuvenilNacional = new JTextField();
		txtJuvenilNacional.setText("Juvenil Nacional");
		txtJuvenilNacional.setForeground(Color.GRAY);
		txtJuvenilNacional.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		txtJuvenilNacional.setColumns(10);
		txtJuvenilNacional.setBackground(Color.WHITE);
		txtJuvenilNacional.setBounds(709, 137, 174, 26);
		txtJuvenilNacional.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_central.add(txtJuvenilNacional);
		
		txtJuvenilCadeteDe = new JTextField();
		txtJuvenilCadeteDe.setText("Juvenil Cadete de Honor");
		txtJuvenilCadeteDe.setForeground(Color.GRAY);
		txtJuvenilCadeteDe.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 23));
		txtJuvenilCadeteDe.setColumns(10);
		txtJuvenilCadeteDe.setBackground(Color.WHITE);
		txtJuvenilCadeteDe.setBounds(709, 179, 174, 26);
		txtJuvenilCadeteDe.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel_central.add(txtJuvenilCadeteDe);
		
		txtEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciarSesion iniciar=new IniciarSesion();
				setVisible(false);
				iniciar.setVisible(true);
				
			}
		});
	}
}
