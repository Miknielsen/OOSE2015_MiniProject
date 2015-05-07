package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Player {
    
	private float playerLengthMultiplier = 1;		//TODO change back to 7, 1 is for easy debugging
	 
	private float playerLength = SimpleSlickGame.getScreenWidth()/playerLengthMultiplier;
	private float playerHeight = SimpleSlickGame.getScreenHeight()*0.02f;
	private float playerXpos = SimpleSlickGame.getScreenWidth()/2.0f-(playerLength*0.50f);
	private float playerYpos = SimpleSlickGame.getScreenHeight()*0.90f; 
    
	/**
	 * Creates the player at given a position with a given size
	 * 
	 * @param g        Graphic engine used to draw the player
	 */
    public void createPlayer(Graphics g) {
        g.drawRect(playerXpos,playerYpos, playerLength,playerHeight);                                  //Draws a rectangle (pos,pos,size,size)
        g.fillRect(playerXpos,playerYpos, playerLength,playerHeight);								   //Fills the rectangle (pos,pos,size,size)
    }
    
    /**
     * Increments player movement to the right, moving 3 pixels
     */
    public void moveRight() {
        if(playerXpos < SimpleSlickGame.getScreenWidth())
            playerXpos += 3;
    }
    
    /**
     * Decreases player movement to the left, moving 3 pixels
     */
    public void moveLeft() {
        if(playerXpos > 0)
            playerXpos -= 3;
    }
    
    /**
     * Getter for the value of the player's height
     * 
     * @return      Returns the player's height in pixel
     */
    public float getHeight() {
    	return playerHeight;
    }
    
    /**
     * Getter for the value of the player's length
     * 
     * @return      Returns the player's length in pixel
     */
    public float getLength() {
    	return playerLength;
    }
    
    /**
     * Getter for the value of the player X-coordinate
     * 
     * @return      Returns the X-coordinate of the player
     */
    public float getXpos() {
    	return playerXpos;
    }
    
    /**
     * Getter for the value of the player Y-coordinate
     * 
     * @return      Returns the Y-coordinate of the player
     */
    public float getYpos() {
    	return playerYpos;
    }
    
    /**
     * Sets the size of the player in length, height and coordinates to spawn
     */
    public void resetPlayer() {
    	playerLengthMultiplier = 7;
    	playerLength = SimpleSlickGame.getScreenWidth()/playerLengthMultiplier;
    	playerHeight = SimpleSlickGame.getScreenHeight()*0.02f;
    	playerXpos = SimpleSlickGame.getScreenWidth()/2.0f-(playerLength*0.50f);
    	playerYpos = SimpleSlickGame.getScreenHeight()*0.90f; 
    }

}
