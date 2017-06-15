package farm;

import java.sql.*;

import farm.SQLiteJDBC;

public class SituacionPaciente 
{
	public Integer CodigoPac ;
	public Integer CodigoMed;
	public String Diagnostico;
	
	public SituacionPaciente()
	{
		this.CodigoPac = null;
		this.CodigoMed = null;
		this.Diagnostico = "";
	}
	
	
	public SituacionPaciente(int CodigoPac,  int CodigoMed, String Diagnostico)
	{
		this.CodigoPac = CodigoPac;
		this.CodigoMed = CodigoMed;
		this.Diagnostico = Diagnostico;
	}

	
	
	public void Guardar()
	{
		try
		{
			Connection conn = SQLiteJDBC.conectar();
			
			Statement sentencia = conn.createStatement();
			sentencia.executeUpdate("INSERT INTO situacion_paciente (paciente_id,medico_id,diagnostico) VALUES ("+ this.CodigoPac +","+ this.CodigoMed +",'"+ this.Diagnostico +"');");
			
			conn.commit();

			SQLiteJDBC.cerrar();
						
		}
		catch ( SQLException e ) 
		{
		
		}
		

	}
	

	public String MostrarDatos()
	{
		return "CodigoPac: " + this.CodigoPac + "CodigoMed: " + this.CodigoMed + "Situacion: " + this.Diagnostico;
	}
}
