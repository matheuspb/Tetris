import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

    private Board board;

    public Keyboard(Board board) {
        this.board = board;
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_LEFT){
            board.moveToLeft();
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT){
            board.moveToRight();
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN){

        }
    }

    public void keyReleased(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP){

        }
    }

    public void keyTyped(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_D){

        }
    }

}