package farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.HeadlessException;

public class VentanaRegistrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JTextField txtNyAp;
	private static SQLiteJDBC mySQLCon;

	/**
	 * Launch the application.
	 */
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mySQLCon = new SQLiteJDBC();
					mySQLCon.getConnection();
					VentanaRegistrar frame = new VentanaRegistrar();
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
	public VentanaRegistrar() {
		setTitle("REGISTRAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(167, 102, 194, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if( txtUsuario.getText()=="" && String.valueOf(txtContrasena.getPassword())=="" && txtNyAp.getText()=="" )
				{
					JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
				}
				else
				{ 
					try {
						
						try {
						     Integer.parseInt(txtUsuario.getText()); // transformo el txtusuario a INT, si tira error va al catch
						     if( mySQLCon.registrarMedico(txtUsuario.getText(), String.valueOf(txtContrasena.getPassword()), txtNyAp.getText() ))
								{
									JOptionPane.showMessageDialog(null, "TODO BIEN, ACA IRIA A LA PANTALLA PRINCIPAL");
								}
								else
								{
									JOptionPane.showMessageDialog(null, "ESE USUARIO YA EXISTE");
								}
						}
						catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "EL USUARIO DEBE SER NUMERICO");
						}
						
						
					} catch (HeadlessException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		btnAceptar.setBounds(48, 198, 140, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(25, 104, 67, 17);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("CONTRASE\u00D1A");
		lblContrasena.setBounds(25, 132, 104, 17);
		contentPane.add(lblContrasena);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin.abrir();
				dispose();
			}
		});
		btnCancelar.setBounds(226, 198, 135, 23);
		contentPane.add(btnCancelar);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(167, 130, 194, 19);
		contentPane.add(txtContrasena);
		
		JLabel lblNewLabel = new JLabel("REGISTRARSE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(147, 11, 140, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE Y APELLIDO");
		lblNewLabel_1.setBounds(24, 79, 135, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNyAp = new JTextField();
		txtNyAp.setColumns(10);
		txtNyAp.setBounds(167, 76, 194, 19);
		contentPane.add(txtNyAp);
		
		
	}
}
