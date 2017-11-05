package BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BackEnd.ProductoVendido;

public class ProductoVendidoDAO {

	public ArrayList<ProductoVendido> obtenerProductosPorVenta(int id) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<ProductoVendido> resultado = new ArrayList<ProductoVendido>();
		Connection conexion = Conexion.conectar();
		conexion.createStatement();
		PreparedStatement prepared = conexion.prepareStatement("Select * From ItemProducto where id_Venta = ?");
		prepared.setInt(1, id);
		ResultSet rsInterno = prepared.executeQuery();
		while (rsInterno.next()) {
			resultado.add(new ProductoVendido(new Producto(rsInterno.getString("codProducto")), rsInterno.getInt("cantidad"), rsInterno.getInt("precio")));
		}
		return resultado;
	}
	
	public boolean insertar(ProductoVendido productoVendido, int idVenta) {
		try {
			Connection conexion = Conexion.conectar();
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
