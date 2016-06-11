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
		matrix[0][4].init();
		matrix[1][4].init();
		matrix[2][4].init();
		matrix[1][3].init();
		
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
		/* Moves the block at i, j position, and if it hits the last line, 
		 * calls the stopAll() method.
		 */
		if (i < matrix.length - 1 && !matrix[i+1][j].show()) {
			// Block is not at the last line and there is not any block
			// under it
			matrix[i+1][j] = matrix[i][j];
			matrix[i][j] = new Block(false, false);
		} else {
			// moving block hit last line or hit another block
			stopAll();
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
	
	private void update() {
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (matrix[i][j].moving())
					moveDown(i, j);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		debug();
	}

}
