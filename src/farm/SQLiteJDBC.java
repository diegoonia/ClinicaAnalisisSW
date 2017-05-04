package farm;

import java.sql.*;

import javax.swing.JOptionPane;

public class SQLiteJDBC {
	private static Connection conn;
	private static java.sql.Statement sentencia;

	public SQLiteJDBC() {

	}

	public Connection getConnection() {
		try {
			if (conn == null) {

				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:test.db");
				conn.setAutoCommit(false);
			}

		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "No se encuentra el driver", "Error", JOptionPane.ERROR_MESSAGE);

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al Intentar la conexion", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}
	
	////////////////////AGREGACION DE NUEVOS REG. A LA BD/////////////////////
	
	public int registrarMedico(String codMedico, String password, String nombreYAppellido) throws SQLException {
		sentencia = null;
		boolean respuesta = false;
		try {

			// Tabla Medicos: codMedico | password | nombreYApellido
			sentencia = conn.createStatement();
			String query = "SELECT * FROM medicos WHERE codMedico = \"" + codMedico + "\"";
			ResultSet rs = sentencia.executeQuery(query);
			while (rs.next()) {
				respuesta = true;
				rs.close();
				sentencia.close();
			}
			if (respuesta == true) {

				JOptionPane.showMessageDialog(null, "Medico ya registrado!", "Error", JOptionPane.ERROR_MESSAGE);
				return 0;
				
			} else {
				sentencia = conn.createStatement();
				query = "INSERT INTO `medicos`(`codMedico`, `password`, `nombreYApellido`)  VALUES(\"" + codMedico
						+ "\",\"" + password + "\",\"" + nombreYAppellido + "\")";
				sentencia.execute(query);
				sentencia.close();
				conn.commit();
				JOptionPane.showMessageDialog(null, "Registro exitoso!");
				return 1;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en la consulta SQL", "Error", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se logro ejecutar Insertar Correctamente la consulta", "Error",
					JOptionPane.ERROR_MESSAGE);
			return 0;
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

				JOptionPane.showMessageDialog(null, "Consulta ya registrada!", "Error", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "Error en la consulta SQL", "Error", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se logro ejecutar Insertar Correctamente la consulta", "Error",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}
	
	
	////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	

	public int verificarUserYPassword(String codMedico, String password) throws SQLException {
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
				return 1;
			} else {
				return 0;
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "No se logro establecer conexión con la BD", "Error",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se logro establecer conexión con la BD", "Error",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al intentar realizar la desconexion", "Error",
					JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "Error al crear la tabla", "Error", JOptionPane.ERROR_MESSAGE);
	        System.exit(0);
	      }
	}
	

	
	public static void crearTablaConsultas(){
		
		try {
	        sentencia = conn.createStatement();
	        String sql = "CREATE TABLE consultas (id INTEGER PRIMARY KEY,codPaciente CHAR(15),codMedico CHAR(15),diagnostico CHAR(50))";
	        sentencia.executeUpdate(sql);
	        sentencia.close();

	      } catch ( Exception e ) {
				JOptionPane.showMessageDialog(null, "Error al crear la tabla", "Error", JOptionPane.ERROR_MESSAGE);
	        System.exit(0);
	      }
	}
	
	////////////////////////////////////////////////////////////////////////
	
	
   public static void main( String args[] ) throws SQLException
    {
  	  
  	  SQLiteJDBC mySQLCon = new SQLiteJDBC();
  	  mySQLCon.getConnection();
  	  //crearTablaConsultas();
  		mySQLCon.registrarConsulta("110","999","Pulmonia");
  		//System.out.println(mySQLCon.verificarUserYPassword("888", "pepe"));
  		mySQLCon.close();
      
    }
  
}
  
  
  





