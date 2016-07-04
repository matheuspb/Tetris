import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private Board board;

	public Keyboard(Board board) {
		this.board = board;
	}

	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			board.moveLeft();
		}
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			board.moveRight();
		}
		if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			board.moveDown();
		}
		if (event.getKeyCode() == KeyEvent.VK_SPACE) {
			board.hardDrop();
		}
		if (event.getKeyCode() == KeyEvent.VK_UP) {
			board.rotate();
		}
	}

	public void keyReleased(KeyEvent event) {

	}

	public void keyTyped(KeyEvent event) {

	}

}
