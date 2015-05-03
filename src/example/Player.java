package example;

import org.newdawn.slick.Graphics;

public class Player {
    
	private float playerLengthMultiplier = 19;
	 
	private float playerLength = SimpleSlickGame.getScreenWidth()/playerLengthMultiplier;
	private float playerHeight = SimpleSlickGame.getScreenHeight()*0.02f;
	private float playerXpos = SimpleSlickGame.getScreenWidth()/2.0f-(playerLength*0.50f);
	private float playerYpos = SimpleSlickGame.getScreenHeight()*0.90f; 
    
    public void createPlayer(Graphics g) {
        
        g.drawRect(playerXpos,playerYpos, playerLength,playerHeight);                                  //Draws a rectangle (pos,pos,size,size)
         
    }
    
    
    public void moveRight() {
        if(playerXpos < SimpleSlickGame.getScreenWidth())
            playerXpos += (playerLength/2);
        
        System.out.println(playerXpos);
    }
    
    public void moveLeft() {
        if(playerXpos > 0)
            playerXpos -= (playerLength/2);
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
    
}
