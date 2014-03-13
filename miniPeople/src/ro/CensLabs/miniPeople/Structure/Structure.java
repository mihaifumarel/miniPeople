package ro.CensLabs.miniPeople.Structure;

import ro.CensLabs.miniPeople.Utils.Storage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Structure {

	
	//knows
	public Sprite structure = new Sprite();
	
	

	
	int currentProgress = 0;
	
	Texture livingTexture;
	Texture buildingTexture;
	Texture deadTexture;
	
	
	Texture [] progressTextures = {buildingTexture, livingTexture};
	int progressAmount = progressTextures.length;
	
	int buildDuration;
	int importance;
	int HP;
	int faction;
	
	
	
	int x,y;
	public String coordinates = x +"_"+ y; 
	
	
	Thread passiveThread;
	public boolean doneBuilding = false;
	
	
	//does
	public void build(){ 
		
		
		if(currentProgress == 0){
			System.out.println("BUILDING ADDED TO FACTION "+faction);
			Storage.unfinishedStructures[faction].add(0,this);
			
		}
		
		if(currentProgress < progressAmount){
			try {
				if(currentProgress != 0)Thread.sleep(buildDuration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		structure.setTexture(progressTextures[currentProgress++]);
		
		
		}
		if(currentProgress == progressAmount){
			System.out.println("THE BUILDING HAS BEEN BUILT!");
			Storage.unfinishedStructures[faction].remove(this);
			passive();
			doneBuilding = true;
		}
		
		
		
		
	}
    void setPosition(){
    	structure.setPosition(x, y);
    }
    void passive(){
    	if(passiveThread!=null)
    	passiveThread.run();
    	
    }

    
    
    
    
	
}
