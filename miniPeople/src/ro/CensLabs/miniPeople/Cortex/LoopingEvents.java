package ro.CensLabs.miniPeople.Cortex;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import ro.CensLabs.miniPeople.Utils.UIControl;

public class LoopingEvents {

	
	
	public LoopingEvents(){
		
       loop();
		
	}
	
	private void loop(){
		
		ThreadPoolExecutor fiveSecondLoop;
		fiveSecondLoop = new ThreadPoolExecutor(100, 100, 1800, TimeUnit.SECONDS,
	            new LinkedBlockingQueue<Runnable>());
	    
		fiveSecondLoop.execute(new Runnable() {

	        @Override
	        public void run() {

				while(true){
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					

					UIControl.updateUI();
					
					
					
					
				}
				
				
				
				
				
			}
	    });
		
		
		

	}
	
	
}
