package ro.CensLabs.miniPeople.Planting;

import ro.CensLabs.miniPeople.Utils.Constants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class woodPlanting extends Resource{
  
	
public woodPlanting() {
		
		
		texture = new Texture("data/wood.png");
		sprite = new Sprite(texture);
		setValues();
		setBound(xMinBound, xMaxBound, yMinBound, yMaxBound);
		selectRandom();
		setCoordinates();
	
		
	}
public woodPlanting(int xMinBound,int xMaxBound,int yMinBound,int yMaxBound) {
	
	
	texture = new Texture("data/wood.png");
	sprite = new Sprite(texture);
	setValues();
	setBound(xMinBound, xMaxBound, yMinBound, yMaxBound);
	selectRandom();
	setCoordinates();

	
}
	
	void setValues(){
		xMinBound = 15; xMaxBound = 15; yMinBound = 100; yMaxBound = 100;
		importance = 12 * 1000/ Constants.initialWood;  //The higher the number, the less important the resource is
		quantity = 1;
		type = 1;
	}

	
	
	
}
