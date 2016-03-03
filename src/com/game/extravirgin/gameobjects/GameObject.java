package com.game.extravirgin.gameobjects;

import java.awt.Graphics;

import com.game.extravirgin.gamestate.GameState;

public abstract class GameObject {
	
	protected int x, y, velX, velY;
	protected GameState gs;
	public GameObject(int x, int y, GameState gs) {
		this.x = x;
		this.y = y;
		this.gs = gs;
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
}
