package com.theprogrammingturkey.ld41.rendering;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class RenderObject {

	private HashMap<String, Animation<Sprite>> animations;

	private Sprite sprite;
	private Animation<Sprite> animation;

	private float animationTime = 0;
	private boolean animated = false;

	public RenderObject() {
		animations = new HashMap<String, Animation<Sprite>>();
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public void addAnimation(String name, Animation<Sprite> animation,
			boolean replace) {
		boolean alreadyContainsAnimation = animations.containsKey(name);
		if ((alreadyContainsAnimation && replace)
				|| !alreadyContainsAnimation) {
			animations.put(name, animation);
		}
	}

	public void setAnimation(String name) {
		if (animations.containsKey(name)) {
			animation = animations.get(name);
			if (animation.getKeyFrames().length <= 1) {
				animated = false;
			}
			animationTime = 0;
		}
	}

	public void draw(float delta) {
		if (animated) {
			animationTime += delta;
			sprite = animation.getKeyFrame(animationTime);
		}

		if (sprite != null) {
			Renderer.drawSprite(sprite);
		}
	}

}
