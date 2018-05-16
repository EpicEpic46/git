package graphical;

import java.awt.Color;
/**
 * This class sets some cells back to white after player moves over them
 */
public class WhiteCellThread extends Thread {
	public void run() {
		while (true) {
			// Resets tiles that the player goes over to white
			// made because of issues created by the cyan cells
			for (Cell cell : SceneDesigner.whiteCells) {
				if (Main.player.getX() == cell.getX() && Main.player.getY() == cell.getY()) {
					cell.setColor(Color.GREEN);
				} else cell.setColor(Color.WHITE);
			}
			// yellow/orange cells are here to prevent the tiles
			// from staying green when the player crosses over them
			for (Cell cell : SceneDesigner.yellowCells) {
				if (Main.player.getX() == cell.getX() && Main.player.getY() == cell.getY()) {
					cell.setColor(Color.GREEN);
				} else if(cell.isKillBlock()) {
					cell.setColor(Color.RED);
				} else {
					cell.setColor(Color.WHITE);
				}
				
			}
			for (Cell cell : SceneDesigner.orangeCells) {
				if (Main.player.getX() == cell.getX() && Main.player.getY() == cell.getY()) {
					cell.setColor(Color.GREEN);
				} else if(cell.isKillBlock()) {
					cell.setColor(Color.RED);
				} else {
					cell.setColor(Color.WHITE);
				}
			}
		}
	}
}
