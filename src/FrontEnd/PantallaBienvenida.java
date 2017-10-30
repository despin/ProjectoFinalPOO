package FrontEnd;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class PantallaBienvenida extends JPanel {
	public PantallaBienvenida(JFrame marco) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblBienvenidoAMarketsystem = new JLabel("Bienvenido a MarketSystem");
		lblBienvenidoAMarketsystem.setFont(new Font("Dialog", Font.BOLD, 20));
		lblBienvenidoAMarketsystem.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBienvenidoAMarketsystem, BorderLayout.NORTH);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		add(progressBar, BorderLayout.SOUTH);
		
		JLabel lblCargando = new JLabel("Cargando...");
		lblCargando.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCargando, BorderLayout.CENTER);
		

	}
}
