package com.theprogrammingturkey.ld41.levels.tiles;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class TileManager {
	private static Map<Integer, Class<? extends Tile>> tiles = new HashMap<>();

	public static void initTiles() {
		tiles.put(0, AirTile.class);
		tiles.put(1, GrassTile.class);
		tiles.put(2, GroundTile.class);
		tiles.put(3, FinishTile.class);
	}

	public static Tile getNewTileFromID(int id, int x, int y) {
		try {
			return tiles.get(id).getDeclaredConstructor(int.class, int.class)
					.newInstance(x, y);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return new AirTile(x, y);
		}
	}
}
