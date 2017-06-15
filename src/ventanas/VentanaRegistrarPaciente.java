package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import farm.Paciente;

import javax.swing.JRootPane;
import java.awt.Color;

public class VentanaRegistrarPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodPaciente;
	private JTextField txtNombrePaciente;

	/**
	 * Launch the application.
	 */
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrarPaciente frame = new VentanaRegistrarPaciente();
					frame.setVisible(true);
					
					frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistrarPaciente() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null);
		
		
		

		JLabel lblNewLabel = new JLabel("Codigo del paciente");
		lblNewLabel.setForeground(new Color(102, 153, 204));
		lblNewLabel.setBounds(40, 52, 176, 14);
		contentPane.add(lblNewLabel);
		
		txtCodPaciente = new JTextField();
		txtCodPaciente.setBounds(158, 49, 230, 20);
		contentPane.add(txtCodPaciente);
		txtCodPaciente.setColumns(10);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(158, 91, 230, 20);
		contentPane.add(txtNombrePaciente);
		
		JLabel lblNombreDelPaciente = new JLabel("Nombre del paciente");
		lblNombreDelPaciente.setForeground(new Color(102, 153, 204));
		lblNombreDelPaciente.setBounds(40, 94, 146, 14);
		contentPane.add(lblNombreDelPaciente);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(102, 153, 204));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean datos_correctos = true;
				
				if (txtCodPaciente.getText() == "" || txtNombrePaciente.getText() == "")
				{
					datos_correctos = false;
					JOptionPane.showMessageDialog(null, "Debe ingresar un codigo y un nombre de paciente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				try 
				{
				    Integer.parseInt(txtCodPaciente.getText());
				} 
				catch (NumberFormatException e) 
				{
					datos_correctos = false;
					JOptionPane.showMessageDialog(null, "El codigo de paciente debe ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if (datos_correctos)
				{
					Paciente p = new Paciente(Integer.parseInt(txtCodPaciente.getText()),txtNombrePaciente.getText());
					if (!p.Existe())
					{
						p.Guardar();
						JOptionPane.showMessageDialog(null, "El paciente se registro con exito", "Error", JOptionPane.INFORMATION_MESSAGE);
						txtCodPaciente.setText("");
						txtNombrePaciente.setText("");
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Ya existe un paciente con el codigo ingresado", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}

			}
		});
		btnAceptar.setBounds(123, 159, 158, 23);
		contentPane.add(btnAceptar);
	}

}
