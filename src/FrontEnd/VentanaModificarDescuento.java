package FrontEnd;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import BackEnd.Descuento;
import BackEnd.Empleado;

public class VentanaModificarDescuento extends JPanel {

	public VentanaModificarDescuento(JFrame marco, Empleado empleado, Descuento aModificar) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblAadirNuevoDescuento = new JLabel("Modificar Descuento existente");
		lblAadirNuevoDescuento.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirNuevoDescuento.setFont(new Font("Dialog", Font.BOLD, 17));
		add(lblAadirNuevoDescuento, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAgregar = new JButton("Continuar");
		btnAgregar.setBounds(283, 227, 117, 25);
		panel.add(btnAgregar);
		
		JTextField txtPalabraclave = new JTextField();
		txtPalabraclave.setBounds(227, 42, 114, 19);
		panel.add(txtPalabraclave);
		txtPalabraclave.setColumns(10);
		txtPalabraclave.setText(aModificar.getPalabraClave());
		
		JSlider slider = new JSlider();
		slider.setValue(1);
		slider.setBounds(147, 151, 243, 16);
		panel.add(slider);
		slider.setValue(aModificar.getPorcentaje());
		JLabel lblValor = new JLabel(aModificar.getPorcentaje()+"%");
		lblValor.setBounds(59, 152, 70, 15);
		panel.add(lblValor);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(164, 44, 70, 15);
		panel.add(lblNombre);
		
		JLabel lblPorcentaje = new JLabel("Porcentaje");
		lblPorcentaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorcentaje.setBounds(59, 128, 331, 15);
		panel.add(lblPorcentaje);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marco.setContentPane(new PanelControl(marco, empleado));
				marco.validate();
			}
		});
		btnCancelar.setBounds(67, 227, 117, 25);
		panel.add(btnCancelar);
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				lblValor.setText(slider.getValue()+"%");
			}
		});

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aModificar.setPalabraClave(txtPalabraclave.getText());
				aModificar.setPorcentaje(slider.getValue());
				marco.setContentPane(new VentanaModificarDescuentoModificarProductos(marco, empleado,aModificar));
				marco.validate();
			}
		});
	}
}
