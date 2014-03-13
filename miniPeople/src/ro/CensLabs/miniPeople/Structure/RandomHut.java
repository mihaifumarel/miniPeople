package ro.CensLabs.miniPeople.Structure;



import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class RandomHut extends Structure{
	
	
	
	
	
	
	
	
	
	public RandomHut(int x, int y){
		setValues(x,y);
		setPosition();
		build();
		
		
	}
	void setValues(int x, int y){
		livingTexture = new Texture("misc/Structure_Default.png");
		buildingTexture = new Texture("misc/Structure_Default_Building.png");
		deadTexture = new Texture("misc/Structure_Default_Dead.png");
		
		buildDuration = 5000;
		structure = new Sprite(buildingTexture);
		
		this.x = x;
		this.y = y;
		
		
		
	}

}
