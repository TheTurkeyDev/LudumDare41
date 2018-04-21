package com.theprogrammingturkey.ld41.levels;

import java.util.HashMap;
import java.util.Map;

public class LevelManager {
	private static Map<String, Level> levels = new HashMap<String, Level>();
	private static String currentLevel = "";

	/**
	 * Register a level
	 *
	 * @param id    of the level
	 * @param level to store
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
}