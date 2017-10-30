package FrontEnd;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marco = new JFrame("MarketSystem v0.1");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setBounds(300, 100, 800, 600);
		marco.setVisible(true);
		
		marco.setContentPane(new PantallaBienvenida(marco));
		marco.validate();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		marco.setContentPane(new Inicio(marco));
		marco.validate();
		
	}

}
