package com.theprogrammingturkey.ld41.levels;

import java.util.ArrayList;
import java.util.List;

public class Level {
	private List<Layer> layers = new ArrayList<>();

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
}
