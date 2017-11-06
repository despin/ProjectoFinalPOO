package FrontEnd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BackEnd.Descuento;
import BackEnd.Empleado;
import BackEnd.Producto;
import BackEndDAO.ProductoDAO;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class VentanaModificarDescuentoModificarProductos extends JPanel{

	private ArrayList<Producto> productos = new ArrayList<Producto>();

	public VentanaModificarDescuentoModificarProductos(JFrame marco, Empleado empleado, Descuento d) {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel modeloProducto = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Agregar?", "Codigo", "Nombre", "Valor"
				}
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			};
		table.setModel(modeloProducto);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marco.setContentPane(new VentanaModificarDescuento(marco, empleado,d));
				marco.validate();
			}
		});
		panel.add(btnAtras, BorderLayout.WEST);
		
		JButton button = new JButton("Modificar");
		panel.add(button, BorderLayout.CENTER);
			
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.eliminar();
				ArrayList<Producto> aAgregar = new ArrayList<Producto>();
				for (int i=0; i<modeloProducto.getRowCount(); i++) {
					if ((boolean) modeloProducto.getValueAt(i, 0)) {
						aAgregar.add(productos.get(i));
					}
				}
				d.setProductos(aAgregar);
				d.registrar();
				marco.setContentPane(new PanelControl(marco, empleado));
				marco.validate();
			}
		});
		ProductoDAO productoDao = new ProductoDAO();
		try {
			productos  = productoDao.obtenerTodosLosProductos();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		for (Producto p : d.getProductosAfectados()) {
			System.out.println(p.getCodProducto());
		}
		for (Producto p : productos) {
			modeloProducto.addRow(new Object[] {
					existeProductoEnArray(p, d.getProductosAfectados()),
					p.getCodProducto(),
					p.getNombre(),
					p.getPrecio()
			});
		}
		
	}

	private boolean existeProductoEnArray(Producto producto, ArrayList<Producto> productosAfectados) {
		// TODO Auto-generated method stub
		for (Producto p : productosAfectados) {
			if (producto.getCodProducto().equals(p.getCodProducto())) {
				return true;
			}
		}
		return false;
	}
}
