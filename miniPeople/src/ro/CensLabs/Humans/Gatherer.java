package ro.CensLabs.Humans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import ro.CensLabs.Screen.gameScreen;
import ro.CensLabs.miniPeople.AI.Locations;
import ro.CensLabs.miniPeople.Planting.Resource;
import ro.CensLabs.miniPeople.Tweening.Tweening;
import ro.CensLabs.miniPeople.Utils.Constants;
import ro.CensLabs.miniPeople.Utils.Storage;
import ro.CensLabs.miniPeople.Utils.UIControl;
import ro.CensLabs.miniPeople.Utils.utilMethods;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquation;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Back;
import aurelienribon.tweenengine.equations.Bounce;
import aurelienribon.tweenengine.equations.Circ;
import aurelienribon.tweenengine.equations.Elastic;
import aurelienribon.tweenengine.equations.Quad;
import aurelienribon.tweenengine.equations.Quart;
import aurelienribon.tweenengine.equations.Quint;
import aurelienribon.tweenengine.equations.Sine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.org.apache.bcel.internal.generic.SWITCH;

import ro.CensLabs.miniPeople.Stocks.*;
public class Gatherer {

	//instances
	int faction;
	int speed;
	int returnSpeed;
	int hp;
	int importance;
	int isCarrying;
	int costGold, costWood, costStone, costFood, costMetal;
	int goldDropped;
	int carryCapacity;
	int mineTime;
	int restTime;
	
	
	
	
	String coordinates;
	int arrayLocation;
	
	
	
	Texture texture = new Texture("data/neutral_human.png");
	public Sprite human = new Sprite(texture);
	
	public SpriteBatch batch;
	

	
	int sleepTime;
	
	int xMaxBound, xMinBound, yMaxBound, yMinBound;
	
	
	ArrayList <Resource> resourceObjectPool = Storage.resourceObjects;
	
	
	
	String oldTarget;
	
	
	
	Resource currentResourceObject;
	ResourceStocks stock = new ResourceStocks();
	
	
	
	//does
	
	
	public void draw(){
		
		gameScreen.toDrawLower.add(human);
	}
	
	
	
