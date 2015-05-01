package example;

import org.newdawn.slick.Graphics;

public class Brick {	
	
	private float brickLength = 55;			//length of created bricks
	private float brickHeight = 15;			//height of bricks
	private float brickXpos;				//X-position, value set to null.
	private float brickYpos; 				//Y-position, value set to null.
    
public void createBrick(Graphics g, int brickXpos, int brickYpos) {
        
        g.drawRect(brickXpos,brickYpos, brickLength,brickHeight);                                  
        
    }
		
		
			
		
	

}
