package com.theprogrammingturkey.ld41.levels;

import java.util.ArrayList;
import java.util.List;

import com.theprogrammingturkey.ld41.entity.Entity;

public class Level {
	private List<Layer> layers = new ArrayList<Layer>();
	private int currentLayer = 0;

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

	// public void draw(float delta) {
	// layers.get(currentLayer).draw(delta);
	// }

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
