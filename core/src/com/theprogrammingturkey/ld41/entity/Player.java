package com.theprogrammingturkey.ld41.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.theprogrammingturkey.ld41.collision.Box2DUtil;
import com.theprogrammingturkey.ld41.levels.Layer;
import com.theprogrammingturkey.ld41.levels.LevelManager;
import com.theprogrammingturkey.ld41.levels.tiles.Tile;
import com.theprogrammingturkey.volatiliajava.math.Vector2F;

public class Player extends Entity {
	private Sprite sprite;
	private boolean jumped = false;
	
	private Body body;
	
	public Player() {
		super(null, 0, 0);
		sprite = new Sprite(
				new Texture(Gdx.files.internal("entities/Player.png")));
		body = Box2DUtil.createBoxBody(0, 160, 16, 16, BodyType.DynamicBody, 0);
	}

	public void setLocation(Layer layer, int x, int y) {
		super.layer = layer;
		super.pos = new Vector2F(x, y);
	}

	public void setLayer(Layer layer) {
		super.layer = layer;
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
			velTemp = velocity.sub(0, .5);
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
		} else if (pos.getX() > (layer.getWidth() * Tile.WIDTH) - 16) {
			pos.setX((layer.getWidth() * Tile.WIDTH) - 16);
		}
	}

	@Override
	public Body getBody() {
		return body;
	}
}
