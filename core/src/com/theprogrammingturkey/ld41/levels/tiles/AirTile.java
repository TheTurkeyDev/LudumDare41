package com.theprogrammingturkey.ld41.levels.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AirTile extends Tile {
	private static final Texture TEXTURE = new Texture("tiles/Air.png");
	public AirTile(int x, int y) {
		super(x, y, new Sprite(TEXTURE));
	}

	@Override
	public boolean isSolid() {
		return false;
	}
}
