package ro.CensLabs.miniPeople.Tweening;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Tweening implements TweenAccessor<Sprite> {

	
	
	public static final int ALPHA = 0;
	public static final int XY = 1;
	@Override
	public int getValues(Sprite target, int tweenType, float[] returnValues) {
		switch(tweenType){
		case ALPHA:  
			returnValues[0] = target.getColor().a;
			return 1;
		case XY:
			returnValues[0] = target.getX();
			returnValues[1] = target.getY();
			return 2;
			
			
		
		}
		return 0;
	}

	@Override
	public void setValues(Sprite target, int tweenType, float[] newValues) {
		switch (tweenType) {
		case ALPHA:
			target.setColor(target.getColor().r, target.getColor().g, target.getColor().b, newValues[0]);
			break;
		case XY:
			target.setPosition(newValues[0], newValues[1]);
	
		}
		
		
		
	}

}
