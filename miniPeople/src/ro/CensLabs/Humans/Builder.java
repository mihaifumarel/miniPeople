package ro.CensLabs.Humans;

import java.util.Random;

import ro.CensLabs.Screen.gameScreen;
import ro.CensLabs.miniPeople.AI.Locations;
import ro.CensLabs.miniPeople.Stocks.BuildingSchedule;
import ro.CensLabs.miniPeople.Structure.Barracks;
import ro.CensLabs.miniPeople.Structure.Garden;
import ro.CensLabs.miniPeople.Structure.LumberJack;
import ro.CensLabs.miniPeople.Structure.Quarry;
import ro.CensLabs.miniPeople.Structure.Structure;
import ro.CensLabs.miniPeople.Utils.Constants;
import ro.CensLabs.miniPeople.Utils.Formulas;
import ro.CensLabs.miniPeople.Utils.Storage;
import ro.CensLabs.miniPeople.Utils.UIControl;
import ro.CensLabs.miniPeople.Utils.utilMethods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Builder {

	
	//will wonder around 
	//will constantly query the building pool
	//if the building pool has an object
	//stop movement, build object
	//resume movement on finshing building
	
	
	//knows
	
	private boolean wondering = true;
	int speed = 4;
	Texture texture = new Texture("data/builder.png");
	public Sprite human = new Sprite(texture);
	String coordinates;
	int idleTime = 1000;
	int xMaxBound, xMinBound, yMaxBound, yMinBound;
	
	int factionID;
	
	
	
	//weird processing stuff
	Structure structure;
	
	
	
	
	//does
	
	public void draw(){
		
		gameScreen.toDrawLower.add(human);
		
		
	}
	


	public void init(){
		setPosition();
		updateCoordinates();
		behavior();
		checkSchedule();
	}
	
	void setPosition(){

		int[] rawCoords = utilMethods.selectRandom(xMinBound, xMaxBound, yMinBound, yMaxBound);
		
		human.setPosition(rawCoords[0], rawCoords[1]);

	}
	
	
	private void behavior(){
		
		Thread process = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					
					while(wondering){

					moveRandom();
					
					}
					
					if(!wondering){

						
						if(!BuildingSchedule.schedule[factionID].isEmpty()){
						
						
						try{
							
							//ADD PRICE DEDUCTION HERE
							
							
							
							 
							/*
							buildingData selectedBuilding = (buildingData)BuildingSchedule.schedule[factionID].get(0);	
							
							ResourceStocks.stoneStock[factionID] = ResourceStocks.stoneStock[factionID] - selectedBuilding.stoneCost;
							ResourceStocks.woodStock[factionID] = ResourceStocks.woodStock[factionID] - selectedBuilding.woodCost;
							ResourceStocks.metalStock[factionID] = ResourceStocks.metalStock[factionID] - selectedBuilding.metalCost;
							ResourceStocks.goldStock[factionID] = ResourceStocks.goldStock[factionID] - selectedBuilding.goldCost;
							*/
							
							
							
					
						
						String building = BuildingSchedule.schedule[factionID].get(0).toString();
						
						
						
						
						
						
						if(building.equals("quarry")){Gdx.app.postRunnable(new Runnable() {
							
							@Override
							public void run() {
								structure = new Quarry((int)human.getX()+4, (int)human.getY(), factionID);
								gameScreen.toBuild.add(structure);
							
							}
						});}
						
						if(building.equals("lumberhut")){ Gdx.app.postRunnable(new Runnable() {
							
							@Override
							public void run() {
								structure = new LumberJack((int)human.getX()+4, (int)human.getY(), factionID);
								gameScreen.toBuild.add(structure);
							}
						}); }
						if(building.equals("barracks")){ Gdx.app.postRunnable(new Runnable() {
							
							@Override
							public void run() {
								structure = new Barracks((int)human.getX()+4, (int)human.getY(), factionID);
								gameScreen.toBuild.add(structure);
							}
						}); }
						if(building.equals("garden")){
							 Gdx.app.postRunnable(new Runnable() {
									
									@Override
									public void run() {
										structure = new Garden((int)human.getX()+4, (int)human.getY(), factionID);
										gameScreen.toBuild.add(structure);
									}
								}); 
						}
						if(building.equals("smeltry")){ }
						if(building.equals("alchemist")){ }
						if(building.equals("temple")){ }
						if(building.equals("outpost")){ }
					
						BuildingSchedule.schedule[factionID].remove(0);
						Thread.sleep(500);	
						
						
						//THE MOVEMENT
						
						System.out.println("!!!!  "+structure.doneBuilding);
						while(!structure.doneBuilding){
							
							//go to fort
							
							while(!moveHuman(Locations.FortLocations.get(factionID))){
								Thread.sleep(Formulas.speedFormula(speed));
							}
							
							Thread.sleep(idleTime);
							
							//go to building
							
							while(!moveHuman(structure.coordinates)){
								Thread.sleep(Formulas.speedFormula(speed));
							}
							
							structure.build();
							
							Thread.sleep(idleTime);
							
							
						}
						
						
						
						
						structure = null;
						wondering = true;
						
						
						
						
						
						
						}catch(Exception e){
							
						}
					}
						
						else if(!Storage.unfinishedStructures[factionID].isEmpty() ){ //help building stuff
							
							
							
						
							Structure building = Storage.unfinishedStructures[factionID].get(0);
							
							
							
							//THE MOVEMENT LOOP
							exit:
								while(!building.doneBuilding){
									
									
									if(!BuildingSchedule.schedule[factionID].isEmpty()) break;	
									
								try{
								//go to fort
								
								while(!moveHuman(Locations.FortLocations.get(factionID))){
									Thread.sleep(Formulas.speedFormula(speed));
									if(!BuildingSchedule.schedule[factionID].isEmpty()||building.doneBuilding) break;	
								}
								
								Thread.sleep(idleTime);
								
								//go to building
								
								while(!moveHuman(building.coordinates)){
									Thread.sleep(Formulas.speedFormula(speed));
									if(!BuildingSchedule.schedule[factionID].isEmpty()||building.doneBuilding) break exit;	
								}
								
								building.build();
								UIControl.updateUI();
								
								
								Thread.sleep(idleTime);
								}catch(Exception e){
									
									e.printStackTrace();
								}
								
							}
							
							
								wondering = true;
								
							
							
						}
					
					
					
					
					
					
					
					
					}
					
					
				}
								
			}
		});
		
		process.start();
		
		
		
		
		
	}

	private void checkSchedule(){
		
		Thread process = new Thread(new Runnable() {
			
			@Override
			public void run() {
			
				while(true){
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
					
					
					
					

					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
					if(BuildingSchedule.schedule[factionID].isEmpty()){
						
						
					
						
						
						wondering = true;
						
						
						
					
					}try{
					if(!Storage.unfinishedStructures[factionID].isEmpty() || !BuildingSchedule.schedule[factionID].isEmpty()){ 
						wondering = false;
					
					
					}
					}catch(Exception e){}
					
					
				}
				
				
			}
		});
		
		process.start();
		
	}
	
	
	private void moveRandom(){

		
		//choose location to go to
		
		int xy[] = utilMethods.parseCoordinates(coordinates);
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
	
	boolean moveHuman(String target){
	  	
    	int x = (int)human.getX();
    	int y = (int)human.getY();
    	
    	int XY[] = utilMethods.parseCoordinates(target);
    	
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
	
	
}
