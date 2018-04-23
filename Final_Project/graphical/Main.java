package graphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JPanel implements KeyListener{

	// begins with "file:/" so in order to allow IO to read file location, must .substring(6)
	public final String SOURCEFOLDER = Main.class.getClassLoader().getResource("resources/").toString().substring(6); 
	
	private void drawBG(Graphics g) {
		Image bg;
		String bgResource = SOURCEFOLDER + "Image.jpg";
		try {
			bg = ImageIO.read(new File(bgResource));
		// at 1280*720, 1260*665 is max w*h
		// at 1600*900, 1580*845?? is w*h window restrictions constant??

			g.drawImage(bg, 0, 0, 1580, 845, null);
			System.out.println("Printed " + bg.toString() + " From " + bgResource);
			
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	
	private void drawSquares(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1580, 845);
		g.setColor(Color.WHITE);
		for(int x = 0; x < 1580/35; x++) {
			for (int y = 0; y < 845/35; y++) {
				g.fillRect(x*35 + 3, y*35 + 3, 32,32);
			}
		}
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
		drawSquares(g);
		initializeKeyboard();
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1600,900);
		frame.setTitle("Test Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new Main());
		
	}
	
	private void initializeKeyboard() {
		JTextField typingArea = new JTextField(1000);
		typingArea.setVisible(true);
		typingArea.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		System.out.println(e.toString());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		e.getKeyChar();
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
