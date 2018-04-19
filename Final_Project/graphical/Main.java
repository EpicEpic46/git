package Final_Project.graphical;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

	// begins with "file:/" so in order to allow IO to read file location, must .substring(6)
	public final String SOURCEFOLDER = Main.class.getClassLoader().getResource("resources/").toString().substring(6); 
	
	// methods for different shapes/images
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
		Image bg;
		String bgResource = SOURCEFOLDER + "Image.jpg";
		System.out.println(bgResource);
		try {
			bg = ImageIO.read(new File(bgResource));
		// at 1280*720, 1260*665 is max w*h

			g.drawImage(bg, 0, 0, 1260, 665, null);
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1280,720);
		frame.setTitle("Test Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new Main());
		
	}

}
