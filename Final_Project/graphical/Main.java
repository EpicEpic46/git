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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JComponent {

	// begins with "file:/" so in order to allow IO to read file location, must .substring(6)
	public final static String SOURCEFOLDER = Main.class.getClassLoader().getResource("resources/").toString().substring(6); 
	public static Cell[][] cellArray = new Cell[22][12];
	public static Cell player;
	public static boolean is_running = true;
	public static final Color COLOR_BORDER = new Color(25,25,112);
	public static boolean endGame = false;
	public static int currentScene = 1;
	public static int inverseControls = 1;
	static boolean threadsRunning = false;
	static boolean showIntro = true;
	
	// TODO *FINISHED* Make while loop to keep game going
	// TODO Make intro screen
	// TODO *FINISHED* Make Cyan Tiles work
	
	public Main(int i) {
		repaint();
	}
	
	public Main() {
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
	
	private static void drawIntroScreen(Graphics g) {
		Image intro;
		String introResource = SOURCEFOLDER + "TitleScreen.jpg";
		try {
			intro = ImageIO.read(new File(introResource));
			g.drawImage(intro, 0, 0, 1580, 845, null);
			System.out.println(introResource);
			
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
		// at 1600*900, 1580*845?? w*h window restrictions are constant

			g.drawImage(bg, 0, 0, 1580, 845, null);
			System.out.println("Printed " + bg.toString() + " From " + bgResource);
			

			
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	
	protected void paintComponent(Graphics g) {
		
		if (showIntro) {
			drawIntroScreen(g);
			showIntro = false;
		}
		if (endGame) endGame(g);
		cellArray[player.x][player.y].setColor(Color.GREEN);
		if (!endGame) drawSquares(g);
		
	}
	
	public static void main(String[] args) {
		
		while (true) {
			
			endGame = false;
			is_running = true;
			System.out.println(endGame);
			System.out.println(threadsRunning);
			
			SceneDesigner sd = new SceneDesigner();
			try {
				sd.readScene(currentScene);
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
			Thread st = new Thread(new SwitchThread());
			st.start();
			Thread wt = new Thread(new WhiteCellThread());
			wt.start();
			
			
			
			while(is_running) {
				frame.repaint();
			}
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ft.stop();
			at.stop();
			st.stop();
			wt.stop();
			frame.dispose();	
			showIntro = true;
		}	
	}
}
