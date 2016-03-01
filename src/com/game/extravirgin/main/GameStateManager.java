package com.game.extravirgin.main;

import java.awt.Graphics;

public class GameStateManager {
		
	GameState currentState;
	Game game;
	
	public GameStateManager(Game g, States state){
		game = g;
		setState(state);
	}
	enum States{
		Level1
	}
	
	public void setState(States state){
		currentState = getState(state);
		currentState.init();
	}
	
	private GameState getState(States state){
		switch(state){
		case Level1: return new Level1(this);
		default: throw new IndexOutOfBoundsException("No state with index " + state);
		}
	}
	
	public void tick(){
		currentState.tick();
	}
	
	public void render(Graphics g){
		currentState.render(g);
	}
	
	public void keyDown(int k){
		currentState.keyDown(k);
	}
	
	public void keyUp(int k){
		currentState.keyUp(k);
	}
	
}
