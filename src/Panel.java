import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Panel extends JPanel {
	
	private Image block;
	private Board board;
	
	public Panel(Board board) {
		super();
		try {
			File file = new File("block.png");
			block = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		this.board = board;
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
					g.drawImage(block, 30*j, 30*i, 30, 30, this);
				}
			}
		}
	}

}
