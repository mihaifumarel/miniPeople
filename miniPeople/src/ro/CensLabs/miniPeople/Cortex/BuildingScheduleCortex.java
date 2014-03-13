package ro.CensLabs.miniPeople.Cortex;

import ro.CensLabs.miniPeople.Stocks.BuildingSchedule;
import ro.CensLabs.miniPeople.Stocks.ResourceStocks;
import ro.CensLabs.miniPeople.Utils.BuildingTimer;
import ro.CensLabs.miniPeople.Utils.Constants;
import ro.CensLabs.miniPeople.Utils.Formulas;
import ro.CensLabs.miniPeople.Utils.buildingData;

public class BuildingScheduleCortex {

	
	public static void initializeCortex(){
		
		for(int i = 1; i < Constants.factionCount; i ++){
			Scheduling(i);
		}
		
		
		
	}
	
	
	public static  void Scheduling (final int ID){  //ID is the faction ID
		
		final ResourceStocks stocks = null;
		
		final BuildingTimer timer = new BuildingTimer();
		
		
		
		Thread process = new Thread(new Runnable() {

			
			
			
			@Override
			public void run() {
				
				while(true){
					
					
					
					int buildingMeta = 0;
					int currentMeta = 0;
					buildingData chosenBuilding = null;
					buildingData bestChoice = null;
					

					
					for(buildingData structure : buildingData.values()){
						
						if(structure.woodCost <= stocks.woodStock[ID] && structure.stoneCost <= stocks.stoneStock[ID]
						&& structure.metalCost <= stocks.metalStock[ID] && structure.goldCost <= stocks.goldStock[ID]
						)
						
						//This means that you can afford building the structure AND that the building is NOT on cooldown
							
						{
							
							if(timer.ready[structure.ordinal()]==false) continue;
							currentMeta = Formulas.structureMetaScore(ID, structure);
							
							if(currentMeta > buildingMeta){
								buildingMeta = currentMeta;
								chosenBuilding = structure;
								
							}
							
							
							
							
							
							
						}
						
						
						else{ continue; } //cant afford, skip
					}
					
					bestChoice = chosenBuilding;
				
					try {
					if(bestChoice!=null && !BuildingSchedule.schedule[ID].contains(bestChoice)){
						try{
							System.out.println("BEST CHOICE "+bestChoice.toString());
							}catch(Exception e){}
						BuildingSchedule.schedule[ID].add(0,bestChoice);
					
						ResourceStocks.stoneStock[ID] = ResourceStocks.stoneStock[ID] - bestChoice.stoneCost;
						ResourceStocks.woodStock[ID] = ResourceStocks.woodStock[ID] - bestChoice.woodCost;
						ResourceStocks.metalStock[ID] = ResourceStocks.metalStock[ID] - bestChoice.metalCost;
						ResourceStocks.goldStock[ID] = ResourceStocks.goldStock[ID] - bestChoice.goldCost;
					    timer.startTimer(bestChoice.ordinal(), ID);
						
						
						
						continue;} //best choice added to the schedule
					
					} catch (Exception e) {
						e.printStackTrace();
					} 
					//deducting the resources from the stocks
					
					//PROCESS FINISHED
				
				
				
			}
				
				
				
			}
		});
		
		
		process.run();
		
	}
	
	
}
