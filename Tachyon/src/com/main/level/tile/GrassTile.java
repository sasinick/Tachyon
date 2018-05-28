package com.main.level.tile;

import com.main.graphics.Screen;
import com.main.graphics.Sprite;

public class GrassTile extends Tile{

	
	// while creating a new grass tile, well have to 
	// specify the right sprite
	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		// the tile class itself giving the command to render itself
		// the 3rd param is how we tell the method which tile to render
		// in this case, we wanna render the "this"
		screen.renderTile(x, y, this);
	}
	
	// grass is not collidable, so solid() should returns false
	// no need to override, as its set to return false by default
}
