package FrontEnd;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BackEnd.Empleado;

import javax.swing.JLabel;
import javax.swing.JMenuBar;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CierreVenta extends JPanel {
	public CierreVenta(JFrame marco, int totalAbonar, Empleado empleado) {
		setLayout(null);
		
		JLabel lblDebeAbonarxxx = new JLabel("Debe abonar $"+totalAbonar);
		lblDebeAbonarxxx.setBounds(143, 67, 131, 15);
		add(lblDebeAbonarxxx);
		
		JLabel lblGr = new JLabel("Gracias por comprar con MarketSystem");
		lblGr.setBounds(74, 121, 303, 15);
		add(lblGr);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 438, 21);
		add(menuBar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marco.setContentPane(new VentaNueva(marco, empleado));
			}
		});
		btnVolver.setBounds(128, 233, 117, 25);
		add(btnVolver);
		
	}
}
