package Aprendices_de_Josuka.LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import Aprendices_de_Josuka.LD.Categoria;
import Aprendices_de_Josuka.LD.Entrenador;
import Aprendices_de_Josuka.LD.Jugador;
import Aprendices_de_Josuka.LD.Material;
import Aprendices_de_Josuka.LN.Gestor;
import Controller.Controller;

import javax.swing.JRadioButton;

public class EditarJugador  extends JFrame {

	private JPanel contentPane;
	private JLabel lblLosAprendicesDe;

	private List<Jugador> ListaJugadores;
	private JPanel panel_central;

	private JPanel panel_izquierdo;
	private JButton btnHome;
	private JButton btnAnyadirEquipo;
	private JButton btnAnyadirInventario;
	private JButton btnVisualizarJugador;
	private JButton btnVisualizarEntrenador;
	private JButton btnVisualziarEquipo;
	private JLabel lblNombreJugador;
	private JLabel lblDni;
	private JLabel lblDNIJugador;
	private JComboBox comboCategoria;
	private JLabel lblEquipoJugador;
	private JLabel lblReconocimientoMdico;
	private JLabel lblEstado;
	private JRadioButton rdbtnLesionado;
	private JRadioButton rdbtnBien;
	private JLabel lblCuota;
	private JRadioButton rdbtnPagada;
	private JRadioButton rdbtnNoPagada;
	private JRadioButton rbtnSuspendido;
	private JRadioButton rdbtnAprobado;
	private JComboBox comboJugadores ;
	private ButtonGroup estado;
	private ButtonGroup Cuota;
	private ButtonGroup Reconocimiento;
	private JButton btnEditarEntrenador;
	private JButton btnEditarEquipo;
	private JButton btnEditarJugador;
	private Controller controller; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller c= new Controller();
					EditarJugador frame = new EditarJugador(c);
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
	public EditarJugador(Controller controller) {
		this.controller=controller;
		initComponents();
		this.setVisible(true);
	}

