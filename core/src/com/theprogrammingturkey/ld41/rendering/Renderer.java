package com.theprogrammingturkey.ld41.rendering;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Renderer {

	private static SpriteBatch batch = new SpriteBatch();
	private static OrthographicCamera cam = new OrthographicCamera();
	private static Texture spriteSheet = new Texture("guys.png");
	
	public static void init() {
		cam.setToOrtho(false, 320, 240);
		cam.position.set(cam.viewportWidth/2, cam.viewportHeight/2, 0);
		cam.update();
	}

	public static void startBatch() {
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
	}

	public static void endBatch() {
		batch.end();
	}

	public static void drawSprite(Sprite sprite) {
		sprite.draw(batch);
	}

	public static TextureRegion createTextureRegion(int x, int y, int w,
			int h) {
		return new TextureRegion(spriteSheet, x, y, w, h);
	}

	public static Sprite createSprite(int x, int y, int w, int h) {
		return new Sprite(spriteSheet, x, y, w, h);
	}

	public static Animation<TextureRegion> createAnimation(float animTime,
			int[] textureRegionData) {
		int numOfFrames = textureRegionData.length / 4;

		if (numOfFrames == 0) {
			System.err.println("NO DATA HERE");
			return null;
		}

		TextureRegion[] frames = new TextureRegion[numOfFrames];
		for (int i = 0; i < numOfFrames; i++) {
			frames[i] = createTextureRegion(textureRegionData[(i * 4)],
					textureRegionData[(i * 4) + 1],
					textureRegionData[(i * 4) + 2],
					textureRegionData[(i * 4) + 3]);
		}
		Animation<TextureRegion> animation = new Animation<TextureRegion>(
				animTime, frames);
		animation.setPlayMode(PlayMode.LOOP);

		return animation;
	}

}
