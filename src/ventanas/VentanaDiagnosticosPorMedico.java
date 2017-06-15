package ventanas;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import farm.Medico;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaDiagnosticosPorMedico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoMedico;

	/**
	 * Launch the application.
	 */
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDiagnosticosPorMedico frame = new VentanaDiagnosticosPorMedico();
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
	public VentanaDiagnosticosPorMedico() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 699, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		DefaultListModel<String> dlm = new DefaultListModel<String>();
		JList<String> list = new JList<>(dlm);
		list.setForeground(new Color(51, 102, 153));
		list.setVisible(false);
		JScrollPane scrollpane = new JScrollPane(list);
		scrollpane.setBounds(10, 113, 659, 298);
		contentPane.add(scrollpane);
		
		
		
		
		JLabel lblCodigoDelMedico = new JLabel("Codigo del Medico");
		lblCodigoDelMedico.setForeground(new Color(102, 153, 204));
		lblCodigoDelMedico.setBounds(10, 14, 126, 14);
		contentPane.add(lblCodigoDelMedico);
		
		txtCodigoMedico = new JTextField();
		txtCodigoMedico.setBounds(123, 11, 86, 20);
		contentPane.add(txtCodigoMedico);
		txtCodigoMedico.setColumns(10);
		
		
		JLabel lblEncabezadoInforme = new JLabel("");
		lblEncabezadoInforme.setForeground(new Color(102, 153, 204));
		lblEncabezadoInforme.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEncabezadoInforme.setBounds(10, 66, 659, 36);
		contentPane.add(lblEncabezadoInforme);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(new Color(102, 153, 204));
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				list.setVisible(false);
				lblEncabezadoInforme.setVisible(false);
				try
				{
					Medico m = new Medico(Integer.parseInt(txtCodigoMedico.getText()));
					if (m.Codigo != null)
					{
						dlm.removeAllElements();
						ArrayList<String> enfermedades = m.ObtenerEnfermedades();

						for (String enfermedad:enfermedades)
						{
							dlm.addElement(enfermedad);
						}
						
						lblEncabezadoInforme.setText("Enfermedades atendidas por el medico " + m.NombreYApellido);
						lblEncabezadoInforme.setVisible(true);
						
						list.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Codigo de medico no encontrado", "Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Ingrese un codigo de medico correcto", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			
					
			
			}
		});
		btnConsultar.setBounds(251, 10, 126, 23);
		contentPane.add(btnConsultar);

	}

}
