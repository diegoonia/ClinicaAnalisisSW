package farm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import farm.Paciente;

public class DatosDelPaciente {

	private JFrame frame;
	private JTextField txtCodPaciente;
	private JTextField txtNombrePaciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosDelPaciente window = new DatosDelPaciente();
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
	public DatosDelPaciente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 232);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo del paciente:");
		lblNewLabel.setBounds(10, 11, 176, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtCodPaciente = new JTextField();
		txtCodPaciente.setBounds(10, 36, 105, 20);
		frame.getContentPane().add(txtCodPaciente);
		txtCodPaciente.setColumns(10);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(10, 91, 378, 20);
		frame.getContentPane().add(txtNombrePaciente);
		
		JLabel lblNombreDelPaciente = new JLabel("Nombre del paciente:");
		lblNombreDelPaciente.setBounds(10, 66, 146, 14);
		frame.getContentPane().add(lblNombreDelPaciente);
		
		JButton btnAceptar = new JButton("Aceptar");
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
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Ya existe un medico con el codigo ingresado", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}

			}
		});
		btnAceptar.setBounds(67, 138, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(276, 138, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}
}
