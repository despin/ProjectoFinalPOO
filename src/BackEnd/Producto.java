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
	
	public Producto (String codigoBarras) throws Exception {
		//Query para obtener el producto mediante un procedimiento almacenado
		ProductoDAO dao = new ProductoDAO();
		Producto nuevo = dao.obtenerProductoDesdeCodigo(codigoBarras);
		this.codigoBarras = nuevo.getCodProducto();
		this.nombre = nuevo.getNombre();
		this.precio = nuevo.getPrecio();
		/*this.nombre = "Producto_"+codigoBarras;
		this.precio = 2;*/
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
