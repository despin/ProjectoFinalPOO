package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BackEnd.Descuento;
import BackEnd.Empleado;
import BackEnd.Producto;
import BackEndDAO.ProductoDAO;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class VentanaAñadirDescuentoAñadirProductos extends JPanel {
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private JTable table;
	public VentanaAñadirDescuentoAñadirProductos(JFrame marco, Empleado empleado, Descuento d) {
		setLayout(new BorderLayout(0, 0));
		
		JButton btnAceptar = new JButton("Aceptar");
		add(btnAceptar, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
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
			
		ProductoDAO productoDao = new ProductoDAO();
		try {
			productos = productoDao.obtenerTodosLosProductos();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		for (Producto p : productos) {
			modeloProducto.addRow(new Object[] {
					false,
					p.getCodProducto(),
					p.getNombre(),
					p.getPrecio()
			});
		}
		
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i=0; i < modeloProducto.getRowCount()-1; i++) {
					if ((boolean) modeloProducto.getValueAt(i, 0)) {
						System.out.println(productos.get(i).getCodProducto());
						d.agregarProductoAfectado(productos.get(i));
					}
				}
				d.registrar();
				marco.setContentPane(new PanelControl(marco,empleado));
				marco.validate();
			}
		});
		
	}

}
