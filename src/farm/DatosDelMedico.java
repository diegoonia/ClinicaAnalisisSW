package farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import  java.lang.Object;


public class DatosDelMedico extends JFrame {

	private JPanel contentPane;
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
					DatosDelMedico frame = new DatosDelMedico();
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
	public DatosDelMedico() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		
		JLabel lblNewLabel = new JLabel("Codigo del Medico");
		lblNewLabel.setBounds(10, 11, 234, 14);
		contentPane.add(lblNewLabel);
		
		txtCodigoMedico = new JTextField();
		txtCodigoMedico.setBounds(10, 36, 86, 20);
		contentPane.add(txtCodigoMedico);
		txtCodigoMedico.setColumns(10);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y Apellido");
		lblNombreYApellido.setBounds(10, 67, 116, 14);
		contentPane.add(lblNombreYApellido);
		
		txtNombreApellido = new JTextField();
		txtNombreApellido.setColumns(10);
		txtNombreApellido.setBounds(10, 92, 332, 20);
		contentPane.add(txtNombreApellido);
		
		JLabel lblEspecializacion = new JLabel("Especializacion");
		lblEspecializacion.setBounds(10, 123, 116, 14);
		contentPane.add(lblEspecializacion);
		
		txtEspecializacion = new JTextField();
		txtEspecializacion.setColumns(10);
		txtEspecializacion.setBounds(10, 148, 332, 20);
		contentPane.add(txtEspecializacion);
		
		JButton btnAceptar = new JButton("Aceptar");
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
					JOptionPane.showMessageDialog(null, "El codigo de medico debe ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
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
		btnAceptar.setBounds(171, 179, 89, 23);
		contentPane.add(btnAceptar);
	}

}
