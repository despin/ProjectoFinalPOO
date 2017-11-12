package FrontEnd;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import BackEnd.Descuento;
import BackEnd.Empleado;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import BackEnd.Descuento;
import BackEnd.Empleado;

public class VentanaAñadirDescuento extends JPanel {
	private JTextField txtPalabraclave;

	public VentanaAñadirDescuento(JFrame marco, Empleado empleado) {
setLayout(new BorderLayout(0, 0));
		
		JLabel lblAadirNuevoDescuento = new JLabel("Añadir nuevo Descuento");
		lblAadirNuevoDescuento.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirNuevoDescuento.setFont(new Font("Dialog", Font.BOLD, 17));
		add(lblAadirNuevoDescuento, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(164, 227, 117, 25);
		panel.add(btnAgregar);
		
		txtPalabraclave = new JTextField();
		txtPalabraclave.setBounds(227, 42, 114, 19);
		panel.add(txtPalabraclave);
		txtPalabraclave.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.setValue(1);
		slider.setBounds(147, 151, 243, 16);
		panel.add(slider);
		
		JLabel lblValor = new JLabel("1%");
		lblValor.setBounds(59, 152, 70, 15);
		panel.add(lblValor);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(164, 44, 70, 15);
		panel.add(lblNombre);
		
		JLabel lblPorcentaje = new JLabel("Porcentaje");
		lblPorcentaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorcentaje.setBounds(59, 128, 331, 15);
		panel.add(lblPorcentaje);
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				lblValor.setText(slider.getValue()+"%");
			}
		});

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Descuento d = new Descuento(txtPalabraclave.getText(), slider.getValue());
				marco.setContentPane(new VentanaAñadirDescuentoAñadirProductos(marco, empleado, d));
				marco.validate();
			}
		});
	}
}
