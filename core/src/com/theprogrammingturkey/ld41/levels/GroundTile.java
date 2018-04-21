package com.theprogrammingturkey.ld41.levels;

import com.theprogrammingturkey.ld41.rendering.RenderObject;
import com.theprogrammingturkey.ld41.rendering.Renderer;

public class GroundTile extends Tile {

	public GroundTile() {
		RenderObject renderObject = new RenderObject();
		renderObject.addAnimation("static",
				Renderer.createAnimation(0f, new int[]{0, 16, 16, 16}), false);
		
		super.setRenderObject(renderObject);

	}

}
