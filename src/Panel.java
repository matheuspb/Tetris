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
	private Board board;

	private Image blue, cyan, green, magenta, orange, red, yellow;

	public static final int BLOCK_SIZE = 24;

	public Panel(Board board) {
		super();
		try {
			blue = ImageIO.read(new File("resources/blue.png"));
			cyan = ImageIO.read(new File("resources/cyan.png"));
			green = ImageIO.read(new File("resources/green.png"));
			magenta = ImageIO.read(new File("resources/magenta.png"));
			orange = ImageIO.read(new File("resources/orange.png"));
			red = ImageIO.read(new File("resources/red.png"));
			yellow = ImageIO.read(new File("resources/yellow.png"));
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
		// Draws the grid behind the pieces
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				g.setColor(Color.LIGHT_GRAY);
				g.drawRect(BLOCK_SIZE * j, BLOCK_SIZE * i, BLOCK_SIZE,
						BLOCK_SIZE);
			}
		}
	}

	private void drawBlock(Graphics g, int i, int j, Image img) {
		// Draws a block on the correct position of the panel
		g.drawImage(img, BLOCK_SIZE * j, BLOCK_SIZE * i, BLOCK_SIZE,
				BLOCK_SIZE, this);
	}

	@Override
	public void paintComponent(Graphics g) {
		// Draws block images on the correct positions based on board.matrix()
		super.paintComponent(g);
		drawGrid(g);
		char[][] matrix = board.matrix(); // See matrix() method in Board
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 'I') {
					drawBlock(g, i, j, cyan);
				} else if (matrix[i][j] == 'J') {
					drawBlock(g, i, j, blue);
				} else if (matrix[i][j] == 'L') {
					drawBlock(g, i, j, orange);
				} else if (matrix[i][j] == 'S') {
					drawBlock(g, i, j, green);
				} else if (matrix[i][j] == 'Z') {
					drawBlock(g, i, j, red);
				} else if (matrix[i][j] == 'T') {
					drawBlock(g, i, j, magenta);
				} else if (matrix[i][j] == 'O') {
					drawBlock(g, i, j, yellow);
				}
			}
		}
	}

}
