package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import farm.Medico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import  java.lang.Object;
import java.awt.Color;


public class VentanaRegistrarMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoMedico;
	private JTextField txtNombreApellido;
	private JTextField txtEspecializacion;


	/**
	 * Launch the application.
	 */
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrarMedico frame = new VentanaRegistrarMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private boolean validarLetras(String s)
	{
		for (int i = 0; i < s.length(); i++) 
		{
	        char charAt2 = s.charAt(i);
	        if (!(Character.isLetter(charAt2) || Character.isSpaceChar(charAt2))) 
	        {
	            return false;
	        }
	        
	        
	    }
		return true;
	}
	/**
	 * Create the frame.
	 */
	public VentanaRegistrarMedico() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 249);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		
		JLabel lblNewLabel = new JLabel("Codigo del Medico");
		lblNewLabel.setForeground(new Color(102, 153, 204));
		lblNewLabel.setBounds(26, 39, 234, 14);
		contentPane.add(lblNewLabel);
		
		txtCodigoMedico = new JTextField();
		txtCodigoMedico.setBounds(136, 36, 247, 20);
		contentPane.add(txtCodigoMedico);
		txtCodigoMedico.setColumns(10);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y Apellido");
		lblNombreYApellido.setForeground(new Color(102, 153, 204));
		lblNombreYApellido.setBounds(26, 80, 116, 14);
		contentPane.add(lblNombreYApellido);
		
		txtNombreApellido = new JTextField();
		txtNombreApellido.setColumns(10);
		txtNombreApellido.setBounds(136, 77, 247, 20);
		contentPane.add(txtNombreApellido);
		
		JLabel lblEspecializacion = new JLabel("Especializacion");
		lblEspecializacion.setForeground(new Color(102, 153, 204));
		lblEspecializacion.setBounds(26, 123, 116, 14);
		contentPane.add(lblEspecializacion);
		
		txtEspecializacion = new JTextField();
		txtEspecializacion.setColumns(10);
		txtEspecializacion.setBounds(136, 120, 247, 20);
		contentPane.add(txtEspecializacion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(102, 153, 204));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				boolean datos_correctos = true;
				
				if (txtCodigoMedico.getText() == "" || txtNombreApellido.getText() == "" || txtEspecializacion.getText() == ""  )
				{
					datos_correctos = false;
					JOptionPane.showMessageDialog(null, "Debe ingresar un codigo, un nombre de medico y especializacion", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				try 
				{
				    Integer.parseInt(txtCodigoMedico.getText());
				} 
				catch (NumberFormatException e) 
				{
					datos_correctos = false;
					JOptionPane.showMessageDialog(null, "El codigo de medico debe ser entero", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if ((txtCodigoMedico.getText()).length() != 5)
				{
					datos_correctos = false;
					JOptionPane.showMessageDialog(null, "El codigo debe tener una longitud de 5 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if (!validarLetras(txtNombreApellido.getText()))
				{
					datos_correctos = false;
					JOptionPane.showMessageDialog(null, "El nombre y apellido deben ser letras del alfabeto", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if (!validarLetras(txtEspecializacion.getText()))
				{
					datos_correctos = false;
					JOptionPane.showMessageDialog(null, "La especializacion debe contener letras del alfabeto", "Error", JOptionPane.ERROR_MESSAGE);
				}

				if (Integer.parseInt(txtCodigoMedico.getText()) < 1 ||  Integer.parseInt(txtCodigoMedico.getText()) > 99999)
				{
					datos_correctos = false;
					JOptionPane.showMessageDialog(null, "El codigo debe estar en un rango de 1 a 99999", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if (txtNombreApellido.getText().trim().length() < 1 || txtNombreApellido.getText().trim().length() > 40)
				{
					datos_correctos = false;
					JOptionPane.showMessageDialog(null, "El nombre del medico debe poseer entre 1 y 40 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if (txtEspecializacion.getText().trim().length() < 1 || txtEspecializacion.getText().trim().length() > 50)
				{
					datos_correctos = false;
					JOptionPane.showMessageDialog(null, "La especialidad debe poseer entre 1 y 50 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				if (datos_correctos)
				{
					Medico m = new Medico(Integer.parseInt(txtCodigoMedico.getText()),txtNombreApellido.getText(),txtEspecializacion.getText());
					if (!m.Existe())
					{
						m.Guardar();

						JOptionPane.showMessageDialog(null, "El medico se registro con exito", "Error", JOptionPane.INFORMATION_MESSAGE);
						txtCodigoMedico.setText("");
						txtEspecializacion.setText("");
						txtNombreApellido.setText("");
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "El medico ingresado ya existe", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				
			}
		});
		btnAceptar.setBounds(136, 176, 143, 23);
		contentPane.add(btnAceptar);
	}


}
