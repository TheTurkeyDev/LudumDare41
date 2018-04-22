package com.theprogrammingturkey.ld41;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.theprogrammingturkey.ld41.levels.LevelLoader;
import com.theprogrammingturkey.ld41.levels.tiles.TileManager;
import com.theprogrammingturkey.ld41.rendering.Renderer;
import com.theprogrammingturkey.ld41.screens.MainScreen;
import com.theprogrammingturkey.volatiliajava.task.Scheduler;

public class GameCore extends Game {

	@Override
	public void create() {
		TileManager.initTiles();
		LevelLoader.loadLevels();
		Renderer.init();
		super.setScreen(new MainScreen(this));
	}

	@Override
	public void render() {
		Scheduler.tickSyncTasks();
		Gdx.gl.glClearColor(.529f, 0.808f, .922f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Renderer.begin();
		super.render();
		Renderer.end();
	}

	@Override
	public void dispose() {
		Renderer.dispose();
	}
}
