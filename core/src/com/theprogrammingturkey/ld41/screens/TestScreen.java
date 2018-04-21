package com.theprogrammingturkey.ld41.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.theprogrammingturkey.ld41.levels.Layer;
import com.theprogrammingturkey.ld41.levels.Level;
import com.theprogrammingturkey.ld41.levels.LevelManager;
import com.theprogrammingturkey.ld41.rendering.Renderer;
import com.theprogrammingturkey.ld41.rendering.models.AnimatedSpriteModel;
import com.theprogrammingturkey.ld41.rendering.models.SpriteModel;

public class TestScreen implements Screen {

	private static final Texture GUY = new Texture("guys.png");

	private AnimatedSpriteModel testSprite;
	Level level1;

	public TestScreen() {
		initLevels();
		initSprite();
	}

	private void initLevels() {
		level1 = new Level();
		level1.addLayer(new Layer(20, 15));
		LevelManager.registerLevel("Random", level1);
		LevelManager.setCurrentLevel("Random");
	}

	private void initSprite() {
		Array<SpriteModel> sprites = new Array<>(true, 4);

		int x = 0;
		final int y = 0;
		final int width = 16;
		final int height = 16;
		for (int i = 0; i < 4; i++) {
			Sprite sprite = new Sprite(GUY, x + (width * i), y, width, height);
			sprite.setX(100);
			sprite.setY(100);
			sprite.scale(5);
			SpriteModel spriteModel = new SpriteModel(sprite);
			sprites.add(spriteModel);
		}
		Animation<SpriteModel> animation = new Animation<>(0.1f, sprites);
		animation.setPlayMode(Animation.PlayMode.LOOP);

		testSprite = new AnimatedSpriteModel(animation);
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

		Renderer.draw(testSprite, delta);

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
