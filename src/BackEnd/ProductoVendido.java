package BackEnd;

import BackEndDAO.ProductoVendidoDAO;

public class ProductoVendido {
	
	Producto producto;
	int cantidad;

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

}
