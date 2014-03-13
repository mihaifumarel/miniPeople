package ro.CensLabs.Humans;

import java.util.Random;

import ro.CensLabs.miniPeople.AI.Locations;
import ro.CensLabs.miniPeople.Utils.Constants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class Red_Gatherer extends Gatherer{

	Locations locations = new Locations();
	Constants constants = new Constants();
	Random rand = new Random();
	
	public Red_Gatherer(){
		
		
	
		//instances
		faction = 1;
		speed = 5;
		returnSpeed = 2;
		carryCapacity = 2;
		mineTime = 800+rand.nextInt(1200);;
		restTime = 800+rand.nextInt(1200);;
    	Texture texture = new Texture("data/red_gatherer.png");
		human = new Sprite(texture);
    
        sleepTime = 200+rand.nextInt(400);
        
        
        String xy[] =  locations.FortLocations.get(faction).split("_"); 
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);
        
       
        xMaxBound = constants.width - x - 10;
        xMinBound = x - 10;
        yMaxBound = constants.height - y - 10; 
        yMinBound = y - 10;
        init();
        draw();
		
		
	}
	
	
}
