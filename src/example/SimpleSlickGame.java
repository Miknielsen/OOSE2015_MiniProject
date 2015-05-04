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

import java.util.ArrayList;
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
    
    Brick brick = new Brick();                                  
    Player player = new Player();
    Ball ball = new Ball();
        
    float x1 = 50;
    float y1 = 50;
    
    
    
    public SimpleSlickGame(String gamename) {
        super(gamename);    
    }

    @Override
    public void init(GameContainer gc) throws SlickException {}

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
                
        Input input = gc.getInput();
        
        if(input.isKeyPressed(Input.KEY_D)) {
            player.moveRight();
            Log.debug("Player moved right");
        }
        
        if(input.isKeyPressed(Input.KEY_A)) {
            player.moveLeft();
            Log.debug("Player moved left");
        }
                               
        //DEBUG - CLOSES THE GAME WHEN ESCAPE IS PRESSED. DO-NOT-DELETE
        if(input.isKeyPressed(Input.KEY_ESCAPE)) {
            System.exit(0);
            Log.debug("Game terminated due to ESC being pressed!");
        }
        
    }

    public void render(GameContainer gc, Graphics g) throws SlickException  {
           
        player.createPlayer(g);
        
        ball.createBall(g);                                                             //Creates the ball
        ball.update();                                                                  //Updates the ball position
        
        if(ball.getYcoord() > player.getYpos() - (player.getHeight()/2) &&
                ball.getXcoord() > (player.getXpos()) && 
                ball.getXcoord() < (player.getXpos() + player.getLength())) {
            ball.changeYdirection();
        } else if (ball.getXcoord() == 0 || ball.getXcoord() > getScreenWidth()) {
            ball.changeXdirection();
        } else if (ball.getYcoord() == getScreenHeight() || ball.getYcoord() == 0) {
            ball.changeYdirection();
        } else if (ball.getYcoord() > player.getYpos() + player.getHeight()) {
            //TODO Show game over splash screen here
            ball.stopBall();
            System.out.println("Game over!");
        }
        
        for (int i = 0; i<21; i++) {
            for (int j = 0; j < 17; j++) {
                brick.createBrick(g, 5+(i*65), 10+(j*25));          //create brick in a grid of 21x17
                
            }
        }
            
    }
    
    public static void main(String[] args) {
        try {
            AppGameContainer appgc;

            appgc = new AppGameContainer(new SimpleSlickGame("Breakout"));                   //Name of the game
            appgc.setDisplayMode(getScreenWidth(), getScreenHeight(), false);  //Fit window to screen size

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
    public static int getScreenWidth() {                                                                 
        return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width - 50;      //Get screen width   
    }
    
    /**
     * Gets the height of the entire screen
     * 
     * @return height of screen in pixel
     */
    public static int getScreenHeight() {
        return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height - 50;     //Get screen height
    }
    
}
