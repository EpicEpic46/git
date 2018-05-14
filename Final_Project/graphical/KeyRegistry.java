package graphical;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class KeyRegistry {

	int keyCode;
	
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
	
	// -1 = left, -2 = up, 1 = right, 2 = down
	
	private void move(int direction) {
		/*
		try {
			// TODO add a way to prevent movement spam
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		int x = Main.player.getX();
		int y = Main.player.getY();
		
		switch(direction) {
		
		case -1:
			if (Main.cellArray[Main.player.x-1][Main.player.y].isPassable() 
			&& !Main.cellArray[Main.player.x-1][Main.player.y].isKillBlock() 
			&& !Main.cellArray[Main.player.x-1][Main.player.y].is_ladder() 
			&& !Main.cellArray[Main.player.x-1][Main.player.y].isSwitchBlock()) 
			{
				System.out.println("Valid Movement");
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
				Main.player.setX(x-1);
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
				// if (is_ladder) {
				new Main(0);
			} else if (Main.cellArray[Main.player.x-1][Main.player.y].isSwitchBlock()) {
				Main.inverseControls *= -1;
				Main.player.setX(x-1);
			
			} else if(Main.cellArray[Main.player.x-1][Main.player.y].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: DEAD Movement");
			} else if (Main.cellArray[Main.player.x-1][Main.player.y].is_ladder()) {
				System.out.println("REACHED LADDER");
				try {
					Main.currentScene++;
					SceneDesigner sd = new SceneDesigner();
					sd.readScene(Main.currentScene);
					Main.player.setX(1);
					Main.player.setY(1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("ERROR: InvalidMovement");
			}
			break;
			
		case -2:
			if (Main.cellArray[Main.player.x][Main.player.y-1].isPassable() 
			&& !Main.cellArray[Main.player.x][Main.player.y-1].isKillBlock() 
			&& !Main.cellArray[Main.player.x][Main.player.y-1].is_ladder() 
			&& !Main.cellArray[Main.player.x][Main.player.y-1].isSwitchBlock()) 
			{
				System.out.println("Valid Movement");
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
				Main.player.setY(y-1);
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
				new Main(0);
			} else if (Main.cellArray[Main.player.x][Main.player.y-1].isSwitchBlock()) {
				Main.inverseControls *= -1;
				Main.player.setY(y-1);
			
			} else if(Main.cellArray[Main.player.x][Main.player.y-1].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: DEAD Movement");
			} else if (Main.cellArray[Main.player.x][Main.player.y-1].is_ladder()) {
				System.out.println("REACHED LADDER");
				try {
					Main.currentScene++;
					SceneDesigner sd = new SceneDesigner();
					sd.readScene(Main.currentScene);
					Main.player.setX(1);
					Main.player.setY(1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("ERROR: InvalidMovement");
			}
			break;
			
		case 1:
			if (Main.cellArray[Main.player.x+1][Main.player.y].isPassable() 
			&& !Main.cellArray[Main.player.x+1][Main.player.y].isKillBlock() 
			&& !Main.cellArray[Main.player.x+1][Main.player.y].is_ladder() 
			&& !Main.cellArray[Main.player.x+1][Main.player.y].isSwitchBlock()) 
			{
				System.out.println("Valid Movement");
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
				Main.player.setX(x+1);
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
				new Main(0);
			} else if (Main.cellArray[Main.player.x+1][Main.player.y].isSwitchBlock()) {
				Main.inverseControls *= -1;
				Main.player.setX(x+1);
			
			} else if(Main.cellArray[Main.player.x+1][Main.player.y].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: DEAD Movement");
			} else if (Main.cellArray[Main.player.x+1][Main.player.y].is_ladder()) {
				System.out.println("REACHED LADDER");
				try {
					Main.currentScene++;
					SceneDesigner sd = new SceneDesigner();
					sd.readScene(Main.currentScene);
					Main.player.setX(1);
					Main.player.setY(1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("ERROR: InvalidMovement");
			}
			break;
			
		case 2:
			if (Main.cellArray[Main.player.x][Main.player.y+1].isPassable() 
			&& !Main.cellArray[Main.player.x][Main.player.y+1].isKillBlock() 
			&& !Main.cellArray[Main.player.x][Main.player.y+1].is_ladder() 
			&& !Main.cellArray[Main.player.x][Main.player.y+1].isSwitchBlock()) 
			{
				System.out.println("Valid Movement");
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
				Main.player.setY(y+1);
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
				new Main(0);
			} else if (Main.cellArray[Main.player.x][Main.player.y+1].isSwitchBlock()) {
				Main.inverseControls *= -1;
				Main.player.setY(y+1);
			
			} else if(Main.cellArray[Main.player.x][Main.player.y+1].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: DEAD Movement");
			} else if (Main.cellArray[Main.player.x][Main.player.y+1].is_ladder()) {
				System.out.println("REACHED LADDER");
				try {
					Main.currentScene++;
					SceneDesigner sd = new SceneDesigner();
					sd.readScene(Main.currentScene);
					Main.player.setX(1);
					Main.player.setY(1);
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

