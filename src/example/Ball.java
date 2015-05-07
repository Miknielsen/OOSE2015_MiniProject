package example;

import java.util.Random;

import org.newdawn.slick.Graphics;

public class Ball {
	
	
	private float speedX = 1.2f;
	private float speedY = -1.2f;
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
		g.drawOval(coordX, coordY, ballWidth, ballHeight);											//Draws the ball / oval (pos,pos,size,size)
		g.fillOval(coordX, coordY, ballWidth, ballHeight);											//Fills the ball (pos,pos,size,size)
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
	 * 
	 * @return	The x-coordinate as a float
	 */
	public float getXcoord() {
		return coordX;
	}
	
	/**
	 * Getter for the current y-coordinate of the ball
	 * 
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
		Random rand = new Random();
		speedY = speedY * -1 + (rand.nextFloat() * (1.3f - 1.0f));;
	}
	
	/**
	 * Getter for the speed of the ball on the x-axis
	 * 
	 * @return     Returns the speed of the ball on the x-axis
	 */
	public float getXspeed(){
		return speedX;
	}
	
	/**
	 * Getter for the speed of the ball on the y-axis
	 * 
	 * @return     Returns the speed of the ball on the y-axis
	 */
	public float getYspeed() {
		return speedY;
	}
	
	/**
	 * Setter for the x-coordinate of the ball
	 * 
	 * @param coord        Takes a coordinate as input and sets the x-coordinate of the ball
	 */
	public void setXcoord(int coord) {
		coordX = coord;
	}
	
	/**
	 * Setter for the y-coordinate of the ball
	 * 
	 * @param coord        Takes a coordinate as input and sets the y-coordinate of the ball
	 */
	public void setYcoord(int coord) {
		coordY = coord;
	}
	
	/**
	 * Multiplies the speed of the ball with inputted value on both
	 * the x- and y-axis
	 * 
	 * @param multiplier       Takes a float as input to be multiplied with the ball speed  
	 */
	public void setSpeed(float multiplier) {
		speedX *= multiplier;
		speedY *= multiplier;
	}
	
	/**
	 * Stops the ball's movement by setting the speed on the x- and y-axis to 0
	 */
	public void stopBall() {
		speedX = 0.0f;
		speedY = 0.0f;
	}
	
}