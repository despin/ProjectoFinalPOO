package BackEnd;

import java.sql.SQLException;
import java.util.Date;

import BackEndDAO.EmpleadoDAO;
import BackEndDAO.ProductoDAO;
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

	public Empleado(String text) throws Exception {
		// TODO Auto-generated constructor stub
		EmpleadoDAO dao = new EmpleadoDAO();
		Empleado nuevo = dao.obtenerEmpleadoDesdeCodigo(text);
		this.codigoDeEmpleado = text;
		this.nombre = nuevo.getNombre();
		this.apellido = nuevo.getApellido();
		this.fechaDeIngreso = nuevo.getFechaDeIngreso();
	}

	public String getCodigo() {
		return this.codigoDeEmpleado;
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

	public boolean eliminar() {
		EmpleadoDAO dao = new EmpleadoDAO();
		try {
			dao.quitar(this);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean registrar() {
		// TODO Auto-generated method stub
		EmpleadoDAO dao = new EmpleadoDAO();
		try {
			dao.insertar(this);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
