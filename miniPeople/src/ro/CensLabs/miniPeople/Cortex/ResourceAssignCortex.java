package ro.CensLabs.miniPeople.Cortex;

import java.util.Random;

import ro.CensLabs.miniPeople.Utils.Constants;

public class ResourceAssignCortex {

	
	public static int aggresiveRatio [] = new int [Constants.factionCount]; //counts the ratio for every faction
	public static int defensiveeRatio [] = new int [Constants.factionCount];
	
	public static  void assign(){   // call once to assign the aggressive ratios
		
		for (int i = 0; i < Constants.factionCount; i++){
			Random rand = new Random();
			int aggRatio = 0 + rand.nextInt(10);
			aggresiveRatio[i] = aggRatio;
			defensiveeRatio[i] = 10 - aggRatio;
		 
			
		}
		
		
	}
	
	
	
	
}
