package BackEnd;

import java.util.Date;

public class Empleado {

	String codigoDeEmpleado;
	String nombre;
	String apellido;
	Date fechaDeIngreso;
	
	public Empleado (String codigoDeEmpleado, String nombre, String apellido, Date fechaDeIngreso){
		
		this.codigoDeEmpleado = codigoDeEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeIngreso = fechaDeIngreso;
		
	}
	
}
