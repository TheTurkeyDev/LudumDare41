package com.theprogrammingturkey.ld41.rendering;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RenderObject {

	private HashMap<String, Animation<TextureRegion>> animations;

	private Sprite sprite;
	private Animation<TextureRegion> animation;

	private float animationTime = 0;
	private boolean animated = false;

	public RenderObject() {
		sprite = new Sprite();
		animations = new HashMap<String, Animation<TextureRegion>>();
	}

	public void addAnimation(String name, Animation<TextureRegion> animation,
			boolean replace) {
		boolean alreadyContainsAnimation = animations.containsKey(name);
		if ((alreadyContainsAnimation && replace)
				|| !alreadyContainsAnimation) {
			animations.put(name, animation);
		}
	}

	/***
	 * Set the current animation for the sprite
	 * 
	 * @param name
	 */
	public void setAnimation(String name) {
		if (animations.containsKey(name)) {
			animation = animations.get(name);
			if (animation.getKeyFrames().length <= 1) {
				animated = false;
			} else {
				animated = true;
			}
			sprite.setRegion(animation.getKeyFrames()[0]);
			sprite.setBounds(sprite.getRegionX(), sprite.getRegionY(),
					sprite.getRegionWidth(), sprite.getRegionHeight());

			animationTime = 0;
		}
	}

	/***
	 * Update the animation and draw the sprite
	 * 
	 * @param delta
	 */
	public void draw(float delta) {
		if (animated && animation != null) {
			animationTime += delta;
			sprite.setRegion(animation.getKeyFrame(animationTime));
		}

		if (sprite != null) {
			Renderer.drawSprite(sprite);
		}
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Sprite getSprite() {
		return sprite;
	}

}
