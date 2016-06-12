import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		
		Board b = new Board();
		Panel pan = new Panel(b);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setPreferredSize(new Dimension(300, 600));
		window.pack();
		window.setResizable(false);
		window.add(pan);
		window.setVisible(true);

		while (true) {
			pan.draw();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
