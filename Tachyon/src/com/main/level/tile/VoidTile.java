package com.main.level.tile;

import com.main.graphics.Screen;
import com.main.graphics.Sprite;


public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	// every tile has its own render version
	public void render(int x, int y, Screen screen){
		screen.renderTile(x, y, this);
	}

}
