package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Inicio extends JPanel{
	private JTextField codEmpleado;
	Inicio (JFrame marco) {
		setLayout(null);
		
		JButton btnVentaNueva = new JButton("Venta Nueva");
		btnVentaNueva.setToolTipText("Inicia el proceso de venta");
		btnVentaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marco.setContentPane(new VentaNueva(marco, codEmpleado.getText()));
				marco.validate();
			}
		});
		btnVentaNueva.setMnemonic('v');
		btnVentaNueva.setBounds(107, 62, 230, 62);
		add(btnVentaNueva);
		
		JButton btnPanelControl = new JButton("Panel de control");
		btnPanelControl.setToolTipText("Administra y monitoriza las transacciones del sistema");
		btnPanelControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marco.setContentPane(new PanelControl(marco, codEmpleado.getText()));
                marco.validate();	
			}
		});
		btnPanelControl.setMnemonic('c');
		btnPanelControl.setBounds(107, 136, 230, 62);
		add(btnPanelControl);
		
		JLabel lblCodigoDeEmpleado = new JLabel("Codigo de empleado");
		lblCodigoDeEmpleado.setBounds(58, 35, 123, 15);
		add(lblCodigoDeEmpleado);
		
		codEmpleado = new JTextField();
		codEmpleado.setBounds(178, 33, 159, 19);
		add(codEmpleado);
		codEmpleado.setColumns(6);
		
	}
}
