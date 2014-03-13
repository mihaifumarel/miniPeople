package ro.CensLabs.miniPeople.Utils;

import ro.CensLabs.miniPeople.Cortex.ResourceAssignCortex;
import ro.CensLabs.miniPeople.Stocks.BuildingCount;

public class Formulas {

	
	public static int speedFormula(int speed){

		return 10 * (10/speed);
		
	}
	
	public static int structureMetaScore(int ID, buildingData structure){
		
		int structureIndex = structure.ordinal();
		int structureCount = 0;
		
		
		
		
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
		
		
		
		
		
		
		ResourceData resource = null;
		
		
		int aggressionModifier = ResourceAssignCortex.aggresiveRatio[ID];   //defensive and aggressive ratios
		int defensiveModifier = ResourceAssignCortex.defensiveeRatio[ID];
		
		int woodCost = structure.woodCost;   //building costs
		int stoneCost = structure.stoneCost;
		int metalCost = structure.metalCost;
		int goldCost = structure.goldCost;
		
		int aggressiveImportance = structure.aggressiveMeta;
		int defensiveImportance = structure.defensiveMeta;
		
		int avarageCost =( ( resource.wood.importance * structure.woodCost ) + ( resource.stone.importance * structure.stoneCost ) + 
				( resource.metal.importance * structure.metalCost ) + ( resource.gold.importance * structure.goldCost ) ) / 4;   //the avarage cost of the building, taking in account the importance of resources
		int formula = (((aggressionModifier * aggressiveImportance) + (defensiveImportance * defensiveModifier))*1000)/(avarageCost*(structureCount+1));  //the avarage meta taking in account the importance of the building for the specific team as well as the avarage resource consumption
		
		
		
		
		
		
		return formula;
		
		
		
		
	}
	
	
}
