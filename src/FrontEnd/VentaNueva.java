package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentaNueva extends JPanel {
	private JTable table;
	VentaNueva (JFrame marco, String codigoDeEmpleado) {
		setLayout(new BorderLayout(0, 0));
		
		JButton btnAceptar = new JButton("Aceptar");
		add(btnAceptar, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEmpleado = new JLabel("Empleado \""+codigoDeEmpleado+"\"");
		lblEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEmpleado);
		
		JButton btnAnadir = new JButton("Añadir ");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnAnadir, BorderLayout.WEST);
		
		JButton btnQuitar = new JButton("Quitar");
		panel.add(btnQuitar, BorderLayout.EAST);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);	
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel, btnAnadir, btnQuitar, scrollPane, btnAceptar}));
		
		
		JPanel panelScroll = new JPanel();
		scrollPane.setViewportView(panelScroll);
		panelScroll.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		panelScroll.add(table, BorderLayout.CENTER);
		
	}
}
