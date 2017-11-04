package BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import BackEnd.ProductoVendido;
import BackEnd.Venta;

public class ProductoVendidoDAO {

	public ArrayList<ProductoVendido> obtenerProductosPorVenta(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conexion = Conexion.conectar();
		Statement declaracion = conexion.createStatement();
		PreparedStatement prepared = conexion.prepareStatement("Select * From ItemProducto where id_Venta = ?");
		prepared.setInt(1, id);
		ResultSet rsInterno = prepared.executeQuery();
		return null;
	}
	
	public boolean insertar(ProductoVendido productoVendido, int idVenta) {
		try {
			Connection conexion = Conexion.conectar();
			Statement declaracion = conexion.createStatement();
			PreparedStatement prepared = conexion.prepareStatement("INSERT INTO ItemProducto VALUES ( default , ?, ?, ?, ? );");
			prepared.setInt(1, idVenta);
			prepared.setString(2, productoVendido.getProducto().getCodProducto());
			prepared.setInt(3, productoVendido.getCantidad());
			prepared.setInt(4, productoVendido.obtenerPrecioSubtotalConDescuentosAplicados());
			prepared.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
