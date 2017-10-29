package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;

public class Inicio extends JPanel{
	private JTextField codEmpleado;
	Inicio (JFrame marco) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblCodigoDeEmpleado = new JLabel("Codigo de empleado");
		panel_1.add(lblCodigoDeEmpleado);
		
		codEmpleado = new JTextField();
		panel_1.add(codEmpleado);
		codEmpleado.setColumns(6);
		
		JButton btnVentaNueva = new JButton("Venta Nueva");
		add(btnVentaNueva, BorderLayout.CENTER);
		btnVentaNueva.setToolTipText("Inicia el proceso de venta");
		btnVentaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marco.setContentPane(new VentaNueva(marco, codEmpleado.getText()));
				marco.validate();
			}
		});
		btnVentaNueva.setMnemonic('v');
		
		JButton btnPanelControl = new JButton("Panel de control");
		add(btnPanelControl, BorderLayout.SOUTH);
		btnPanelControl.setToolTipText("Administra y monitoriza las transacciones del sistema");
		btnPanelControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marco.setContentPane(new PanelControl(marco, codEmpleado.getText()));
                marco.validate();	
			}
		});
		btnPanelControl.setMnemonic('c');
		
	}
}
