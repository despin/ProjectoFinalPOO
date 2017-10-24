package BackEnd;

import java.util.ArrayList;
import java.util.Date;

public class Venta {

	
	int cajeroResponsable;
	Date fechaTransaccion;
	ArrayList <ProductoVendido> productosVendidos = new ArrayList <ProductoVendido>();

	
	public Venta(int cajeroResponsable, Date fechaTransaccion){
		
		this.cajeroResponsable = cajeroResponsable;
		this.fechaTransaccion = fechaTransaccion;
		
	}	
	
}
