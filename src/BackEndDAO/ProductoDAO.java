package BackEndDAO;

import BackEnd.Producto;

public class ProductoDAO {
	
	public ProductoDAO() {
	}

	public Producto obtenerProductoDesdeCodigo(String codigo) {
		//obtener datos desde un query
		return new Producto(codigo, "", 0);
	}
	
}
