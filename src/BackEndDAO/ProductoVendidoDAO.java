package BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BackEnd.Producto;
import BackEnd.ProductoVendido;

import BackEndDAO.DAO;

public class ProductoVendidoDAO extends DAO {

	Connection conexion = null;
	PreparedStatement prepared = null;
	ResultSet rsInterno = null;

	public ProductoVendidoDAO () {

	}

	public ArrayList<ProductoVendido> obtenerProductosPorVenta(int id) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<ProductoVendido> resultado = new ArrayList<ProductoVendido>();
		conexion = conectar();
		conexion.createStatement();
		prepared = conexion.prepareStatement("Select * From ItemProducto where id_Venta = ?");
		prepared.setInt(1, id);
		rsInterno = prepared.executeQuery();
		while (rsInterno.next()) {
			resultado.add(new ProductoVendido(new Producto(rsInterno.getString("codProducto")), rsInterno.getInt("cantidad"), rsInterno.getInt("precio")));
		}
		close(conexion, prepared, rsInterno);
		return resultado;
	}
	
	public boolean insertar(ProductoVendido productoVendido, int idVenta) {
		try {
			conexion = conectar();
			conexion.createStatement();
			prepared = conexion.prepareStatement("INSERT INTO ItemProducto VALUES ( default , ?, ?, ?, ? );");
			prepared.setInt(1, idVenta);
			prepared.setString(2, productoVendido.getProducto().getCodProducto());
			prepared.setInt(3, productoVendido.getCantidad());
			prepared.setInt(4, productoVendido.obtenerPrecioSubtotalConDescuentosAplicados());
			prepared.executeUpdate();
			close(conexion, prepared);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
