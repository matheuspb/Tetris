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
		this.setPreferredSize(new Dimension(BLOCK_SIZE * 16, BLOCK_SIZE * 20));
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

    private void drawNextSquare(Graphics g) {
        for (int i = 3; i < 7; i++) {
            for(int j = 11; j < 15; j++) {
                g.drawRect(BLOCK_SIZE * j, BLOCK_SIZE * i,
                           BLOCK_SIZE, BLOCK_SIZE);
            }
        }
    }

    private void drawNextBlock(Graphics g, char piece) {
        if (piece == 'I') {
            drawBlock(g, 3, 12, cyan);
            drawBlock(g, 4, 12, cyan);
            drawBlock(g, 5, 12, cyan);
            drawBlock(g, 6, 12, cyan);
        } else if( piece == 'J') {
            drawBlock(g, 4, 13, blue);
            drawBlock(g, 5, 13, blue);
            drawBlock(g, 6, 13, blue);
            drawBlock(g, 6, 12, blue);
        } else if( piece == 'L') {
            drawBlock(g, 4, 12, orange);
            drawBlock(g, 5, 12, orange);
            drawBlock(g, 6, 12, orange);
            drawBlock(g, 6, 13, orange);
        } else if( piece == 'S') {
            drawBlock(g, 5, 12, green);
            drawBlock(g, 5, 13, green);
            drawBlock(g, 4, 13, green);
            drawBlock(g, 4, 14, green);
        } else if( piece == 'Z') {
            drawBlock(g, 4, 12, red);
            drawBlock(g, 4, 13, red);
            drawBlock(g, 5, 13, red);
            drawBlock(g, 5, 14, red);
        } else if( piece == 'T') {
            drawBlock(g, 4, 12, magenta);
            drawBlock(g, 4, 13, magenta);
            drawBlock(g, 5, 13, magenta);
            drawBlock(g, 4, 14, magenta);
        } else if( piece == 'O') {
            drawBlock(g, 4, 12, yellow);
            drawBlock(g, 5, 12, yellow);
            drawBlock(g, 4, 13, yellow);
            drawBlock(g, 5, 13, yellow);
        }
    }


	@Override
	public void paintComponent(Graphics g) {
		// Draws block images on the correct positions based on board.matrix()
		super.paintComponent(g);
		drawGrid(g);
        drawNextSquare(g);
        drawNextBlock(g, board.generateNextPiece());
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
