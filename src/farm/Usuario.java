package farm;

import java.sql.*;

import javax.swing.JOptionPane;

import basededatos.SQLiteJDBC;

public class Usuario 
{
	public String UserName;
	public String Password;
	
	public Usuario()
	{
		this.UserName = "";
		this.Password = "";
	}
	
	public Usuario(int Codigo)
	{
		
	}

	
	public Usuario(String UserName,String Password)
	{
		this.UserName = UserName;
		this.Password = Password;
	}

	
	
	public void Guardar()
	{
		try
		{
			Connection conn = SQLiteJDBC.conectar();
			
			Statement sentencia = conn.createStatement();
			
			sentencia.execute("INSERT INTO `usuarios`(`username`,`password`) VALUES (\""+this.UserName+"\",\""+this.Password+"\")");
			
			sentencia.close();
			conn.commit();
			
			SQLiteJDBC.cerrar();
						
		}
		catch ( Exception e ) 
		{
		
		}
		

	}

	
	public boolean Existe()
	{
		try
		{
			boolean resultado;
			
			Connection conn = SQLiteJDBC.conectar();
			
			Statement sentencia = conn.createStatement();
			
			ResultSet rs = sentencia.executeQuery("SELECT * FROM usuarios WHERE username = '" + this.UserName + "'");
			

			if(rs.next())
			{
				resultado = true;
			}
			else
			{
				resultado = false;
			}
			
			
			SQLiteJDBC.cerrar();
			
			return resultado;
			
		}
		catch ( Exception e ) 
		{
			return false;
		}
		
	}
	

	public boolean Valido()
	{
		try
		{
			boolean resultado;
			
			Connection conn = SQLiteJDBC.conectar();
			
			Statement sentencia = conn.createStatement();
			
			ResultSet rs = sentencia.executeQuery("SELECT * FROM usuarios WHERE username = '" + this.UserName + "' and password = '" + this.Password + "'");
			

			if(rs.next())
			{
				resultado = true;
			}
			else
			{
				resultado = false;
			}
			
			
			SQLiteJDBC.cerrar();
			
			return resultado;
			
		}
		catch ( Exception e ) 
		{
			return false;
		}
		
	}
	

	public String MostrarDatos()
	{
		return "Username: " + this.UserName + " Password:" + this.Password;
	}
}
