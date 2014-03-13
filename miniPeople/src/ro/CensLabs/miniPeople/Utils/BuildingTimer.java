package ro.CensLabs.miniPeople.Utils;

import java.util.Arrays;

import ro.CensLabs.miniPeople.Stocks.BuildingCount;
import ro.CensLabs.miniPeople.Structure.Structure;


public class BuildingTimer {

	
	
	
	int structureCount = 0;
	public boolean ready [] = new boolean[buildingData.values().length];
	

	
	
	public BuildingTimer(){
		Arrays.fill(ready, Boolean.TRUE);
	}
	
	
	
	public void startTimer(final int index, int factionID){
		
		
		
		buildingData structure = buildingData.values()[index];
		int structureIndex = structure.ordinal();
		
		int ID = factionID;
		
		
		
		switch (structureIndex) {
		case 0:
			structureCount = BuildingCount.quarryCount[ID];
			
			break;

		case 1:
			structureCount = BuildingCount.lumberCount[ID];
			
			break;
		case 2:
			structureCount = BuildingCount.barrackCount[ID];
			
			break;
		case 3:
			structureCount = BuildingCount.gardenCount[ID];
			
			break;
		case 4:
			structureCount = BuildingCount.smeltryCount[ID];
			
			break;
		case 5:
			structureCount = BuildingCount.alchemistCount[ID];
			
			break;
		case 6:
			structureCount = BuildingCount.templeCount[ID];
			
			break;
		case 7:
			structureCount = BuildingCount.outpostCount[ID];
			
			break;
		default:
			break;
		}
		
		
		
		
		ready[index] = false;
		final int cooldown = buildingData.values()[index].cooldown;
		
		System.out.println("STARTED TIMER FOR INDEX "+index);
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i = cooldown; i > 0; i --){
					try {
						Thread.sleep(1000 + (1000*structureCount));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				ready[index] = true;
				structureCount = 0;
				System.out.println("ENDED TIMER FOR INDEX "+index);
			}
		});
		
		t.run();
	}
	
}
