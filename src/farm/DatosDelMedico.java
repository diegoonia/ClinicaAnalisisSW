package farm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DatosDelMedico {

	private JFrame frame;
	private JTextField txtCodigoMedico;
	private JTextField txtNombreApellido;
	private JTextField txtEspecializacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosDelMedico window = new DatosDelMedico();
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
	public DatosDelMedico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 267);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo del Medico");
		lblNewLabel.setBounds(10, 11, 98, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtCodigoMedico = new JTextField();
		txtCodigoMedico.setBounds(10, 36, 86, 20);
		frame.getContentPane().add(txtCodigoMedico);
		txtCodigoMedico.setColumns(10);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y Apellido");
		lblNombreYApellido.setBounds(10, 67, 116, 14);
		frame.getContentPane().add(lblNombreYApellido);
		
		txtNombreApellido = new JTextField();
		txtNombreApellido.setColumns(10);
		txtNombreApellido.setBounds(10, 92, 332, 20);
		frame.getContentPane().add(txtNombreApellido);
		
		JLabel lblEspecializacion = new JLabel("Especializacion");
		lblEspecializacion.setBounds(10, 123, 116, 14);
		frame.getContentPane().add(lblEspecializacion);
		
		txtEspecializacion = new JTextField();
		txtEspecializacion.setColumns(10);
		txtEspecializacion.setBounds(10, 148, 332, 20);
		frame.getContentPane().add(txtEspecializacion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
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
					JOptionPane.showMessageDialog(null, "El codigo de medico debe ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if (datos_correctos)
				{
					Medico m = new Medico(Integer.parseInt(txtCodigoMedico.getText()),txtNombreApellido.getText(),txtEspecializacion.getText());
					if (!m.Existe())
					{
						m.Guardar();

						JOptionPane.showMessageDialog(null, "El medico se registro con exito", "Error", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "El medico ingresado ya existe", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				
			}
		});
		btnAceptar.setBounds(100, 195, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(280, 195, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}
}
