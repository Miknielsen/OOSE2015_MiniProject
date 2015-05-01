package example;

import org.newdawn.slick.Graphics;

public class Ball {
	
	
	float speedX = 1;
	float speedY = -1;
	float coordX = SimpleSlickGame.getScreenWidth() * 0.5f;
	float coordY = SimpleSlickGame.getScreenHeight() * 0.85f;

	
	public void createBall(Graphics g) {
		g.drawOval(coordX, coordY, 15, 15);
	}
	
	public void update() {
		
		coordX = coordX + speedX;
		coordY = coordY + speedY;
		
	}	
	
	public float getXcoord() {
		return coordX;
	}
	
	public float getYcoord() {
		return coordY;
	}
	
	public void changeXdirection() {
		speedX = speedX * -1;
	}
	
	public void changeYdirection() {
		speedY = speedY * -1;
	}
	
}
