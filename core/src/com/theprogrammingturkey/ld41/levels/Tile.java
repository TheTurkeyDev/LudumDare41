package com.theprogrammingturkey.ld41.levels;

import com.badlogic.gdx.graphics.Texture;

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
		AIR(0, "Air"), GROUND(1, "GroundDirt"), GROUND_GRASS(2, "GroundGrass");

		private int id;
		private String name;
		private Texture texture;

		TileType(int id, String name) {
			this.id = id;
			this.name = name;
			this.texture = new Texture("tiles/" + name + ".png");
		}

		public int getID() {
			return this.id;
		}

		public Texture getTexture() {
			return this.texture;
		}
	}
}
