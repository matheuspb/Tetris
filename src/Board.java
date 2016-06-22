import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

public class Board implements ActionListener {

	/*
	 * This class holds the logic of the program, it consists on a 20x10 2D
	 * array of Blocks, and a Timer to pace the game.
	 */

	private Block[][] matrix;
	private Timer timer;

	char[] pieceSequence;
	int index;

	int currentJ, currentI;

	char currentPiece;

	public Board() {
		matrix = new Block[21][10];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = new Block(false, false);
			}
		}
		timer = new Timer(500, this);
		pieceSequence = new char[7];
		pieceSequence[0] = 'I';
		pieceSequence[1] = 'J';
		pieceSequence[2] = 'L';
		pieceSequence[3] = 'S';
		pieceSequence[4] = 'Z';
		pieceSequence[5] = 'T';
		pieceSequence[6] = 'O';
		index = 0;
		currentJ = 0;
		currentI = 0;
		currentPiece = '.';
	}

	public void init() {
		timer.start();
		shuffleSequence();
		generatePiece();
	}

	private void generatePiece() {
		/*
		 * Gets wich piece needs to be generated from 'pieceSequence', and
		 * generates it. When it reaches the end of 'pieceSequence', it calls
		 * shuffleSequence() to regenerate the pattern.
		 */
		if (pieceSequence[index] == 'I') {
			matrix[1][3].init('I');
			matrix[1][4].init('I');
			matrix[1][5].init('I');
			matrix[1][6].init('I');
			currentPiece = 'I';
		} else if (pieceSequence[index] == 'J') {
			matrix[0][3].init('J');
			matrix[1][3].init('J');
			matrix[1][4].init('J');
			matrix[1][5].init('J');
			currentPiece = 'J';
		} else if (pieceSequence[index] == 'L') {
			matrix[0][5].init('L');
			matrix[1][3].init('L');
			matrix[1][4].init('L');
			matrix[1][5].init('L');
			currentPiece = 'L';
		} else if (pieceSequence[index] == 'S') {
			matrix[0][5].init('S');
			matrix[0][4].init('S');
			matrix[1][4].init('S');
			matrix[1][3].init('S');
			currentPiece = 'S';
		} else if (pieceSequence[index] == 'Z') {
			matrix[0][3].init('Z');
			matrix[0][4].init('Z');
			matrix[1][4].init('Z');
			matrix[1][5].init('Z');
			currentPiece = 'Z';
		} else if (pieceSequence[index] == 'T') {
			matrix[0][4].init('T');
			matrix[1][3].init('T');
			matrix[1][4].init('T');
			matrix[1][5].init('T');
			currentPiece = 'Z';
		} else if (pieceSequence[index] == 'O') {
			matrix[0][4].init('O');
			matrix[0][5].init('O');
			matrix[1][4].init('O');
			matrix[1][5].init('O');
			currentPiece = 'O';
		}
		currentJ = 3;
		currentI = 0;
		if (index == 6) {
			shuffleSequence();
			index = 0;
		}
		index++;
	}

	public void shuffleSequence() {
		// Uses Random() to shuffle the array pieceSequence.
		Random rnd = new Random();
		for (int i = 0; i < pieceSequence.length - 1; i++) {
			// Generates a random index, and then switches with the element at i
			int index = rnd.nextInt(pieceSequence.length);
			char tmp = pieceSequence[index];
			pieceSequence[index] = pieceSequence[i];
			pieceSequence[i] = tmp;
		}
	}

	public void moveToLeft() {
		if (canMoveLeft()) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					moveOneBlock(i, j, false);
				}
			}
			currentJ--;
		}
	}

	public void moveToRight() {
		if (canMoveRight()) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = matrix[0].length - 1; j >= 0; j--) {
					moveOneBlock(i, j, true);
				}
			}
			currentJ++;
		}
	}

	public void moveToBottom() {
		if (canMoveDown()) {
			for (int i = matrix.length - 1; i >= 0; i--) {
				for (int j = 0; j < matrix[0].length; j++) {
					if (matrix[i][j].moving())
						moveOneBlockDown(i, j);
				}
			}
			currentI++;
		}
	}

	private void moveOneBlockDown(int i, int j) {
		// Moves down the block at i j position.
		matrix[i + 1][j] = matrix[i][j];
		matrix[i][j] = new Block(false, false);
	}

	private boolean canMoveRight() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j].moving()) {
					if (j == 9
							|| (!matrix[i][j + 1].moving() && matrix[i][j + 1]
									.show())) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean canMoveLeft() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j].moving()) {
					if (j == 0
							|| (!matrix[i][j - 1].moving() && matrix[i][j - 1]
									.show())) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean canMoveDown() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j].moving()) {
					if (i == 20
							|| (!matrix[i + 1][j].moving() && matrix[i + 1][j]
									.show()))
						return false;
				}
			}
		}
		return true;
	}

	private void moveOneBlock(int i, int j, boolean right) {
		// Move just one block to right(right == true) or left(right == false).
		if (right && matrix[i][j].moving()) {
			matrix[i][j + 1] = matrix[i][j];
			matrix[i][j] = new Block(false, false);
		} else if (matrix[i][j].moving()) {
			matrix[i][j - 1] = matrix[i][j];
			matrix[i][j] = new Block(false, false);
		}
	}

	private void rotatePiece(int i, int j) {
		Block tmp = new Block();

		tmp = matrix[0 + i][0 + j];
		matrix[0 + i][0 + j] = matrix[2 + i][0 + j];
		matrix[2 + i][0 + j] = matrix[2 + i][2 + j];
		matrix[2 + i][2 + j] = matrix[0 + i][2 + j];
		matrix[0 + i][2 + j] = tmp;

		tmp = matrix[0 + i][1 + j];
		matrix[0 + i][1 + j] = matrix[1 + i][0 + j];
		matrix[1 + i][0 + j] = matrix[2 + i][1 + j];
		matrix[2 + i][1 + j] = matrix[1 + i][2 + j];
		matrix[1 + i][2 + j] = tmp;

		if (currentPiece == 'I') {
			tmp = matrix[1 + i][3 + j];
			matrix[1 + i][3 + j] = matrix[3 + i][1 + j];
			matrix[3 + i][1 + j] = tmp;
		}
	}

	public void rotate() {
		if (currentPiece == 'O')
			return;

		if (currentJ == -1) {
			moveToRight();
		} else if (currentJ == 8) {
			moveToLeft();
		}

		if (canRotate()) {
			rotatePiece(currentI, currentJ);
		}
	}

	private boolean canRotate() {
		int offset = 3;
		if (currentPiece == 'I') {
			offset = 4;
		}

		if (currentJ + offset > 10 || currentJ < 0) {
			return false;
		}

		for (int i = currentI; i < currentI + offset; i++) {
			for (int j = currentJ; j < currentJ + offset; j++) {
				if (matrix[i][j].show() && !matrix[i][j].moving())
					return false;
			}
		}
		return true;

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
			for (int j = 0; j < matrix[0].length; j++) {
				moveOneBlockDown(i, j);
			}
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

	public char[][] matrix() {
		/*
		 * Returns a 2D array of chars. It holds the type of block, depending of
		 * the shape it makes.
		 */
		char[][] out = new char[20][10];
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				out[i - 1][j] = matrix[i][j].type();
			}
		}
		return out;
	}

	private boolean gameOver() {
		// Check if the pieces can still move or they hit the top of the window.
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[1][i].show() && !matrix[1][i].moving()) {
				return true;
			}
		}
		return false;
	}

	private void update() {
		if (canMoveDown()) {
			moveToBottom();
		} else {
			stopAll();
			clearFullLines();
			if (gameOver()) {
				return;
			}
			generatePiece();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
	}

}
