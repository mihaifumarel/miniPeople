package ro.CensLabs.miniPeople.Utils;

public enum ResourceData {

	 wood(12), stone(13), metal(20), gold(35);
	
	 
	 int importance;
	 
	  ResourceData(int importance){
		 this.importance = importance;
	 }
	
}