	int calculateDistance(String pointA,String pointB){
		int C1[] = parseCoords(pointA);
		int C2[] = parseCoords(pointB);
		
		
		int x1 = C1[0], y1 = C1[1], x2 = C2[0], y2 = C2[1];
		
		int a = x2 - x1;
		a = a * a;
		int b = y2 - y1;
		b = b * b;
        int c = (int)Math.sqrt(a+b);
        
        return c;
		
		
	}
    int[] parseCoords(String coords){
    	String parsed[] = coords.split("_");
    	int returned[] = new int[2];
    	returned[0] = Integer.parseInt(parsed[0]);
    	returned[1] = Integer.parseInt(parsed[1]);
    	return returned;
    }
	int metaScore(int distance, int importance){
		int metaScore = (((10000/distance)*importance));
		
		
		
		return metaScore;
		
	}
	public void init(){
        
		
		setPosition();
		updateCoordinates();
		behavior();
		
	}
	
	
	void setPosition(){

		int[] rawCoords = utilMethods.selectRandom(xMinBound, xMaxBound, yMinBound, yMaxBound);
		
		human.setPosition(rawCoords[0], rawCoords[1]);

	}
	void behavior(){
		
		Thread t = new Thread(new Runnable() {
			
			
			int currentID;
			String currentTarget;
			
			int metaScore;
			
			public void run() {
             currentID = 0;
             currentTarget = "";
             oldTarget = "";
             metaScore = 0;
				while(true){ // thought process
				
					
	                
					try {
						Thread.sleep(sleepTime);
						//calculate metascore block, get coordinates with highest metascore
						 
						
						
						//DONT FORGET TO BUILD ALL 3 TYPES OF BEHAVIOR TODO
						
						
						if(currentTarget.equals(oldTarget)){
							
							
							
							while(metaScore < 1200){ // if meta is not high enaugh, move the human randomly
								
								
								
								
						
							
							
							
							
						
						
						
						
						for(int i = 0; i < resourceObjectPool.size(); i++){
                           
							int distance = calculateDistance(coordinates, resourceObjectPool.get(i).getCoordinates()); //This is the distance between the human and the resource
							int currentMetaScore = metaScore(distance, resourceObjectPool.get(i).getImportance()); //the current meta
							
							if(currentMetaScore > metaScore){
								
								metaScore = currentMetaScore;
								currentID = i;
								
								currentTarget = resourceObjectPool.get(i).getCoordinates();
								currentResourceObject = resourceObjectPool.get(i);
								
							}
							
						}
					
						
						
						
						   walkRandomly();
						
						
						
							}
					  
						
						
						//if coordinates remain unchanged, continue exectution, if they change, halt all action, recalculate.
						
						
					
							
							
						}
						else if(Storage.getResourceObjects().length>0){ //Change target
							
							while(!moveHuman()){
								Thread.sleep(10 * (10/speed));
							}
							
							
						Thread.sleep(mineTime); //how much time spent mining resource
							
							while(!moveHuman(Locations.FortLocations.get(faction))){
								Thread.sleep(10 * (10/returnSpeed));
							}
							
							Thread.sleep(restTime); //how much time spent at fort
							
							//adding resources
							int resourceType = currentResourceObject.getType();
							
							switch (resourceType) {
							case 1: //wood
								stock.woodStock[faction] = stock.woodStock[faction] + isCarrying + stock.woodMultiplier[faction];
								break;
							case 2: //stone
								stock.stoneStock[faction] = stock.stoneStock[faction] + isCarrying + stock.stoneMultiplier[faction];
								break;
							case 3: //metal
								stock.metalStock[faction] = stock.metalStock[faction] + isCarrying + stock.metalMultiplier[faction];
								break;
							case 4: //gold
								stock.goldStock[faction] = stock.goldStock[faction] + isCarrying + stock.goldMultiplier[faction];
								break;
							case 5: //food
								stock.foodStock[faction] = stock.foodStock[faction] + isCarrying + stock.foodMultiplier[faction];
								break;
								
							default:
								break;
							}
							
							UIControl.updateUI();
							
							
							
							coordinates = (int)(human.getX()) + "_" + (int)(human.getY());
							
						
							
						
							
							metaScore = 0;
							
						}
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					
					
					
				
				}
			}
		});
		
		
		
		t.start();
		
		
		
	}
	
	void walkRandomly(){
		
		//choose location to go to
		
		int xy[] = parseCoords(coordinates);
		int x = xy[0] - 100 + new Random().nextInt(200);
		int y = xy[1] - 100 + new Random().nextInt(200);
		
		//make sure it doesen't get out of the screen
		if(x < 25) x = 25;
		if(y < 100) y = 100;
		if(x > Constants.width-25) x = Constants.width-25;
		if(y > Constants.height-100) y = Constants.height-100;
		
		//go to the chosen location
		
		while(!moveHuman(x+"_"+y)){
			try {
				Thread.sleep(10 * (10/speed));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		updateCoordsManual();
		
		
		
		
		
	}
	
	
    void updateCoordinates(){ //TODO WORK ON THIS
    	Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
 
				try {
					
				
				coordinates = (int)human.getX() + "_" + (int)human.getY();
				Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
    	
    	t.run();
    }
    
    
    void updateCoordsManual(){
    	coordinates = (int)human.getX()+"_"+(int)human.getY();
    }
    
    
    //movers
    
    boolean moveHuman(){
    	
    	try{
    	currentResourceObject = null;
		int currentID;
		String currentTarget = "";
		
		int metaScore = 0;
	
		for(int i = 0; i < resourceObjectPool.size(); i++){
            
			int distance = calculateDistance(coordinates, resourceObjectPool.get(i).getCoordinates()); //This is the distance between the human and the resource
			int currentMetaScore = metaScore(distance, resourceObjectPool.get(i).getImportance()); //the current meta
			
			if(currentMetaScore > metaScore){
				
				metaScore = currentMetaScore;
				currentID = i;
				
				currentTarget = resourceObjectPool.get(i).getCoordinates();
				currentResourceObject = resourceObjectPool.get(i);
			
			}
		
		}
		
		String target = currentTarget;
    	
    	int x = (int)human.getX();
    	int y = (int)human.getY();
    	
    	int XY[] = parseCoords(target);
    	
    	int targetX = XY[0];
    	int targetY = XY[1];
    	
    	if(x > targetX) x --;
    	if(x < targetX) x ++;
    	if(y > targetY) y --;
    	if(y < targetY) y ++;
    	
    	human.setPosition(x, y);
    	
    	if(x == targetX && y == targetY){
    		
    		
    		//updating amount of resources carried
    		
    		if(currentResourceObject.getQuantity()>carryCapacity){
    			isCarrying = carryCapacity;
    			
    		}
    		else{
    			isCarrying = currentResourceObject.getQuantity();
    			
    			
    		}
    		
    		
    		currentResourceObject.deductQuantity(carryCapacity);
    		//add resource to stock here
    		//delete resources here too
    		if(currentResourceObject.getQuantity()<=0){
    			gameScreen.woodObjects.remove(currentResourceObject);
    			gameScreen.stoneObjects.remove(currentResourceObject);
    			resourceObjectPool.remove(currentResourceObject);
    			Storage.removeResource(currentResourceObject);
    			
    			oldTarget = currentTarget;
    			
    		}
    		
    		
    		
    		return true;
    	}
    	
    	else return false;
    	}catch(Exception e){
    		
    		e.printStackTrace();
    		return true;
    		
    	}
    }
    
    
    boolean moveHuman(String target){
  	
    	int x = (int)human.getX();
    	int y = (int)human.getY();
    	
    	int XY[] = parseCoords(target);
    	
    	int targetX = XY[0];
    	int targetY = XY[1];
    	
    	if(x > targetX) x --;
    	if(x < targetX) x ++;
    	if(y > targetY) y --;
    	if(y < targetY) y ++;
    	
    	human.setPosition(x, y);
    	
    	if(x == targetX && y == targetY) return true;
    	else return false;
    	
    }
    
    
    
    Object[] getCurentTargetGatherer(){

		
		Resource currentResourceObject = new Resource();
		int currentID=0;
		String currentTarget = "";
		String oldTarget = "";
		int metaScore = 0;
		int currentMetaScore=0;
		
		
		
		Resource[] resourceObjectPool = Storage.getResourceObjects();
		
		
		for(int i = 0; i < resourceObjectPool.length; i++){

			int distance = calculateDistance(coordinates, resourceObjectPool[i].getCoordinates()); //This is the distance between the human and the resource
			currentMetaScore = metaScore(distance, resourceObjectPool[i].getImportance()); //the current meta
			
			if(currentMetaScore > metaScore){
				
				metaScore = currentMetaScore;
				currentID = i;
				currentTarget = resourceObjectPool[i].getCoordinates();
				currentResourceObject = resourceObjectPool[i];
			}
			
		}
		
		
		Object toReturn[] = {metaScore + "",currentID + "",currentTarget, currentResourceObject};
	
	return toReturn;	
    }
    
    
}

