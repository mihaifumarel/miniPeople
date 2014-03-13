package ro.CensLabs.miniPeople.Planting;

import ro.CensLabs.miniPeople.Utils.Constants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class stonePlanting extends Resource{
  
	
public stonePlanting() {
		
		
		texture = new Texture("data/stone.png");
		sprite = new Sprite(texture);
		setValues();
		setBound(xMinBound, xMaxBound, yMinBound, yMaxBound);
		selectRandom();
		setCoordinates();
	
		
	}
	
	void setValues(){
		xMinBound = 200; xMaxBound = 200; yMinBound = 30; yMaxBound = 30;
		importance = 5 * (1000/ Constants.initialStone); // the lower the number, the higher the importance
		quantity = 5;
		type = 2;
	}

	
	
	
}
