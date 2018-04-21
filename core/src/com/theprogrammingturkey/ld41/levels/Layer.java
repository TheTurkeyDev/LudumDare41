package com.theprogrammingturkey.ld41.levels;

import com.theprogrammingturkey.ld41.levels.Tile.TileType;

public class Layer {
	Tile[][] tiles;

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
}
