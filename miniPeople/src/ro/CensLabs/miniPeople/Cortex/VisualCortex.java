package ro.CensLabs.miniPeople.Cortex;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;

import ro.CensLabs.Screen.gameScreen;
import ro.CensLabs.miniPeople.Structure.Garden;
import ro.CensLabs.miniPeople.Utils.UIControl;
import ro.CensLabs.miniPeople.Visuals.Cloud;

public class VisualCortex {
	
	public static int cloudCount = 0;
	private final static int maxCloudCount = 5;
	private final static int cloudSpawnRatio = 3;
	
	public static void initCortex(){
		ThreadPoolExecutor tpe;
		tpe = new ThreadPoolExecutor(100, 100, 1800, TimeUnit.SECONDS,
	            new LinkedBlockingQueue<Runnable>());
	    
		tpe.execute(new Runnable() {

	        @Override
	        public void run() {
				while(true){
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
					if(cloudCount < maxCloudCount){
						Random rand = new Random();
						
						if(rand.nextInt(cloudSpawnRatio) == 1){
							 Gdx.app.postRunnable(new Runnable() {
									
									@Override
									public void run() {
										gameScreen.spawnCloud();
									}
								}); 
							
							cloudCount ++;
						}
						
						
					}
					
					
				}
		}
	    });
		
		
		
		
		
	}
	
	

}
