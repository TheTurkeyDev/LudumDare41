package com.theprogrammingturkey.ld41.collision;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.theprogrammingturkey.ld41.levels.LevelManager;

public class Box2DUtil {

	public static Body createBoxBody(float x, float y, float w, float h, BodyType type, int layer) {
		BodyDef def = new BodyDef();
		def.type = type;
		
		def.position.set(x + w/2.0f, y + h/2.0f);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(h / 2.0f, w / 2.0f);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		
		if(layer >= 0 && layer < 5) {
			fixtureDef.filter.categoryBits = LevelManager.layerMasks[layer];
			fixtureDef.filter.maskBits = LevelManager.layerMasks[layer];
		}
		
		Body body = LevelManager.world.createBody(def);
		body.createFixture(fixtureDef);
		
		return body;
	}

}
