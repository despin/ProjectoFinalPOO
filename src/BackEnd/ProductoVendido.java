package BackEnd;

import java.sql.SQLException;
import java.util.ArrayList;

import BackEndDAO.DescuentoDAO;
import BackEndDAO.ProductoVendidoDAO;

public class ProductoVendido {
	
	Producto producto;
	int cantidad;
	int precioConDescuentosAplicados;

	public ProductoVendido(Producto producto, int cantidad){
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int obtenerPrecioSubtotal() {
		return this.producto.precio * this.cantidad;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void registrar(int idVenta) {
		ProductoVendidoDAO dao = new ProductoVendidoDAO();
		dao.insertar(this, idVenta);
	}

	public int getCantidad() {
		// TODO Auto-generated method stub
		return this.cantidad;
	}

	public void aplicarDescuentos() {
		this.precioConDescuentosAplicados = producto.getPrecio();
		double porcentajeTotal = 0;
		for (Descuento d : this.producto.obtenerDescuentos()) {
			porcentajeTotal = porcentajeTotal + d.getPorcentaje();
			System.out.println("porcentajeTotal: "+porcentajeTotal);
		}
		porcentajeTotal = 1 - (porcentajeTotal/100);
		System.out.println(porcentajeTotal);
		double operacion = producto.getPrecio() * porcentajeTotal;
		this.precioConDescuentosAplicados = (int) operacion;
	}

	public int obtenerPrecioSubtotalConDescuentosAplicados() {
		return this.precioConDescuentosAplicados * this.cantidad;
	}
	
	
}
