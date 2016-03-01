package com.game.extravirgin.main;

import java.awt.Color;
import java.awt.Graphics;

public class Level1 extends GameState {

	public Level1(GameStateManager gsm) {
		super(gsm);
	}
	
	
	//sets up the level. call this if you ever need to restart the level.
	public void init(){
		super.init();//call this first, it clears the entities
		//add all entities and initialize the player here
		player = new Player(100,100,this);
		objects.add(new Flowchart(0,0,this));
	}
	
	public void render(Graphics g){
		g.setColor(Color.red);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		//the super renders entities and the player. We do this AFTER the backdrop
		super.render(g);
	}
	
	//we don't change the behavior of the tick or key events so we don't override them
	
}
