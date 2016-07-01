import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		JButton restartButton = new JButton("Restart");
		Board board = new Board();
		Keyboard keyboard = new Keyboard(board);
		Panel pan = new Panel(board);
		Mouse mouse = new Mouse(board, pan);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setPreferredSize(
				new Dimension(Panel.BLOCK_SIZE * 16, Panel.BLOCK_SIZE * 20));
		window.setResizable(false);
		window.setTitle("Tetris");

		window.add(pan);

		// window.add(restartButton, BorderLayout.SOUTH);

		window.pack();
		window.setVisible(true);

		window.addKeyListener(keyboard);
		window.addMouseListener(mouse);
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
