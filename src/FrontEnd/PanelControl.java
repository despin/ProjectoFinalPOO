package FrontEnd;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BackEnd.Empleado;
import BackEnd.Producto;
import BackEndDAO.ProductoDAO;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PanelControl extends JPanel {
	private JTable tableProductos;
	private JTable tableDescuentos;
	private JTable tableEmpleados;
	private JTable table;
	PanelControl(JFrame marco,Empleado empleado) {
		setLayout(new BorderLayout(0, 0));
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marco.setContentPane(new Inicio(marco));
				marco.validate();
			}
		});
		add(btnAceptar, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar);
		
		JMenu mnAadir = new JMenu("Añadir");
		menuBar.add(mnAadir);
		
		JMenuItem mntmProducto = new JMenuItem("Producto");
		mnAadir.add(mntmProducto);
		
		JMenuItem menuItemDescuento = new JMenuItem("Descuento");
		mnAadir.add(menuItemDescuento);
		
		JMenuItem menuItemEmpleado = new JMenuItem("Empleado");
		mnAadir.add(menuItemEmpleado);
		
		JMenu mnFiltrar = new JMenu("Filtrar");
		menuBar.add(mnFiltrar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JScrollPane scrollPaneVenta = new JScrollPane();
		tabbedPane.addTab("Ventas", null, scrollPaneVenta, null);
		
		table = new JTable();
		scrollPaneVenta.setViewportView(table);
		
		JScrollPane scrollPaneDescuento = new JScrollPane();
		tabbedPane.addTab("Descuentos", null, scrollPaneDescuento, null);
		
		tableDescuentos = new JTable();
		tableDescuentos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		scrollPaneDescuento.setViewportView(tableDescuentos);
		
		JScrollPane scrollPaneEmpleado = new JScrollPane();
		tabbedPane.addTab("Empleados", null, scrollPaneEmpleado, null);
		
		tableEmpleados = new JTable();
		scrollPaneEmpleado.setViewportView(tableEmpleados);
		
		JScrollPane scrollPaneProducto = new JScrollPane();
		tabbedPane.addTab("Productos", null, scrollPaneProducto, null);
		
		DefaultTableModel modeloProducto = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Codigo", "Nombre", "Precio"
					
				}
			);
		
		ProductoDAO productoDao = new ProductoDAO();
		
		try {
			for (Producto p : productoDao.obtenerTodosLosProductos()) {
				modeloProducto.addRow(new Object[] {
						p.getCodProducto(),
						p.getNombre(),
						p.getPrecio()
				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableProductos = new JTable();
		tableProductos.setModel(modeloProducto);
		scrollPaneProducto.setViewportView(tableProductos);
		
	}
}
