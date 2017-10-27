package BackEndDAO;

import BackEnd.Producto;

public class ProductoDAO {
	
	public ProductoDAO() {
	}

	public Producto obtenerProductoDesdeCodigo(String codigo) {
		//obtener datos desde un query
		
		/*conexion 
		
		statement 
		
		query
		
		in
		*/
		
		return new Producto(codigo, "producto_"+codigo, 2);
	}
	
}
