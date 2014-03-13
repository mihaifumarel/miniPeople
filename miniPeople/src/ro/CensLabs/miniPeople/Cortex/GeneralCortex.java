package ro.CensLabs.miniPeople.Cortex;

import java.util.ArrayList;

import ro.CensLabs.miniPeople.Stocks.BuildingSchedule;
import ro.CensLabs.miniPeople.Stocks.ResourceStocks;
import ro.CensLabs.miniPeople.Structure.Structure;
import ro.CensLabs.miniPeople.Utils.Constants;
import ro.CensLabs.miniPeople.Utils.Storage;

public final class GeneralCortex {

	
	
	public static final void startCortex() throws Exception{ //starts every cortex 
		
		
		
		ResourceStocks stocks = new ResourceStocks();
		ResourceAssignCortex.assign();  //assign resource disposal ratios
		BuildingSchedule.initializeArray(); //initializes the building array
		
		for(int i = 0; i < Constants.factionCount; i++){
			
			Storage.unfinishedStructures[i] = new ArrayList<Structure>();
			
			
		}
		
		
		
		
		//CANNOT BE INITIALIZED RIGHT AWAY!
		

		Thread.sleep(4000);
		BuildingScheduleCortex.initializeCortex();
		LoopingEvents loopingEventCortex = new LoopingEvents();
		System.out.println("sup");
		VisualCortex.initCortex();
		
		
		
		
		
	}
	
	
}
