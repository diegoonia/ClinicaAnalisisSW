package farm;

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
import javax.swing.JRootPane;

public class DatosDelPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodPaciente;
	private JTextField txtNombrePaciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosDelPaciente frame = new DatosDelPaciente();
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
	public DatosDelPaciente() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null);
		
		
		

		JLabel lblNewLabel = new JLabel("Codigo del paciente:");
		lblNewLabel.setBounds(10, 11, 176, 14);
		contentPane.add(lblNewLabel);
		
		txtCodPaciente = new JTextField();
		txtCodPaciente.setBounds(10, 36, 105, 20);
		contentPane.add(txtCodPaciente);
		txtCodPaciente.setColumns(10);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(10, 91, 378, 20);
		contentPane.add(txtNombrePaciente);
		
		JLabel lblNombreDelPaciente = new JLabel("Nombre del paciente:");
		lblNombreDelPaciente.setBounds(10, 66, 146, 14);
		contentPane.add(lblNombreDelPaciente);
		
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
		btnAceptar.setBounds(165, 135, 89, 23);
		contentPane.add(btnAceptar);
	}

}
