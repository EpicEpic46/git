package graphical;

import java.awt.Color;

/**
 * This class defines the cells that make up Main.cellArray[][]
 */
public class Cell {
	private Color color;
	private int x;
	private int y;
	private boolean passable = true;
	private boolean killBlock;
	private boolean is_ladder;
	private boolean switchBlock;
	
	public Cell() {
		this.color = Color.WHITE;
	}
	
	public Cell(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public boolean isSwitchBlock() {
		return switchBlock;
	}

	public void setSwitchBlock(boolean switchBlock) {
		this.switchBlock = switchBlock;
	}

	public boolean is_ladder() {
		return this.is_ladder;
	}
	
	public void set_ladder(boolean is_ladder) {
		this.is_ladder = is_ladder;
	}
	
	public boolean isKillBlock() {
		return this.killBlock;
	}
	
	public void setKillBlock(boolean killBlock) {
		this.killBlock = killBlock;
	}
	
	public boolean isPassable() {
		return passable;
	}

	public void setPassable(boolean passable) {
		if (!passable) this.color = Main.COLOR_BORDER;
		else this.color = Color.WHITE;
		this.passable = passable;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public String toString() {
		return "Cell[X:" + getX() + "-Y:" + getY() + "-Color:" + getColor() + "-KillBlock:" + isKillBlock() + "-Ladder:" + is_ladder();
	}
	
	public boolean posEquals(Cell other_cell) {
		if (this.getX() == other_cell.getX() && this.getY() == other_cell.getY()) {
			return true;
		} else return false;
	}
	
}
