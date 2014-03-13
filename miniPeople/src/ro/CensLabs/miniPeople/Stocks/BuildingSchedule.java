package ro.CensLabs.miniPeople.Stocks;

import java.util.ArrayList;

import ro.CensLabs.miniPeople.Utils.Constants;
import ro.CensLabs.miniPeople.Utils.buildingData;

public class BuildingSchedule {

	
	public static ArrayList schedule [] = new ArrayList[Constants.factionCount];
	
	public static void initializeArray(){
		
		for(int i = 0; i < Constants.factionCount; i ++){
			
			schedule[i] = new ArrayList<buildingData>();
			
		}
		
		
		
	}
	
	
	
	
}
