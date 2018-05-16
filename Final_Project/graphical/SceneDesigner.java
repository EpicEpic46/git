package graphical;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class SceneDesigner {
	
	final Color PURPLE = new Color(128,0,128);
	
	String source_folder = this.getClass().getClassLoader().getResource("Resources/").toString().substring(6);
	
	Cell[][] sceneArray = new Cell[22][12];
	public static ArrayList<Cell> yellowCells;
	public static ArrayList<Cell> orangeCells;
	public static ArrayList<Cell> cyanCells;
	public static ArrayList<Cell> whiteCells;
	// read scenes from text and load them into Main.cellArray[][]
	public void readScene(int scene) throws IOException {
		// yellow cells = alternating reds #1
		yellowCells = new ArrayList<Cell>();
		// orange cells = alternating reds #2
		orangeCells = new ArrayList<Cell>();
		// cyan cells = inverse controls
		cyanCells = new ArrayList<Cell>();
		// white cells = safe areas
		whiteCells = new ArrayList<Cell>();
		
		File sceneFile = new File(source_folder + "Scene" + scene + ".txt");
		// cannot br.close() at end of method because readScene gets read again
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
					sceneArray[i][counter].set_ladder(true);
					break;
				case 'x':
					sceneArray[i][counter] = new Cell(Color.RED, i, counter);
					sceneArray[i][counter].setKillBlock(true);
					break;
				case '#':
					sceneArray[i][counter] = new Cell(Color.RED, i, counter);
					yellowCells.add(sceneArray[i][counter]);
					sceneArray[i][counter].setKillBlock(true);
					break;
				case '*':
					sceneArray[i][counter] = new Cell(Main.COLOR_BORDER, i, counter);
					sceneArray[i][counter].setPassable(false);
					break;
				case '-':
					sceneArray[i][counter] = new Cell(Color.WHITE, i, counter);
					whiteCells.add(sceneArray[i][counter]);
					break;
				case '%':
					sceneArray[i][counter] = new Cell(Color.RED, i, counter);
					orangeCells.add(sceneArray[i][counter]);
					sceneArray[i][counter].setKillBlock(true);
					break;
				case '?':
					sceneArray[i][counter] = new Cell(Color.CYAN, i, counter);
					sceneArray[i][counter].setSwitchBlock(true);
					cyanCells.add(sceneArray[i][counter]);
				}
			}
		counter++;
		}
		Main.cellArray = sceneArray;
		
	}
}