package ro.CensLabs.miniPeople.Structure;



import ro.CensLabs.miniPeople.Stocks.BuildingCount;
import ro.CensLabs.miniPeople.Stocks.ResourceStocks;
import ro.CensLabs.miniPeople.Utils.Constants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class LumberJack extends Structure{
	
	
	
	
	

	
	
	
	public LumberJack(int x, int y, final int factionID){
		setValues(x,y);
		setPosition();
		build();
		faction = factionID;
		BuildingCount.lumberCount[factionID]++;
		
		//passive
		
		passiveThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				ResourceStocks.woodMultiplier[factionID] = ResourceStocks.woodMultiplier[factionID] + 1; 
			}
		});
		
		
		
	}
	void setValues(int x, int y){
		livingTexture = new Texture("Structures/lumberjack.png");
		buildingTexture = new Texture("Structures/lumberjack_building.png");
		deadTexture = new Texture("misc/Structure_Default_Dead.png");
		coordinates = x +"_"+ y;
		progressTextures = new Texture[2];
		progressTextures[0] = new Texture("Structures/lumberjack_building.png");
		progressTextures[1] = new Texture("Structures/lumberjack.png");
		buildDuration = 100;
		structure = new Sprite(buildingTexture);
		
		this.x = x;
		this.y = y;
		
		
		
	}

}
