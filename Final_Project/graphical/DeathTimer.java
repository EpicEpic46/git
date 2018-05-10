package graphical;

import java.awt.Graphics;
import java.util.TimerTask;

public class DeathTimer extends Thread {

	
	public void run() {
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
