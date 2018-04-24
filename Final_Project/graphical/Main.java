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

public class Main extends JPanel {

	// begins with "file:/" so in order to allow IO to read file location, must .substring(6)
	public final String SOURCEFOLDER = Main.class.getClassLoader().getResource("resources/").toString().substring(6); 
	public static Cell[][] cellArray = new Cell[45][24];
	public static Cell player;
	public static boolean is_running = true;
	
	public Main(int i) {
		repaint();
	}
	
	public Main() {
		for(int i = 0; i < 45; i++) {
			for(int k = 0; k < 24; k++) {
				cellArray[i][k] = new Cell();
			}
		}
		player = new Cell(Color.GREEN, 5, 5);
		
		cellArray[player.x][player.y].setColor(Color.GREEN);
	}
	
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
				
				if (cellArray[x][y].color != Color.WHITE) {
					g.setColor(cellArray[x][y].color);
				}
				g.fillRect(x*35 + 3, y*35 + 3, 32,32);
				g.setColor(Color.WHITE);
			}
		}
	}
	
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
		drawSquares(g);
		
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1600,900);
		frame.setTitle("Test Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new Main());
		frame.addKeyListener(new KeyboardListener());
		
		while(is_running) {
			frame.repaint();
		}
		frame.dispose();
		System.exit(0);
		
		
	}


}
