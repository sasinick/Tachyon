package com.main.level;

import com.main.graphics.Screen;

// 2 types, random generation
// from image file
// superclass or template for levels
public class Level {

	protected int width, height;
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
	
	public void render(int xScroll, int yScroll, Screen screen){
		
	}
}
