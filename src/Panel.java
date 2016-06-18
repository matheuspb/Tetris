import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image block;
	private Board board;

	private static final int BLOCK_SIZE = 30;

	public Panel(Board board) {
		super();
		try {
			File file = new File("block.png");
			block = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		this.board = board;

		this.setPreferredSize(new Dimension(BLOCK_SIZE * 10, BLOCK_SIZE * 20));
	}

	public void draw() {
		this.repaint();
	}

	private void drawGrid(Graphics g) {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				g.setColor(Color.LIGHT_GRAY);
				g.drawRect(BLOCK_SIZE * j, BLOCK_SIZE * i, BLOCK_SIZE,
						BLOCK_SIZE);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		// Draws block images on the correct positions based on board.matrix()
		super.paintComponent(g);
		drawGrid(g);
		char[][] matrix = board.matrix(); // See matrix() method in Board
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] != '.') {
					if (matrix[i][j] == 'I') {
						g.setColor(Color.BLUE);
						g.fillRect(BLOCK_SIZE * j, BLOCK_SIZE * i, BLOCK_SIZE,
								BLOCK_SIZE);
					} else if (matrix[i][j] == 'J') {
						g.setColor(Color.GREEN);
						g.fillRect(BLOCK_SIZE * j, BLOCK_SIZE * i, BLOCK_SIZE,
								BLOCK_SIZE);
					} else if (matrix[i][j] == 'L') {
						g.setColor(Color.CYAN);
						g.fillRect(BLOCK_SIZE * j, BLOCK_SIZE * i, BLOCK_SIZE,
								BLOCK_SIZE);
					} else if (matrix[i][j] == 'S') {
						g.setColor(Color.RED);
						g.fillRect(BLOCK_SIZE * j, BLOCK_SIZE * i, BLOCK_SIZE,
								BLOCK_SIZE);
					} else if (matrix[i][j] == 'Z') {
						g.setColor(Color.MAGENTA);
						g.fillRect(BLOCK_SIZE * j, BLOCK_SIZE * i, BLOCK_SIZE,
								BLOCK_SIZE);
					} else if (matrix[i][j] == 'T') {
						g.setColor(Color.PINK);
						g.fillRect(BLOCK_SIZE * j, BLOCK_SIZE * i, BLOCK_SIZE,
								BLOCK_SIZE);
					} else if (matrix[i][j] == 'O') {
						g.setColor(Color.YELLOW);
						g.fillRect(BLOCK_SIZE * j, BLOCK_SIZE * i, BLOCK_SIZE,
								BLOCK_SIZE);
					}
					g.setColor(Color.BLACK);
					g.drawRect(BLOCK_SIZE * j, BLOCK_SIZE * i, BLOCK_SIZE,
							BLOCK_SIZE);
				}
			}
		}
	}

}