	public void initComponents() {
		ListaJugadores=new ArrayList<>();
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

		lblLosAprendicesDe = new JLabel("LOS APRENDICES DE JOSUKA C.F.");
		lblLosAprendicesDe.setBackground(new Color(0, 102, 0));
		lblLosAprendicesDe.setForeground(Color.WHITE);
		lblLosAprendicesDe.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 40));
		lblLosAprendicesDe.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		lblLosAprendicesDe.setBounds(45, 39, 702, 89);
		panel_superior.add(lblLosAprendicesDe);

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
		btnEditarJugador.setEnabled(false);
		btnEditarJugador.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditarJugador.setForeground(Color.WHITE);
		btnEditarJugador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnEditarJugador.setBackground(new Color(0, 102, 0));
		btnEditarJugador.setBounds(0, 322, 328, 42);
		panel_izquierdo.add(btnEditarJugador);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(0, 128, 0));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Guardar();
			}
		});
		btnAceptar.setBounds(1138, 457, 125, 38);
		panel_central.add(btnAceptar);
		
		JLabel lblSeleccioneCategoria = new JLabel("Seleccione la categoria");
		lblSeleccioneCategoria.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblSeleccioneCategoria.setBounds(343, 16, 182, 20);
		panel_central.add(lblSeleccioneCategoria);
		
		comboCategoria = new JComboBox();
		comboCategoria.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		comboCategoria.setBounds(547, 13, 246, 26);
		panel_central.add(comboCategoria);
		comboCategoria.addItem(Categoria.ALEVIN);
		comboCategoria.addItem(Categoria.INFANTIL);
		comboCategoria.addItem(Categoria.CADETE);
		comboCategoria.addItem(Categoria.JUVENIL);
		comboCategoria.addItem(Categoria.SENIOR);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblNombre.setBounds(530, 194, 69, 20);
		panel_central.add(lblNombre);
		
		lblNombreJugador = new JLabel();
		lblNombreJugador.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblNombreJugador.setBounds(631, 194, 182, 20);
		panel_central.add(lblNombreJugador);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEquipo.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblEquipo.setBounds(530, 245, 69, 20);
		panel_central.add(lblEquipo);
		
		lblEquipoJugador = new JLabel();
		lblEquipoJugador.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblEquipoJugador.setBounds(631, 245, 295, 20);
		panel_central.add(lblEquipoJugador);
		
		lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblDni.setBounds(530, 147, 69, 20);
		panel_central.add(lblDni);
		
		lblDNIJugador = new JLabel();
		lblDNIJugador.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblDNIJugador.setBounds(631, 147, 161, 20);
		panel_central.add(lblDNIJugador);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VisualizarJugadores();
				panel_izquierdo.repaint();
				
			}
		});
		btnGo.setBounds(816, 14, 69, 29);
		panel_central.add(btnGo);
		
		comboJugadores = new JComboBox();
		comboJugadores.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		comboJugadores.setBounds(547, 47, 246, 26);
		panel_central.add(comboJugadores);
		
		JLabel lblSeleccioneJugador = new JLabel("Seleccione el Jugador");
		lblSeleccioneJugador.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblSeleccioneJugador.setBounds(343, 50, 182, 23);
		panel_central.add(lblSeleccioneJugador);
		
		JButton btnGO2 = new JButton("GO!");
		btnGO2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarInformacion();
			}
		});
		btnGO2.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnGO2.setBounds(816, 48, 69, 29);
		panel_central.add(btnGO2);
		
		lblReconocimientoMdico = new JLabel("Reconocimiento Médico");
		lblReconocimientoMdico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReconocimientoMdico.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblReconocimientoMdico.setBounds(382, 297, 217, 22);
		panel_central.add(lblReconocimientoMdico);
		
		 Reconocimiento= new ButtonGroup();
		rdbtnAprobado = new JRadioButton("Aprobado");
		rdbtnAprobado.setBackground(Color.WHITE);
		rdbtnAprobado.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		rdbtnAprobado.setBounds(645, 296, 109, 23);
		panel_central.add(rdbtnAprobado);
		
		rbtnSuspendido = new JRadioButton("Suspendido");
		rbtnSuspendido.setBackground(Color.WHITE);
		rbtnSuspendido.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		rbtnSuspendido.setBounds(817, 296, 109, 23);
		panel_central.add(rbtnSuspendido);
		Reconocimiento.add(rdbtnAprobado);
		Reconocimiento.add(rbtnSuspendido);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblEstado.setBounds(382, 344, 217, 22);
		panel_central.add(lblEstado);
		
		 estado= new ButtonGroup();
		rdbtnLesionado = new JRadioButton("Lesionado");
		rdbtnLesionado.setBackground(Color.WHITE);
		rdbtnLesionado.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		rdbtnLesionado.setBounds(645, 344, 109, 23);
		panel_central.add(rdbtnLesionado);
		
		rdbtnBien = new JRadioButton("Bien");
		rdbtnBien.setBackground(Color.WHITE);
		rdbtnBien.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		rdbtnBien.setBounds(817, 344, 109, 23);
		panel_central.add(rdbtnBien);
		estado.add(rdbtnLesionado);
		estado.add(rdbtnBien);
		
		Cuota= new ButtonGroup();
		lblCuota = new JLabel("Cuota:");
		lblCuota.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCuota.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblCuota.setBounds(382, 391, 217, 22);
		panel_central.add(lblCuota);
		
		rdbtnPagada = new JRadioButton("Pagada");
		rdbtnPagada.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		rdbtnPagada.setBackground(Color.WHITE);
		rdbtnPagada.setBounds(645, 394, 109, 23);
		panel_central.add(rdbtnPagada);
		
		
		rdbtnNoPagada = new JRadioButton("No pagada");
		rdbtnNoPagada.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		rdbtnNoPagada.setBackground(Color.WHITE);
		rdbtnNoPagada.setBounds(817, 394, 109, 23);
		panel_central.add(rdbtnNoPagada);
		Cuota.add(rdbtnNoPagada);
		Cuota.add(rdbtnPagada);
	}
	
	public void VisualizarJugadores()
	{
		ListaJugadores.clear();
		try {
			ListaJugadores=controller.MostrarJugadores((Categoria)comboCategoria.getSelectedItem());
			for(Jugador j:ListaJugadores)
			{
				comboJugadores.addItem(j.toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void MostrarInformacion()
	{
		if (ListaJugadores.size()==0)return;
		else{
			for(Jugador j: ListaJugadores)
			{
				if(j.toString().equals(comboJugadores.getSelectedItem().toString()))
				{
					lblDNIJugador.setText(j.getDNI());
					lblNombreJugador.setText(j.getNombre()+" "+j.getApellido());
					try {
						lblEquipoJugador.setText(controller.ObtenerEquipoJugador(j));
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(j.isCuota_pagada()) rdbtnPagada.setSelected(true); else rdbtnNoPagada.setSelected(true);
					if(j.isLesionado()) rdbtnLesionado.setSelected(true); else rdbtnBien.setSelected(true);
					if(j.isReconocimiento_medico()) rdbtnAprobado.setSelected(true);else rbtnSuspendido.setSelected(true);
				}
			}
		}
	}

	public void Guardar()
	{
		for(Jugador j:ListaJugadores)
		{
			if(j.toString().equals(comboJugadores.getSelectedItem().toString()))
					{
						try {
							controller.ActualizarJugador(j, rdbtnAprobado.isSelected(), rdbtnLesionado.isSelected(), rdbtnPagada.isSelected());
							lblDNIJugador.setText("");
							lblEquipoJugador.setText("");
							lblNombreJugador.setText("");
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
		}
	}
}
