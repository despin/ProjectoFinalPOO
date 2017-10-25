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
	VentaNueva (JFrame marco, String codigoDeEmpleado) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Empleado"+codigoDeEmpleado);
		lblNewLabel.setBounds(22, 12, 175, 15);
		add(lblNewLabel);
	}
}
