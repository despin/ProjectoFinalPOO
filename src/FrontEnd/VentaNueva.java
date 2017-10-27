package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.sun.media.sound.ModelOscillator;

import BackEnd.Producto;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class VentaNueva extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCodProducto;
	private JTable table;
	private JSpinner spinner;
	VentaNueva (JFrame marco, String codigoDeEmpleado) {
		//agregar arraylist productosvendidos
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Empleado"+codigoDeEmpleado);
		lblNewLabel.setBounds(121, 12, 122, 15);
		add(lblNewLabel);
		
		String[] headerTable = new String[] {
				"Codigo", "Nombre", "Precio p/u", "Unidades", "PrecioTotal"
			};
			
		Object[][] registros = { null,null,null,null,null};
		
		DefaultTableModel modelo = new DefaultTableModel(
				registros,
				headerTable
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					String.class, String.class, Double.class, Double.class, Double.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			};
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAceptar.setBounds(260, 265, 102, 25);
		add(btnAceptar);
		
		
		
		textFieldCodProducto = new JTextField();
		textFieldCodProducto.setBounds(115, 28, 122, 19);
		add(textFieldCodProducto);
		textFieldCodProducto.setColumns(6);
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(401, 25, 72, 25);
		add(btnQuitar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(32, 62, 497, 191);
		add(scrollPane);
		
		JPanel panelTable = new JPanel();
		scrollPane.setViewportView(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Precio p/u", "Unidades", "PrecioTotal"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(203);
		panelTable.add(table, BorderLayout.CENTER);
		panelTable.add(table.getTableHeader(), BorderLayout.NORTH);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		spinner.setBounds(249, 28, 61, 20);
		add(spinner);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Producto productoNuevo = new Producto(textFieldCodProducto.getText());
				int precioTotal = productoNuevo.getPrecio() * (int) spinner.getValue();
				modelo.addRow(new Object[]{productoNuevo.getCodProducto(), productoNuevo.getNombre(), productoNuevo.getPrecio(), spinner.getValue(), precioTotal});
				
			}
		});
		btnAgregar.setBounds(22, 25, 81, 25);
		add(btnAgregar);
	}
}
