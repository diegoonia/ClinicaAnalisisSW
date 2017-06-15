package ventanas;

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
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.*;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public VentanaMenu() throws IOException {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		setTitle("MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 550);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		
		
		getContentPane().setLayout(null);
		

		
		
		JButton btnRegistrarPaciente = new JButton("Registrar paciente");
		btnRegistrarPaciente.setForeground(new Color(255, 255, 255));
		btnRegistrarPaciente.setBackground(new Color(102, 153, 204));
		btnRegistrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistrarPaciente.abrir();
			}
		});
		btnRegistrarPaciente.setBounds(347, 199, 175, 23);
		getContentPane().add(btnRegistrarPaciente);
		
		JButton btnRegistrarMedico = new JButton("Registrar m\u00E9dico");
		btnRegistrarMedico.setForeground(new Color(255, 255, 255));
		btnRegistrarMedico.setBackground(new Color(102, 153, 204));
		btnRegistrarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistrarMedico.abrir();
			}
		});
		
		btnRegistrarMedico.setBounds(347, 142, 175, 23);
		getContentPane().add(btnRegistrarMedico);
		
		JButton btnRegistrarDiagnostico = new JButton("Registrar diagn\u00F3stico");
		btnRegistrarDiagnostico.setForeground(new Color(255, 255, 255));
		btnRegistrarDiagnostico.setBackground(new Color(102, 153, 204));
		btnRegistrarDiagnostico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistrarDiagnostico.abrir();
			}
		});
		btnRegistrarDiagnostico.setBounds(347, 257, 175, 23);
		getContentPane().add(btnRegistrarDiagnostico);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 323, 580, 177);
		getContentPane().add(separator);
		
		JButton btnConsultarPacientesDe = new JButton("Consultar pacientes de m\u00E9dico");
		btnConsultarPacientesDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPacientesPorMedico.abrir();
			}
		});
		btnConsultarPacientesDe.setBounds(198, 389, 237, 23);
		btnConsultarPacientesDe.setForeground(new Color(255, 255, 255));
		btnConsultarPacientesDe.setBackground(new Color(102, 153, 204));
		getContentPane().add(btnConsultarPacientesDe);
		
		JButton btnConsultarDiagnosticosDe = new JButton("Consultar diagnosticos de m\u00E9dico");
		btnConsultarDiagnosticosDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaDiagnosticosPorMedico.abrir();
			}
		});
		btnConsultarDiagnosticosDe.setBounds(198, 435, 237, 23);
		btnConsultarDiagnosticosDe.setForeground(new Color(255, 255, 255));
		btnConsultarDiagnosticosDe.setBackground(new Color(102, 153, 204));
		getContentPane().add(btnConsultarDiagnosticosDe);
		
		JLabel lblRegistros = new JLabel("Registros");
		lblRegistros.setForeground(new Color(102, 153, 204));
		lblRegistros.setFont(new Font("Calibri", Font.BOLD, 32));
		lblRegistros.setBounds(368, 82, 167, 39);
		getContentPane().add(lblRegistros);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setForeground(new Color(102, 153, 204));
		lblConsultas.setFont(new Font("Calibri", Font.BOLD, 32));
		lblConsultas.setBounds(249, 339, 167, 39);
		getContentPane().add(lblConsultas);
		
		String path = "nick.png";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("nick.png").getImage().getScaledInstance(150, 250, Image.SCALE_DEFAULT));

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(58, 54, 203, 258);
		getContentPane().add(lblNewLabel);
		
		JLabel lblBienvenidoAlHospital = new JLabel("Bienvenido al Hospital Springfield");
		lblBienvenidoAlHospital.setForeground(new Color(102, 153, 204));
		lblBienvenidoAlHospital.setFont(new Font("Calibri", Font.BOLD, 32));
		lblBienvenidoAlHospital.setBounds(99, 11, 464, 39);
		getContentPane().add(lblBienvenidoAlHospital);
		
	}
}
