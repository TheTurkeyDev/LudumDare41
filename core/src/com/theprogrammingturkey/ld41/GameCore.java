package com.theprogrammingturkey.ld41;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.theprogrammingturkey.ld41.rendering.Renderer;
import com.theprogrammingturkey.ld41.screens.TestScreen;
import com.theprogrammingturkey.volatiliajava.task.Scheduler;

public class GameCore extends Game {

	@Override
	public void create() {
		Renderer.init();
		super.setScreen(new TestScreen());
	}

	@Override
	public void render() {
		Scheduler.tickSyncTasks();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

		Renderer.begin();
		super.render();
		Renderer.end();
	}

	@Override
	public void dispose() {
		Renderer.dispose();
	}
}
