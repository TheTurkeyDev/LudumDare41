package com.theprogrammingturkey.ld41.levels;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.theprogrammingturkey.ld41.entity.Entity;
import com.theprogrammingturkey.ld41.entity.Player;

public class Level {
	private List<Layer> layers = new ArrayList<Layer>();
	private int currentLayer = 0;
	private int switchLayer = -1;
	private boolean on;

	/**
	 * Adds a layer to the level
	 * 
	 * @param layer
	 *            to add
	 * @return the id of the layer that was added
	 */
	public int addLayer(Layer layer) {
		layers.add(layer);
		return layers.size() - 1;
	}

	public void setCurrentLayer(int layer) {
		this.currentLayer = layer;
	}

	public void update() {
		if (Gdx.input.isKeyPressed(Input.Keys.Q) && switchLayer == -1
				&& currentLayer + 1 < layers.size()) {
			switchLayer = currentLayer;
			layers.get(switchLayer).transition(false);
			currentLayer++;
			on = false;
			movePlayerToNewLayer(switchLayer, currentLayer);
		} else if (Gdx.input.isKeyPressed(Input.Keys.W) && switchLayer == -1
				&& currentLayer > 0) {
			switchLayer = currentLayer - 1;
			layers.get(switchLayer).transition(true);
			on = true;
			movePlayerToNewLayer(currentLayer, switchLayer);
		}

		for (Layer layer : layers) {
			layer.update();
		}
	}

	public void render(float delta) {
		layers.get(currentLayer).render(delta, false);
		if (switchLayer != -1) {
			Layer layer = layers.get(switchLayer);
			layer.render(delta, true);
			if (layer.isTransitionComplete()) {
				if (on)
					currentLayer = switchLayer;
				switchLayer = -1;
			}
		}

	}

	/**
	 * Gets the layer at the give index/id
	 * 
	 * @param id
	 *            or index to get the layer of
	 * @return Layer
	 */
	public Layer getLayer(int id) {
		return layers.get(id);
	}

	/**
	 * Adds and entity to the given layer
	 * 
	 * @param layer
	 *            to add the entity to
	 * @param entity
	 *            to add
	 */
	public void addEntity(int layer, Entity entity) {
		this.layers.get(layer).addEntity(entity);
	}

	public void movePlayerToNewLayer(int o, int n) {
		Layer oldLayer = layers.get(o);
		Layer newLayer = layers.get(n);
		for (int i = oldLayer.getEntities().size() - 1; i >= 0; i--) {
			Entity ent = oldLayer.getEntities().get(i);
			if (ent instanceof Player) {
				oldLayer.getEntities().remove(i);
				newLayer.addEntity(ent);
			}
		}
	}

	/**
	 * Gets all entities currently in the level
	 * 
	 * @return List<Entity>
	 */
	public List<Entity> getAllEntities() {
		List<Entity> ents = new ArrayList<Entity>();
		for (Layer layer : layers) {
			ents.addAll(layer.getEntities());
		}
		return ents;
	}

	/**
	 * Gets all the entities from a specific layer
	 * 
	 * @param layer
	 *            to get the entities from
	 * @return List<Entity>
	 */
	public List<Entity> getEntitiesFromLayer(int layer) {
		return layers.get(layer).getEntities();
	}

}
