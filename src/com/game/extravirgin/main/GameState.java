package com.game.extravirgin.main;

import java.awt.Graphics;
import java.util.LinkedList;

public abstract class GameState {

	protected LinkedList<GameObject> objects; //all projectiles, enemies, or other entity will be stored here
	protected Player player; //we don't store the player in the list because we want direct access
	protected GameStateManager gsm; //for easy access
	/*
	 * Executes game logic. Called before render()
	 * By default updates all GameObjects in objects
	 */
	
	public GameState(GameStateManager gsm){
		this.gsm = gsm;
		objects = new LinkedList<>();
	}
	
	public void tick() {
		for (GameObject object : objects) {
			object.tick();
		}
		player.tick();
	}
	
	/*
	 * Draws game to screen. By default, renders all GameObjects in objects
	 */
	public void render(Graphics g) {
		for (GameObject object : objects) {
			object.render(g);
		}
		player.render(g);
	}
	
	public void keyDown(int k){
		player.keyDown(k);
	}
	
	public void keyUp(int k){
		player.keyUp(k);
	}

	public void init() {
		 objects.clear();
		 
	}
	
}
