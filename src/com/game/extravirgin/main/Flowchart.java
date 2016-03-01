package com.game.extravirgin.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Flowchart extends GameObject {

	BufferedImage sprite;
	int w,h;
	public Flowchart(int x, int y, GameState gs) {
		super(x, y, gs);
		try {
			sprite = ImageIO.read(new File("flowchart.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 h = Game.HEIGHT - 30;
		 w = (int) (sprite.getWidth() * (h / (float)sprite.getHeight()));
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, x, y,w,h, null);
	}

}
