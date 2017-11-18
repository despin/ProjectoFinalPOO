package BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import BackEnd.Empleado;

import BackEndDAO.DAO;
import Excepciones.FormatoInvalidoException;
import Excepciones.RegistroYaExisteException;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class EmpleadoDAO extends DAO{

	private Connection conexion = null;
    private PreparedStatement prepared = null;
    private ResultSet resultSet = null;

	
	public EmpleadoDAO() {
	}

	@SuppressWarnings("deprecation")
	public Empleado obtenerEmpleadoDesdeCodigo(String codigo) throws Exception {
		//obtener datos desde un query
		conexion = conectar();
		// se alista a la conexion para recibir consultas
		
		//statement 
		//query
		prepared = conexion.prepareStatement("Select * From Empleado where codEmpleado= ? ");
        prepared.setString(1, codigo);
        
        resultSet = prepared.executeQuery();
        
        String nombre = null;
        String apellido = null;
        Date fecha = null;
        
        while (resultSet.next()) {
        	nombre = resultSet.getString("nombre");
        	apellido = resultSet.getString("apellido");
        	fecha = resultSet.getDate("fechaIngreso");
        }
		
		close(conexion, prepared,resultSet);
		return new Empleado (codigo, nombre, apellido, fecha);
	}
	
	public ArrayList<Empleado> obtenerTodosLosEmpleados() throws SQLException {
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		
        conexion = conectar();
		
		prepared = conexion.prepareStatement("Select * From supermercado.Empleado");
        
        resultSet = prepared.executeQuery();
        
        while(resultSet.next()) {
        	Empleado nuevo = new Empleado(resultSet.getString("codEmpleado"), resultSet.getString("nombre"),resultSet.getString("apellido"), resultSet.getDate("fechaIngreso"));
        	lista.add(nuevo);
        }
		close(conexion, prepared,resultSet);
		return lista;
	}
	
	public void quitar(Empleado empleado) throws SQLException {
		conexion = conectar();
		
		prepared = conexion.prepareStatement("DELETE FROM Empleado WHERE codEmpleado = ?");
		prepared.setString(1, empleado.getCodigo());
        
		prepared.executeUpdate();
		close(conexion, prepared);
	}

	public void insertar(Empleado empleado) throws RegistroYaExisteException, FormatoInvalidoException {
		long tiempo = empleado.getFechaDeIngreso().getTime();
		java.sql.Timestamp timestamp = new Timestamp(tiempo);
		try {
			conexion = conectar();
			prepared = conexion.prepareStatement("INSERT INTO Empleado VALUES ( ? , ? , ?, ? )");
			prepared.setString(1, empleado.getCodigo());
			prepared.setString(2, empleado.getNombre());
			prepared.setString(3, empleado.getApellido());
        	prepared.setTimestamp(4, timestamp);
			prepared.executeUpdate();
		} catch(MySQLIntegrityConstraintViolationException exception) {
			exception.printStackTrace();
			throw new RegistroYaExisteException("Ya existe un registro con la clave: "+empleado.getCodigo());
		} catch(MysqlDataTruncation e) {
			e.printStackTrace();
			throw new FormatoInvalidoException("La clave:"+empleado.getCodigo()+" es muy larga");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		close(conexion, prepared);
	}
}
