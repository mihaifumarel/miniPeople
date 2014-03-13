package ro.CensLabs.miniPeople.Utils;

public enum buildingData {

	
	quarry(0,15,0,0,0,2,10), lumberhut(15,0,0,0,0,2,10), barracks(30,30,30,0,5,2,60), garden(50,0,0,0,0,5,60), smeltry(0,50,0,0,1,5,90), alchemist(50,50,50,0,2,6,120), temple(100,100,100,300,10,10,360), outpost(30,10,30,0,5,5,40);
	
	
	
	public int woodCost;
	public int stoneCost;
	public int metalCost;
	public int goldCost;
	
	public int aggressiveMeta;
	public int defensiveMeta;
	
	int cooldown;
	buildingData(int wood, int stone, int metal, int gold, int aggressive, int defensive, int cooldown){
		
		
		woodCost = wood;
		stoneCost = stone;
		metalCost = metal;
		goldCost = gold;
		
		aggressiveMeta = aggressive;
		defensiveMeta = defensive;
		
		this.cooldown = cooldown;
	}
	
	
}
