package com.theprogrammingturkey.ld41.screens;

import com.badlogic.gdx.Screen;
import com.theprogrammingturkey.ld41.entity.Player;
import com.theprogrammingturkey.ld41.levels.LevelManager;
import com.theprogrammingturkey.ld41.rendering.Renderer;

public class GameScreen implements Screen {
	public static final Player player = new Player();

	public GameScreen() {
		initLevel();
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

	private void initLevel() {
		LevelManager.setCurrentLevel("Tutorial");
		LevelManager.getCurrentLevel().init();
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
