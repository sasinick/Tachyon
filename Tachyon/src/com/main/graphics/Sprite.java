package com.main.graphics;

public class Sprite {

	// size of sprite, 16 for now
	public final int SIZE;
	private int x,y;
	public int[] pixels;
	// sprite may belong to any of the spritesheet, 
	// so need a reference
	private SpriteSheet sheet;
	
	// using sprites (this code comes later)
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	
	
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE 		= size;
		// a new pixel array equal to a sprite
		// every sprite will contain SIZE * SIZE pixels
		pixels = new int[SIZE * SIZE];
		// if the sprite is at 5 horizontally and 2 down vertically
		// we need to multiply size variable 5 times to x to reach it
		// and multiply size variable 2 times to y to reach it
		this.x 		= x * size;
		this.y 		= y * size;
		this.sheet 	= sheet;
		load();
	}
	
	
	
	// image has already been loaded in the pixels array of SpriteSheet class.by load() method 
	// 1. here we have to get the pixels array from spritesheet and 
	// 2. find the right sprite (by finding right set of pixels)
	// 3. load it into the new pixels array defined here
	private void load(){
		// cycle thru each pixel of spritesheet and
		// set it in our local pixels array
		for(int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				pixels [x + y * SIZE] = sheet.pixels[(x + this.x) + 
				                          (y + this.y) * sheet.SIZE];
			}
		}
		
	}
}
