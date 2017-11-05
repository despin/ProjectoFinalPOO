package BackEnd;

import java.sql.SQLException;
import java.util.ArrayList;

import BackEndDAO.ProductoDAO;

public class Producto {

	String codigoBarras;
	String nombre;
	int precio;
	ArrayList <Descuento> descuentos = new ArrayList <Descuento>();

	public Producto (String codigo, String nombre, int precio){
			this.codigoBarras = codigo;
			this.nombre = nombre;
			this.precio = precio;
	}
	
	public Producto (String codigoBarras) throws Exception {
		ProductoDAO dao = new ProductoDAO();
		Producto nuevo = dao.obtenerProductoDesdeCodigo(codigoBarras);
		this.codigoBarras = nuevo.getCodProducto();
		this.nombre = nuevo.getNombre();
		this.precio = nuevo.getPrecio();
	}
	
	public String getCodProducto() {
		return this.codigoBarras;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getPrecio() {
		return this.precio;
	}

	public boolean registrar() {
		// TODO Auto-generated method stub
		ProductoDAO dao = new ProductoDAO();
		try {
			dao.insertar(this);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean eliminar() {
		ProductoDAO dao = new ProductoDAO();
		try {
			dao.quitar(this);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Descuento> obtenerDescuentos() {
		ProductoDAO dao = new ProductoDAO();
		try {
			return dao.obtenerDescuentos(this);
		} catch (SQLException e) {
			return null;
		}
	}
	
	
}
