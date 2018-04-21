package com.theprogrammingturkey.ld41.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen {

	RenderObject testSprite;

	@Override
	public void show() {
		testSprite = new RenderObject();
		testSprite.addAnimation("idle", Renderer.createAnimation(.1f,new int[] {0,0,16,16,16,0,16,16,0,0,16,16,32,0,16,16}), false);
		testSprite.setAnimation("idle");
		
		testSprite.getSprite().setX(100);
		testSprite.getSprite().setY(100);
		testSprite.getSprite().setScale(10);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		testSprite.getSprite().rotate(1);

		Renderer.startBatch();

		testSprite.draw(delta);

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
