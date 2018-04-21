package com.theprogrammingturkey.ld41.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameScreen implements Screen{
	
	Sprite testSprite;

	@Override
	public void show() {
		testSprite = Renderer.createSprite(0,0,100,100);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
		
		Renderer.startBatch();
		
		testSprite.setRegion(testSprite.getRegionX()+5, testSprite.getRegionY(), testSprite.getRegionWidth(), testSprite.getRegionHeight());
		
		Renderer.drawSprite(testSprite);
		
		Renderer.endBatch();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}
