package graphical;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * This class registers keypresses and maps them to movement
 * also turns movement into changes in the Main.cellArray[][]
 */
public class KeyRegistry {
	
	// Integer value defining keypress picked up by KeyboardListener
	int keyCode;
	
	// Constructor defines movement pressed and assigns it accordingly
	public KeyRegistry(KeyEvent e) {
		System.out.println(e.getKeyCode());
		keyCode = e.getKeyCode();
		if (keyCode == 37) {
			move(-1* Main.inverseControls);
		} else if (keyCode == 38) {
			move(-2* Main.inverseControls);
		} else if (keyCode == 39) {
			move(1* Main.inverseControls);
		} else if (keyCode == 40) {
			move(2 * Main.inverseControls);
		} else if (keyCode == 27) {
			System.exit(0);
		} else if (keyCode == 112) { //f1
			
		} else {
			System.out.println("Invalid Key");
		}
		
	}
	// DIRECTIONS:
	// -1 = left, -2 = up, 1 = right, 2 = down
	// originally: 0,1,2,3; but changed to allow cyan tiles to be on a 1 or -1 integer
	
	private void move(int direction) {

		int x = Main.player.getX();
		int y = Main.player.getY();
		
		switch(direction) {
		//LEFT MOVEMENT
		case -1:
			if (Main.cellArray[x-1][y].isPassable() 
			&& !Main.cellArray[x-1][y].isKillBlock() 
			&& !Main.cellArray[x-1][y].is_ladder() 
			&& !Main.cellArray[x-1][y].isSwitchBlock()) 
			{
				System.out.println("Valid Movement");
				Main.cellArray[x][y].setColor(Color.WHITE);
				Main.player.setX(x-1);
				Main.cellArray[x][y].setColor(Color.GREEN);
				// if (is_ladder) {
				new Main(0);
			} else if (Main.cellArray[x-1][y].isSwitchBlock()) {
				Main.inverseControls *= -1;
				Main.player.setX(x-1);
			
			} else if(Main.cellArray[x-1][y].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: DEAD Movement");
			} else if (Main.cellArray[x-1][y].is_ladder()) {
				System.out.println("REACHED LADDER");
				try {
					Main.currentScene++;
					if (Main.currentScene > 5) {
						Main.endGame = true;
					} else {
						SceneDesigner sd = new SceneDesigner();
						sd.readScene(Main.currentScene);
						Main.player.setX(1);
						Main.player.setY(1);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("ERROR: InvalidMovement");
			}
			break;
		// UP MOVEMENT (is y-1 because 2d arrays inverse what we think is "up")
		case -2:
			if (Main.cellArray[x][y-1].isPassable() 
			&& !Main.cellArray[x][y-1].isKillBlock() 
			&& !Main.cellArray[x][y-1].is_ladder() 
			&& !Main.cellArray[x][y-1].isSwitchBlock()) 
			{
				System.out.println("Valid Movement");
				Main.cellArray[x][y].setColor(Color.WHITE);
				Main.player.setY(y-1);
				Main.cellArray[x][y].setColor(Color.GREEN);
				new Main(0);
			} else if (Main.cellArray[x][y-1].isSwitchBlock()) {
				Main.inverseControls *= -1;
				Main.player.setY(y-1);
			
			} else if(Main.cellArray[x][y-1].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: DEAD Movement");
			} else if (Main.cellArray[x][y-1].is_ladder()) {
				System.out.println("REACHED LADDER");
				try {
					Main.currentScene++;
					if (Main.currentScene > 5) {
						Main.endGame = true;
					} else {
						SceneDesigner sd = new SceneDesigner();
						sd.readScene(Main.currentScene);
						Main.player.setX(1);
						Main.player.setY(1);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("ERROR: InvalidMovement");
			}
			break;
		//RIGHT MOVEMENT
		case 1:
			if (Main.cellArray[x+1][y].isPassable() 
			&& !Main.cellArray[x+1][y].isKillBlock() 
			&& !Main.cellArray[x+1][y].is_ladder() 
			&& !Main.cellArray[x+1][y].isSwitchBlock()) 
			{
				System.out.println("Valid Movement");
				Main.cellArray[x][y].setColor(Color.WHITE);
				Main.player.setX(x+1);
				Main.cellArray[x][y].setColor(Color.GREEN);
				new Main(0);
			} else if (Main.cellArray[x+1][y].isSwitchBlock()) {
				Main.inverseControls *= -1;
				Main.player.setX(x+1);
			
			} else if(Main.cellArray[x+1][y].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: DEAD Movement");
			} else if (Main.cellArray[x+1][y].is_ladder()) {
				System.out.println("REACHED LADDER");
				try {
					Main.currentScene++;
					if (Main.currentScene > 5) {
						Main.endGame = true;
					} else {
						SceneDesigner sd = new SceneDesigner();
						sd.readScene(Main.currentScene);
						Main.player.setX(1);
						Main.player.setY(1);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("ERROR: InvalidMovement");
			}
			break;
		// DOWN MOVEMENT
		case 2:
			if (Main.cellArray[x][y+1].isPassable() 
			&& !Main.cellArray[x][y+1].isKillBlock() 
			&& !Main.cellArray[x][y+1].is_ladder() 
			&& !Main.cellArray[x][y+1].isSwitchBlock()) 
			{
				System.out.println("Valid Movement");
				Main.cellArray[x][y].setColor(Color.WHITE);
				Main.player.setY(y+1);
				Main.cellArray[x][y].setColor(Color.GREEN);
				new Main(0);
			} else if (Main.cellArray[x][y+1].isSwitchBlock()) {
				Main.inverseControls *= -1;
				Main.player.setY(y+1);
			
			} else if(Main.cellArray[x][y+1].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: DEAD Movement");
			} else if (Main.cellArray[x][y+1].is_ladder()) {
				System.out.println("REACHED LADDER");
				try {
					Main.currentScene++;
					if (Main.currentScene > 5) {
						Main.endGame = true;
					} else {
						SceneDesigner sd = new SceneDesigner();
						sd.readScene(Main.currentScene);
						Main.player.setX(1);
						Main.player.setY(1);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("ERROR: InvalidMovement");
			}
			break;
		}
		
	}
	
}

