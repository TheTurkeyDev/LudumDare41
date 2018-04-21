package com.theprogrammingturkey.ld41.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Renderer {

	private static SpriteBatch batch;
	private static OrthographicCamera cam;

	public static void init() {
		batch = new SpriteBatch();
		cam = new OrthographicCamera();

		cam.setToOrtho(false, 320, 240);
		cam.position.set(cam.viewportWidth / 2, cam.viewportHeight / 2, 0);

		cam.update();
	}

	public static void begin() {
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
	}

	public static void draw(Renderable renderable, float delta) {
		if (batch.isDrawing()) {
			renderable.getSprite(delta).draw(batch);
		}
	}

	public static void end() {
		batch.end();
	}

	public static void dispose() {
		batch.dispose();
	}

	public static TextButton getCustomButton(String text) {
		BitmapFont font = new BitmapFont();
		Skin skin = new Skin();
		TextureAtlas buttonAtlas = new TextureAtlas(
				Gdx.files.internal("ui_components/ButtonPack.txt"));
		skin.addRegions(buttonAtlas);
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.font = font;
		textButtonStyle.up = skin.getDrawable("ButtonNormal");
		textButtonStyle.down = skin.getDrawable("ButtonSelected");
		textButtonStyle.checked = skin.getDrawable("ButtonChecked");
		return new TextButton(text, textButtonStyle);
	}
}
