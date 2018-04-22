package com.theprogrammingturkey.ld41.levels;

import java.util.ArrayList;
import java.util.List;

import com.theprogrammingturkey.ld41.entity.Entity;
import com.theprogrammingturkey.ld41.levels.tiles.AirTile;
import com.theprogrammingturkey.ld41.levels.tiles.GrassTile;
import com.theprogrammingturkey.ld41.levels.tiles.GroundTile;
import com.theprogrammingturkey.ld41.levels.tiles.Tile;

public class Layer {

	private Tile[][] tiles;
	private List<Entity> entities = new ArrayList<Entity>();

	private int width;
	private int height;

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

	public List<Tile> getTiles(int offset) {
		List<Tile> tilesToReturn = new ArrayList<>();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tilesToReturn.add(tiles[x][y]);
			}
		}
		return tilesToReturn;
	}

	public void setTile(Tile tile, int x, int y) {
		tiles[x][y] = tile;
	}

	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}

	public void addEntity(Entity ent) {
		this.entities.add(ent);
	}

	public List<Entity> getEntities() {
		return this.entities;
	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			Entity ent = entities.get(i);
			ent.update();
			if (!ent.isAlive())
				entities.remove(i);
		}
	}
}
