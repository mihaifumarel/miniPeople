package ro.CensLabs.miniPeople.Structure;



import ro.CensLabs.miniPeople.Stocks.BuildingCount;
import ro.CensLabs.miniPeople.Stocks.ResourceStocks;
import ro.CensLabs.miniPeople.Utils.Constants;
import ro.CensLabs.miniPeople.Utils.Storage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class Quarry extends Structure{
	
	
	
	

	
	
	
	public Quarry(int x, int y, final int factionID){
		setValues(x,y);
		setPosition();
		build();
		faction = factionID;
		BuildingCount.quarryCount[factionID]++;
		System.out.println("BUILDING ADDED TO FACTION "+faction);
		Storage.unfinishedStructures[faction].add(0,this);
		//passive
		
		passiveThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				ResourceStocks.stoneMultiplier[factionID] = ResourceStocks.stoneMultiplier[factionID] + 1; 
			}
		});
		
		
		
	}
	void setValues(int x, int y){
		livingTexture = new Texture("Structures/quarry_living.png");
		buildingTexture = new Texture("Structures/quarry_red_building.png");
		deadTexture = new Texture("misc/Structure_Default_Dead.png");
		coordinates = x +"_"+ y;
		progressTextures = new Texture[2];
		progressTextures[0] = new Texture("Structures/quarry_red_building.png");
		progressTextures[1] = new Texture("Structures/quarry_living.png");

	
		buildDuration = 100;
		progressAmount = progressTextures.length;
		structure = new Sprite(buildingTexture);
		
		this.x = x;
		this.y = y;
		
		
		
	}

}
