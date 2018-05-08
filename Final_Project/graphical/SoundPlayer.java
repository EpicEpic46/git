package graphical;
import java.io.*;
import sun.audio.*;

public class SoundPlayer {
	public void playSound(String soundFileName) {
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(soundFileName);
			AudioStream audioStream = new AudioStream(inputStream);
			AudioPlayer.player.start(audioStream);
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}