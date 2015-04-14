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
    	
	public SimpleSlickGame(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
	    	    
	    //DEBUG - CLOSES THE GAME WHEN ESCAPE IS PRESSED. DO-NOT-DELETE
	    Input input = gc.getInput();
	    if(input.isKeyPressed(Input.KEY_ESCAPE)) {
	        System.exit(0);
	        Log.debug("Game terminated due to ESC being pressed!");
	    }
	    
	}

	public void render(GameContainer gc, Graphics g) throws SlickException 	{
	    
	    player.createPlayer(g);
	        		
	}
	
	public static void main(String[] args) {
	    
		System.out.println(GetScreenWorkingWidth()/2);
		try {
			AppGameContainer appgc;

			appgc = new AppGameContainer(new SimpleSlickGame("Breakout"));                   //Name of the game
			appgc.setDisplayMode(GetScreenWorkingWidth(), GetScreenWorkingHeight(), false);  //Fit window to screen size

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
	public static int GetScreenWorkingWidth() {                                                                 //Get screen width
	    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
	    
	}
	
	/**
	 * Gets the height of the entire screen
	 * 
	 * @return height of screen in pixel
	 */
	public static int GetScreenWorkingHeight() {
	    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;     //Get screen height
	}
	
}

