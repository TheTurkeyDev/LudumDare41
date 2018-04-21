package com.theprogrammingturkey.ld41.levels;

import java.util.ArrayList;
import java.util.List;

import com.theprogrammingturkey.ld41.entity.Entity;
import com.theprogrammingturkey.ld41.levels.Tile.TileType;

public class Layer {
	private Tile[][] tiles;
	private List<Entity> entities = new ArrayList<Entity>();

	public Layer(int width, int height) {
		tiles = new Tile[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (y > 3) {
					tiles[x][y] = new Tile(TileType.AIR);
				} else {
					tiles[x][y] = new Tile(TileType.GROUND);
				}
			}
		}
	}

	public void setTile(TileType type, int x, int y) {
		tiles[x][y] = new Tile(type);
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
}
