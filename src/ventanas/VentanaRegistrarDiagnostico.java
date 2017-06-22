package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import farm.Medico;
import farm.Paciente;
import farm.SituacionPaciente;

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


public class VentanaRegistrarDiagnostico extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtCodPaciente;
	private JTextField txtCodMedico;
	private JTextField txtDiagnostico;
	private boolean paciente_correcto = false;
	private boolean medico_correcto = false;
	private JLabel lblPacienteNombre;
	private JLabel lblMedicoNombre;

	/**
	 * Launch the application.
	 */
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrarDiagnostico frame = new VentanaRegistrarDiagnostico();
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
	public VentanaRegistrarDiagnostico() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 242);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		

		JLabel lblCodigoDelPaciente = new JLabel("Codigo del Paciente");
		lblCodigoDelPaciente.setForeground(new Color(102, 153, 204));
		lblCodigoDelPaciente.setBounds(40, 39, 136, 14);
		contentPane.add(lblCodigoDelPaciente);
		
		JLabel lblCodigoDelMedico = new JLabel("Codigo del Medico");
		lblCodigoDelMedico.setForeground(new Color(102, 153, 204));
		lblCodigoDelMedico.setBounds(40, 75, 136, 14);
		contentPane.add(lblCodigoDelMedico);
		
		lblPacienteNombre = new JLabel("");
		lblPacienteNombre.setForeground(Color.RED);
		lblPacienteNombre.setBounds(164, 57, 136, 14);
		contentPane.add(lblPacienteNombre);
		
		lblMedicoNombre = new JLabel("");
		lblMedicoNombre.setForeground(Color.RED);
		lblMedicoNombre.setBounds(165, 95, 136, 14);
		contentPane.add(lblMedicoNombre);

		
		txtCodMedico = new JTextField();
		txtCodMedico.setBounds(164, 72, 223, 20);
		contentPane.add(txtCodMedico);
		txtCodMedico.setColumns(10);
		
		txtCodPaciente = new JTextField();
		txtCodPaciente.setBounds(164, 36, 223, 20);
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
									lblMedicoNombre.setText(m.NombreYApellido);
									medico_correcto = true;
								}
								else
								{
									lblMedicoNombre.setText("");
									medico_correcto = false;
								}
							}
						}
						catch (NumberFormatException m)
						{
							//JOptionPane.showMessageDialog(null, "Ingrese un codigo numerico ", "Error", JOptionPane.ERROR_MESSAGE);
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
									lblPacienteNombre.setText(p.NombreYApellido);
									paciente_correcto = true;
								}
								else
								{
									lblPacienteNombre.setText("");
									paciente_correcto = false;
								}
							}
						}
						catch (NumberFormatException ec)
						{
							//JOptionPane.showMessageDialog(null, "Ingrese un codigo numerico", "Error", JOptionPane.ERROR_MESSAGE);
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
		lblDiagnostico.setForeground(new Color(102, 153, 204));
		lblDiagnostico.setBounds(40, 114, 136, 14);
		contentPane.add(lblDiagnostico);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(102, 153, 204));
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (paciente_correcto && medico_correcto)
				{
					if (!txtDiagnostico.getText().trim().isEmpty())
					{
						SituacionPaciente sp = new SituacionPaciente(Integer.parseInt(txtCodPaciente.getText()),Integer.parseInt(txtCodMedico.getText()),txtDiagnostico.getText());
						sp.Guardar();
						JOptionPane.showMessageDialog(null, "Diagnóstico archivado con exito", "Error", JOptionPane.INFORMATION_MESSAGE);
						txtCodMedico.setText("");
						txtCodPaciente.setText("");
						txtDiagnostico.setText("");
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Ingrese un diagnóstico", "Error", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Paciente y/o Médico incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(126, 157, 151, 23);
		contentPane.add(btnAceptar);
		
		txtDiagnostico = new JTextField();
		txtDiagnostico.setColumns(10);
		txtDiagnostico.setBounds(164, 111, 223, 20);
		contentPane.add(txtDiagnostico);
	}

}
