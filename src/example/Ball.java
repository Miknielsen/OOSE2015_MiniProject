package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

public class Ball {
	
	
	float speedX = 1;
	float speedY = 1;
	float coordX = 50;
	float coordY = 50;

	
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
