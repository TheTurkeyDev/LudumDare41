package com.theprogrammingturkey.ld41.levels;

import com.theprogrammingturkey.ld41.rendering.RenderObject;

public class Tile {
	private RenderObject renderObject;

	public Tile() {

	}
	
	public void draw(float delta) {
		this.renderObject.draw(delta);
	}
	
	public RenderObject getRenderObject() {
		return renderObject;
	}
	
	public void setRenderObject(RenderObject renderObject) {
		this.renderObject = renderObject;
	}

	public static enum TileType {
		AIR(0), GROUND(1);

		int id;

		TileType(int id) {
			this.id = id;
		}

		public int getID() {
			return this.id;
		}
	}
}
