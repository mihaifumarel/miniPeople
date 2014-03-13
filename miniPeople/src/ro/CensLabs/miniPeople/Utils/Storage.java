package ro.CensLabs.miniPeople.Utils;

import java.util.ArrayList;

import ro.CensLabs.Screen.gameScreen;
import ro.CensLabs.miniPeople.Planting.Resource;
import ro.CensLabs.miniPeople.Planting.stonePlanting;
import ro.CensLabs.miniPeople.Planting.woodPlanting;
import ro.CensLabs.miniPeople.Structure.Structure;
import aurelienribon.tweenengine.TweenManager;

public class Storage {

	static ArrayList<String> woodLocations = new ArrayList<String>();
	static ArrayList<String> stoneLocations = new ArrayList<String>();
	static ArrayList<String> resourceLocations = new ArrayList<String>();
	
	
	static ArrayList <woodPlanting> woodObjects = new ArrayList <woodPlanting>();
	static ArrayList <stonePlanting> stoneObjects = new ArrayList <stonePlanting>();
	public static ArrayList <Resource> resourceObjects = new ArrayList <Resource>();
	
	public static TweenManager humanManager = new TweenManager();
    public static ArrayList<Structure> unfinishedStructures[] = new ArrayList[Constants.factionCount];
	
	
	

	
	
	
	
	
	public static void addStone(String coordinates){
		stoneLocations.add(coordinates);
	}
	public static void addWood(String coordinates){
		woodLocations.add(coordinates);
	}
	public static void addResource(String coordinates){
		resourceLocations.add(coordinates);
	}
    public static String[] getWoodLocations(){
    	String[] string = (String[]) woodLocations.toArray();
    	return string;
    }
    public static String[] getStoneLocations(){
    	String[] string = (String[]) stoneLocations.toArray();
    	return string;
    }
    public static String[] getResourceLocations(){
    	String string[] = new String[resourceLocations.size()];
    	for(int i = 0; i < string.length; i ++){
    		string[i] = resourceLocations.get(i).toString();
    	}
    	return string;
    }
    public static woodPlanting[] getWoodObjects(){
    	woodPlanting[] toReturn = (woodPlanting[])woodObjects.toArray();
    	return toReturn;
    }
    public static Resource[] getResourceObjects(){
    	Resource res[] = new Resource[resourceObjects.size()];
    	for(int i = 0; i < res.length; i ++){
    		try{
    		res[i] = resourceObjects.get(i);
    		}catch(Exception e){}
    	}
    	return res;
    	
    }
    
    //updaters
    
    public static void updateResourceObjectArrays(){
  	    woodObjects = gameScreen.getWoodObjects();
  	    resourceObjects.removeAll(woodObjects);
  	    stoneObjects = gameScreen.getStoneObjects();
  	    resourceObjects.removeAll(stoneObjects);
  	    //update stone stuff here
  	    resourceObjects.addAll(woodObjects);
  	  resourceObjects.addAll(stoneObjects);
			
		}
    
	//removers
    
    public static void removeResource(Resource resource){
    	resourceObjects.remove(resource);
    	resourceLocations.remove(resource.getCoordinates());
    }
    	
    
    
    
    
}
