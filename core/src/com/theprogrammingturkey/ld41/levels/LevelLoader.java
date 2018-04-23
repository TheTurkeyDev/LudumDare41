package com.theprogrammingturkey.ld41.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.theprogrammingturkey.ld41.collision.Box2DUtil;
import com.theprogrammingturkey.ld41.levels.tiles.Tile;
import com.theprogrammingturkey.ld41.levels.tiles.TileManager;

public class LevelLoader {

	private static final JsonParser PARSER = new JsonParser();

	public static void loadLevels() {
		String[] files = Gdx.files.internal("levels/Levels.txt").readString()
				.split("\n");
		for (String file : files) {
			Level level = new Level();

			JsonObject json = PARSER
					.parse(Gdx.files.internal("levels/" + file.trim()).reader())
					.getAsJsonObject();
			String levelName = json.get("LevelName").getAsString();
			LevelManager.registerLevel(levelName, level);

			JsonObject playerData = json.getAsJsonObject("Player");
			level.setPlayerStartX(
					playerData.get("StartX").getAsInt() * Tile.WIDTH);
			level.setPlayerStartY(
					playerData.get("StartY").getAsInt() * Tile.HEIGHT);
			level.setPlayerStartLayer(playerData.get("StartLayer").getAsInt());

			JsonArray layersJson = json.getAsJsonArray("Layers");
			int layerId = 0;
			
			for (JsonElement layerJson : layersJson) {
				JsonArray tiles = layerJson.getAsJsonObject()
						.getAsJsonArray("Tiles");
				Layer layer = new Layer(tiles.size(), 20);
				int x = 0;
				int y = 19;
				for (JsonElement columnJson : tiles) {
					for (JsonElement tileID : columnJson.getAsJsonArray()) {
						layer.setTile(TileManager.getNewTileFromID(
								tileID.getAsInt(), x, y), x, y);

						if (layer.getTile(x, y).isSolid()) {
							layer.getTile(x, y)
									.setBody(Box2DUtil.createBoxBody(
											x * Tile.WIDTH, y * Tile.HEIGHT,
											Tile.WIDTH, Tile.HEIGHT, BodyDef.BodyType.StaticBody,layerId));
						}

						y--;
					}
					x++;
					y = 19;
				}
				JsonArray entitiesJson = layerJson.getAsJsonObject()
						.getAsJsonArray("Entities");

				level.addLayer(layer);
				layerId++;
			}
		}
	}
}
