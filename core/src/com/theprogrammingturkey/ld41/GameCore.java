package com.theprogrammingturkey.ld41;

import com.badlogic.gdx.Game;
import com.theprogrammingturkey.ld41.rendering.GameScreen;
import com.theprogrammingturkey.volatiliajava.task.Scheduler;

public class GameCore extends Game {

	@Override
	public void create() {
		super.setScreen(new GameScreen());
	}

	@Override
	public void render() {
		Scheduler.tickSyncTasks();
		super.render();
	}

	@Override
	public void dispose() {

	}
}
