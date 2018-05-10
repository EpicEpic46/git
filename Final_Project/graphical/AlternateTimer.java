package graphical;

import java.awt.Color;

public class AlternateTimer extends Thread {

	public void run() {
		try {
			Thread.sleep(750);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				
				for(Cell c : SceneDesigner.orangeCells) {
					if (Main.cellArray[c.x][c.y].killBlock) {
						Main.cellArray[c.x][c.y].setKillBlock(false);
						Main.cellArray[c.x][c.y].setColor(Color.WHITE);
					} 
				}
				Thread.sleep(1000);
				for(Cell c : SceneDesigner.orangeCells) {
					if (!Main.cellArray[c.getX()][c.getY()].isKillBlock()) {
						if (c.posEquals(Main.player)) {
							Main.endGame = true;
						}
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
