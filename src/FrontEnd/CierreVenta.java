package FrontEnd;

import javax.swing.JPanel;

import BackEnd.Empleado;
import BackEnd.Venta;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CierreVenta extends JPanel {
	public CierreVenta(JFrame marco, Empleado empleado, Integer total) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(119, 136, 153));
		menuBar.setForeground(new Color(255, 255, 255));
		panel.add(menuBar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("GRACIAS POR COMPRAR");
		label_1.setBounds(12, 85, 329, 15);
		panel_1.add(label_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(176, 224, 230));
		
		btnVolver.setBounds(38, 166, 117, 25);
		panel_1.add(btnVolver);
		
		JLabel lblTotalX = new JLabel("Total: "+total.toString());
		lblTotalX.setBounds(39, 119, 123, 15);
		panel_1.add(lblTotalX);
		
		JButton btnIrAlInicio = new JButton("Ir al inicio");
		btnIrAlInicio.setBackground(new Color(176, 224, 230));
		btnIrAlInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marco.setContentPane(new Inicio(marco));
				marco.validate();
			}
		});
		btnIrAlInicio.setBounds(167, 166, 117, 25);
		panel_1.add(btnIrAlInicio);
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marco.setContentPane(new VentaNueva(marco, empleado));
				marco.validate();
			}
		});
	}
}
