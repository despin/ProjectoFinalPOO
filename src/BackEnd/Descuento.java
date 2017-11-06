package BackEnd;

import BackEndDAO.DescuentoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Descuento {
	int ID;
	String palabraClave;
	int porcentaje;
	ArrayList<Producto> productosAfectados = new ArrayList<Producto>();
	
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
	
	public Descuento(String palabraClave, int porcentaje, ArrayList<Producto> productosAfectados){
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
		this.productosAfectados = productosAAgregar;
	}

	public void eliminar() {
		DescuentoDAO dao = new DescuentoDAO();
		try {
			dao.quitar(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registrar() {
		DescuentoDAO dao = new DescuentoDAO();
		try {
			dao.insertar(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setPalabraClave(String text) {
		this.palabraClave = text;
	}
	
	public void setPorcentaje(int porc) {
		this.porcentaje = porc;
	}
	
}
