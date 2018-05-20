package com.main.graphics;

// that fills pixels with color n displays
public class Screen {

	private int width, height;
	public int[] pixels;
	
	public int counter, time;
	
	public Screen(int width,int height){
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
	}
	
	public void render(){
		counter++;
		if(counter % 100 == 0) time++;
		for(int y=0; y < height; y++){
			for(int x=0; x < width; x++){
				pixels[x + y * width] = 0xFF00FF;
			}
		}
	}
	
	public void clear(){
		for(int i=0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
}
