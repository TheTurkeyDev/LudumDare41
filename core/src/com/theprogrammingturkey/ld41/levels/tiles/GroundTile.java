package com.theprogrammingturkey.ld41.levels.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GroundTile extends Tile {
	private static final Texture TEXTURE = new Texture("tiles/GroundDirt.png");
	public GroundTile(int x, int y) {
		super(x, y, new Sprite(TEXTURE));
	}
}
