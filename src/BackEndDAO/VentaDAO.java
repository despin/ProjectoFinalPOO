package BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import BackEnd.Empleado;
import BackEnd.Venta;

public class VentaDAO {
	public VentaDAO() {
		
	}

	public ArrayList<Venta> obtenerTodosLasVentas() throws SQLException, Exception {
		// TODO Auto-generated method stub
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		Connection conexion = Conexion.conectar();
		PreparedStatement prepared = conexion.prepareStatement("Select * From Venta");
		ResultSet rsInterno = prepared.executeQuery();
		
		while (rsInterno.next()) {
			ventas.add(new Venta(
					rsInterno.getInt("Id_Venta"),
					new Empleado(rsInterno.getString("cajero")),
					rsInterno.getTimestamp("fechaVenta")
			));
		}

		return ventas;
	}

//Devuelve un Date de SQL
	
	public int insertar(Venta venta, int totalAbonar) throws SQLException {
		// TODO Auto-generated method stub
		long tiempo = venta.getFecha().getTime();
		java.sql.Timestamp timestamp = new Timestamp(tiempo);
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		Connection conexion = Conexion.conectar();
		Statement declaracion = conexion.createStatement();
		PreparedStatement prepared = conexion.prepareStatement("INSERT INTO Venta VALUES ( default , ? , ?, ? );");
		prepared.setString(1, venta.getEmpleado().getCodigo());
		prepared.setTimestamp(2, timestamp);
		prepared.setInt(3, totalAbonar);
		prepared.executeUpdate();

		
		int ID = 0;
		
		prepared = conexion.prepareStatement("SELECT MAX(Venta.Id_Venta) FROM Venta;");
		ResultSet rsInterno = prepared.executeQuery();
		
		while (rsInterno.next()) {
			ID = rsInterno.getInt(1);
		}
		return ID;
	}
}
