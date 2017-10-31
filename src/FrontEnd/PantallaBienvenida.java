package FrontEnd;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Canvas;

public class PantallaBienvenida extends JPanel {
	public PantallaBienvenida(JFrame marco) {
		setBackground(new Color(176, 196, 222));
		setLayout(new BorderLayout(0, 0));
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(128, 128, 128));
		progressBar.setIndeterminate(true);
		add(progressBar, BorderLayout.SOUTH);
		
		JLabel lblCargando = new JLabel("Cargando...");
		lblCargando.setBackground(new Color(135, 206, 250));
		lblCargando.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCargando.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCargando, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Bienvenido a MarketSystem");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBackground(new Color(255, 255, 255));
		panel.add(label);
		

	}
}
