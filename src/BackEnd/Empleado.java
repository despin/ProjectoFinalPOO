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

	public Empleado(String text) {
		// TODO Auto-generated constructor stub
	}

	public String getApellido() {
		// TODO Auto-generated method stub
		return this.apellido;
	}
	
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	
	public Date getFechaDeIngreso() {
		return this.fechaDeIngreso;
	}
}
