package farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 103);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		setLocationRelativeTo(null);
		
		DatosDelPaciente dp = new DatosDelPaciente();
		DatosDelMedico dm = new DatosDelMedico();
		HistorialPaciente hp = new HistorialPaciente();
		ListadoDePacientesPorMedico lpm = new ListadoDePacientesPorMedico();
		ListadoDeEnfermedadesPorMedico lem = new ListadoDeEnfermedadesPorMedico();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnIngresoDeDatos = new JMenu("Ingreso de Datos");
		menuBar.add(mnIngresoDeDatos);
		
		JMenuItem mntmDatosDelPaciente = new JMenuItem("Datos del Paciente");
		mntmDatosDelPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				dp.setVisible(true);
			}
		});
		mnIngresoDeDatos.add(mntmDatosDelPaciente);
		
		JMenuItem mntmDatosDelMedico = new JMenuItem("Datos del Medico");
		mntmDatosDelMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dm.setVisible(true);
			}
		});
		mnIngresoDeDatos.add(mntmDatosDelMedico);
		
		JMenuItem mntmSituacionDePaciente = new JMenuItem("Situacion de Paciente");
		mntmSituacionDePaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hp.setVisible(true);
			}
		});
		mnIngresoDeDatos.add(mntmSituacionDePaciente);
		
		JMenu mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		JMenuItem mntmListadoDePacientes = new JMenuItem("Listado de pacientes por medico");
		mntmListadoDePacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				lpm.setVisible(true);
			}
		});
		mnInformes.add(mntmListadoDePacientes);
		
		JMenuItem mntmListadoDeEnfermedades = new JMenuItem("Listado de enfermedades por medico");
		mntmListadoDeEnfermedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				lem.setVisible(true);
			}
		});
		mnInformes.add(mntmListadoDeEnfermedades);
	}

}
