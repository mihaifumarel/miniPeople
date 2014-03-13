package ro.CensLabs.Screen;
import java.util.ArrayList;

import ro.CensLabs.Humans.Red_Builder;
import ro.CensLabs.Humans.Red_Gatherer;
import ro.CensLabs.miniPeople.miniPeople;
import ro.CensLabs.miniPeople.AI.Locations;
import ro.CensLabs.miniPeople.Cortex.GeneralCortex;
import ro.CensLabs.miniPeople.Planting.GenerateForest;
import ro.CensLabs.miniPeople.Planting.stonePlanting;
import ro.CensLabs.miniPeople.Planting.woodPlanting;
import ro.CensLabs.miniPeople.Structure.RandomHut;
import ro.CensLabs.miniPeople.Structure.RedFort;
import ro.CensLabs.miniPeople.Structure.Structure;
import ro.CensLabs.miniPeople.Utils.Constants;
import ro.CensLabs.miniPeople.Utils.Storage;
import ro.CensLabs.miniPeople.Utils.utilMethods;
import ro.CensLabs.miniPeople.Visuals.Cloud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class gameScreen implements Screen {

	SpriteBatch batch;
	miniPeople game;
	GenerateForest forest = new GenerateForest();
	
	public static ArrayList <woodPlanting> woodObjects = new ArrayList <woodPlanting>();
	public static ArrayList <stonePlanting> stoneObjects = new ArrayList <stonePlanting>();
	
	
	
	int woodCount = Constants.initialWood;
	int stoneCount = Constants.initialStone;
	Texture backGroundTexture;
	Sprite BackGroundSprite;
	RedFort redFort;
	Locations locationsOb;
	
	public static ArrayList <Red_Gatherer> RedGathererObjects = new ArrayList <Red_Gatherer>();
	public static ArrayList <Red_Builder> RedBuilderObjects = new ArrayList <Red_Builder>();
	int redGathererCount = 3;
	int redBuilderCount = 1;
	
	public static ArrayList <Structure> toBuild = new ArrayList<Structure>(); //specifically made ofr buildings
	public static ArrayList <Sprite> toDrawLower = new ArrayList<Sprite>(); //made for everything else on the LOWER level
	public static ArrayList <Sprite> toDrawUpper = new ArrayList<Sprite>(); //made for everything else on the UPPER level
	
	
public gameScreen(miniPeople game){
	this.game = game;
}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		batch.begin();
		BackGroundSprite.draw(batch);
		drawForest(batch);
		
        drawWood(batch);
        drawStone(batch);
        

        for(Sprite sprite : toDrawLower){
			sprite.draw(batch);
		}
		redFort.structure.draw(batch);
		
		for(Structure struct : toBuild){
			if(struct.structure != null)
			struct.structure.draw(batch);
		}
		

		for(Sprite sprite : toDrawUpper){
			sprite.draw(batch);
		}
		
		batch.end();

		
			
	}

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void show() {
 

		Thread cortex = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					GeneralCortex.startCortex();
				} catch (Exception e) {
					
					e.printStackTrace();
				}				
			}
		});
		
		cortex.start();
		
		
		
		//misc objects for constructors
		locationsOb = new Locations();
		
		
		backGroundTexture = new Texture("data/background.png"); //Background stuff
		BackGroundSprite = new Sprite(backGroundTexture);
		
		
		
		
		//planting wood
		
		plantWood();
		
		
		
		
		//planting stone
		
		plantStone();
		
		
		//spawn human
		redFort = new RedFort();
		spawnRedGatherer();
		spawnRedBuilder();
		
		Storage.updateResourceObjectArrays();
		
		
		
		
		
		
		batch = new SpriteBatch();
	
	
	}
	

	@Override
	public void hide() {
		
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void dispose() {
		
		
	}
	
	//TODO COPY THIS STUFF FOR OTHER TYPES OF RESOURCES
	private void plantWood(){  
		
		int forestCount = forest.forestAmount;
		int woodPerForest = woodCount/forestCount;
		
		for(int j = 0; j < forestCount; j++){
		for(int i = 0; i < woodPerForest; i++){
			
			//get coordinates of the forest
			
			String coordinatesOfForest = forest.forestCoordinates.get(j);
			int xy[] =utilMethods.parseCoordinates(coordinatesOfForest);
			int x = xy[0];
			int y = xy[1];
			int width = (int)forest.forest.get(j).getWidth();
			int height = (int)forest.forest.get(j).getHeight();
			
			woodObjects.add(i,new woodPlanting(x, Constants.width - x - width, y, Constants.height - y - height)); //init object in it's forest
			Storage.addWood(woodObjects.get(i).getCoordinates()); //set coords
			Storage.addResource(woodObjects.get(i).getCoordinates()); //dont forget to add it to the reource pool
		}
		}
	}
    private void drawWood(SpriteBatch batch){
    	
    	
    	
    	
		for(int i = 0; i < woodCount; i++){
			try{
				
			woodObjects.get(i).sprite.draw(batch);
			}catch(Exception e){
				continue;
			}
			
		}
    }
    private void drawForest(SpriteBatch batch){
    	
    	int forestCount = forest.forestAmount;
    	
    	
  		for(int i = 0; i < forestCount; i++){
  			try{
  			forest.forest.get(i).draw(batch);
  			}catch(Exception e){
  				continue;
  			}
  			
  		}
      }
    private void plantStone(){  
		for(int i = 0; i < stoneCount; i++){
			stoneObjects.add(i,new stonePlanting()); //init object
			Storage.addStone(stoneObjects.get(i).getCoordinates()); //set coords
			Storage.addResource(stoneObjects.get(i).getCoordinates()); //dont forget to add it to the reource pool
		}
	}
    private void drawStone(SpriteBatch batch){
		for(int i = 0; i < stoneCount; i++){
			try{
			stoneObjects.get(i).sprite.draw(batch);
			}catch(Exception e){
				continue;
			}
			
		}
    }



    
    
    private void spawnRedGatherer(){  
		for(int i = 0; i < redGathererCount; i++){
			Red_Gatherer human = new Red_Gatherer();
			RedGathererObjects.add(i,human); //init object
			
		}
	}

    
 

    
    private void spawnRedBuilder(){  
		for(int i = 0; i < redBuilderCount; i++){
			Red_Builder human = new Red_Builder();
			RedBuilderObjects.add(i,human); //init object
			
		}
	}
    

    
    
    
    public static void spawnCloud(){
    	Cloud cloud = new Cloud();
    }
    
    
    
    
    
    
    


//getters and setters
    
   public static ArrayList getWoodObjects(){
	   return woodObjects;
   }

   public static ArrayList getStoneObjects(){
	   return stoneObjects;
   }

   public static void addRandomHut(int x, int y){
	   RandomHut randomHut = new RandomHut(x,y);
	   toBuild.add(randomHut);
   }

}
