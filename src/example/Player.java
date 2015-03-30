package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

public class Player {
        
    public void CreatePlayer() {
        
    }
    
    
    public void Movement(GameContainer key) {
        
        Input input = key.getInput();
        if(input.isKeyPressed(Input.KEY_D)) {
            
            Log.debug("Game terminated due to ESC being pressed!");
        }
        
    }
    
    //Create player - Rectangle
    
    
    //Fixiate player on the y-axis
    //Allow player to move on the x-axis with the arrow-keys or mouse
    
}
