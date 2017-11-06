package BackEndDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import BackEnd.Descuento;
import BackEnd.Producto;
import sun.security.krb5.internal.crypto.Des;

public class ProductoDAO {
	
	private Connection conexion = null;
    private Statement declaracion = null;
    private PreparedStatement prepared = null;
    private ResultSet resultSet = null;

	
	public ProductoDAO() {
	}

	public Producto obtenerProductoDesdeCodigo(String codigo) throws Exception {
		//obtener datos desde un query
        conexion = Conexion.conectar();
		// se alista a la conexion para recibir consultas
        /*declaracion = conexion.createStatement();

        resultSet = declaracion.executeQuery("Select * From supermercado.Producto where codigoBarras="+codigo+";");*/
        
        prepared = conexion.prepareStatement("Select * From Producto where codigoBarras= ? ");
        
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
	}
	
	public ArrayList<Producto> obtenerTodosLosProductos() throws SQLException {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		
        conexion = Conexion.conectar();
		
		prepared = conexion.prepareStatement("Select * From Producto");
        
        resultSet = prepared.executeQuery();
        
        while(resultSet.next()) {
        	Producto nuevo = new Producto(resultSet.getString("codigoBarras"), resultSet.getString("nombre"), resultSet.getInt("precio_Unitario"));
        	lista.add(nuevo);
        }

		return lista;
	}

	public void insertar(Producto producto) throws SQLException {
		// TODO Auto-generated method stub
		conexion = Conexion.conectar();
		
		prepared = conexion.prepareStatement("INSERT INTO Producto VALUES ( ? , ? , ?)");
		prepared.setString(1, producto.getCodProducto());
		prepared.setString(2, producto.getNombre());
		prepared.setInt(3, producto.getPrecio());
        
		prepared.executeUpdate();
	}
	
	public void quitar(Producto producto) throws SQLException {
		conexion = Conexion.conectar();
		
		prepared = conexion.prepareStatement("DELETE FROM Producto WHERE codigoBarras = ?");
		prepared.setString(1, producto.getCodProducto());
		prepared.executeUpdate();
		prepared = conexion.prepareStatement("DELETE FROM ProductosConDescuento WHERE id_producto = ?");
		prepared.setString(1, producto.getCodProducto());
		prepared.executeUpdate();
	}

	public ArrayList<Descuento> obtenerDescuentos(Producto producto) throws SQLException {
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		conexion = Conexion.conectar();
		// se alista a la conexion para recibir consultas
		declaracion = conexion.createStatement();
		//statement 
		
		prepared = conexion.prepareStatement("Select * From ProductosConDescuento where id_producto = ? ");
		prepared.setString(1, producto.getCodProducto());
		
		ResultSet rsInterno = prepared.executeQuery();
		
		while (rsInterno.next()) {
			System.out.println("id_descuento -> "+rsInterno.getInt("id_descuento"));
			descuentos.add(new Descuento(rsInterno.getInt("id_descuento")));
		}
		return descuentos;
	}


}
