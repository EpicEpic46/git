package graphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JPanel {

	// begins with "file:/" so in order to allow IO to read file location, must .substring(6)
	public final String SOURCEFOLDER = Main.class.getClassLoader().getResource("resources/").toString().substring(6); 
	public static Cell[][] cellArray = new Cell[22][12];
	public static Cell player;
	public static boolean is_running = true;
	public static final Color COLOR_BORDER = new Color(25,25,112);
	public static boolean endGame;
	public static int currentScene = 1;
	
	public Main(int i) {
		repaint();
	}
	
	public Main() {
		/*
		for(int i = 0; i < 22; i++) {
			for(int k = 0; k < 12; k++) {
				cellArray[i][k] = new Cell();
				cellArray[i][k].setPassable(true);
			}
		}
		for (int i = 0; i < 22; i++) {
			cellArray[i][0].setPassable(false);
			cellArray[i][11].setPassable(false);	
		}
		for(int i = 0; i < 12; i++) {
			cellArray[0][i].setPassable(false);
			cellArray[21][i].setPassable(false);
		}
		*/
		player = new Cell(Color.GREEN, 1, 1);
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
		for(int x = 0; x < 1580/70; x++) {
			for (int y = 0; y < 845/70; y++) {
				
				if (cellArray[x][y].color != Color.WHITE) {
					g.setColor(cellArray[x][y].color);
				}
				g.fillRect(x*70 + 20, y*70 + 6, 64,64);
				g.setColor(Color.WHITE);
			}
		}
	}
	
	public void endGame(Graphics g) {
		is_running = false;
		Image bg;
		String bgResource = SOURCEFOLDER + "YouDied.jpg";
		try {
			bg = ImageIO.read(new File(bgResource));
		// at 1280*720, 1260*665 is max w*h
		// at 1600*900, 1580*845?? is w*h window restrictions constant??

			g.drawImage(bg, 0, 0, 1580, 845, null);
			System.out.println("Printed " + bg.toString() + " From " + bgResource);
			
			Thread deathThread = new Thread(new DeathTimer());
			deathThread.start();
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	
	protected void paintComponent(Graphics g) {
		if (endGame) endGame(g);

		cellArray[player.x][player.y].setColor(Color.GREEN);
		//Graphics2D g2 = (Graphics2D) g;
		//super.paintComponent(g);
		if (!endGame) drawSquares(g);
		
	}
	
	public static void main(String[] args) {
		SceneDesigner sd = new SceneDesigner();
		try {
			sd.readScene(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame();
		frame.setSize(1600,900);
		frame.setTitle("Test Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new Main());
		frame.addKeyListener(new KeyboardListener());
		
		Thread ft = new Thread(new FlipTimer());
		ft.start();
		Thread at = new Thread(new AlternateTimer());
		at.start();
		
		while(is_running) {
			System.out.println(Main.currentScene);
		//	System.out.println(cellArray[20][10]);
			frame.repaint();
		}
		
		frame.dispose();
		
		
		
	}


}
