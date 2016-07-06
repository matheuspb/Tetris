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

		if (mouseX > Panel.IMG_X && mouseX < Panel.IMG_X + 100) {
			if (mouseY > Panel.IMG_Y && mouseY < Panel.IMG_Y + 35) {
				board.restartGame();
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
