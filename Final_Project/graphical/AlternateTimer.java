package graphical;

import java.awt.Color;

public class AlternateTimer extends Thread {
	
	public void run() {
		try {
			// Initial sleep to offset from flipTimer
			Thread.sleep(750);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				
				for(Cell c : SceneDesigner.orangeCells) {
					if (Main.cellArray[c.getX()][c.getY()].isKillBlock()) {
						Main.cellArray[c.getX()][c.getY()].setKillBlock(false);
						Main.cellArray[c.getX()][c.getY()].setColor(Color.WHITE);
					} 
				}
				Thread.sleep(1000);
				for(Cell c : SceneDesigner.orangeCells) {
					if (!Main.cellArray[c.getX()][c.getY()].isKillBlock()) {
						if (c.posEquals(Main.player)) {
							Main.endGame = true;
						}
						Main.cellArray[c.getX()][c.getY()].setKillBlock(true);
						Main.cellArray[c.getX()][c.getY()].setColor(Color.RED);
					}
				}
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
