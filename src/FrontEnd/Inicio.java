package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JPanel{
	Inicio (JFrame marco) {
		setLayout(null);
		
		JButton btnVentaNueva = new JButton("Venta Nueva");
		btnVentaNueva.setToolTipText("Inicia el proceso de venta");
		btnVentaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Venta!");
			}
		});
		btnVentaNueva.setMnemonic('v');
		btnVentaNueva.setBounds(107, 62, 230, 62);
		add(btnVentaNueva);
		
		JButton btnPanelControl = new JButton("Panel de control");
		btnPanelControl.setToolTipText("Administra y monitoriza las transacciones del sistema");
		btnPanelControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Control!");
			}
		});
		btnPanelControl.setMnemonic('c');
		btnPanelControl.setBounds(107, 136, 230, 62);
		add(btnPanelControl);
		
	}
}
