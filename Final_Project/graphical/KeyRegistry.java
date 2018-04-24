package graphical;

import java.awt.Color;
import java.awt.event.KeyEvent;

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
		int x = Main.player.x;
		int y = Main.player.getY();
		
		switch(direction) {
		case 0:
			Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
			Main.player.setX(x-1);
			Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
			new Main(0);
			break;
		case 1:
			Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
			Main.player.setY(y-1);
			Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
			new Main(0);
			break;
		case 2:
			Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
			Main.player.setX(x+1);
			Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
			new Main(0);
			break;
		case 3:
			Main.cellArray[Main.player.x][Main.player.y].setColor(Color.WHITE);
			Main.player.setY(y+1);
			Main.cellArray[Main.player.x][Main.player.y].setColor(Color.GREEN);
			new Main(0);
			break;
		}
		new Main(0);
		
	}
	
}

