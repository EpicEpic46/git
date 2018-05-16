package graphical;

import java.awt.Color;

/**
 * This class sets the UI coloring correctly for movement over cyan tiles
 */
public class SwitchThread extends Thread{
	
	public void run() {
		while(true) {
			// check if the player runs into a cyan cell, doesnt work in keyRegistry because trying
			// to move onto a new cyan block inverts controls before going over it
			for (Cell cell : SceneDesigner.cyanCells) {
				if (Main.player.getX() == cell.getX() && Main.player.getY() == cell.getY()) {
					cell.setColor(Color.GREEN);
				} else cell.setColor(Color.CYAN);
			}
		}
	}
}
