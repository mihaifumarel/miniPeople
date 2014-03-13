package ro.CensLabs.miniPeople.Utils;

import java.util.Random;

import com.badlogic.gdx.Gdx;

public class utilMethods {
	public static int[] selectRandom(int xMinBound, int xMaxBound, int yMinBound, int yMaxBound){
		int x = (int)Gdx.graphics.getWidth();
		int y = (int)Gdx.graphics.getHeight();
		Random random = new Random();
		int a = (xMinBound + random.nextInt(x- xMaxBound-xMinBound));
		int b = ((yMinBound) + random.nextInt(y - yMaxBound-yMinBound));
		int[] toReturn = {a,b};
		
		return toReturn;
		
	}
	public static int[] parseCoordinates(String coordinates){

	    	
	    	String[] xy = coordinates.split("_");
	    	
	    	int x = Integer.parseInt(xy[0]);
	    	int y = Integer.parseInt(xy[1]);
	    	int[] toReturn = {x,y};
	    	return toReturn;
	    }

}
