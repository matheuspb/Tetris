import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
	private int mouseX, mouseY;
	private Board board;

	public Mouse(Board board) {
		this.board = board;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		this.mouseX = event.getX();
		this.mouseY = event.getY();

		if (mouseX > Panel.BLOCK_SIZE * 11 && mouseX < Panel.BLOCK_SIZE * 15) {
			if (mouseY > Panel.BLOCK_SIZE * 17
					&& mouseY < Panel.BLOCK_SIZE * 19 - 4) {
				board.restartGame();
				mouseX = 0;
				mouseY = 0;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {

	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {

	}
}
