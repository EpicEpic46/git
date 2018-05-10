package graphical;

import java.awt.Color;

public class FlipTimer extends Thread {

	public void run() {
		while (true) {
			try {
				for(Cell c : SceneDesigner.yellowCells) {
					if (Main.cellArray[c.x][c.y].killBlock) {
						Main.cellArray[c.x][c.y].setKillBlock(false);
						Main.cellArray[c.x][c.y].setColor(Color.WHITE);
					} else {
						Main.cellArray[c.x][c.y].setKillBlock(true);
						Main.cellArray[c.x][c.y].setColor(Color.RED);
					}
				}
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
