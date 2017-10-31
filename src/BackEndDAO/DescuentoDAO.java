package BackEndDAO;

import BackEnd.Descuento;
import BackEnd.Empleado;
import BackEndDAO.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DescuentoDAO {

	private Connection conexion = null;
    private Statement declaracion = null;
    private PreparedStatement prepared = null;
    private ResultSet resultSet = null;

    public DescuentoDAO() {

    }

	public Descuento obtenerDescuentoDesdeCodigo(String clave) throws SQLException {
				//obtener datos desde un query
				conexion = Conexion.conectar();
				// se alista a la conexion para recibir consultas
				declaracion = conexion.createStatement();
				
				//statement 
				//query
				prepared = conexion.prepareStatement("Select * From Descuento where nombre = ? ");
				prepared.setString(1, clave);
				
				resultSet = prepared.executeQuery();
				
				String nombre = null;
				int porcentaje = 0;
				
				while (resultSet.next()) {
					nombre = resultSet.getString("nombre");
					porcentaje = resultSet.getInt("porcentaje");
					obtenerCodigosDeProductosDesdeDescuento(nombre);
				}
				
				return new Descuento (clave, porcentaje);
	}
	
	public ArrayList<String> obtenerCodigosDeProductosDesdeDescuento(String clave) throws SQLException {
		ResultSet rsInterno = null;
		ArrayList<String> resultado = new ArrayList<String>();
		conexion = Conexion.conectar();
		// se alista a la conexion para recibir consultas
		declaracion = conexion.createStatement();
		//statement 
		
		prepared = conexion.prepareStatement("Select * From Descuento where nombre = ? ");
		prepared.setString(1, clave);
		
		rsInterno = prepared.executeQuery();
		
		int codigoReferencia = 0;
		
		while (rsInterno.next()) {
			codigoReferencia = rsInterno.getInt("id_descuento");
		}
		
		prepared = conexion.prepareStatement("Select * From ProductosConDescuento where id_descuento = ?");
		prepared.setInt(1, codigoReferencia);
		rsInterno = prepared.executeQuery();
		
		
		while (rsInterno.next()) {
			resultado.add(rsInterno.getString("id_producto"));
		}
		
		return resultado;
	}
	
	public ArrayList<Descuento> obtenerDescuentosDesdeProducto(String codigoProducto) throws SQLException {
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		conexion = Conexion.conectar();
		// se alista a la conexion para recibir consultas
		declaracion = conexion.createStatement();
		//statement 
		
		prepared = conexion.prepareStatement("Select * From ProductosConDescuento where id_producto = ? ");
		prepared.setString(1, codigoProducto);
		
		ResultSet rsInterno = prepared.executeQuery();
		
		while (rsInterno.next()) {
			descuentos.add(new Descuento(rsInterno.getString("id_descuento")));
		}
		return descuentos;
	}
	
	public ArrayList<Descuento> obtenerTodosLosDescuentos() throws SQLException {
		ResultSet rsInterno = null;
		ArrayList<Descuento> resultado = new ArrayList<Descuento>();
		conexion = Conexion.conectar();
		// se alista a la conexion para recibir consultas
		declaracion = conexion.createStatement();
		//statement 
		
		prepared = conexion.prepareStatement("Select * From Descuento");
		rsInterno = prepared.executeQuery();
		
		while (rsInterno.next()) {
			resultado.add(new Descuento(rsInterno.getString("nombre")));
		}
		
		return resultado;
		
	}
}
