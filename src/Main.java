import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {

		JFrame window = new JFrame();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setPreferredSize(
				new Dimension(Panel.BLOCK_SIZE * 16, Panel.BLOCK_SIZE * 20));
		window.setResizable(false);
		window.setTitle("Tetris");

		Board board = new Board();
		window.addKeyListener(new Keyboard(board));
		window.addMouseListener(new Mouse(board));

		window.setVisible(true);
		window.pack();

		Panel pan = new Panel(board, window.getHeight());
		window.add(pan);

		board.init();
		window.pack();

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
