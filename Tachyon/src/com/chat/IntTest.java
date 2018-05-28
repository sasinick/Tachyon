package com.chat;

public class IntTest {
	int width = 64;
	int height = 64;
	int[] tiles = new int[8*8];
	int[] pixels = new int[width*height];
	
	public static void main(String [] args){
		new IntTest().render();
	}
	
	public void render(){
		for (int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				int tileIndex = (x / 4) + (y / 4) * 8;
				pixels[x + y * width] = tiles[tileIndex];
				System.out.println("y= " + y + " x= "+ x + " TileIndex: " + tileIndex + " :: Pixels: " + pixels[x+y*width]);
			}
		}
	}
}
