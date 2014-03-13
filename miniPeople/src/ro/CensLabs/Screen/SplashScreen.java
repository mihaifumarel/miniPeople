package ro.CensLabs.Screen;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap.Filter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ro.CensLabs.miniPeople.miniPeople;
import ro.CensLabs.miniPeople.Tweening.*;


public class SplashScreen implements Screen {
    
	Texture logo;
	Sprite sprite;
	SpriteBatch batch;
	Texture logo2;
	Sprite sprite2;
	TweenManager manager;
	Sprite sprite3;
	Texture intro;

	miniPeople game;
	public SplashScreen(miniPeople game){
	this.game = game;
	}
	
	@Override
	public void render(float delta) {
		
		 Gdx.gl.glClearColor(0, 0, 0, 1);  //YOU NEED THIS STUFF TO CLEAR STUFF FROM THE SCREEn
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		manager.update(delta);
		batch.begin();
		sprite.draw(batch);
		sprite2.draw(batch);

		batch.end();
		

	}

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void show() {
		
	logo = new Texture("data/mini.png");
	logo2 = new Texture("data/people.png");
	
	sprite = new Sprite(logo);
	
	sprite2 = new Sprite(logo2);

    batch = new SpriteBatch();	
    
    manager = new TweenManager();
    Tween.registerAccessor(Sprite.class, new Tweening());  //tweenaccesor se ocupa de animatii. In acea clasa ii spui cum sa se ocupe de anumite obiecte. Ca sa spui - "accesoru asta se ocupa de obiectele astea" folosesti register.
    
    
    sprite.setOrigin(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
    sprite.setPosition(Gdx.graphics.getWidth()/25, Gdx.graphics.getHeight()/5);
    sprite2.setOrigin(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
    sprite2.setPosition(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/5);

    
    Tween.set(sprite, Tweening.ALPHA).target(0).start(manager); // pentru ca de clasa sprite se ocupa accesoru facut mai devreme, acesta va prelua valorile. a doua valoare functioneaza ca un switch, sau ca un ID. La fel ca in minipeople, cand selectezi un behavior id. In functie de ce numar alegi, primesti o anumita functie 
    Tween.to(sprite, Tweening.ALPHA, 2).target(1).start(manager); //targetul 0 e alphaul de la inceput iar 1 e cel de la sfarsit, peste 2 secunde
    Tween.to(sprite, Tweening.ALPHA, 2).target(0).delay(3).start(manager);
		
    Tween.set(sprite2, Tweening.ALPHA).target(0).start(manager); 
    Tween.to(sprite2, Tweening.ALPHA, 2).target(1).delay(1).start(manager);
    Tween.to(sprite2, Tweening.ALPHA, 2).target(0).delay(3).setCallback(new TweenCallback() {

		@Override
		public void onEvent(int type, BaseTween<?> source) {
			
			
			game.setScreen(new gameScreen(game));
			
		}
    	
    	
    	
    }).setCallbackTriggers(TweenCallback.COMPLETE).start(manager);
   
    
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void pause() {
	
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
		
	}

}
