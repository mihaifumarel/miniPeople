package ro.CensLabs.miniPeople.Utils;
import ro.CensLabs.Screen.*;
import ro.CensLabs.miniPeople.Stocks.ResourceStocks;
public class UIControl {

	public static void updateUI(){
		
		UI.blue_gold.setText(ResourceStocks.goldStock[2]+"");
		UI.blue_metal.setText(ResourceStocks.metalStock[2]+"");
		UI.blue_stone.setText(ResourceStocks.stoneStock[2]+"");
		UI.blue_wood.setText(ResourceStocks.woodStock[2]+"");
		UI.red_gold.setText(ResourceStocks.goldStock[1]+"");
		UI.red_metal.setText(ResourceStocks.metalStock[1]+"");
		UI.red_stone.setText(ResourceStocks.stoneStock[1]+"");
		UI.red_wood.setText(ResourceStocks.woodStock[1]+"");
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
