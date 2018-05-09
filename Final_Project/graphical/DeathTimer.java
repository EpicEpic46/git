package graphical;

import java.util.TimerTask;

public class DeathTimer extends TimerTask implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
