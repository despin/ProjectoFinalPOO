package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import BackEnd.Empleado;
import BackEnd.Producto;
import BackEnd.ProductoVendido;
import BackEnd.Venta;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class VentaNueva extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textFieldCodProducto;
	VentaNueva (JFrame marco,Empleado empleado) {
		setLayout(new BorderLayout(0, 0));
		
		Venta ventaActual = new Venta(empleado);

		JLabel lblNewLabel = new JLabel("Empleado "+empleado.getApellido()+", "+empleado.getNombre());
		add(lblNewLabel);
		
		String[] headerTable = new String[] {
				"Codigo", "Nombre", "Precio p/u", "Unidades", "PrecioTotal"
			};
			
		Object[][] registros = { };
		
		DefaultTableModel modelo = new DefaultTableModel(
				registros,
				headerTable
			);
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//marco.setContentPane(new CierreVenta(marco, modelo));
				ventaActual.aplicarDescuentos();
				if(ventaActual.registrar()) {
					marco.setContentPane(new CierreVenta(
							marco,
							empleado,
							ventaActual.getTotalAbonar(),
							ventaActual.getTotalAbonarConDescuentos()));
					marco.validate();
				} else {
					JOptionPane.showMessageDialog(null, "ERROR AL REGISTAR LA VENTA. Revise los datos");
				}	
			}
		});
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		add(buttonAceptar, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		JPanel panelTable = new JPanel();
		scrollPane.setViewportView(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(modelo);
		table.getColumnModel().getColumn(1).setPreferredWidth(203);
		panelTable.add(table.getTableHeader(), BorderLayout.NORTH);
		panelTable.add(table, BorderLayout.CENTER);
		
		JPanel panelTop = new JPanel();
		add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panelTop.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);

		JMenuItem mntmAtras = new JMenuItem("Atras");
		mnArchivo.add(mntmAtras);

		mntmAtras.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				marco.setContentPane(new Inicio(marco));
			}
		});
		
		mntmSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				marco.dispose();
			}
		});
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);
		
		JLabel lblNewLabel_1 = new JLabel("Empleado "+empleado.getApellido()+", "+empleado.getNombre()+"  ");
		menuBar.add(lblNewLabel_1);
		
		
		JPanel panel_1 = new JPanel();
		panelTop.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JButton btnAgregar = new JButton("Agregar");
		panel_1.add(btnAgregar);

		textFieldCodProducto = new JTextField();
		panel_1.add(textFieldCodProducto);
		textFieldCodProducto.setColumns(6);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		panel_1.add(spinner);
		
		JButton btnQuitar = new JButton("Quitar");
		panel_1.add(btnQuitar);
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() > -1) {
					modelo.removeRow(table.getSelectedRow());
					ventaActual.quitarProducto(table.getSelectedRow());
				} else if (table.getSelectedRow() < 0 && modelo.getRowCount()>0) {
					modelo.removeRow(modelo.getRowCount()-1);
					ventaActual.quitarProducto(ventaActual.cantidadDeProductos()-1);
				}
			}
		});
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Producto productoNuevo = null;
				try {
					productoNuevo = new Producto(textFieldCodProducto.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (productoNuevo.getNombre()!=null) {
					ProductoVendido vendido = new ProductoVendido(productoNuevo,(int) spinner.getValue());
					ventaActual.agregarProducto(vendido);
					modelo.addRow(new Object[]{vendido.getProducto().getCodProducto(), vendido.getProducto().getNombre(), productoNuevo.getPrecio(), spinner.getValue(), vendido.obtenerPrecioSubtotal()});
				} else {
					JOptionPane.showMessageDialog(null, "ESE PRODUCTO NO EXISTE");
				}
				textFieldCodProducto.setText("");
				spinner.setValue((int) 1);
			}
		});
	}
}
