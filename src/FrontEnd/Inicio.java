package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BackEnd.Empleado;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;

public class Inicio extends JPanel{
	private JTextField codEmpleado;
	Inicio (JFrame marco) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(112, 128, 144));
		panel.add(menuBar, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 196, 222));
		panel.add(panel_1);
		
		JLabel lblCodigoDeEmpleado = new JLabel("Codigo de empleado");
		lblCodigoDeEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblCodigoDeEmpleado);
		
		codEmpleado = new JTextField();
		panel_1.add(codEmpleado);
		codEmpleado.setColumns(6);
		
		JButton btnVentaNueva = new JButton("Venta Nueva");
		btnVentaNueva.setBackground(new Color(230, 230, 250));
		btnVentaNueva.setForeground(new Color(0, 0, 0));
		btnVentaNueva.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(btnVentaNueva, BorderLayout.CENTER);
		btnVentaNueva.setToolTipText("Inicia el proceso de venta");
		btnVentaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Empleado nuevoEmpleado = null;
				try {
					nuevoEmpleado = new Empleado(codEmpleado.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (nuevoEmpleado.getNombre()!=null){
					System.out.println(nuevoEmpleado.getNombre());
					marco.setContentPane(new VentaNueva(marco, nuevoEmpleado));
					marco.validate();
				} else {
					JOptionPane.showMessageDialog(null, "ESE EMPLEADO NO EXISTE");
					codEmpleado.setText("");
				}
			}
		});
		btnVentaNueva.setMnemonic('v');
		
		JButton btnPanelControl = new JButton("Panel de control");
		btnPanelControl.setBackground(new Color(176, 196, 222));
		btnPanelControl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnPanelControl, BorderLayout.SOUTH);
		btnPanelControl.setToolTipText("Administra y monitoriza las transacciones del sistema");
		btnPanelControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado nuevoEmpleado = null;
				try {
					nuevoEmpleado = new Empleado(codEmpleado.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (nuevoEmpleado.getNombre()!=null){
					marco.setContentPane(new PanelControl(marco, nuevoEmpleado));
					marco.validate();
				} else {
					JOptionPane.showMessageDialog(null, "ESE EMPLEADO NO EXISTE");
					codEmpleado.setText("");
				}
			}
		});
		btnPanelControl.setMnemonic('c');
		
	}
}
