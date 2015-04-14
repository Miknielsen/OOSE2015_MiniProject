package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

public class Player {
    
	public float playerLengthMultiplier = 19;
	
    public float 
    	playerXpos = SimpleSlickGame.getScreenWorkingWidth()/2,
    	playerYpos = SimpleSlickGame.getScreenWorkingHeight()*0.90f,
    	playerLength = SimpleSlickGame.getScreenWorkingWidth()/playerLengthMultiplier,
    	playerHeight = SimpleSlickGame.getScreenWorkingHeight()*0.02f; 
    
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
    
    /*
       
    public void movement(GameContainer key) {
        
        Input keyInput = key.getInput();                                  							   //Save the input passed from the method as keyInput
        
        if(keyInput.isKeyPressed(Input.KEY_D)) {       
            playerXpos += 10;
        }
        
        if(keyInput.isKeyPressed(Input.KEY_A)) {       
            playerXpos -= 10;
        }
        
    }*/
    
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
