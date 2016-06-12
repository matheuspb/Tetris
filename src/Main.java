import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.setSize(300, 640);
		
		Board b = new Board();
		Panel pan = new Panel(b);

		window.add(pan);
		window.setVisible(true);

		while (true) {
			pan.draw();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
