package graphical;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class KeyRegistry {

	int keyCode;
	
	public KeyRegistry(KeyEvent e) {
		System.out.println(e.getKeyCode());
		keyCode = e.getKeyCode();
		if (keyCode == 37) {
			move(0);
		} else if (keyCode == 38) {
			move(1);
		} else if (keyCode == 39) {
			move(2);
		} else if (keyCode == 40) {
			move(3);
		} else if (keyCode == 27) {
			Main.is_running = false;
		} else {
			System.out.println("Invalid Key");
		}
		
	}
	
	// 0 = left, 1 = up, 2 = right, 3 = down
	
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
		
		case 0:
			if (Main.cellArray[Main.player.x-1][Main.player.y].isPassable() && !Main.cellArray[Main.player.x-1][Main.player.y].isKillBlock()) {
				System.out.println("Valid Movement");
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
				Main.player.setX(x-1);
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
				// if (is_ladder) {
				new Main(0);
			} else if(Main.cellArray[Main.player.x-1][Main.player.y].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: InvalidMovement");
			} else {
				System.out.println("ERROR: InvalidMovement");
				SoundPlayer player = new SoundPlayer();
			}
			break;
		case 1:
			
			if (Main.cellArray[Main.player.x][Main.player.y-1].isPassable() && !Main.cellArray[Main.player.x][Main.player.y-1].isKillBlock()) {
				System.out.println("Valid Movement");
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
				Main.player.setY(y-1);
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
				new Main(0);
			} else if(Main.cellArray[Main.player.x][Main.player.y-1].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: InvalidMovement");
			} else {
				System.out.println("ERROR: InvalidMovement");
			}
			break;
		case 2:
			
			if (Main.cellArray[Main.player.x+1][Main.player.y].isPassable() && !Main.cellArray[Main.player.x+1][Main.player.y].isKillBlock()) {
				System.out.println("Valid Movement");
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
				Main.player.setX(x+1);
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
				new Main(0);
			} else if(Main.cellArray[Main.player.x+1][Main.player.y].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: InvalidMovement");
			} else {
				System.out.println("ERROR: InvalidMovement");
			}
			break;
		case 3:
			
			if (Main.cellArray[Main.player.x][Main.player.y+1].isPassable() && !Main.cellArray[Main.player.x][Main.player.y+1].isKillBlock()) {
				System.out.println("Valid Movement");
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
				Main.player.setY(y+1);
				Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
				new Main(0);
			} else if(Main.cellArray[Main.player.x][Main.player.y+1].isKillBlock()) {
				Main.endGame = true;
				System.out.println("ERROR: InvalidMovement");
			} else {
				System.out.println("ERROR: InvalidMovement");
			}
			break;
		}
		
	}
	
}

