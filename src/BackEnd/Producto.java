package BackEnd;

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
	
	public Producto Producto (String codigoBarras){
		//Query para obtener el producto mediante un procedimiento almacenado
		ProductoDAO dao = new ProductoDAO();
		return dao.obtenerProductoDesdeCodigo(codigoBarras);
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
	
	
}
