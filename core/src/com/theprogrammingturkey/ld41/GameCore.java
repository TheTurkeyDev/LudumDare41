package com.theprogrammingturkey.ld41;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.theprogrammingturkey.ld41.screens.MainScreen;
import com.theprogrammingturkey.volatiliajava.task.Scheduler;

public class GameCore extends Game {

    @Override
    public void create() {
        super.setScreen(new MainScreen(this));
    }

    @Override
    public void render() {
        Scheduler.tickSyncTasks();
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        super.render();
    }

    @Override
    public void dispose() {

    }
}
