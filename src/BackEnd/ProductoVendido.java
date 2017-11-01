package BackEnd;

import BackEndDAO.ProductoVendidoDAO;

public class ProductoVendido {
	
	Producto producto;
	int cantidad;

	public ProductoVendido(Producto producto, int cantidad){
		this.producto = producto;
		this.cantidad = cantidad;
	}

}
