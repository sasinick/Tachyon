package com.main.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	// take the spritesheet png and cache into memory (a variable)
	private String path;
	public final int SIZE;   // size of spritesheet, not sprites, hence final
	// a new pixel array, equal to spritesheet 
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet(
			"/textures/spritesheet.png", 256);
	
	public SpriteSheet(String path, int size){
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	// 1. load the spritesheet png into image object
	// 2. then load it into pixels array
	private void load(){
		try {
			// converting the png into an image object 
			BufferedImage image = ImageIO.read
					(SpriteSheet.class.getResource(path));
			
			//BUT, we dont wanna deal with image (buffered one) 
			// but as pixels, so we can fill colors in it
			int w = image.getWidth();
			int h = image.getHeight();
			// this is how we do that
			// explaining the params below::
			// start scanning the image from 0,0 till w,h (covers entire image)
			// where to put it, inside pixels array
			// offset to start scan is 0
			// scan horizontaslly, so scansize will be width, hence w
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
