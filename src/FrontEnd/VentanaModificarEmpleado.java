package FrontEnd;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import BackEnd.Empleado;

public class VentanaModificarEmpleado extends JPanel {
	public VentanaModificarEmpleado(JFrame marco, Empleado empleadoEnSesion, Empleado aModificar) {
		setLayout(new BorderLayout(0, 0));
		
		Empleado empleadoAnterior = aModificar;
		
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
		
		JTextField textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(206, 22, 142, 19);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		textFieldCodigo.setText(empleadoAnterior.getCodigo());
		textFieldCodigo.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(131, 55, 70, 15);
		panel.add(lblNewLabel);
		
		JTextField textFieldNombre = new JTextField();
		textFieldNombre.setBounds(206, 53, 142, 19);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.setText(empleadoAnterior.getNombre());
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.TRAILING);
		lblApellido.setBounds(131, 82, 70, 15);
		panel.add(lblApellido);
	
		JTextField textFieldApellido = new JTextField();
		textFieldApellido.setBounds(206, 80, 142, 19);
		panel.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		textFieldApellido.setText(empleadoAnterior.getApellido());
		
		JTextField textField_1 = new JTextField();
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
		
		JButton btnAgregar = new JButton("Modificar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				empleadoAnterior.eliminar();
				Empleado nuevo = new Empleado(empleadoAnterior.getCodigo(), textFieldNombre.getText(),textFieldApellido.getText(), ahora);
				try {
					nuevo.registrar();
					marco.setContentPane(new PanelControl(marco,empleadoEnSesion));
					marco.validate();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}	
			}
		});
		btnAgregar.setBounds(219, 161, 117, 25);
		panel.add(btnAgregar);
		
		
	}
}
