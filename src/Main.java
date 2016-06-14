import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame window = new JFrame();

		Board board = new Board();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setPreferredSize(new Dimension(300, 600));
		window.setResizable(true);

		Panel pan = new Panel(board);
		window.add(pan);

		window.pack();
		window.setVisible(true);

		board.init();

		while (true) {
			pan.draw();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
