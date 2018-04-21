package com.theprogrammingturkey.ld41.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.theprogrammingturkey.ld41.levels.Layer;
import com.theprogrammingturkey.ld41.levels.Level;
import com.theprogrammingturkey.ld41.levels.LevelManager;

public class TestScreen implements Screen {

	RenderObject testSprite;
	Level level1;

	@Override
	public void show() {
		Renderer.init();

		level1 = new Level();
		level1.addLayer(new Layer(20, 15));
		LevelManager.registerLevel("Random", level1);
		LevelManager.setCurrentLevel("Random");

		testSprite = new RenderObject();
		testSprite
				.addAnimation("idle",
						Renderer.createAnimation(.1f, new int[]{0, 0, 16, 16,
								16, 0, 16, 16, 0, 0, 16, 16, 32, 0, 16, 16}),
						false);
		testSprite.setAnimation("idle");

		testSprite.getSprite().setX(100);
		testSprite.getSprite().setY(100);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

		testSprite.getSprite().rotate(1);

		Renderer.startBatch();

		LevelManager.getCurrentLevel().draw(delta);

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
