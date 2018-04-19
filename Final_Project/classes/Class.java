package Final_Project.classes;

import java.util.ArrayList;
import spell.Spell;

public interface Class {
	
	String name = "default_name";
	//						  Level: 0,1  ,2,  3,  4,  5,  6,   7,   8,   9,   10
	final int[] LEVEL_THRESHOLDS = {0,100,200,300,500,800,1300,2100,3400,5500,8900}; 
	ArrayList<Integer> stats = new ArrayList<Integer>();
	ArrayList<Integer> statGrowth = new ArrayList<Integer>();
	ArrayList<Spell> spellList = new ArrayList<Spell>();
	
	public void levelUp();
	
	
}
