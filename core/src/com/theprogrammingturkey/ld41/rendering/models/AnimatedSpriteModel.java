package com.theprogrammingturkey.ld41.rendering.models;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.theprogrammingturkey.ld41.rendering.Renderable;

public class AnimatedSpriteModel implements Renderable {

	private Animation<Sprite> animation;
	private float animationTime;

	public AnimatedSpriteModel(Animation<Sprite> animation) {
		this.animation = animation;
	}

	@Override
	public Sprite getSprite(float delta) {
		animationTime = (animationTime + delta) % animation.getAnimationDuration();
		return animation.getKeyFrame(animationTime);
	}
}
