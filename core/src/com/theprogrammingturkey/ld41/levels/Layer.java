package com.theprogrammingturkey.ld41.levels;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.theprogrammingturkey.ld41.entity.Entity;
import com.theprogrammingturkey.ld41.levels.tiles.AirTile;
import com.theprogrammingturkey.ld41.levels.tiles.GrassTile;
import com.theprogrammingturkey.ld41.levels.tiles.GroundTile;
import com.theprogrammingturkey.ld41.levels.tiles.Tile;
import com.theprogrammingturkey.ld41.rendering.Renderer;

public class Layer {

	private Tile[][] tiles;
	private List<Entity> entities = new ArrayList<Entity>();

	private int width;
	private int height;

	private int transitionOffset = 0;
	private boolean transitionOn = true;

	public Layer(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (y > 3) {
					tiles[x][y] = new AirTile(x, y);
				} else if (y == 3) {
					tiles[x][y] = new GrassTile(x, y);
				} else {
					tiles[x][y] = new GroundTile(x, y);
				}
			}
		}
	}

	public List<Tile> getTiles() {
		List<Tile> tilesToReturn = new ArrayList<>();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tilesToReturn.add(tiles[x][y]);
			}
		}
		return tilesToReturn;
	}

	public boolean setTile(Tile tile, int x, int y) {
		if(x >= 0 && x < width && y >= 0 && y < height) {
			tiles[x][y] = tile;
			return true;
		}
		return false;
	}

	public Tile getTile(int x, int y) {
		if(x >= 0 && x < width && y >= 0 && y < height)
			return tiles[x][y];
		return null;
	}

	public void addEntity(Entity ent) {
		this.entities.add(ent);
	}

	public void removeEntity(Entity ent) {
		this.entities.remove(ent);
	}

	public List<Entity> getEntities() {
		return this.entities;
	}

	public void render(float delta, boolean transition) {
//		transitionOffset = transitionOn
//				? transitionOffset - 5
//				: transitionOffset + 5;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Tile t = tiles[x][y];
				if (!(t instanceof AirTile)) {
//					if (transition) {
//						t.setPosition(x * Tile.WIDTH,
//								(y * Tile.HEIGHT) - this.transitionOffset);
//					}
					Renderer.draw(t, delta);
				}
			}
		}

		for (Entity ent : entities) {
			Renderer.draw(ent, delta);
		}
	}

	public void update(float delta) {
		for (int i = entities.size() - 1; i >= 0; i--) {
			Entity ent = entities.get(i);
			ent.update();
			Vector2 center = ent.getBody().getPosition();
			ent.getSprite(delta).setCenter(center.x, center.y);
			if (!ent.isAlive())
				entities.remove(i);
		}
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void transition(boolean on) {
		transitionOffset = on ? Gdx.graphics.getHeight() : 0;
		transitionOn = on;
	}

	public boolean isTransitionComplete() {
		return (transitionOn && transitionOffset <= 0) || (!transitionOn
				&& transitionOffset >= Gdx.graphics.getHeight());
	}
}
