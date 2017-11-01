package FrontEnd;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BackEnd.Empleado;
import BackEnd.Producto;
import BackEnd.Venta;
import BackEndDAO.EmpleadoDAO;
import BackEndDAO.ProductoDAO;
import BackEndDAO.VentaDAO;

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
import javax.swing.JComboBox;
import javax.swing.JList;

public class PanelControl extends JPanel {
	private JTable tableProductos;
	private JTable tableEmpleados;
	private JTable tableVentas;
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
		
		DefaultTableModel modeloVentas = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID",
					"Empleado Responsable",
					"Fecha de realizacion"
		});
		
		VentaDAO ventaDao = new VentaDAO();
		
		try {
			for (Venta v : ventaDao.obtenerTodosLasVentas()) {
				modeloVentas.addRow(new Object[] {
						v.getID(),
						v.getEmpleado().getApellido()+", "+v.getEmpleado().getNombre(),
						v.getFecha()
				});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		tableVentas = new JTable(modeloVentas);
		scrollPaneVenta.setViewportView(tableVentas);
		
		JScrollPane scrollPaneDescuento = new JScrollPane();
		tabbedPane.addTab("Descuentos", null, scrollPaneDescuento, null);
		
		JPanel panel_1 = new JPanel();
		scrollPaneDescuento.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(28, 12, 157, 24);
		
		
		
		panel_1.add(comboBox);
		
		JList list = new JList();
		list.setBounds(197, 12, 233, 184);
		panel_1.add(list);
		
		JScrollPane scrollPaneEmpleado = new JScrollPane();
		tabbedPane.addTab("Empleados", null, scrollPaneEmpleado, null);
		

		DefaultTableModel modeloEmpleado = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Codigo", "Nombre", "Apellido", "Fecha de Ingreso"	
				}
			);
		
		EmpleadoDAO empleadoDao = new EmpleadoDAO();
		
		try {
			for (Empleado e : empleadoDao.obtenerTodosLosEmpleados()) {
				modeloEmpleado.addRow(new Object[] {
						e.getCodigo(),
						e.getNombre(),
						e.getApellido(),
						e.getFechaDeIngreso()	
				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableEmpleados = new JTable();
		tableEmpleados.setModel(modeloEmpleado);
		
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
