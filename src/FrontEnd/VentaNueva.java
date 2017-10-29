package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

import javax.jws.WebParam.Mode;
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
	private JTable table;
	private JTextField textFieldCodProducto;
	VentaNueva (JFrame marco, String codigoDeEmpleado) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Empleado"+codigoDeEmpleado);
		add(lblNewLabel);
		
		String[] headerTable = new String[] {
				"Codigo", "Nombre", "Precio p/u", "Unidades", "PrecioTotal"
			};
			
		Object[][] registros = { };
		
		DefaultTableModel modelo = new DefaultTableModel(
				registros,
				headerTable
			);
		
		JButton button_1 = new JButton("Aceptar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.get
			}
		});
		add(button_1, BorderLayout.SOUTH);
		
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
		panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.X_AXIS));
		
		JButton btnAgregar = new JButton("Agregar");
		panelTop.add(btnAgregar);
		
		textFieldCodProducto = new JTextField();
		textFieldCodProducto.setColumns(6);
		panelTop.add(textFieldCodProducto);
		
		JSpinner spinner = new JSpinner();
		panelTop.add(spinner);
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.removeRow(table.getSelectedRow());
			}
		});
		panelTop.add(btnQuitar);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Producto productoNuevo = null;
				try {
					productoNuevo = new Producto(textFieldCodProducto.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int precioTotal = productoNuevo.getPrecio() * (int) spinner.getValue();
				modelo.addRow(new Object[]{productoNuevo.getCodProducto(), productoNuevo.getNombre(), productoNuevo.getPrecio(), spinner.getValue(), precioTotal});
			}
		});
	}
}
