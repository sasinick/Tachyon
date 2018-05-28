package com.main.level.tile;

import com.main.graphics.Screen;
import com.main.graphics.Sprite;

// every tile will have its own rendering method
// tree, grass etc has different rendering
public class Tile {

	// each tile should have a position (no level association?)
	// a sprite, and need to be displayed in all cases
	// an entity may not be displayed, like a timer
	// but needs to be computed
	// should be collidable, 
	
	public int x, y;
	public Sprite sprite;
	
	// grass tile will use the grass sprite.
	// a static tile, there will be only one grass tile
	// always has same parameters like not solid.
	// Grass creation is only once, hence static
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	// tile has to have a sprite, can live without
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}
	
}
