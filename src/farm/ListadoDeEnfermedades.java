package farm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListadoDeEnfermedades {

	private JFrame frame;
	private JTextField txtCodigoMedico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoDeEnfermedades window = new ListadoDeEnfermedades();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListadoDeEnfermedades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 695, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		JList<String> list = new JList<>(dlm);
		list.setVisible(false);
		JScrollPane scrollpane = new JScrollPane(list);
		scrollpane.setBounds(10, 113, 659, 298);
		frame.getContentPane().add(scrollpane);
		
		
		
		
		JLabel lblCodigoDelMedico = new JLabel("Codigo del Medico");
		lblCodigoDelMedico.setBounds(10, 14, 126, 14);
		frame.getContentPane().add(lblCodigoDelMedico);
		
		txtCodigoMedico = new JTextField();
		txtCodigoMedico.setBounds(123, 11, 86, 20);
		frame.getContentPane().add(txtCodigoMedico);
		txtCodigoMedico.setColumns(10);
		
		
		JLabel lblEncabezadoInforme = new JLabel("");
		lblEncabezadoInforme.setForeground(new Color(0, 102, 204));
		lblEncabezadoInforme.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEncabezadoInforme.setBounds(10, 48, 659, 36);
		frame.getContentPane().add(lblEncabezadoInforme);
		
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
						ArrayList<String> enfermedades = m.ObtenerEnfermedades();

						for (String enfermedad:enfermedades)
						{
							dlm.addElement(enfermedad);
						}
						
						lblEncabezadoInforme.setText("Las enfermedades atendidas por el medico " + m.NombreYApellido + " son las siguientes:");
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
		btnConsultar.setBounds(251, 10, 89, 23);
		frame.getContentPane().add(btnConsultar);
		
	
		
		 
	}
}
