package com.main.level;

import com.main.graphics.Screen;
import com.main.level.tile.Tile;

// 2 types, random generation
// from image file
// superclass or template for levels
public class Level {

	protected int width, height;
	// the index where tiles need to be placed will
	// be defined by tiles array
	protected int[] tiles;
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		// if width and height are 4x4 tiles, we have 16 tiles
		// one integer for each tile
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
	}
	
	// random level generation
	// fill tiles array with random int values
	protected void generateLevel(){
		
	}
	
	
	private void loadLevel(String path){
		
	}
	
	// entities moving in the screen
	public void update(){
		
	}
	
	// for time management
	private void time(){
		
	}
	// xscroll and yscroll is our player location
	// x0 and others are corner pins (they define the render region of our screen)
	// div by 16, to convert them into tile values 
	// (one integer representing a tile, and not a pixel)
	public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;

		// Actually rendering tiles on screen
		for(int y = y0; y< y1; y++){
			for(int x = x0; x < x1; x++){
				getTile(x,y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if (tiles[x + y * width] == 0){
			return Tile.grass;
		}
		return Tile.voidTile;
	} 
	
	//tiles have to rendered at tile level, player at pixel level
}
