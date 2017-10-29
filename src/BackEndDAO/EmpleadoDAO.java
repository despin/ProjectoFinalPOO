package BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import BackEnd.Empleado;
import BackEnd.Producto;

public class EmpleadoDAO {

	private Connection conexion = null;
    private Statement declaracion = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

	
	public EmpleadoDAO() {
	}

	@SuppressWarnings("deprecation")
	public Empleado obtenerProductoDesdeCodigo(String codigo) throws Exception {
		//obtener datos desde un query
		conexion = Conexion.conectar();
		// se alista a la conexion para recibir consultas
		declaracion = conexion.createStatement();
		
		//statement 
		
		//query
		
		return new Empleado (codigo, "Pedro", "Calogero", new Date(2015, 10, 20));
	}
	
}
