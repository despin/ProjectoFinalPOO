package FrontEnd;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PantallaBienvenida extends JPanel {
	public PantallaBienvenida(JFrame marco) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hola, bienvenido a MarketSystem");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getSize() + 6f));
		lblNewLabel.setBounds(40, 27, 357, 23);
		add(lblNewLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setBounds(31, 168, 348, 14);
		add(progressBar);
		
		JLabel lblCargando = new JLabel("Cargando...");
		lblCargando.setBounds(158, 141, 111, 15);
		add(lblCargando);
		

	}
}
