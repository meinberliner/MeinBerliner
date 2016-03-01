package com.game.extravirgin.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler h) {
		this.handler = h;
		
		for (int x = 0; x < 4; x++) {
			keyDown[x] = false;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Player) {
				//key events for player input
				if (key == KeyEvent.VK_W) { tempObject.setVelY(-3); keyDown[0] = true; }     //  0
				if (key == KeyEvent.VK_S) { tempObject.setVelY(3); keyDown[1] = true; }      // 213
				if (key == KeyEvent.VK_D) { tempObject.setVelX(3); keyDown[2] = true; }
				if (key == KeyEvent.VK_A) { tempObject.setVelX(-3); keyDown[3] = true; }
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) keyDown[0] = false;
				if (key == KeyEvent.VK_S) keyDown[1] = false;
				if (key == KeyEvent.VK_D) keyDown[2] = false;
				if (key == KeyEvent.VK_A) keyDown[3] = false;
				
				//vertical movement
				if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				//horizontal movement
				if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
		}
	}
}
