import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

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

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		boolean[][] matrix = board.matrix();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j]) {
					g.drawImage(block, BLOCK_SIZE * j, BLOCK_SIZE * i,
							BLOCK_SIZE, BLOCK_SIZE, this);
				}
			}
		}
	}

}
