package farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private static SQLiteJDBC mySQLCon;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		txtUsuario = new JTextField();
		txtUsuario.setBounds(147, 78, 214, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnIngresar = new JButton("INGRESAR");
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
							Menu m = new Menu();
							m.setVisible(true);
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
		
		btnIngresar.setBounds(48, 198, 140, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(25, 81, 67, 17);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("CONTRASE\u00D1A");
		lblContrasena.setBounds(25, 125, 104, 17);
		contentPane.add(lblContrasena);
		
		JButton btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistrar.abrir();
				dispose();
				
			}
		});
		btnRegistrarse.setBounds(226, 198, 135, 23);
		contentPane.add(btnRegistrarse);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(147, 123, 214, 20);
		contentPane.add(txtContrasena);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setSize(new Dimension(25, 25));
		lblLogin.setBounds(168, 11, 74, 30);
		contentPane.add(lblLogin);
	}
}
