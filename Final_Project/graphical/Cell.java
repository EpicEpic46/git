package graphical;

import java.awt.Color;

public class Cell {
	Color color;
	int x;
	int y;
	boolean passable = true;
	boolean killBlock;
	
	public Cell() {
		this.color = Color.WHITE;
	}
	
	public Cell(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
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
	
}
