package ro.CensLabs.Humans;

import ro.CensLabs.miniPeople.AI.Locations;
import ro.CensLabs.miniPeople.Utils.Constants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Red_Builder extends Builder{

	
	
	public Red_Builder(){
		
		speed = 3;
		texture = new Texture("data/red_builder.png");
		human = new Sprite(texture);
		factionID = 1;
		

        String xy[] =  Locations.FortLocations.get(factionID).split("_"); 
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);
        
        
        
        xMaxBound = Constants.width - x - 10;
        xMinBound = x - 10;
        yMaxBound = Constants.height - y - 10; 
        yMinBound = y - 10;
		init();
		draw();
		
	}
	
	
}
