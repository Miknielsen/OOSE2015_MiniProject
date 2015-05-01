package example;

import org.newdawn.slick.Graphics;

public class Player {
    
	public float playerLengthMultiplier = 19;
	
    public float 
    	playerLength = SimpleSlickGame.getScreenWidth()/playerLengthMultiplier,
    	playerHeight = SimpleSlickGame.getScreenHeight()*0.02f,
        playerXpos = SimpleSlickGame.getScreenWidth()/2.0f-(playerLength*0.50f),
        playerYpos = SimpleSlickGame.getScreenHeight()*0.90f; 
    
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
