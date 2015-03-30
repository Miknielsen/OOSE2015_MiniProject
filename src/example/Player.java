package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

public class Player {

        
    public void CreatePlayer() {
        
    }

    
    float xPos, yPos;

    
    
    public void Movement(GameContainer key) {
        
        Input keyInput = key.getInput();                                   //Save the input passed from the method as keyInput
        
        if(keyInput.isKeyPressed(Input.KEY_D)) {       
            xPos += 10;                                                    //Move the Player 10px to the right
            
            Log.debug("Player moved right");
        }
        
    }
    
    //Create player - Rectangle
    
    
    //Fixiate player on the y-axis
    //Allow player to move on the x-axis with the arrow-keys or mouse
    
}
