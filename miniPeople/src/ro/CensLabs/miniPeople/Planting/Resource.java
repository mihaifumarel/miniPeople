package ro.CensLabs.miniPeople.Planting;

import java.util.Random;

import ro.CensLabs.miniPeople.Utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Resource{
	
	//Init variables
	
	public Sprite sprite = new Sprite();
	
    String coordinates;
	int type;
	int xMinBound, xMaxBound, yMinBound, yMaxBound;
	int quantity;
	int importance;
	Texture texture = new Texture("data/neutral resource.png");
	
	
	
	
	
	
	
	
	//does

	void init(){
		setBound(xMinBound, xMaxBound, yMinBound, yMaxBound);
		selectRandom();
		setCoordinates();
	}
	void selectRandom(){
		int x = Constants.width;
		int y = Constants.height;
		Random random = new Random();
		int a = (this.xMinBound + random.nextInt(x- this.xMaxBound-xMinBound));
		int b = ((this.yMinBound) + random.nextInt(y - this.yMaxBound-yMinBound));
		
		
		this.coordinates = a +"_"+ b;
		
		
	}
	void setBound(int xMinBound, int xMaxBound, int yMinBound, int yMaxBound){
		
		this.xMinBound = xMinBound;
		this.xMaxBound = xMaxBound;
		this.yMinBound = yMinBound;
		this.yMaxBound = yMaxBound;
		
		
	}
    void setCoordinates(){

    	
    	String[] xy = coordinates.split("_");
    	System.out.println(coordinates);
    	int x = Integer.parseInt(xy[0]);
    	int y = Integer.parseInt(xy[1]);
    	sprite.setPosition(x, y);
    }
    void setTexture(){
    	sprite.setTexture(this.texture);
    }	public String getCoordinates() {
		return coordinates;
	}
    
    
    
    //setters and getters
    
    public int getImportance(){
    	return importance;
    }
    public int getQuantity(){
    	
    	return quantity;
    	
    }

    public void deductQuantity(int amount){
    	if(quantity > amount)
    	quantity = quantity - amount;
    	else quantity = 0;
    }
    
    public int getType(){
    	return type;
    }
}
