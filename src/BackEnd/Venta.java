package BackEnd;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import BackEndDAO.ProductoVendidoDAO;
import BackEndDAO.VentaDAO;

public class Venta {

	int ID;
	Empleado cajeroResponsable;
	Date fechaTransaccion;
	ArrayList<ProductoVendido> productos = new ArrayList<ProductoVendido>();
	int precioTotal;

	
	public Venta(Empleado empleado){
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date ahora = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		this.cajeroResponsable = empleado;
		this.fechaTransaccion = ahora;
	}
	
	public Venta(int id, Empleado empleado, Date fecha, int precio){
		this.ID = id;
		this.cajeroResponsable = empleado;
		this.fechaTransaccion = fecha;
		this.precioTotal = precio;
	}

	public boolean registrar() {
		VentaDAO ventaDao = new VentaDAO();
		try {
			ID = ventaDao.insertar(this, getTotalAbonarConDescuentos());
			for (ProductoVendido pv : productos) {
				pv.registrar(ID);
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Empleado getEmpleado() {
		// TODO Auto-generated method stub
		return this.cajeroResponsable;
	}	
	
	public int getID() {
		return this.ID;
	}
	public Date getFecha() {
		return fechaTransaccion;
	}

	public void agregarProducto(ProductoVendido producto) {
		this.productos.add(producto);
	}

	public void quitarProducto(int selectedRow) {
		// TODO Auto-generated method stub
		this.productos.remove(selectedRow);
	}

	public int cantidadDeProductos() {
		return this.productos.size();
	}

	public void aplicarDescuentos() {
		for (ProductoVendido pV : productos) {
			pV.aplicarDescuentos();
		}
		
	}

	public int getTotalAbonar() {
		int totalAbonar = 0;
		for (ProductoVendido pv : productos) {
			totalAbonar = totalAbonar + pv.obtenerPrecioSubtotal();
		}
		return totalAbonar;
	}

	public int getPrecioTotal() {
		return this.precioTotal;
	}
	
	public int getTotalAbonarConDescuentos() {
		int totalAbonar = 0;
		for (ProductoVendido pv : productos) {
			totalAbonar = totalAbonar + pv.obtenerPrecioSubtotalConDescuentosAplicados();
		}
		return totalAbonar;
	}

	public ArrayList<ProductoVendido> obtenerProductosVendidos() {
		ProductoVendidoDAO dao = new ProductoVendidoDAO();
		try {
			return dao.obtenerProductosPorVenta(this.ID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
