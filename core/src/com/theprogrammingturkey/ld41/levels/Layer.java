package com.theprogrammingturkey.ld41.levels;

public class Layer {
	private Tile[][] tiles;
	private int width, height;

	public Layer(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (Math.random() < .5) {
					tiles[x][y] = new AirTile();
				} else {
					tiles[x][y] = new GroundTile();
				}
				tiles[x][y].getRenderObject().getSprite().setPosition(x*16, y*16);
			}
		}
	}
	
	public void draw(float delta) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y].draw(delta);
			}
		}
	}

	public void setTile(Tile tile, int x, int y) {
		tiles[x][y] = tile;
	}

	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}
}
