package com.theprogrammingturkey.ld41.levels;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class LevelManager {
	private static Map<String, Level> levels = new HashMap<String, Level>();
	private static String currentLevel = "";
	
	public static World world = new World(new Vector2(0,-200f), false);
	
	public static short[] layerMasks = {1,2,4,8,16};

	/**
	 * Register a level
	 *
	 * @param id
	 *            of the level
	 * @param level
	 *            to store
	 */
	public static void registerLevel(String id, Level level) {
		levels.put(id, level);
	}

	public static void setCurrentLevel(String id) {
		currentLevel = id;
	}

	/**
	 * Get the current active level
	 *
	 * @return Level
	 */
	public static Level getCurrentLevel() {
		return levels.get(currentLevel);
	}

	/**
	 * Get the level with the given ID
	 *
	 * @param id
	 * @return Level
	 */
	public static Level getLevel(String id) {
		return levels.get(id);
	}

	public static int numLevels() {
		return levels.size();
	}
}