package ro.CensLabs.miniPeople.Structure;



import ro.CensLabs.miniPeople.Stocks.BuildingCount;
import ro.CensLabs.miniPeople.Stocks.ResourceStocks;
import ro.CensLabs.miniPeople.Utils.Constants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class Garden extends Structure{
	
	
	
	
	
	int factionID;
	
	
	
	public Garden(int x, int y, final int factionID){
		setValues(x,y);
		setPosition();
		build();
		this.factionID = factionID;
		BuildingCount.gardenCount[factionID]++;
		
		//passive
		
		passiveThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					ResourceStocks.woodStock[factionID] = ResourceStocks.woodStock[factionID] ++; 
				}
			}
		});
		
		
		
	}
	void setValues(int x, int y){
		livingTexture = new Texture("Structures/garden_living.png");
		buildingTexture = new Texture("Structures/garden_building.png");
		deadTexture = new Texture("misc/Structure_Default_Dead.png");
		coordinates = x +"_"+ y;
		progressTextures = new Texture[2];
		progressTextures[0] = new Texture("Structures/garden_building.png");
		progressTextures[1] = new Texture("Structures/garden_living.png");
		buildDuration = 1000;
		structure = new Sprite(buildingTexture);
		
		this.x = x;
		this.y = y;
		
		
		
	}

}
