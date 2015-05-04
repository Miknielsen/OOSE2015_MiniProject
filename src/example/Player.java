package example;

import org.newdawn.slick.Graphics;

public class Player {
    
	private float playerLengthMultiplier = 7;
	 
	private float playerLength = SimpleSlickGame.getScreenWidth()/playerLengthMultiplier;
	private float playerHeight = SimpleSlickGame.getScreenHeight()*0.02f;
	private float playerXpos = SimpleSlickGame.getScreenWidth()/2.0f-(playerLength*0.50f);
	private float playerYpos = SimpleSlickGame.getScreenHeight()*0.90f; 
    
    public void createPlayer(Graphics g) {
        g.drawRect(playerXpos,playerYpos, playerLength,playerHeight);                                  //Draws a rectangle (pos,pos,size,size)
    }
    
    public void moveRight() {
        if(playerXpos < SimpleSlickGame.getScreenWidth())
            playerXpos += 3;
    }
    
    public void moveLeft() {
        if(playerXpos > 0)
            playerXpos -= 3;
    }
    
    public float getHeight() {
    	return playerHeight;
    }
    
    public float getLength() {
    	return playerLength;
    }
        
    public float getXpos() {
    	return playerXpos;
    }
    
    public float getYpos() {
    	return playerYpos;
    }
    
    public void resetPlayer() {
    	playerLengthMultiplier = 7;
    	playerLength = SimpleSlickGame.getScreenWidth()/playerLengthMultiplier;
    	playerHeight = SimpleSlickGame.getScreenHeight()*0.02f;
    	playerXpos = SimpleSlickGame.getScreenWidth()/2.0f-(playerLength*0.50f);
    	playerYpos = SimpleSlickGame.getScreenHeight()*0.90f; 
    }
    
}
