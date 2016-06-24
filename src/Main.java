import java.awt.Dimension;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		Board board = new Board();
		Keyboard keyboard = new Keyboard(board);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setPreferredSize(
				new Dimension(Panel.BLOCK_SIZE * 16, Panel.BLOCK_SIZE * 20));
		window.setResizable(false);
		window.setTitle("Tetris");

		Panel pan = new Panel(board);
		window.add(pan);

		window.pack();
		window.setVisible(true);

		window.addKeyListener(keyboard);
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
