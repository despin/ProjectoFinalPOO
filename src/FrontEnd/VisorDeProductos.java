package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BackEnd.Descuento;
import BackEnd.Empleado;
import BackEnd.ProductoVendido;
import BackEnd.Venta;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class VisorDeProductos extends JPanel {
	private JTable table;

	public VisorDeProductos(JFrame marco, Empleado empleado, Venta venta) {
		setLayout(new BorderLayout(0, 0));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marco.setContentPane(new PanelControl(marco,empleado));
				marco.validate();
			}
		});
		add(btnVolver, BorderLayout.SOUTH);
		
		JLabel lblVenta = new JLabel("Venta N°"+
									 venta.getID()+
									 " realizada por "+
									 venta.getEmpleado().getApellido()+
									 ", "+
									 venta.getEmpleado().getNombre()+
									 " el "+
									 (venta.getFecha().getYear()+1900)+
									 "/"+
									 (venta.getFecha().getMonth()+1)+
									 "/"+
									 venta.getFecha().getDate()
									 );
		lblVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenta.setFont(new Font("Dialog", Font.BOLD, 11));
		add(lblVenta, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] { },
				new String[] {
					"Codigo",
					"Nombre",
					"Cantidad",
					"Precio",
					"Descuentos",
					"Precio Subtotal"
				});
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
		for (ProductoVendido pv : venta.obtenerProductosVendidos()) {
			String descuentos = "";
			for (Descuento d : pv.getProducto().obtenerDescuentos()) {
				descuentos = descuentos + d.getPalabraClave()+"(" + d.getPorcentaje()+"%), ";
			}
			modelo.addRow(new Object[] {
					pv.getProducto().getCodProducto(),
					pv.getProducto().getNombre(),
					pv.getCantidad(),
					pv.getProducto().getPrecio(),
					descuentos,
					pv.obtenerPrecioSubtotalConDescuentosAplicados()
			});
		}
	}

}
