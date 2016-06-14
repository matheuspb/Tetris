import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Board implements ActionListener {

	private Block[][] matrix;
	private Timer timer;

	public Board() {
		matrix = new Block[20][10];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = new Block(false, false);
			}
		}
		timer = new Timer(1000, this);
	}

	public void init() {
		matrix[0][8].init();
		matrix[0][9].init();
		matrix[1][9].init();
		matrix[2][9].init();

		for (int i = 18; i < 20; i++) {
			for (int j = 0; j < 9; j++) {
				matrix[i][j] = new Block(true, false);
			}
		}

		timer.start();
	}

	private void debug() {
		String text = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j].show())
					text += "1";
				else
					text += "0";
			}
			text += "\n";
		}
		System.out.println(text);
	}

	private void moveDown(int i, int j, boolean force) {
		/*
		 * Moves down the block at i j position. If force is false, it will only
		 * move the blocks with moving() == true.
		 */
		if (matrix[i][j].moving() || force) {
			matrix[i + 1][j] = matrix[i][j];
			matrix[i][j] = new Block(false, false);
		}
	}

	private void moveLineDown(int n, boolean force) {
		// Moves all blocks at line n down
		for (int i = 0; i < matrix[0].length; i++) {
			moveDown(n, i, force);
		}
	}

	private boolean detectCollision(int i, int j) {
		/*
		 * Returns true if block is at last line or there is another block under
		 * it
		 */
		if (i == matrix.length - 1 || matrix[i + 1][j].show()) {
			return true;
		} else {
			return false;
		}
	}

	private void stopAll() {
		// Stops all blocks
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j].stop();
			}
		}
	}

	private boolean detectFullLine(int i) {
		// Returns true if line i is completed, else returns false
		for (int j = 0; j < matrix[0].length; j++) {
			if (!matrix[i][j].show())
				return false;
		}
		return true;
	}

	private void clearLine(int n) {
		// Clears line n, then moves all other lines above down
		for (int i = n - 1; i >= 0; i--) {
			moveLineDown(i, true);
		}
	}

	private void clearFullLines() {
		// Detects and clears full lines
		for (int i = 0; i < matrix.length; i++) {
			if (detectFullLine(i)) {
				clearLine(i);
			}
		}
	}

	public boolean[][] matrix() {
		/*
		 * Returns a 2D array of booleans, where they're true when you need to
		 * show a block.
		 */
		boolean[][] out = new boolean[20][10];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				out[i][j] = matrix[i][j].show();
			}
		}
		return out;
	}

	private void update() {
		boolean collided = false;
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (matrix[i][j].moving()) {
					collided = detectCollision(i, j);
				}
			}
			if (collided) {
				stopAll();
			} else {
				moveLineDown(i, false);
			}
		}
		if (collided) {
			clearFullLines();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		// debug();
	}

}
