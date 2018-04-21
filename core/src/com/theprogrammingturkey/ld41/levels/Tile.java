package com.theprogrammingturkey.ld41.levels;

public class Tile {
	private TileType type;

	public Tile(TileType type) {
		this.type = type;
	}

	/**
	 * Get the Type of the tile
	 * 
	 * @return TileType type
	 */
	public TileType getTileType() {
		return this.type;
	}

	public static enum TileType {
		AIR(0), GROUND(1), GROUND_GRASS(2);

		int id;

		TileType(int id) {
			this.id = id;
		}

		public int getID() {
			return this.id;
		}
	}
}
