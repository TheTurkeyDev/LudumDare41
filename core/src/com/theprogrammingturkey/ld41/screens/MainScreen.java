package com.theprogrammingturkey.ld41.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.theprogrammingturkey.ld41.rendering.Renderer;

public class MainScreen implements Screen {

	private TextButton start;
	private Stage stage;

	public MainScreen(Game game) {
		start = Renderer.getCustomButton("Start");
		start.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new GameScreen());
				dispose();
			}
		});

		stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight()));
		Gdx.input.setInputProcessor(stage);
		Table table = new Table();
		table.setFillParent(true);
		table.center().center();
		stage.addActor(table);
		table.add(start);
		table.row();
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		stage.act(delta);
		stage.draw();
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
		stage.dispose();
	}

}
