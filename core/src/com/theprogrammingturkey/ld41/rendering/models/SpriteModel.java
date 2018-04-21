package com.theprogrammingturkey.ld41.rendering.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.theprogrammingturkey.ld41.rendering.Renderable;

public class SpriteModel implements Renderable {

	private Sprite sprite;

	public SpriteModel(Sprite sprite) {
		this.sprite = sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public Sprite getSprite(float delta) {
		return sprite;
	}
}
