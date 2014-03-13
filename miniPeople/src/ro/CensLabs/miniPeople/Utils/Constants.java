package ro.CensLabs.miniPeople.Utils;

import java.util.Random;

import ro.CensLabs.miniPeople.Planting.GenerateForest;

import com.badlogic.gdx.Gdx;

public class Constants {

	
	
	
	public static final int width = 1080;
	public static final int height = 490;
	public static final int initialWood = 10 + GenerateForest.forestAmount * 10;
	public static final int initialStone = 50;
	public static final int factionCount = 2 + 1;//+1 because faction count starts at 1
	
}
