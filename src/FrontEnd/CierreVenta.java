package FrontEnd;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CierreVenta extends JPanel {
	public CierreVenta(JFrame marco, int totalAbonar) {
		setLayout(null);
		
		JLabel lblDebeAbonarxxx = new JLabel("Debe abonar $"+totalAbonar);
		lblDebeAbonarxxx.setBounds(143, 67, 131, 15);
		add(lblDebeAbonarxxx);
		
		JLabel lblGr = new JLabel("Gracias por comprar con MarketSystem");
		lblGr.setBounds(183, 121, 62, 15);
		add(lblGr);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 438, 21);
		add(menuBar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(128, 233, 117, 25);
		add(btnVolver);
		
	}
}
