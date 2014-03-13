package ro.CensLabs.miniPeople.Planting;

import java.util.ArrayList;
import java.util.Random;

import ro.CensLabs.miniPeople.Utils.utilMethods;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GenerateForest extends Resource{

	public static ArrayList<Sprite> forest = new ArrayList<Sprite>();
	Texture forestTexture;
	static public int forestAmount;
	static public ArrayList <String> forestCoordinates  = new ArrayList();
	
	
	utilMethods utils = new utilMethods();
	public GenerateForest() {
			
		//how many forests will be there?
		Random rand = new Random();
		forestAmount = 1 + rand.nextInt(30);
		
		for(int i = 0; i < forestAmount; i++){
		
		selectRandom();
		
		
		
		
		}
	}
	
	
	@Override
	void selectRandom() {
	
		//Select random texture here
		Random rand = new Random();
		texture = new Texture("enviourment/forest-"+(1 + rand.nextInt(3))+".png");
		Sprite thisForest = new Sprite(texture);
		
		xMinBound = 0;
		xMaxBound = 100;
		yMinBound = 0;
		yMaxBound = 100;
		
		super.selectRandom();
		int xy [];
		xy = utils.parseCoordinates(coordinates);
		int x = xy[0];
		int y = xy[1];
		forestCoordinates.add(coordinates);
		thisForest.setPosition(x, y);
		forest.add(thisForest);
	}
	
	
}
