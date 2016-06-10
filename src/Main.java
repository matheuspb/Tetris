import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    window.setSize(50, 50);
	    window.setVisible(true);
	    
	    Board b = new Board();
	    b.init();

	}

}
