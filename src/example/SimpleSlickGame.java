/*------------------------------------------------------------------------------------
 *  Author:        Mads Kondrup Haugaard, Mikkel Moenster Nielsen, Nicolai Foldager
 *  Written:       30/3/2015
 *  Last updated:  30/3/2015
 *  
 *  BREAKOUT GAME
 *  This game creates a player model, multiple 'enemy' blocks to destroy and a ball
 *  that is used to destroy these enemy blocks. 
 *
 *------------------------------------------------------------------------------------*/

package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;


public class SimpleSlickGame extends BasicGame {
    
	Player player = new Player();
	Ball ball = new Ball();
    	
	public SimpleSlickGame(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
	    
	    Input input = gc.getInput();
	    
        if(input.isKeyPressed(Input.KEY_D)) {
            player.MoveRight();
            Log.debug("Player moved right");
        }
        
        if(input.isKeyPressed(Input.KEY_A)) {
            player.MoveLeft();
            Log.debug("Player moved left");
        }
	    	    
	    //DEBUG - CLOSES THE GAME WHEN ESCAPE IS PRESSED. DO-NOT-DELETE
	    
	    if(input.isKeyPressed(Input.KEY_ESCAPE)) {
	        System.exit(0);
	        Log.debug("Game terminated due to ESC being pressed!");
	    }
	    
	}

	public void render(GameContainer gc, Graphics g) throws SlickException 	{
	       
	    player.createPlayer(g);
	    ball.createBall(g);
	            		
	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer appgc;

			appgc = new AppGameContainer(new SimpleSlickGame("Breakout"));                   //Name of the game
			appgc.setDisplayMode(getScreenWorkingWidth(), getScreenWorkingHeight(), false);  //Fit window to screen size

			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
	
	/**
	 * Gets the width of the entire screen
	 * 
	 * @return width of screen in pixel
	 */
	public static int getScreenWorkingWidth() {                                                                 
	    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;      //Get screen width   
	}
	
	/**
	 * Gets the height of the entire screen
	 * 
	 * @return height of screen in pixel
	 */
	public static int getScreenWorkingHeight() {
	    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;     //Get screen height
	}
	
}

