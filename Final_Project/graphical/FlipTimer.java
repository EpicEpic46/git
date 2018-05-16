package graphical;

import java.awt.Color;

public class FlipTimer extends Thread {

	public void run() {
		while (true) {
			try {
				
				for(Cell c : SceneDesigner.yellowCells) {
					if (Main.cellArray[c.getX()][c.getY()].isKillBlock()) {
						Main.cellArray[c.getX()][c.getY()].setKillBlock(false);
						Main.cellArray[c.getX()][c.getY()].setColor(Color.WHITE);
					} 
				}
				// One second off
				Thread.sleep(1000);
				for(Cell c : SceneDesigner.yellowCells) {
					if (!Main.cellArray[c.getX()][c.getY()].isKillBlock()) {
						if (c.posEquals(Main.player)) {
							Main.endGame = true;
						}
						Main.cellArray[c.getX()][c.getY()].setKillBlock(true);
						Main.cellArray[c.getX()][c.getY()].setColor(Color.RED);
					}
				}
				// half second on
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
