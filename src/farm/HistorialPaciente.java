package farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;


public class HistorialPaciente extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtCodPaciente;
	private JTextField txtCodMedico;
	private JTextField txtDiagnostico;
	private boolean paciente_correcto = false;
	private boolean medico_correcto = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistorialPaciente frame = new HistorialPaciente();
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
	public HistorialPaciente() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		

		JLabel lblCodigoDelPaciente = new JLabel("Codigo del Paciente");
		lblCodigoDelPaciente.setBounds(10, 11, 136, 14);
		contentPane.add(lblCodigoDelPaciente);
		
		JLabel lblCodigoDelMedico = new JLabel("Codigo del Medico");
		lblCodigoDelMedico.setBounds(10, 64, 136, 14);
		contentPane.add(lblCodigoDelMedico);
		
		
		
		
		JLabel lblPaciente = new JLabel(" ");
		lblPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPaciente.setForeground(Color.RED);
		lblPaciente.setBounds(242, 11, 252, 14);
		contentPane.add(lblPaciente);
		
		JLabel lblMedico = new JLabel("");
		lblMedico.setForeground(Color.RED);
		lblMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMedico.setBounds(242, 64, 252, 14);
		contentPane.add(lblMedico);
		
		
		
		
		
		
		txtCodMedico = new JTextField();
		txtCodMedico.setBounds(146, 61, 86, 20);
		contentPane.add(txtCodMedico);
		txtCodMedico.setColumns(10);
		
		txtCodPaciente = new JTextField();
		txtCodPaciente.setBounds(146, 8, 86, 20);
		contentPane.add(txtCodPaciente);
		txtCodPaciente.setColumns(10);
		
		
		
		FocusAdapter fa = new FocusAdapter() {
			@Override
			public void focusLost(java.awt.event.FocusEvent focusEvent) 
		    {
		        try 
		        {
		            JTextField src = (JTextField)focusEvent.getSource();
		            
		            if(src == txtCodMedico)
		            {
		            	try
						{
							Integer.parseInt(txtCodMedico.getText());
						
							if (txtCodMedico.getText() != "")
							{
								Medico m = new Medico(Integer.parseInt(txtCodMedico.getText()));
								if (m.Codigo != null)
								{
									lblMedico.setText(m.NombreYApellido);
									medico_correcto = true;
								}
								else
								{
									lblMedico.setText("");
									JOptionPane.showMessageDialog(null, "Codigo de medico incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
									medico_correcto = false;
								}
							}
						}
						catch (NumberFormatException m)
						{
							lblMedico.setText("");
							JOptionPane.showMessageDialog(null, "Ingrese un codigo numerico ", "Error", JOptionPane.ERROR_MESSAGE);
							medico_correcto = false;
						}
		            
		            
		            }
		            
		            
		            
		            
		            if(src == txtCodPaciente)
		            {
		            	try
						{
							Integer.parseInt(txtCodPaciente.getText());
							
							if (txtCodPaciente.getText() != "")
							{
								Paciente p = new Paciente(Integer.parseInt(txtCodPaciente.getText()));
								if (p.Codigo != null)
								{
									lblPaciente.setText(p.NombreYApellido);
									paciente_correcto = true;
								}
								else
								{
									lblPaciente.setText("");
									JOptionPane.showMessageDialog(null, "Codigo de paciente incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
									paciente_correcto = false;
								}
							}
						}
						catch (NumberFormatException ec)
						{
							lblPaciente.setText("");
							JOptionPane.showMessageDialog(null, "Ingrese un codigo numerico", "Error", JOptionPane.ERROR_MESSAGE);
							paciente_correcto = false;
						}
		            
		            
		            }
		            
		            
		        } 
		        catch (ClassCastException ignored) 
		        {
		            /* I only listen to JTextFields */
		        }
		    }
		};
		
		txtCodMedico.addFocusListener(fa);
		txtCodPaciente.addFocusListener(fa);
		

		
		JLabel lblDiagnostico = new JLabel("Diagnostico");
		lblDiagnostico.setBounds(10, 114, 136, 14);
		contentPane.add(lblDiagnostico);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (paciente_correcto && medico_correcto)
				{
					if (!txtDiagnostico.getText().trim().isEmpty())
					{
						SituacionPaciente sp = new SituacionPaciente(Integer.parseInt(txtCodPaciente.getText()),Integer.parseInt(txtCodMedico.getText()),txtDiagnostico.getText());
						sp.Guardar();
						JOptionPane.showMessageDialog(null, "Situacion guardad con exito", "Error", JOptionPane.INFORMATION_MESSAGE);
						txtCodMedico.setText("");
						txtCodPaciente.setText("");
						txtDiagnostico.setText("");
						lblMedico.setText("");
						lblPaciente.setText("");
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Ingrese un diagnostico", "Error", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Paciente y/o Medico incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(188, 157, 89, 23);
		contentPane.add(btnAceptar);
		
		txtDiagnostico = new JTextField();
		txtDiagnostico.setColumns(10);
		txtDiagnostico.setBounds(146, 111, 278, 20);
		contentPane.add(txtDiagnostico);
	}

}
