package BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.util.ResultSetUtil;

import BackEnd.Empleado;
import BackEnd.Venta;
import Excepciones.FormatoInvalidoException;

public class VentaDAO  extends DAO {
	
	Connection conexion = null;
	PreparedStatement prepared = null;
	ResultSet rsInterno = null;
	
	public VentaDAO() {
		
	}

	public ArrayList<Venta> obtenerTodosLasVentas() throws SQLException, Exception {
		// TODO Auto-generated method stub
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		conexion = conectar();
		conexion.createStatement();
		prepared = conexion.prepareStatement("Select * From Venta");
		rsInterno = prepared.executeQuery();
		
		while (rsInterno.next()) {
			ventas.add(new Venta(
					rsInterno.getInt("Id_Venta"),
					new Empleado(rsInterno.getString("cajero")),
					rsInterno.getTimestamp("fechaVenta"),
					rsInterno.getInt("precioTotal")
			));
		}

		close(conexion, prepared, rsInterno);
		return ventas;
	}

//Devuelve un Date de SQL
	
	public int insertar(Venta venta, int totalAbonar) throws SQLException {
		int ID = 0;
		long tiempo = venta.getFecha().getTime();
		java.sql.Timestamp timestamp = new Timestamp(tiempo);
		new ArrayList<Venta>();
		conexion = conectar();
		conexion.createStatement();
		prepared = conexion.prepareStatement("INSERT INTO Venta VALUES ( default , ? , ?, ? );");
		prepared.setString(1, venta.getEmpleado().getCodigo());
		prepared.setTimestamp(2, timestamp);
		prepared.setInt(3, totalAbonar);
		prepared.executeUpdate();
		
		prepared = conexion.prepareStatement("SELECT MAX(Venta.Id_Venta) FROM Venta;");
		
		rsInterno = prepared.executeQuery();
		
		while (rsInterno.next()) {
			ID = rsInterno.getInt(1);
		}
		close(conexion, prepared, rsInterno);
		return ID;
	}
}
