import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private Board board;

	public Keyboard(Board board) {
		this.board = board;
	}

	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			board.moveToLeft();
		}
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			board.moveToRight();
		}
	}

	public void keyReleased(KeyEvent event) {

	}

	public void keyTyped(KeyEvent event) {

	}

}
