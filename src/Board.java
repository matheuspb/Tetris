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
		timer = new Timer(500, this);
	}
	
	public void init() {
		matrix[0][3].init();
		matrix[0][4].init();
		matrix[0][5].init();
		matrix[0][6].init();
		
		matrix[19][0] = new Block(true, false);
		matrix[19][1] = new Block(true, false);
		matrix[19][2] = new Block(true, false);
		matrix[19][3] = new Block(true, false);
		
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
	
	private void moveDown(int i, int j) {
		// Moves down the block at i j position
		matrix[i+1][j] = matrix[i][j];
		matrix[i][j] = new Block(false, false);
	}
	
	private boolean detectCollision(int i, int j) {
		if (i == matrix.length - 1 || matrix[i+1][j].show()) {
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
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[n][i] = new Block(false, false);
		}
		for (int i = n-1; i >= 0; i--) {
			for (int j = 0; j < matrix[0].length; j++) {
				moveDown(i, j);
			}
		}
	}
	
	private void update() {
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (matrix[i][j].moving()) {
					if (detectCollision(i, j)) {
						stopAll();
					} else {
						moveDown(i, j);
					}
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		debug();
	}

}
