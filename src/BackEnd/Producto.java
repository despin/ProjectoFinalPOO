package BackEnd;

import java.util.ArrayList;

public class Producto {

	int codigoBarras;
	String nombre;
	int precio;
	ArrayList <Descuento> descuentos = new ArrayList <Descuento>();

	public Producto (int codigoBarras, String nombre, int precio){
		
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.precio = precio;
		
	}
	
}
