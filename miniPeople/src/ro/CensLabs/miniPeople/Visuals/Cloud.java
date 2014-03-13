package ro.CensLabs.miniPeople.Visuals;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import ro.CensLabs.Screen.gameScreen;
import ro.CensLabs.miniPeople.Cortex.VisualCortex;
import ro.CensLabs.miniPeople.Utils.Constants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Cloud {

	Sprite cloud;
	Texture textures[] = {new Texture("enviourment/cloud1.png"),new Texture("enviourment/cloud2.png"),new Texture("enviourment/cloud3.png"),new Texture("enviourment/cloud4.png")};
	int speed;
	
	public Cloud(){
		
		System.out.println("Cloud");
		
		//set up the cloud
		Random rand = new Random();
		cloud = new Sprite(textures[rand.nextInt(4)]);
		speed = 30 + rand.nextInt(200);
		cloud.setPosition(0-cloud.getWidth(),  rand.nextFloat()*(Constants.height - (cloud.getHeight())));
		gameScreen.toDrawUpper.add(cloud);
		
		
		
		//thread
		//THANKS DARKPOOL2000!
		ThreadPoolExecutor tpe;
	    tpe = new ThreadPoolExecutor(100, 100, 1800, TimeUnit.SECONDS,
	            new LinkedBlockingQueue<Runnable>());
	    
	    tpe.execute(new Runnable() {

	        @Override
	        public void run() {
	           
	                try {
	                	
	                	


	    				while(true){
	    					
	    					try {
	    						Thread.sleep(speed);
	    					} catch (InterruptedException e) {
	    						e.printStackTrace();
	    					}
	    					
	    					
	    					cloud.setPosition(cloud.getX()+1, cloud.getY());
	    					if(cloud.getX() >= Constants.width) { gameScreen.toDrawUpper.remove(cloud);
	    					                                     VisualCortex.cloudCount -- ; // cloud disposed, no longer present
	    					                                     break;
	    					}
	    					
	    					
	    				}
	    				
	    			
	                	
	                	
	                } catch (Exception e) {
	                    
	                    e.printStackTrace();
	                
	            }
	        }
	    });
	    
		
		
		
		
		
		
		
		
		
	
		
		
	}
	
	
}
