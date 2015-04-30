package example;

import org.newdawn.slick.Graphics;

public class Brick {	
	
	public float 
	
		brickLength = 55,			//length of created bricks
		brickHeight = 15,			//height of bricks
        brickXpos,					//X-position, value set to null.
        brickYpos; 					//Y-position, value set to null.
    
public void createBrick(Graphics g, int brickXpos, int brickYpos) {
        
        g.drawRect(brickXpos,brickYpos, brickLength,brickHeight);                                  
        
    }
		
		
			
		
	

}
