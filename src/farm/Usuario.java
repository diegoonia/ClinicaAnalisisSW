package farm;

import farm.SQLiteJDBC;
import java.sql.*;

public class Usuario 
{
	public String UserName;
	public String Password;
	
	public Usuario()
	{
		this.UserName = "";
		this.Password = "";
	}
	
	public Usuario(String UserName,String Password)
	{
		this.UserName = UserName;
		this.Password = Password;
	}

	
	
	public boolean Guardar()
	{
		try
		{
			if (this.UserName != "" && this.Password != "")
			{
				SQLiteJDBC.conectar();
				SQLiteJDBC.ejecutarConsulta("INSERT INTO usuarios (username,password) VALUES ('" + this.UserName +"','"+ this.Password +"')","insert");
				SQLiteJDBC.cerrar();
				return true;
			}
			else
			{
				return false;
			}
						
		}
		catch ( Exception e ) 
		{
			return false;
		}
		

	}

	
	public boolean Existe(String UserName)
	{
		try
		{
			SQLiteJDBC.conectar();
			ResultSet rs = SQLiteJDBC.ejecutarConsulta("SELECT * FROM usuarios WHERE username = '" + UserName + "'","select");
			
			if(rs.next())
			{
				SQLiteJDBC.cerrar();
				return true;
			}
			else
			{
				SQLiteJDBC.cerrar();
				return false;
			}
			
			

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
			SQLiteJDBC.conectar();
			ResultSet rs = SQLiteJDBC.ejecutarConsulta("SELECT * FROM usuarios WHERE id = 1","select");
			
			if(rs.next())
			{
				SQLiteJDBC.cerrar();
				return true;
			}
			else
			{
				SQLiteJDBC.cerrar();
				return false;
			}
			
			

		}
		catch ( Exception e ) 
		{
			return false;
		}
		
	}
	
	public boolean Obtener(int codigo)
	{
		try
		{
			SQLiteJDBC.conectar();
			ResultSet rs = SQLiteJDBC.ejecutarConsulta("SELECT * FROM usuarios WHERE id = " + codigo + ";","select");
			
			if(rs.next())
			{
				this.UserName = rs.getString("username");
				this.Password = rs.getString("password");
				SQLiteJDBC.cerrar();
				return true;
			}
			else
			{
				SQLiteJDBC.cerrar();
				return false;
			}

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
