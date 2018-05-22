package com.main.graphics;

import java.util.Random;

// this class fills pixels defined in Main with color (or SPRITES)
// so last line can be changed to load colors or sprites
// map size is 64 and sprite size is 16, which is tile size
public class Screen {

	private int width, height;
	public int[] pixels; 
	// MAP ! = SPRITESHEET
	// TILES == SPRITES
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	private Random random= new Random();
	
	public int counter, time;
	
	public Screen(int width,int height){
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
		
		for(int i=0; i< MAP_SIZE * MAP_SIZE; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void render(int xOffset, int yOffset){
		// counter++;
		// if(counter % 50 == 0) time++;
		
		for(int y=0; y < height; y++){
			 int yy = y + yOffset;
			// if (y < 0 || y >= height) break;
			if (yy < 0 || yy >= height) continue;
			for(int x=0; x < width; x++){
				 int xx = x + xOffset;
				//if (x < 0 || x >= width) break;
				if (xx < 0 || xx >= width) continue;
				// tiles to be 16 by 16, thats what is 
				// defined here
				//int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + 
				//		((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
				//pixels[x + y * width] = tiles[tileIndex];
				// instead of pointing it to random color tiles
				// set it to grass sprite
				// sprite width is 16*16, so break at 15
				pixels[xx + yy * width] = 
						Sprite.grass.pixels[(x & 15) + 
				                    (y & 15) * Sprite.grass.SIZE];
				// THE ABOVE LINE IS RENDERING THE WHOLE GAME
			}
		}
	}
	
	
	public void clear(){
		for(int i=0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
}
