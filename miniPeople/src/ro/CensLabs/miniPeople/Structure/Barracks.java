package ro.CensLabs.miniPeople.Structure;



import ro.CensLabs.miniPeople.Stocks.BuildingCount;
import ro.CensLabs.miniPeople.Stocks.ResourceStocks;
import ro.CensLabs.miniPeople.Utils.Constants;
import ro.CensLabs.miniPeople.Utils.Storage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class Barracks extends Structure{
	
	
	
	

	
	
	
	public Barracks(int x, int y, final int factionID){
		setValues(x,y);
		setPosition();
		build();
		faction = factionID;
		BuildingCount.barrackCount[factionID]++;
		Storage.unfinishedStructures[faction].add(0,this);
		//passive
		
		
		
		
		
	}
	void setValues(int x, int y){
		livingTexture = new Texture("Structures/barracks-living.png");
		buildingTexture = new Texture("Structures/barracks-building.png");
		deadTexture = new Texture("misc/Structure_Default_Dead.png");
		coordinates = x +"_"+ y;
		progressTextures = new Texture[6];
		progressTextures[0] = new Texture("Structures/barracks-1.png");
		progressTextures[1] = new Texture("Structures/barracks-2.png");
		progressTextures[2] = new Texture("Structures/barracks-3.png");
		progressTextures[3] = new Texture("Structures/barracks-4.png");
		progressTextures[4] = new Texture("Structures/barracks-5.png");
		progressTextures[5] = new Texture("Structures/barracks-6.png");
		
		buildDuration = 1000;
		progressAmount = progressTextures.length;
		structure = new Sprite(buildingTexture);
		
		this.x = x;
		this.y = y;
		
		
		
	}

}
