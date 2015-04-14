package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

public class Player {
    
	public float playerLengthMultiplier = 19;
	
    public float 
    	playerLength = SimpleSlickGame.getScreenWorkingWidth()/playerLengthMultiplier,
    	playerHeight = SimpleSlickGame.getScreenWorkingHeight()*0.02f,
        playerXpos = SimpleSlickGame.getScreenWorkingWidth()/2.0f-(playerLength*0.50f),
        playerYpos = SimpleSlickGame.getScreenWorkingHeight()*0.90f; 
    
    public void createPlayer(Graphics g) {
        
        g.drawRect(playerXpos,playerYpos, playerLength,playerHeight);                                  //Draws a rectangle (pos,pos,size,size)
        
    }
    
    public void MoveRight() {
        if(playerXpos < SimpleSlickGame.getScreenWorkingWidth())
            playerXpos += playerLength;
        
        System.out.println(playerXpos);
    }
    
    public void MoveLeft() {
        if(playerXpos > 0)
            playerXpos -= playerLength;
    }
    
    
    /**
     * Returns a float
     * 
     * @param varName name of the float you want
     * @return the value of the 
     */
    public float getFloat(String varName) {        
        if (varName.equals(playerXpos))
            return playerXpos;
        else if (varName.equals(playerYpos))
            return playerYpos;
        else if (varName.equals(playerLength))
            return playerLength;
        else if (varName.equals(playerHeight))
            return playerHeight;
        else
            return -1;
    }
    
}
