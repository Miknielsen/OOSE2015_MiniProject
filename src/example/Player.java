package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

public class Player {
    
    private float playerXpos, playerYpos, playerLength, playerHeight; 
    
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
    
    public void CreatePlayer() {
        
        //Create player - Rectangle
        
        //Fixiate player on the y-axis
        
    }
       
    public void Movement(GameContainer key) {
        
        Input keyInput = key.getInput();                                   //Save the input passed from the method as keyInput
        
        if(keyInput.isKeyPressed(Input.KEY_D)) {       
            xPos += 10;                                                    //Move the Player 10px to the right
            
            Log.debug("Player moved right");
        }
        
    }
    
}
