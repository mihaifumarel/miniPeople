package ro.CensLabs.miniPeople.Structure;

import ro.CensLabs.miniPeople.AI.Locations;
import ro.CensLabs.miniPeople.Utils.utilMethods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class RedFort extends Structure{
	
	
	int faction = 1; //RED
	
	
	
	
    public RedFort(){
    	init();
    }
	
	void init(){
		setVariables();
		setPosition();
		passive();
	}
	
	void setVariables(){
		livingTexture = new Texture("Structures/fort_red_living.png");		
		Texture deadTexture =  new Texture("Structures/fort_dead.png");
		structure.setOrigin(structure.getWidth()/2, structure.getHeight()/2);
		structure = new Sprite(livingTexture);
		
		
		int importance = 10;
		int HP = 50;
		
		int[] xy = utilMethods.selectRandom(15, Gdx.graphics.getWidth()/2, 100, 100);
		x = xy[0];
		y = xy[1];
		
		Locations.FortLocations.add(faction, (int)(x+structure.getWidth()/2)+"_"+(int)(y+structure.getHeight()/2));
		
	}
}
