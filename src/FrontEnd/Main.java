package FrontEnd;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marco = new JFrame("SuperSoft v0.0 proto");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setBounds(10, 100, 1000, 400);
		marco.setVisible(true);
		
		marco.setContentPane(new PantallaBienvenida(marco));
		marco.validate();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		marco.setContentPane(new Inicio(marco));
		marco.validate();
		
	}

}
