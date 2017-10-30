package BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import BackEnd.Empleado;
import BackEnd.Producto;

public class EmpleadoDAO {

	private Connection conexion = null;
    private Statement declaracion = null;
    private PreparedStatement prepared = null;
    private ResultSet resultSet = null;

	
	public EmpleadoDAO() {
	}

	@SuppressWarnings("deprecation")
	public Empleado obtenerEmpleadoDesdeCodigo(String codigo) throws Exception {
		//obtener datos desde un query
		conexion = Conexion.conectar();
		// se alista a la conexion para recibir consultas
		declaracion = conexion.createStatement();
		
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
		
		
		return new Empleado (codigo, nombre, apellido, fecha);
	}
	
	public ArrayList<Empleado> obtenerTodosLosEmpleados() throws SQLException {
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		
        conexion = Conexion.conectar();
		
		prepared = conexion.prepareStatement("Select * From supermercado.Empleado");
        
        resultSet = prepared.executeQuery();
        
        while(resultSet.next()) {
        	Empleado nuevo = new Empleado(resultSet.getString("codEmpleado"), resultSet.getString("nombre"),resultSet.getString("apellido"), resultSet.getDate("fechaIngreso"));
        	lista.add(nuevo);
        }

		return lista;
	}
	/*
	 obtener datos desde un query
        System.out.println(codigo);
        
        conexion = Conexion.conectar();
		 se alista a la conexion para recibir consultas
        declaracion = conexion.createStatement();

        resultSet = declaracion.executeQuery("Select * From supermercado.Producto where codigoBarras="+codigo+";");
        
        prepared = conexion.prepareStatement("Select * From supermercado.Producto where codigoBarras= ? ");
        
        prepared.setString(1, codigo);
        
        resultSet = prepared.executeQuery();
        
        String nombre = null;
        int precio = 0;
        
        
        
        while (resultSet.next()) {
        	nombre = resultSet.getString("nombre");
        	precio = resultSet.getInt("precio_Unitario");
        }
		
		//statement 
		
		//query
		
		return new Producto(codigo, nombre, precio);
	 */
}
