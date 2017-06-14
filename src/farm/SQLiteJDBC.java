package farm;

import java.sql.*;
import javax.swing.JOptionPane;

public  class SQLiteJDBC 
{
	private static Connection conn;
	

	public static Connection conectar() 
	{ 
		
		try 
		{
			if (conn == null)
			{
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:C:/clinica.db");
				conn.setAutoCommit(false);
			}
			return conn;
				
		} 
		catch (ClassNotFoundException cnfe) 
		{
			JOptionPane.showMessageDialog(null, "No se encuentra el driver", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		} 
		catch (SQLException sqle) 
		{
			JOptionPane.showMessageDialog(null, "Error al Intentar la conexion", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}

	
	
	public static void cerrar()
	{
		try
		{
			if (conn != null)
			{
				conn.close();
				conn = null;
			}
			
		}
		catch ( Exception e ) 
		{
			JOptionPane.showMessageDialog(null, "Error al cerrar la conexion", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/*
	public static void mostrarMedicos()
	{
		sentencia = null;
		boolean respuesta = false;
		try {
			// Tabla Medicos: codMedico | password | nombreYApellido
			sentencia = conn.createStatement();
			String query = "SELECT * FROM medicos";
			ResultSet rs = sentencia.executeQuery(query);
			   ResultSetMetaData rsmd = rs.getMetaData();
			   System.out.println("querying SELECT * FROM medicos");
			   int columnsNumber = rsmd.getColumnCount();
			   
			 while (rs.next()) {
			       for (int i = 1; i <= columnsNumber; i++) {
			           if (i > 1) System.out.print(",  ");
			           String columnValue = rs.getString(i);
			           System.out.print(columnValue + " " + rsmd.getColumnName(i));
			       }
			       System.out.println("");
			   }
		} catch (Exception e) { }
	}
	*/
	/*
	 * CODIGO DEL SISTEMA BASE -- VIEJO -- UTILIZAR PARA COPIAR CODIGO
	
	public boolean registrarMedico(String codMedico, String password, String nombreYApellido) throws SQLException {
		sentencia = null;
		boolean respuesta = false;
		try {

			// Tabla Medicos: codMedico | password | nombreYApellido
			sentencia = conn.createStatement();
			String query = "SELECT * FROM medicos WHERE codMedico = " + codMedico ;
			ResultSet rs = sentencia.executeQuery(query);
			while (rs.next()) {
				respuesta = true;
				rs.close();
				sentencia.close();
			}
			
			if (respuesta == true) 
			{

				return false;
				
			} 
			else 
			{
				sentencia = conn.createStatement();
				query = "INSERT INTO `medicos`(`codMedico`, `password`, `nombreYApellido`)  VALUES(\"" + codMedico
						+ "\",\"" + password + "\",\"" + nombreYApellido + "\")";
				sentencia.execute(query);
				sentencia.close();
				conn.commit();
				//JOptionPane.showMessageDialog(null, "Registro exitoso!");
				return true;
			}
		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, "Error en la consulta SQL", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "No se logro ejecutar Insertar Correctamente la consulta", "Error",
					//JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public int registrarConsulta(String codPaciente ,String codMedico, String diagnostico) throws SQLException {
		sentencia = null;
		boolean respuesta = false;
		try {

			// Tabla Consultas: id(auto incremental) | codPaciente | codMedico | diagnostico
			sentencia = conn.createStatement();
			String query = "SELECT * FROM consultas WHERE id = \"" + null + "\"";
			ResultSet rs = sentencia.executeQuery(query);
			while (rs.next()) {
				respuesta = true;
				rs.close();
				sentencia.close();
			}
			if (respuesta == true) {

				//JOptionPane.showMessageDialog(null, "Consulta ya registrada!", "Error", JOptionPane.ERROR_MESSAGE);
				return 0;
				
			} else {
			
				sentencia = conn.createStatement();
				query = "INSERT INTO `consultas`(`codPaciente`, `codMedico`, `diagnostico`)  VALUES(\"" + codPaciente + "\",\"" + codMedico + "\",\"" + diagnostico + "\")";
				sentencia.execute(query);
				sentencia.close();
				conn.commit();
				JOptionPane.showMessageDialog(null, "Consulta Registrada!");
				return 1;
			
			}
		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, "Error en la consulta SQL", "Error", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

		catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "No se logro ejecutar Insertar Correctamente la consulta", "Error",
					//JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}
	
	
	////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	

	public boolean verificarUserYPassword(String codMedico, String password) throws SQLException {
		// Verifica que el codMedico y la contraseña ingresada sean las correctas en la BD
		sentencia = null;
		boolean respuesta = false;

		try {

			sentencia = conn.createStatement();
			String query = "SELECT * FROM medicos WHERE codMedico = \"" + codMedico + "\" and password = \"" + password
					+ "\"";
			ResultSet rs = sentencia.executeQuery(query);
			while (rs.next()) {
				respuesta = true;
				rs.close();
				sentencia.close();
			}
			if (respuesta == true) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, "No se logro establecer conexión con la BD", "Error",
					//JOptionPane.ERROR_MESSAGE);
			return false;
		}

		catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "No se logro establecer conexión con la BD", "Error",
					//JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException sqle) {
			//JOptionPane.showMessageDialog(null, "Error al intentar realizar la desconexion", "Error",
					//JOptionPane.ERROR_MESSAGE);
		}
	}
    
	/////////////////////////CREACION DE TABLAS //////////////////////////////
	
	public static void crearTablaMedicos(){
		
		try {
	        sentencia = conn.createStatement();
	        String sql = "CREATE TABLE medicos (codMedico CHAR(15) PRIMARY KEY,password CHAR(15),nombreYApellido CHAR(50))";
	        sentencia.executeUpdate(sql);
	        sentencia.close();

	      } catch ( Exception e ) {
				//JOptionPane.showMessageDialog(null, "Error al crear la tabla", "Error", JOptionPane.ERROR_MESSAGE);
	        System.exit(0);
	      }
	}
	

	
	public static void crearTablaConsultas(){
		
		try {
	        sentencia = conn.createStatement();
	        String sql = "CREATE TABLE consultas (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,codPaciente CHAR(15),codMedico CHAR(15),diagnostico CHAR(50))";
	        sentencia.executeUpdate(sql);
	        sentencia.close();

	      } catch ( Exception e ) {
				//JOptionPane.showMessageDialog(null, "Error al crear la tabla", "Error", JOptionPane.ERROR_MESSAGE);
	        System.exit(0);
	      }
	}
	
	public static void mostrarConsultas(){
		sentencia = null;
		boolean respuesta = false;
		try {
			// Tabla Consultas: id(auto incremental) | codPaciente | codMedico | diagnostico
			sentencia = conn.createStatement();
			String query = "SELECT * FROM consultas";
			ResultSet rs = sentencia.executeQuery(query);
			   ResultSetMetaData rsmd = rs.getMetaData();
			   System.out.println("querying SELECT * FROM consultas");
			   int columnsNumber = rsmd.getColumnCount();
			   
			 while (rs.next()) {
			       for (int i = 1; i <= columnsNumber; i++) {
			           if (i > 1) System.out.print(",  ");
			           String columnValue = rs.getString(i);
			           System.out.print(columnValue + " " + rsmd.getColumnName(i));
			       }
			       System.out.println("");
			   }
		} catch (Exception e) { }
	}
	
	public static void mostrarMedicos(){
		sentencia = null;
		boolean respuesta = false;
		try {
			// Tabla Medicos: codMedico | password | nombreYApellido
			sentencia = conn.createStatement();
			String query = "SELECT * FROM medicos";
			ResultSet rs = sentencia.executeQuery(query);
			   ResultSetMetaData rsmd = rs.getMetaData();
			   System.out.println("querying SELECT * FROM medicos");
			   int columnsNumber = rsmd.getColumnCount();
			   
			 while (rs.next()) {
			       for (int i = 1; i <= columnsNumber; i++) {
			           if (i > 1) System.out.print(",  ");
			           String columnValue = rs.getString(i);
			           System.out.print(columnValue + " " + rsmd.getColumnName(i));
			       }
			       System.out.println("");
			   }
		} catch (Exception e) { }
	}
	
	public static void consultaPorMedico(int codMedico){
		sentencia = null;
		boolean respuesta = false;
		try {
			// Tabla Consultas: id(auto incremental) | codPaciente | codMedico | diagnostico
			sentencia = conn.createStatement();
			String query = "SELECT * FROM consultas WHERE codMedico = \"" + codMedico + "\"";
			ResultSet rs = sentencia.executeQuery(query);
			   ResultSetMetaData rsmd = rs.getMetaData();
			   System.out.println("querying SELECT * FROM consultas WHERE codMedico = \"" + codMedico + "\"");
			   int columnsNumber = rsmd.getColumnCount();
			   
			 while (rs.next()) {
			       for (int i = 1; i <= columnsNumber; i++) {
			           if (i > 1) System.out.print(",  ");
			           String columnValue = rs.getString(i);
			           System.out.print(columnValue + " " + rsmd.getColumnName(i));
			       }
			       System.out.println("");
			   }
		} catch (Exception e) { }
	}
	
	
	////////////////////////////////////////////////////////////////////////
	
	*/
  
}
  
  
  





