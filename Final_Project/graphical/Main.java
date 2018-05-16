package graphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;


/**@author Gordon Reis & Carl Tavernise
 * @version 1.1.0c
 * Last Updated: May 15th, 2018 
 * 
 * This is the Main Method to be run in order to run the game.
 */
@SuppressWarnings("serial")
public class Main extends JComponent {

	// begins with "file:/" so in order to allow IO to read file location, must .substring(6)
	public final static String SOURCEFOLDER = Main.class.getClassLoader().getResource("resources/").toString().substring(6); 
	// Main Cell Array
	public static Cell[][] cellArray = new Cell[22][12];
	// Player cell Color is always green, contains x/y of player's currentlocation
	public static Cell player;
	// states that a single instance of the game is running
	public static boolean is_running = true;
	// color for border tiles/blocks
	public static final Color COLOR_BORDER = new Color(25,25,112);
	// boolean to end the game whether win or not
	public static boolean endGame = false;
	// Current scene, change initialization here for beginning scene
	public static int currentScene = 1;
	// Changes based on state of cyan tiles
	public static int inverseControls = 1;
	// runs once to show intro combined with a Thread.sleep for a 5000ms pause
	static boolean showIntro = true;
	// defines when the game itself is over, not several instances
	public static boolean outer_loop = true;
	
	// TODO *FINISHED* Make while loop to keep game going
	// TODO *FINISHED* Make intro screen
	// TODO *FINISHED* Make Cyan Tiles work
	// TODO *FINISHED* Make win screen
	
	// To keep the frame repainted
	public Main(int i) {
		repaint();
	}
	
	// Used when a new scene is created
	public Main() {
		player = new Cell(Color.GREEN, 1, 1);
		cellArray[player.getX()][player.getY()].setColor(Color.GREEN);	
	}
	
	/* Initially made to test ImageIO class
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
	*/
	
	// draws a 1580x845 "titlescreen.jpg" image
	private void drawIntroScreen(Graphics g) {
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
	
	// draws all the squares currently defined in cellArray[][]
	private void drawSquares(Graphics g) {
		g.setColor(Color.BLACK);
		
		g.fillRect(0, 0, 1580, 845);
		g.setColor(Color.WHITE);
		for(int x = 0; x < 1580/70; x++) {
			for (int y = 0; y < 845/70; y++) {
				
				if (cellArray[x][y].getColor() != Color.WHITE) {
					g.setColor(cellArray[x][y].getColor());
				}
				g.fillRect(x*70 + 20, y*70 + 6, 64,64);
				g.setColor(Color.WHITE);
			}
		}
	}
	/*
	public void winGame(Graphics g) {
		outer_loop = false;
		is_running = false;
		endGame = true;
		Image bg;
		String bgResource = SOURCEFOLDER + "YouWin.jpg";
		try {
			bg = ImageIO.read(new File(bgResource));
			g.drawImage(bg, 0, 0, 1580, 845, null);
			System.out.println("Printed " + bg.toString() + " From " + bgResource);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	// outlines procedures when game is over whether win or loss
	public void endGame(Graphics g) {
		is_running = false;
		Image bg;
		String bgResource;
		if (Main.currentScene == 6) {
			bgResource = SOURCEFOLDER + "YouWin.jpg";
		} else {
			bgResource = SOURCEFOLDER + "YouDied.jpg";
		}
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
	
	// Is constantly running in a while loop due to repaint(); This keeps the player's tile green
	// and the squares updated, also checks for endGame(g);
	protected void paintComponent(Graphics g) {
		// shows intro at start of game
		if (showIntro) {
			drawIntroScreen(g);
			showIntro = false;
		
			// if intro already shown, then do the following
		} else {
			if (endGame) endGame(g);
			// prevents beginning square from staying green
			if (!cellArray[player.getX()][player.getY()].posEquals(new Cell(Color.WHITE,1,1))) {
				cellArray[1][1].setColor(Color.WHITE);
			}
			cellArray[player.getX()][player.getY()].setColor(Color.GREEN);
			if (!endGame) drawSquares(g);
		}
	}
	
	// Main method
	@SuppressWarnings("deprecation") // for thread.stop
	public static void main(String[] args) {	
	
		while (outer_loop) {
			
			endGame = false;
			is_running = true;			
			SceneDesigner sd = new SceneDesigner();
			try {
				if (currentScene <= 5) { //Done to prevent error after game closes
					sd.readScene(currentScene);
				}
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
			
			try {
				if(currentScene == 6) {
					System.exit(0);
				}
				Thread.sleep(5000);
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
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
