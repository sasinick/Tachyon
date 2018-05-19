package com.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.main.graphics.Render;

public class Main extends Canvas implements Runnable {

	public static int width = 300;
	public static int height = width * 16 /9;
	public static int scale = 3;

	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	private Render render;

	public Main() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		frame = new JFrame();
		render = new Render(width, height);
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
		while (running) {
			System.out.println("Running Tachyon....");
			tick();
			render();
		}
	}

	private void tick(){}
	private void render(){
		// need a buffer before pushing to screen
		
	}
	
	public static void main(String[] args) {
		Main game = new Main();
		game.frame.setResizable(false);
		game.frame.setTitle("Tachyon");
		// adding canvas within frame or filling our frame with something, our
		// game
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the
																	// process
																	// when X is
																	// pressed
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}

}
