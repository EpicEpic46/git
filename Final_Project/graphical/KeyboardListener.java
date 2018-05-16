package graphical;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * This class uses KeyListener to create KeyRegistry objects
 */
public class KeyboardListener implements KeyListener {


	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.toString());
		new KeyRegistry(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println(e.toString());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println(e.toString());
		
	}


}
