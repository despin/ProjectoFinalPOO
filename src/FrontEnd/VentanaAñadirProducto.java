package FrontEnd;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import BackEnd.Empleado;
import BackEnd.Producto;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class VentanaAñadirProducto extends JPanel {
	protected static final Container PanelControl = null;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	public VentanaAñadirProducto(JFrame marco, Empleado empleado) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblAadirNuevoProducto = new JLabel("Añadir nuevo Producto");
		lblAadirNuevoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirNuevoProducto.setFont(new Font("Dialog", Font.BOLD, 17));
		add(lblAadirNuevoProducto, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCodigoDeBarras = new JLabel("Codigo de barras");
		lblCodigoDeBarras.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCodigoDeBarras.setBounds(37, 24, 164, 15);
		panel.add(lblCodigoDeBarras);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(206, 22, 142, 19);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(131, 55, 70, 15);
		panel.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(206, 53, 142, 19);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrecio.setBounds(131, 82, 70, 15);
		panel.add(lblPrecio);
		
		JSpinner spinnerPrecio = new JSpinner();
		spinnerPrecio.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerPrecio.setBounds(206, 80, 142, 20);
		panel.add(spinnerPrecio);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Producto nuevo = new Producto(textFieldCodigo.getText(), textFieldNombre.getText(),(Integer) spinnerPrecio.getValue());
				if (nuevo.getCodProducto() != "Error") {
					if (nuevo.registrar()) {
						marco.setContentPane(new PanelControl(marco,empleado));
						marco.validate();
					} else {
						JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
					}	
				} else {
					JOptionPane.showMessageDialog(null, "LOS DATOS NO SON VALIDOS");
				}
			}
		});
		btnAgregar.setBounds(219, 161, 117, 25);
		panel.add(btnAgregar);
		
	}
	
	public VentanaAñadirProducto(JFrame marco, Empleado empleado, Producto producto) {
		setLayout(new BorderLayout(0, 0));
		
		Producto productoViejo = producto;
		
		JLabel lblAadirNuevoProducto = new JLabel("Editar Producto existente");
		lblAadirNuevoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirNuevoProducto.setFont(new Font("Dialog", Font.BOLD, 17));
		add(lblAadirNuevoProducto, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCodigoDeBarras = new JLabel("Codigo de barras");
		lblCodigoDeBarras.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCodigoDeBarras.setBounds(37, 24, 164, 15);
		panel.add(lblCodigoDeBarras);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(206, 22, 142, 19);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		textFieldCodigo.setText(producto.getCodProducto());
		textFieldCodigo.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(131, 55, 70, 15);
		panel.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(206, 53, 142, 19);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.setText(producto.getNombre());
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrecio.setBounds(131, 82, 70, 15);
		panel.add(lblPrecio);
		
		JSpinner spinnerPrecio = new JSpinner();
		spinnerPrecio.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerPrecio.setBounds(206, 80, 142, 20);
		panel.add(spinnerPrecio);
		
		spinnerPrecio.setValue(producto.getPrecio());
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productoViejo.eliminar();
				
				Producto nuevo = new Producto(producto.getCodProducto(), textFieldNombre.getText(),(Integer) spinnerPrecio.getValue());
				if (nuevo.getCodProducto() != "Error") {
					if (nuevo.registrar()) {
						marco.setContentPane(new PanelControl(marco,empleado));
						marco.validate();
					} else {
						JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
					}	
				} else {
					JOptionPane.showMessageDialog(null, "LOS DATOS NO SON VALIDOS");
				}
			}
		});
		btnAgregar.setBounds(219, 161, 117, 25);
		panel.add(btnAgregar);
		
	}
}
