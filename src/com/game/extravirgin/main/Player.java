package com.game.extravirgin.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends GameObject {

	public Player(int x, int y, GameState gs) {
		super(x, y,gs);
	}

	static final int speed = 3;
	
	public void tick() {
		velX = velY = 0; // set velocities to 0
		//Calc velocities based on currently pressed keys
		if(UP)velY -= speed;
		if(DOWN)velY += speed;
		if(RIGHT)velX += speed;
		if(LEFT)velX -= speed;
		
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}

	//Controls
	boolean UP = false, DOWN = false, RIGHT = false, LEFT = false;
	
	public void keyDown(int k) {
		switch(k){
		case KeyEvent.VK_W: UP = true;
			break;
		case KeyEvent.VK_A: LEFT = true;
			break;
		case KeyEvent.VK_S: DOWN = true;
			break;
		case KeyEvent.VK_D: RIGHT = true;
			break;
		}
	}
	
	public void keyUp(int k) {
		switch(k){
		case KeyEvent.VK_W: UP = false;
			break;
		case KeyEvent.VK_A: LEFT = false;
			break;
		case KeyEvent.VK_S: DOWN = false;
			break;
		case KeyEvent.VK_D: RIGHT = false;
			break;
		}
	}

}
