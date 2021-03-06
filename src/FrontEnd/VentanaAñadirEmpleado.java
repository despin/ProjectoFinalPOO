package FrontEnd;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import BackEnd.Empleado;
import BackEnd.Producto;
import Excepciones.FormatoInvalidoException;
import Excepciones.RegistroYaExisteException;

public class VentanaAñadirEmpleado extends JPanel{
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textField_1;
	
	/**
	 * @wbp.parser.constructor
	 */
	public VentanaAñadirEmpleado(JFrame marco, Empleado empleadoEnSesion) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblAadirNuevoEmpleado = new JLabel("Añadir nuevo Empleado");
		lblAadirNuevoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirNuevoEmpleado.setFont(new Font("Dialog", Font.BOLD, 17));
		add(lblAadirNuevoEmpleado, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//GENERAR CODIGO DE EMPLEADO
		
		JLabel lblCodigoDeBarras = new JLabel("Codigo de empleado");
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
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.TRAILING);
		lblApellido.setBounds(131, 82, 70, 15);
		panel.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(206, 80, 142, 19);
		panel.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 111, 142, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date ahora = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		
		textField_1.setText((ahora.getYear()+1900)+"/"+(ahora.getMonth()+1)+"/"+ahora.getDate());
		textField_1.setEditable(false);
		
		
		JLabel lblFecha = new JLabel("Fecha de ingreso");
		lblFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFecha.setBounds(59, 113, 142, 15);
		panel.add(lblFecha);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Empleado nuevo = new Empleado(textFieldCodigo.getText(), textFieldNombre.getText(),textFieldApellido.getText(), ahora);
				try {
					nuevo.registrar();
					marco.setContentPane(new PanelControl(marco,empleadoEnSesion));
					marco.validate();
				} catch(FormatoInvalidoException e){
					JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
				} catch(RegistroYaExisteException e) {
					
				}
			}
		});
		btnAgregar.setBounds(219, 161, 117, 25);
		panel.add(btnAgregar);
	}
	
}
