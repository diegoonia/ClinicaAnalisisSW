package farm;

import farm.SQLiteJDBC;
import java.sql.*;

public class Paciente 
{
	public Integer Codigo ;
	public String NombreYApellido;
	
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

	
	
	public boolean Guardar()
	{
		try
		{
			if (this.Codigo != null && this.NombreYApellido != "")
			{
				SQLiteJDBC.conectar();
				SQLiteJDBC.ejecutarConsulta("INSERT INTO paciente VALUES (" + this.Codigo +",'"+ this.NombreYApellido +"')");
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

	
	public boolean Obtener(int codigo)
	{
		try
		{
			SQLiteJDBC.conectar();
			ResultSet rs = SQLiteJDBC.ejecutarConsulta("SELECT * FROM paciente WHERE id = " + codigo);
			while(rs.next())
			{
				this.Codigo = rs.getInt("id");
				this.NombreYApellido = rs.getString("nombre_apellido");
			}

			SQLiteJDBC.cerrar();
			return true;
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
