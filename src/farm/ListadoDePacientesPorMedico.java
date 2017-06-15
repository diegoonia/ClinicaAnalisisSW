package farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.DefaultListModel;

public class ListadoDePacientesPorMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoMedico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoDePacientesPorMedico frame = new ListadoDePacientesPorMedico();
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
	public ListadoDePacientesPorMedico() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 622, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		

		DefaultListModel<String> dlm = new DefaultListModel<String>();
		JList<String> list = new JList<>(dlm);
		list.setVisible(false);
		contentPane.setLayout(null);
		JScrollPane scrollpane = new JScrollPane(list);
		scrollpane.setBounds(10, 112, 589, 299);
		contentPane.add(scrollpane);
		
		txtCodigoMedico = new JTextField();
		txtCodigoMedico.setBounds(140, 11, 86, 20);
		contentPane.add(txtCodigoMedico);
		txtCodigoMedico.setColumns(10);
		
		JLabel lblCodigoDelMedico = new JLabel("Codigo del Medico");
		lblCodigoDelMedico.setBounds(10, 14, 126, 14);
		contentPane.add(lblCodigoDelMedico);
		
		JLabel lblEncabezadoInforme = new JLabel("");
		lblEncabezadoInforme.setForeground(new Color(0, 102, 204));
		lblEncabezadoInforme.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEncabezadoInforme.setBounds(10, 48, 589, 36);
		contentPane.add(lblEncabezadoInforme);
		
		JButton btnConsultar = new JButton("Consultar");
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
						ArrayList<String> pacientes = m.ObtenerPacientes();

						for (String paciente:pacientes)
						{
							dlm.addElement(paciente);
						}
						
						lblEncabezadoInforme.setText("Los pacientes atendidos por el medico " + m.NombreYApellido + " son los siguientes:");
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
		btnConsultar.setBounds(267, 11, 95, 20);
		contentPane.add(btnConsultar);
		
	}

}
