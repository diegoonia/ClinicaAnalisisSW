package ventanas;

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

import basededatos.SQLiteJDBC;
import farm.Usuario;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;

public class VentanaRegistrar extends JFrame 
{

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private static SQLiteJDBC mySQLCon;

	/**
	 * Launch the application.
	 */
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		txtUsuario = new JTextField();
		txtUsuario.setBounds(167, 99, 194, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnAceptar = new JButton("Registrar");
		btnAceptar.setBackground(new Color(102, 153, 204));
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				boolean datos_validos = true;
				
				if( txtUsuario.getText()=="" && String.valueOf(txtContrasena.getPassword())=="")
				{
					datos_validos = false;
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
				}
				else
				{ 
						try 
						{
							Integer.parseInt(txtUsuario.getText()); // transformo el txtusuario a INT, si tira error va al catch
						}
						catch (NumberFormatException e) 
						{
							datos_validos = false;
							JOptionPane.showMessageDialog(null, "El usuario debe ser numerico");
						}
						
						if (datos_validos == true)
						{
							Usuario u = new Usuario(txtUsuario.getText(),String.valueOf(txtContrasena.getPassword()));
							 
							if(!u.Existe())
							{
								u.Guardar();
								JOptionPane.showMessageDialog(null, "REGISTRADO CON EXITO");
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "ESE USUARIO YA EXISTE");
							}
						}
				}
			}
		});
		
		btnAceptar.setBounds(52, 215, 140, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(new Color(102, 153, 204));
		lblUsuario.setBounds(25, 101, 67, 17);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("CONTRASE\u00D1A");
		lblContrasena.setForeground(new Color(102, 153, 204));
		lblContrasena.setBounds(25, 145, 104, 17);
		contentPane.add(lblContrasena);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(102, 153, 204));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin.abrir();
				dispose();
			}
		});
		btnCancelar.setBounds(227, 215, 135, 23);
		contentPane.add(btnCancelar);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(167, 143, 194, 19);
		contentPane.add(txtContrasena);
		
		JLabel lblNewLabel = new JLabel("Registrarse");
		lblNewLabel.setForeground(new Color(102, 153, 204));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 32));
		lblNewLabel.setBounds(124, 25, 188, 34);
		contentPane.add(lblNewLabel);
		
		
	}
}
