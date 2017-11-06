package FrontEnd;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BackEnd.Descuento;
import BackEnd.Empleado;
import BackEnd.Producto;
import BackEnd.Venta;
import BackEndDAO.DescuentoDAO;
import BackEndDAO.EmpleadoDAO;
import BackEndDAO.ProductoDAO;
import BackEndDAO.VentaDAO;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultComboBoxModel;

public class PanelControl extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable tableProductos;
	private JTable tableEmpleados;
	private JTextField textField;
	private JTable tableVentas;
	private JComboBox comboBox_1;
	private TableRowSorter trsFiltro;
	
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
		
		JMenu mnQuitar = new JMenu("Quitar");
		menuBar.add(mnQuitar);
		
		JMenuItem menuItem = new JMenuItem("Producto");
		mnQuitar.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Descuento");
		mnQuitar.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Empleado");
		mnQuitar.add(menuItem_2);
		
		JMenu mnModificar = new JMenu("Modificar");
		menuBar.add(mnModificar);
		
		JMenuItem menuItem_3 = new JMenuItem("Producto");
		mnModificar.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Descuento");
		mnModificar.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Empleado");
		mnModificar.add(menuItem_5);
		
		JMenuItem mntmVerProductos = new JMenuItem("Ver productos");
		panel.add(mntmVerProductos);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Ventas", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Empleado", "Fecha y hora", "Monto"}));
		panel_2.add(comboBox_1);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		panel_2.add(btnFiltrar);
		
		JScrollPane scrollPaneVenta = new JScrollPane();
		panel_4.add(scrollPaneVenta, BorderLayout.CENTER);

		
		DefaultTableModel modeloVentas = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID",
					"Empleado Responsable",
					"Fecha de realizacion",
					"Monto"
		});
		
		tableVentas = new JTable(modeloVentas);
		scrollPaneVenta.setViewportView(tableVentas);
		tableVentas.setEnabled(false);
		
		VentaDAO ventaDao = new VentaDAO();
		
		try {
			for (Venta v : ventaDao.obtenerTodosLasVentas()) {
				modeloVentas.addRow(new Object[] {
						v.getID(),
						v.getEmpleado().getApellido()+", "+v.getEmpleado().getNombre(),
						v.getFecha(),
						v.getPrecioTotal()
				});
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		mntmVerProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					marco.setContentPane(new VisorDeProductos(
							marco, 
							empleado,
							ventaDao.obtenerTodosLasVentas().get(tableVentas.getSelectedRow())
					));
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				marco.validate();
			}
		});
		
		
		JScrollPane scrollPaneDescuento = new JScrollPane();
		tabbedPane.addTab("Descuentos", null, scrollPaneDescuento, null);
		
		JPanel panel_1 = new JPanel();
		scrollPaneDescuento.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		comboBox.setEditable(false);
		comboBox.setBounds(28, 12, 157, 24);
		comboBox.addItem("Selecciona uno");
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		JList<String> list = new JList<>(listModel);
		list.setBounds(197, 12, 233, 184);
		
		DescuentoDAO descuentoDao = new DescuentoDAO();
		
		try {
			for (Descuento des : descuentoDao.obtenerTodosLosDescuentos()) {
				comboBox.addItem(des.getPalabraClave());
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		comboBox.setSelectedIndex(0);
		
		panel_1.add(comboBox);
		panel_1.add(list);
		
		JLabel lblPorcentaje = new JLabel("Porcentaje: ");
		lblPorcentaje.setBounds(28, 59, 157, 15);
		panel_1.add(lblPorcentaje);
		
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
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			productos = productoDao.obtenerTodosLosProductos();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		for (Producto p : productos) {
			modeloProducto.addRow(new Object[] {
					p.getCodProducto(),
					p.getNombre(),
					p.getPrecio()
			});
		}
		
		tableProductos = new JTable();
		tableProductos.setModel(modeloProducto);
		scrollPaneProducto.setViewportView(tableProductos);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
				if (comboBox.getSelectedIndex()!=0) {
					Descuento d = null;
					d = new Descuento((String) comboBox.getSelectedItem());
					for (Producto pD : d.getProductosAfectados()) {
						listModel.addElement(pD.getNombre());
					}
					lblPorcentaje.setText("Porcentaje: "+d.getPorcentaje()+"%");
				} else {
					lblPorcentaje.setText("Ningun descuento seleccionado");
				}
			}
		});
		
		// SECCION VENTAS
		
		//Filtrar
		
		btnFiltrar.addActionListener(new ActionListener() {
			//Funciona, pero busca los datos en toda la tabla, no deja seleccionar una fila a filtrar
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modeloVentas);
		       	tableVentas.setRowSorter(tr);
		        tr.setRowFilter(RowFilter.regexFilter(textField.getText(),comboBox_1.getSelectedIndex()+1));
			}
		});
		
		
		// SECCION PRODUCTOS
		// Agregar
		mntmProducto.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	marco.setContentPane(new VentanaAñadirProducto(marco, empleado));
		    	marco.validate();
		    }
		});
		// Quitar
		menuItem_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	for (int i : tableProductos.getSelectedRows()) {
		    		Producto aQuitar = new Producto(
			    			(String) modeloProducto.getValueAt(i, 0), 
			    			(String) modeloProducto.getValueAt(i , 1), 
							(int) modeloProducto.getValueAt(i , 2)
			    	);
			    	if (JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar \""+aQuitar.getNombre()+"\"?") == 0) {
			    		aQuitar.eliminar();
			    	};
			    	modeloProducto.removeRow(i);
		    	}
		    }
		});
		// Modificar
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto aModificar = new Producto(
		    			(String) modeloProducto.getValueAt(tableProductos.getSelectedRow(), 0), 
		    			(String) modeloProducto.getValueAt(tableProductos.getSelectedRow() , 1), 
						(int) modeloProducto.getValueAt(tableProductos.getSelectedRow() , 2)
		    	);
				marco.setContentPane(new VentanaModificarProducto(marco, empleado, aModificar));
				marco.validate();
			}
		});
		
		// SECCION EMPLEADOS
		// Agregar
		menuItemEmpleado.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	marco.setContentPane(new VentanaAñadirEmpleado(marco, empleado));
		    	marco.validate();
		    }
		});
		// Quitar
		menuItem_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	for (int i : tableEmpleados.getSelectedRows()) {
		    		Empleado aQuitar = new Empleado(
			    			(String) modeloEmpleado.getValueAt(i, 0), 
			    			(String) modeloEmpleado.getValueAt(i , 1), 
							(String) modeloEmpleado.getValueAt(i , 2),
							null
			    	);
			    	if (JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar \""+aQuitar.getApellido()+"\"?") == 0) {
			    		aQuitar.eliminar();
			    	};
			    	modeloEmpleado.removeRow(i);
		    	}
		    }
		});
		// Modificar
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado aModificar = new Empleado(
						(String) modeloEmpleado.getValueAt(tableEmpleados.getSelectedRow(), 0), 
		    			(String) modeloEmpleado.getValueAt(tableEmpleados.getSelectedRow() , 1), 
						(String) modeloEmpleado.getValueAt(tableEmpleados.getSelectedRow() , 2),
						(Date) modeloEmpleado.getValueAt(tableEmpleados.getSelectedRow(), 3)
					);
				marco.setContentPane(new VentanaModificarEmpleado(marco, empleado, aModificar));
				marco.validate();
				
			}
		});
		// SECCION DESCUENTOS
		// Agregar
		menuItemDescuento.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	marco.setContentPane(new VentanaAñadirDescuento(marco, empleado));
		    	marco.validate();
		    }
		});
		// Quitar
		menuItem_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    		Descuento aQuitar = new Descuento((String) comboBox.getSelectedItem());
			    	if (JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar \""+aQuitar.getPalabraClave()+"\"?") == 0) {
			    		aQuitar.eliminar();
			    	};
			    	comboBox.removeItemAt(comboBox.getSelectedIndex());
		    }
		});
		// Modificar
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Descuento aModificar = new Descuento((String) comboBox.getSelectedItem());
				marco.setContentPane(new VentanaModificarDescuento(marco, empleado, aModificar));
				marco.validate();
				
			}
		});
	}
	
	public void filtro() {
        int columnaABuscar = 0;
        if (comboBox_1.getSelectedItem() == "Codigo") {
            columnaABuscar = 0;
        }
        if (comboBox_1.getSelectedItem().toString() == "Nombre") {
            columnaABuscar = 1;
        }
        if (comboBox_1.getSelectedItem() == "DNI") {
            columnaABuscar = 2;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(textField.getText(), columnaABuscar));
    }
}
