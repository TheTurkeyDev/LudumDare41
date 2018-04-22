package com.theprogrammingturkey.ld41.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.theprogrammingturkey.ld41.levels.Layer;
import com.theprogrammingturkey.ld41.levels.tiles.Tile;
import com.theprogrammingturkey.volatiliajava.math.Vector2F;

public class Player extends Entity {
	private Sprite sprite;
	private boolean jumped = false;
	public Player(Layer layer, int x, int y) {
		super(layer, x, y);
		sprite = new Sprite(
				new Texture(Gdx.files.internal("entities/Player.png")));
	}

	@Override
	public Sprite getSprite(float delta) {
		sprite.setPosition(super.getX(), super.getY());
		return sprite;
	}

	public void update() {
		Vector2F velTemp;
		if (Gdx.input.isKeyPressed(Input.Keys.UP) && !jumped) {
			velTemp = velocity.add(0, 3);
			jumped = true;
		} else {
			velTemp = velocity.sub(0, 0.1);
		}
		Vector2F posTemp = pos.addVector(velTemp);

		if (!layer.getTile((int) (posTemp.getX() / Tile.WIDTH),
				(int) (posTemp.getY() / Tile.HEIGHT)).isSolid()) {
			velocity = velTemp;
		} else {
			velocity.setY(0);
			jumped = false;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			velocity.addU(.25, 0);
		} else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			velocity.addU(-.25, 0);
		} else if (velocity.getX() > 0) {
			velocity.addU(-.1, 0);
		} else if (velocity.getX() < 0) {
			velocity.addU(.1, 0);
		}

		if (velocity.getX() > 1) {
			velocity.setX(1);
		} else if (velocity.getX() < -1) {
			velocity.setX(-1);
		} else if (Math.abs(velocity.getX()) < .1) {
			velocity.setX(0);
		}

		pos.addVectorU(velocity);

		if (pos.getX() < 0) {
			pos.setX(0);
		} else if (pos.getX() > 300) {
			pos.setX(300);
		}
	}
}
