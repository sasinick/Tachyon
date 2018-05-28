package com.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.main.graphics.Render;
import com.main.graphics.Screen;
import com.main.input.Keyboard;

public class Main extends Canvas implements Runnable {

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;

	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	private Render render;
	private Screen screen;
	private Keyboard key;
	int x =0, y = 0;
	
	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	// convert the image object into array of integers
	// assign colors to integers to color each pixel
	// get the raster which is bunch of pixels
	private int[] pixels = ((DataBufferInt)image.getRaster().
			getDataBuffer()).getData();
	
	public Main() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		frame = new JFrame();
		//render = new Render(width, height);
		screen = new Screen(width,height);
		key = new Keyboard();
		addKeyListener(key);
	}

	public synchronized void start() {
		if (running) return;
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void run() {
		requestFocus();
		while (running) {
			//System.out.println("Running Tachyon....");
			update();
			render();
		}
	}

	private void update(){
		key.update();
		if (key.up)y--;
		if (key.down)y++;
		if (key.left)x--;
		if (key.right)x++;
		//x++;
		//y++;
	}
	
	private void render(){
		
		// need a buffer before pushing to screen
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		screen.render(x,y);
		
		for(int i=0;i<pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		// the link between buffer and graphics
		Graphics graphics = bs.getDrawGraphics();
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		graphics.drawImage(image, 0, 0, getWidth(), getHeight(),null);
		graphics.dispose();
		bs.show(); //show the next buffer in line
	}
	
	public static void main(String[] args) {
		Main game = new Main();
		game.frame.setResizable(false);
		game.frame.setTitle("Tachyon");
		// adding canvas within frame or filling our frame with something, our game
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}

}
