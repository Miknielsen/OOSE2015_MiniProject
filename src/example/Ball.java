package example;

<<<<<<< HEAD
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

public class Ball {
    
    public float 
    ballRadius = 15.0f,                                                             //The radius of the ball
    ballXpos = SimpleSlickGame.getScreenWorkingWidth()/2.0f,                        //The start X-coordinates of the ball, center of screen
    ballYpos = SimpleSlickGame.getScreenWorkingHeight()*0.80f;                      //The start Y-coordinates of the ball, 80% on the Y-axis
    
    public void createBall(Graphics g){

        g.drawOval(ballXpos, ballYpos, ballRadius, ballRadius);                     //Creates an oval shape, X-pos, Y-pos, radius, radius
    }
    
    public void ballMovement(){
        
    }

=======
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
	
>>>>>>> origin/master
}
