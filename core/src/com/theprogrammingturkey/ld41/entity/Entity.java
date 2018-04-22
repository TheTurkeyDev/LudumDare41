package com.theprogrammingturkey.ld41.entity;

import com.theprogrammingturkey.ld41.levels.Layer;
import com.theprogrammingturkey.ld41.rendering.Renderable;
import com.theprogrammingturkey.volatiliajava.math.Vector2F;

public abstract class Entity implements Renderable {
	protected Layer layer;

	protected Vector2F pos;
	protected Vector2F velocity;

	private boolean isAlive;

	public Entity(Layer layer, int x, int y) {
		this.layer = layer;
		pos = new Vector2F(x, y);
		velocity = new Vector2F(0, 0);
		isAlive = true;
	}

	public int getX() {
		return this.pos.getX().intValue();
	}

	public int getY() {
		return this.pos.getY().intValue();
	}

	public void update() {

	}

	public boolean isAlive() {
		return this.isAlive;
	}
}
