package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import farm.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

public class VentanaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		abrir();
	}

	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaLogin() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		txtUsuario = new JTextField();
		txtUsuario.setBounds(147, 102, 214, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(102, 153, 204));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if( txtUsuario.getText().equals("") || String.valueOf(txtContrasena.getPassword()).equals("") )
				{
					JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
				}
				else
				{ 
					try 
					{
						Usuario u = new Usuario(txtUsuario.getText(),String.valueOf(txtContrasena.getPassword()));
						if(u.Valido())
						{
							VentanaMenu.abrir();
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTOS");
						}
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		btnIngresar.setBounds(51, 226, 140, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(new Color(102, 153, 204));
		lblUsuario.setBounds(25, 104, 67, 17);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("CONTRASE\u00D1A");
		lblContrasena.setForeground(new Color(102, 153, 204));
		lblContrasena.setBounds(25, 148, 104, 17);
		contentPane.add(lblContrasena);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBackground(new Color(102, 153, 204));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistrar.abrir();
				dispose();
				
			}
		});
		btnRegistrarse.setBounds(225, 226, 135, 23);
		contentPane.add(btnRegistrarse);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(147, 146, 214, 20);
		contentPane.add(txtContrasena);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(102, 153, 204));
		lblLogin.setFont(new Font("Calibri", Font.BOLD, 32));
		lblLogin.setSize(new Dimension(25, 25));
		lblLogin.setBounds(173, 25, 111, 31);
		contentPane.add(lblLogin);
	}
}
