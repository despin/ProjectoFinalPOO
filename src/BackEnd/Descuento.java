package BackEnd;

import BackEndDAO.DescuentoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Descuento {
	int ID;
	String palabraClave;
	int porcentaje;
	ArrayList<Producto> productosAfectados;
	
	public Descuento(int codDescuento) throws SQLException {
		DescuentoDAO dao = new DescuentoDAO();
		Descuento nuevo = dao.obtenerDescuentoDesdeCodigo(codDescuento);
		this.ID = nuevo.ID;
		this.palabraClave = nuevo.palabraClave;
		this.porcentaje = nuevo.porcentaje;
		this.productosAfectados = nuevo.productosAfectados;
	}
	
	public Descuento(String palabraClave, int porcentaje){
		this.palabraClave = palabraClave;
		this.porcentaje = porcentaje;
		
	}
	
	public Descuento(int ID, String palabraClave, int porcentaje){
		this.ID = ID;
		this.palabraClave = palabraClave;
		this.porcentaje = porcentaje;
	}
	
	public Descuento(int ID, String palabraClave, int porcentaje, ArrayList<Producto> productosAfectados){
		this.ID = ID;
		this.palabraClave = palabraClave;
		this.porcentaje = porcentaje;
		this.productosAfectados = productosAfectados;
	}
	
	public Descuento(String palabraClave) {
		DescuentoDAO dao = new DescuentoDAO();
		Descuento nuevo = null;
		try {
			nuevo = dao.obtenerDescuentoDesdeNombre(palabraClave);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ID = nuevo.ID;
		this.palabraClave = nuevo.palabraClave;
		this.porcentaje = nuevo.porcentaje;
		this.productosAfectados = nuevo.productosAfectados;
	}

	public ArrayList<Producto> getProductosAfectados() {
		return this.productosAfectados;
	}
	
	public void agregarProductoAfectado(Producto producto) {
		this.productosAfectados.add(producto);
	}
	
	public String getPalabraClave() {
		return this.palabraClave;
	}

	public int getPorcentaje() {
		// TODO Auto-generated method stub
		return this.porcentaje;
	}
	
	public int getID() {
		return this.ID;
	}

	public void setProductos(ArrayList<Producto> productosAAgregar) {
		// TODO Auto-generated method stub
		this.productosAfectados = productosAAgregar;
	}
	
	
	
	
}
