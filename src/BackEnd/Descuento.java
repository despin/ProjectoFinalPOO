package BackEnd;

import BackEndDAO.DescuentoDAO;
import java.util.ArrayList;

public class Descuento {

	String palabraClave;
	int porcentaje;
	ArrayList<Producto> productosAfectados;
	
	
	public Descuento(String palabraClave, int porcentaje){
		
		this.palabraClave = palabraClave;
		this.porcentaje = porcentaje;
		
	}

	public Descuento(String palabraClave) {
		DescuentoDAO dao = new DescuentoDAO();
		Descuento nuevo = dao.obtenerDescuentoDesdeCodigo();
		this.palabraClave = palabraClave;
		this.porcentaje = nuevo.porcentaje;
		ArrayList<Producto> afectados = new ArrayList<Producto>();
		
	}
	
}
