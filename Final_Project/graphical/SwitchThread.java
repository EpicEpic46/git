package graphical;

import java.awt.Color;

public class SwitchThread extends Thread{
	
	public void run() {
		while(true) {
			for (Cell cell : SceneDesigner.cyanCells) {
				if (Main.player.getX() == cell.getX() && Main.player.getY() == cell.getY()) {
					cell.setColor(Color.GREEN);
				} else cell.setColor(Color.CYAN);
			}
		}
	}
}
