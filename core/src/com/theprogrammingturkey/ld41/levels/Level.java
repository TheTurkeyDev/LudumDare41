package com.theprogrammingturkey.ld41.levels;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.theprogrammingturkey.ld41.entity.Entity;
import com.theprogrammingturkey.ld41.rendering.Renderer;
import com.theprogrammingturkey.ld41.screens.GameScreen;

public class Level {
	private List<Layer> layers = new ArrayList<Layer>();
	private int currentLayer = 0;
	private int switchLayer = -1;
	private boolean on;

	private int playerStartX;
	private int playerStartY;
	private int playerStartLayer;

	public void init() {
		currentLayer = playerStartLayer;
		this.layers.get(playerStartLayer).addEntity(GameScreen.player);
		GameScreen.player.setLocation(this.layers.get(playerStartLayer),
				playerStartX, playerStartY);
	}

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

	public void update(float delta) {
		if (Gdx.input.isKeyPressed(Input.Keys.Q)// && switchLayer == -1
				&& currentLayer + 1 < layers.size()) {
			switchLayer = currentLayer;
			layers.get(switchLayer).transition(false);
			currentLayer++;
			on = false;
			layers.get(switchLayer).removeEntity(GameScreen.player);
			layers.get(currentLayer).addEntity(GameScreen.player);
			GameScreen.player.setLayer(layers.get(currentLayer));
		} else if (Gdx.input.isKeyPressed(Input.Keys.W)// && switchLayer == -1
				&& currentLayer > 0) {
			switchLayer = currentLayer - 1;
			layers.get(switchLayer).transition(true);
			on = true;
			layers.get(currentLayer).removeEntity(GameScreen.player);
			layers.get(switchLayer).addEntity(GameScreen.player);
			currentLayer--; // sfsdf
			GameScreen.player.setLayer(layers.get(switchLayer));
		}

		for (Layer layer : layers) {
			layer.update(delta);
		}
	}

	public void render(float delta) {
		// (currentLayer - i) / layers.size()
		layers.get(currentLayer).render(delta, false);
		
		Renderer.box2dDebugRender();
		// Renderer.batch.setColor(Color.WHITE);
		// for (int i = layers.size() - 1; i >= currentLayer; i--) {
		// layers.get(i).render(delta, false);
		// }
		// if (switchLayer != -1) {
		// Layer layer = layers.get(switchLayer);
		// layer.render(delta, true);
		// if (layer.isTransitionComplete()) {
		// if (on)
		// currentLayer = switchLayer;
		// switchLayer = -1;
		// }
		// }
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

	public int getPlayerStartX() {
		return playerStartX;
	}

	public void setPlayerStartX(int playerStartX) {
		this.playerStartX = playerStartX;
	}

	public int getPlayerStartY() {
		return playerStartY;
	}

	public void setPlayerStartY(int playerStartY) {
		this.playerStartY = playerStartY;
	}

	public int getPlayerStartLayer() {
		return playerStartLayer;
	}

	public void setPlayerStartLayer(int playerStartLayer) {
		this.playerStartLayer = playerStartLayer;
	}

}
