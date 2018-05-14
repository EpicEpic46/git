package graphical;

import java.awt.Color;

public class WhiteCellThread extends Thread {
	public void run() {
		while (true) {
			for (Cell cell : SceneDesigner.whiteCells) {
				if (Main.player.getX() == cell.getX() && Main.player.getY() == cell.getY()) {
					cell.setColor(Color.GREEN);
				} else cell.setColor(Color.WHITE);
			}
		}
	}
}
