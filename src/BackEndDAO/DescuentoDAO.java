package BackEndDAO;

import BackEnd.Descuento;
import BackEnd.Producto;import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BackEndDAO.DAO;
import Excepciones.ErrorConexion;

public class DescuentoDAO extends DAO {

	private Connection conexion = null;
    private PreparedStatement prepared = null;
    private ResultSet resultSet = null;

    public DescuentoDAO() {

    }

	public Descuento obtenerDescuentoDesdeNombre(String palabraClave) throws SQLException {
		//obtener datos desde un query
		try {
			Connection conexion = conectar();
		} catch (Exception e) {
			
		}
		prepared = conexion.prepareStatement("Select * From Descuento where nombre = ? ");
		prepared.setString(1, palabraClave);
		
		resultSet = prepared.executeQuery();
		
		Descuento resultado = null;
		
		while (resultSet.next()) {
			resultado = new Descuento (resultSet.getInt("id_descuento"),resultSet.getString("nombre"), resultSet.getInt("porcentaje"));
		}
		ArrayList<Producto> productosAAgregar = new ArrayList<Producto>();
		productosAAgregar = obtenerProductosDesdeDescuento(resultado);
		resultado.setProductos(productosAAgregar);
		close(conexion, prepared, resultSet);
		return resultado;
	}


	public Descuento obtenerDescuentoDesdeCodigo(int codDescuento) throws SQLException {
		//obtener datos desde un query
		conexion = conectar();
		// se alista a la conexion para recibir consultas
		//statement 
		//query
		prepared = conexion.prepareStatement("Select * From Descuento where id_descuento = ? ");
		prepared.setInt(1, codDescuento);
		
		resultSet = prepared.executeQuery();
		
		Descuento resultado = null;
		
		while (resultSet.next()) {
			resultado = new Descuento (resultSet.getInt("id_descuento"),resultSet.getString("nombre"), resultSet.getInt("porcentaje"));
		}
		ArrayList<Producto> productosAAgregar = new ArrayList<Producto>();
		productosAAgregar = obtenerProductosDesdeDescuento(resultado);
		resultado.setProductos(productosAAgregar);
		close(conexion, prepared, resultSet);
		return resultado;
}
	
	public ArrayList<Producto> obtenerProductosDesdeDescuento(Descuento descuento) throws SQLException {
		ResultSet rsInterno = null;
		ArrayList<Producto> resultado = new ArrayList<Producto>();
		conexion = conectar();

		prepared = conexion.prepareStatement("Select * From ProductosConDescuento where id_descuento = ?");
		prepared.setInt(1, descuento.getID());
		rsInterno = prepared.executeQuery();
		
		
		while (rsInterno.next()) {
			try {
				resultado.add(new Producto(rsInterno.getString("id_producto")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		close(conexion, prepared, resultSet);
		return resultado;
	}
	
	public ArrayList<Descuento> obtenerTodosLosDescuentos() throws SQLException {
		ResultSet rsInterno = null;
		ArrayList<Descuento> resultado = new ArrayList<Descuento>();
		conexion = conectar();
		// se alista a la conexion para recibir consultas
		//statement 
		
		prepared = conexion.prepareStatement("Select * From Descuento");
		rsInterno = prepared.executeQuery();
		
		while (rsInterno.next()) {
			Descuento d = new Descuento(
				rsInterno.getInt("id_Descuento"),
				rsInterno.getString("nombre"),
				rsInterno.getInt("porcentaje")
			);
			resultado.add(d);
		}
		close(conexion, prepared, resultSet);
		return resultado;
		
	}

	public void quitar(Descuento descuento) throws SQLException {
		conexion = conectar();
		prepared = conexion.prepareStatement("DELETE FROM Descuento WHERE id_descuento = ?");
		prepared.setInt(1, descuento.getID());
		prepared.executeUpdate();
		prepared = conexion.prepareStatement("DELETE FROM ProductosConDescuento WHERE id_descuento = ?");
		prepared.setInt(1, descuento.getID());
		prepared.executeUpdate();	
	}

	public void insertar(Descuento descuento) throws SQLException {
			conexion = conectar();
		prepared = conexion.prepareStatement("INSERT INTO Descuento VALUES ( default, ?, ?)");
		prepared.setString(1, descuento.getPalabraClave());
		prepared.setInt(2, descuento.getPorcentaje());
		prepared.executeUpdate();
		
		prepared = conexion.prepareStatement("SELECT MAX(Descuento.id_descuento) FROM Descuento;");
		ResultSet rsInterno = prepared.executeQuery();
		
		int id = 0;
		while (rsInterno.next()) {
			id = rsInterno.getInt(1);
			descuento.setID(id);
		}
		prepared = conexion.prepareStatement("INSERT INTO ProductosConDescuento VALUES ( default, ?, ?)");
		prepared.setInt(2, id);
		for (Producto p : descuento.getProductosAfectados()) {
			prepared.setString(1, p.getCodProducto());
			prepared.executeUpdate();
		}
		close(conexion, prepared, resultSet);
	}
	
}
