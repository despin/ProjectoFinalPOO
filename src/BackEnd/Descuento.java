package BackEnd;

import BackEndDAO.DescuentoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Descuento {

	String palabraClave;
	int porcentaje;
	ArrayList<Producto> productosAfectados;
	
	
	public Descuento(String palabraClave, int porcentaje){
		
		this.palabraClave = palabraClave;
		this.porcentaje = porcentaje;
		
	}

	public Descuento(String palabraClave) throws SQLException {
		DescuentoDAO dao = new DescuentoDAO();
		Descuento nuevo = dao.obtenerDescuentoDesdeCodigo(palabraClave);
		this.palabraClave = palabraClave;
		this.porcentaje = nuevo.porcentaje;
		ArrayList<Producto> afectados = new ArrayList<Producto>();
		
	}
	
}
