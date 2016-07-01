import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{
    private int mouseX, mouseY;
    private Board board;
    private Panel panel;

    public Mouse(Board board, Panel panel) {
        this.board = board;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        this.mouseX = event.getX();
        this.mouseY = event.getY();

        if(mouseX > panel.BLOCK_SIZE*11 && mouseX < panel.BLOCK_SIZE*15){
            if(mouseY > panel.BLOCK_SIZE*17 && mouseY < panel.BLOCK_SIZE*19-4){
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
