package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

public class Player {
    
	public float playerLengthMultiplier = 19;
	
    private float 
    	playerXpos = SimpleSlickGame.GetScreenWorkingWidth()/2,
    	playerYpos = SimpleSlickGame.GetScreenWorkingHeight()*0.90f,
    	playerLength = SimpleSlickGame.GetScreenWorkingWidth()/playerLengthMultiplier,
    	playerHeight = SimpleSlickGame.GetScreenWorkingHeight()*0.02f; 
    
    /**
     * Returns a float
     * 
     * @param varName name of the float you want
     * @return the value of the 
     */
    public float getter(String varName) {        
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
    
    public void createPlayer(Graphics g) {
        
        g.drawRect(playerXpos,playerYpos, playerLength,playerHeight);                                  //Draws a rectangle (pos,pos,size,size)
        
    }
       
    public void Movement(GameContainer key) {
        
        Input keyInput = key.getInput();                                   //Save the input passed from the method as keyInput
        
        if(keyInput.isKeyPressed(Input.KEY_D)) {       
            playerXpos += 10;                                              //Move the Player 10px to the right
            
            Log.debug("Player moved right");
        }
        
    }
    
}
