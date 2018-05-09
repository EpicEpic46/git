package graphical;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class SceneDesigner {
	
	final Color PURPLE = new Color(128,0,128);
	
	String source_folder = this.getClass().getClassLoader().getResource("Resources/").toString().substring(6);
	Cell[][] sceneArray = new Cell[22][12];
	public static ArrayList<Cell> yellowCells = new ArrayList<Cell>();
	
	
	public SceneDesigner() {
	}
	
	public void readScene(int scene) throws IOException {
		File sceneFile = new File(source_folder + "Scene" + scene + ".txt");
		BufferedReader br = new BufferedReader(new FileReader(sceneFile));
		String line;
		int counter = 0;
		while(br.ready()) {
			
			line = br.readLine();
			for(int i = 0; i < line.length(); i++) {
				switch(line.charAt(i)) {
				case 'p':
					sceneArray[i][counter] = new Cell(Color.GREEN, i, counter);
					break;
				case '^':
					sceneArray[i][counter] = new Cell(PURPLE, i, counter);
					break;
				case 'x':
					sceneArray[i][counter] = new Cell(Color.RED, i, counter);
					sceneArray[i][counter].setKillBlock(true);
					break;
				case '#':
					sceneArray[i][counter] = new Cell(Color.YELLOW, i, counter);
					yellowCells.add(sceneArray[i][counter]);
					sceneArray[i][counter].setKillBlock(true);
					break;
				case '*':
					sceneArray[i][counter] = new Cell(Main.COLOR_BORDER, i, counter);
					sceneArray[i][counter].setPassable(false);
					break;
				case '-':
					sceneArray[i][counter] = new Cell(Color.WHITE, i, counter);
					break;
				case '%':
					sceneArray[i][counter] = new Cell(Color.YELLOW, i, counter);
					break;
				}
			}
		counter++;
		}
		
	}
}