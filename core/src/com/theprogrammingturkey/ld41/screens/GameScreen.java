package com.theprogrammingturkey.ld41.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.theprogrammingturkey.ld41.entity.Player;
import com.theprogrammingturkey.ld41.levels.Layer;
import com.theprogrammingturkey.ld41.levels.Level;
import com.theprogrammingturkey.ld41.levels.LevelManager;
import com.theprogrammingturkey.ld41.levels.tiles.Tile;
import com.theprogrammingturkey.ld41.rendering.Renderer;

public class GameScreen implements Screen {
	private Player player;

	public GameScreen() {
		initLevels();
	}

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		LevelManager.getCurrentLevel().update();

		Renderer.updateCameraScroll(player.getX());
		LevelManager.getCurrentLevel().render(delta);
	}

	private void initLevels() {
		Level level = new Level();
		level.addLayer(new Layer(50, Gdx.graphics.getHeight() / Tile.HEIGHT));
		player = new Player(level.getLayer(0), 0, 200);
		level.getLayer(0).addEntity(player);
		level.addLayer(new Layer(50, Gdx.graphics.getHeight() / Tile.HEIGHT));
		level.addLayer(new Layer(50, Gdx.graphics.getHeight() / Tile.HEIGHT));
		level.addLayer(new Layer(50, Gdx.graphics.getHeight() / Tile.HEIGHT));
		level.addLayer(new Layer(50, Gdx.graphics.getHeight() / Tile.HEIGHT));
		LevelManager.registerLevel("0", level);
		LevelManager.setCurrentLevel("0");
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
