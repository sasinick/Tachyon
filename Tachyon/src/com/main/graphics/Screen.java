package com.main.graphics;

import java.util.Random;

// that fills pixels with color n displays
public class Screen {

	private int width, height;
	public int[] pixels; 
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
		counter++;
		if(counter % 50 == 0) time++;
		
		for(int y=0; y < height; y++){
			int yy = y + yOffset;
			if (y < 0 || y >= height) break;
			for(int x=0; x < width; x++){
				int xx = x + xOffset;
				if (x < 0 || x >= width) break;
				int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + 
						((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}
	}
	
	
	public void clear(){
		for(int i=0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
}
