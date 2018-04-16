package graphical;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

	// methods for different shapes/images
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// insert drawings
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1280,720);
		frame.setTitle("Test Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new Main());

	}

}
