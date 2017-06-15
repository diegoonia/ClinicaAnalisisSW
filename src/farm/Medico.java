package farm;

import farm.SQLiteJDBC;
import java.sql.*;

public class Medico 
{
	public Integer Codigo ;
	public String NombreYApellido;
	public String Especializacion;
	
	public Medico()
	{
		this.Codigo = null;
		this.NombreYApellido = "";
		this.Especializacion = "";
	}
	
	public Medico(int Codigo)
	{
		try
		{
			
			Connection conn = SQLiteJDBC.conectar();
			
			Statement sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM medicos WHERE id = " + Codigo);
			
			if (rs.next()) 
			{
				this.NombreYApellido  = rs.getString("nombre_apellido");
				this.Especializacion  = rs.getString("especializacion");
				this.Codigo  = rs.getInt("id");
			}
			
			SQLiteJDBC.cerrar();
						
		}
		catch ( SQLException e ) 
		{
		
		}
	}
	
	public Medico(int Codigo,  String NombreYApellido, String Especializacion)
	{
		this.Codigo = Codigo;
		this.NombreYApellido = NombreYApellido;
		this.Especializacion = Especializacion;
	}

	
	
	public void Guardar()
	{
		try
		{
			Connection conn = SQLiteJDBC.conectar();
			
			Statement sentencia = conn.createStatement();
			sentencia.executeUpdate("INSERT INTO medicos (id,nombre_apellido,especializacion) VALUES ('" + this.Codigo +"','"+ this.NombreYApellido +"','"+ this.Especializacion +"');");
			
			conn.commit();

			SQLiteJDBC.cerrar();
						
		}
		catch ( SQLException e ) 
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
			
			ResultSet rs = sentencia.executeQuery("SELECT * FROM medicos WHERE id = " + this.Codigo);
			

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

	
	public boolean Obtener(int codigo)
	{
		return false;
		
	}

	public String MostrarDatos()
	{
		return "Codigo: " + this.Codigo + " Nombre y Apellido:" + this.NombreYApellido + " Especializacion: " + this.Especializacion ;
	}
}
