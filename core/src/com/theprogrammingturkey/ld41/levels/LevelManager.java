package com.theprogrammingturkey.ld41.levels;

import java.util.HashMap;
import java.util.Map;

public class LevelManager {
	private static Map<Integer, Level> levels = new HashMap<Integer, Level>();

	/**
	 * Register a level
	 * 
	 * @param id
	 *            of the level
	 * @param level
	 *            to store
	 */
	public static void registerLevel(int id, Level level) {
		levels.put(id, level);
	}

	/**
	 * Get the level with the given ID
	 * 
	 * @param id
	 * @return Level
	 */
	public static Level getLevel(int id) {
		return levels.get(id);
	}
}
