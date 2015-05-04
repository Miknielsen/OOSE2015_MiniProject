package example;

import org.newdawn.slick.Graphics;

public class Ball {
	
	
	private float speedX = 1;
	private float speedY = -1;
	private float coordX = SimpleSlickGame.getScreenWidth() * 0.5f;
	private float coordY = SimpleSlickGame.getScreenHeight() * 0.85f;
	private float ballWidth = 15;
	private float ballHeight = 15;

	/**
	 * Creates the ball
	 * 
	 * @param g		The graphic engine that is going to be drawing the ball
	 */
	public void createBall(Graphics g) {
		g.drawOval(coordX, coordY, ballWidth, ballHeight);
	}
	
	
	/**
	 * Updates the position of the ball every frame it is called
	 */
	public void update() {
		coordX = coordX + speedX;
		coordY = coordY + speedY;
	}	

	/**
	 * Getter for the current x-coordinate of the ball
	 * @return	The x-coordinate as a float
	 */
	public float getXcoord() {
		return coordX;
	}
	
	/**
	 * Getter for the current y-coordinate of the ball
	 * @return	The y-coordinate as a float
	 */
	public float getYcoord() {
		return coordY;
	}
	
	/**
	 * Changes the direction of which the ball is moving on x-axis
	 */
	public void changeXdirection() {
		speedX = speedX * -1;
	}
	
	/**
	 * Changes the direction of which the ball is moving on y-axis
	 */
	public void changeYdirection() {
		speedY = speedY * -1;
	}
	
}