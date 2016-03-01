package com.game.extravirgin.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.HashMap;

import com.game.extravirgin.main.GameStateManager.States;

public class Game extends Canvas implements Runnable, KeyListener {
	
	/**
	 *  main class with  rendering / game tick
	 */
	private static final long serialVersionUID = 6700036366787160773L;
	
	public static final int WIDTH = 920, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	GameStateManager gsm;
	
	//So we can access the game object anywhere, by using Game.instance
	private static Game instance;
	//Stores state of key at its keycode
	HashMap<Integer, Boolean> keys;
	
	public static Game getInstance(){
		return instance;
	}
	
	public Game() {
		gsm = new GameStateManager(this, States.Level1);
		instance = this;
		keys = new HashMap<>();
		this.addKeyListener(this);
		new Window(WIDTH, HEIGHT, "Mein Berliner", this);
		
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join(); //kill
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
				frames++;
			}
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		gsm.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.red);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		gsm.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Game();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		keys.put(arg0.getKeyCode(), true);
		gsm.keyDown(arg0.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keys.put(arg0.getKeyCode(), false);
		gsm.keyUp(arg0.getKeyCode());
		
	}

	
	
	public static boolean isKeyDown(int k){
		if(instance.keys.containsKey(k)){
			return instance.keys.get(k);
		}
		return false;
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {}
	
}
