package farm;

import farm.SQLiteJDBC;
import java.sql.*;

public class Medico 
{
	public Integer Codigo ;
	public String Password;
	public String NombreYApellido;
	public String Especializacion;
	
	public Medico()
	{
		this.Codigo = null;
		this.NombreYApellido = "";
		this.Password = "";
		this.Especializacion = "";
	}
	
	public Medico(int Codigo, String Password, String NombreYApellido, String Especializacion)
	{
		this.Codigo = Codigo;
		this.Password = Password;
		this.NombreYApellido = NombreYApellido;
		this.Especializacion = Especializacion;
	}

	
	
	public boolean Guardar()
	{
		try
		{
			if (this.Codigo != null && this.NombreYApellido != "" && this.Password != "" && this.Especializacion != "")
			{
				SQLiteJDBC.conectar();
				SQLiteJDBC.ejecutarConsulta("INSERT INTO medico VALUES (" + this.Codigo +",'"+ this.Password +"','"+ this.NombreYApellido +"','"+ this.Especializacion +"')","insert");
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
			ResultSet rs = SQLiteJDBC.ejecutarConsulta("SELECT * FROM medicos WHERE codMedico = " + codigo,"select");
			
			if(rs.next())
			{
				this.Codigo = rs.getInt("codMedico");
				this.NombreYApellido = rs.getString("nombreYApellido");
				this.Especializacion = rs.getString("especialidad");
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
		return "Codigo: " + this.Codigo + " Nombre y Apellido:" + this.NombreYApellido + " Especializacion: " + this.Especializacion + " Password:" + this.Password;
	}
}
