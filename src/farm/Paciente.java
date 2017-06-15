package farm;

import farm.SQLiteJDBC;
import java.sql.*;

public class Paciente 
{
	public Integer Codigo ;
	public String NombreYApellido;
	
	
	public Paciente(int Codigo)
	{
		try
		{
			boolean result;
			
			Connection conn = SQLiteJDBC.conectar();
			
			Statement sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM pacientes WHERE id = " + Codigo);
			
			if (rs.next()) 
			{
				this.NombreYApellido  = rs.getString("nombre_apellido");
				this.Codigo  = rs.getInt("id");
			}
			
			SQLiteJDBC.cerrar();
						
		}
		catch ( SQLException e ) 
		{
		
		}
	}
	
	public Paciente()
	{
		this.Codigo = null;
		this.NombreYApellido = "";
	}
	
	public Paciente(int Codigo, String NombreYApellido)
	{
		this.Codigo = Codigo;
		this.NombreYApellido = NombreYApellido;
	}
	
	
	public void Guardar()
	{
		try
		{
			Connection conn = SQLiteJDBC.conectar();
			
			Statement sentencia = conn.createStatement();
			
			sentencia.executeUpdate("INSERT INTO pacientes (id,nombre_apellido) VALUES ('"+this.Codigo+"','"+this.NombreYApellido+"')");
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
			
			ResultSet rs = sentencia.executeQuery("SELECT * FROM pacientes WHERE id = " + this.Codigo);
			

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
		return "Codigo: " + this.Codigo + " Nombre y Apellido:" + this.NombreYApellido;
	}
}
