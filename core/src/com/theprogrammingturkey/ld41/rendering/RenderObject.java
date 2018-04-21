package com.theprogrammingturkey.ld41.rendering;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class RenderObject {
	
	private static final Sprite clearSprite = Renderer.createSprite();
	
	private HashMap<String, Animation<Sprite>> animations;
	
	private Sprite sprite;
	private Animation<Sprite> animation;
	
	public RenderObject() {
		animations = new HashMap<String, Animation<Sprite>>();
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void addAnimation(String name, Animation<Sprite> animation, boolean replace) {
		boolean alreadyContainsAnimation = animations.containsKey(name);
		if((alreadyContainsAnimation && replace) || !alreadyContainsAnimation) {
			animations.put(name, animation);
		}
	}
	
	public void update(float delta) {
		
	}
	
}
