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
 
import javax.swing.JOptionPane;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;
 
 
public class SimpleSlickGame extends BasicGame {
    
    private int matrixX = 10;																				//Set size of X in the matrix
    private int matrixY = 10;																				//Set size of Y in the matrix

    Brick brick[][] = new Brick[matrixX+1][matrixY+1];                                  
    Player player = new Player();
    Ball ball = new Ball();
   
    private int score = 0;

    private boolean bricksCreated = false;
   
    public SimpleSlickGame(String gamename) {
        super(gamename);    
    }
 
    @Override
    public void init(GameContainer gc) throws SlickException {}
 
    @Override
    public void update(GameContainer gc, int i) throws SlickException {
               
        Input input = gc.getInput();

        if(player.getXpos() < getScreenWidth()-50 - player.getLength()/2 && 								
        		input.isKeyDown(Input.KEY_D)) {																//Checks if the player is within the window
            player.moveRight();
        }

        if(player.getXpos() + player.getLength() > 100 && input.isKeyDown(Input.KEY_A)) {					//Checks if the player is within the window
            player.moveLeft();
        }
                               
        //DEBUG - CLOSES THE GAME WHEN ESCAPE IS PRESSED. DO-NOT-DELETE
        if(input.isKeyPressed(Input.KEY_ESCAPE)) {
            System.exit(0);
            Log.debug("Game terminated due to ESC being pressed!");
        }
       
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException  {

    	//Creates a 10x10 matrix of bricks once
    	if(!bricksCreated) {
		    for (int i = 0; i<matrixY; i++) {
		        for (int j = 0; j < matrixX; j++) {
        			brick[i][j] = new Brick(g, 5+(i*65), 10+(j*25));
	        	}
	        }
		    bricksCreated = true;
    	}
    	
        player.createPlayer(g);																				//Creates the player
       
        ball.createBall(g);                                                             					//Creates the ball
        ball.update();                                                                  					//Updates the ball position
       
        if(ball.getYcoord() > player.getYpos() - (player.getHeight()/2) &&
                ball.getXcoord() > (player.getXpos()) &&
                ball.getXcoord() < (player.getXpos() + player.getLength())) {
            ball.changeYdirection();
            ball.setSpeed(1.02f);																			//Increases the speed of the ball each time it hits the player
        } else if (ball.getXcoord() <= 0.0f || ball.getXcoord() > getScreenWidth() - 10.0f) {
            ball.changeXdirection();
        } else if (ball.getYcoord() == getScreenHeight()-10.0f || ball.getYcoord() <= 0.0f) {
            ball.changeYdirection();
        } else if (ball.getYcoord() > player.getYpos() + player.getHeight()) {
            //TODO Show game over splash screen here
            ball.stopBall();
            ball.setXcoord(0);
            ball.setYcoord(0);
            System.out.println("Game over!");
            gameOverText(gc, g, score);

            int input = JOptionPane.showOptionDialog(null, "You have lost the game!", "GAME OVER", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

            if(input == JOptionPane.OK_OPTION)
            {
                System.exit(0);
            }
        }
        
        for (int k = 0; k<matrixY; k++) {
            for (int j = 0; j < matrixX; j++) {
            	if(ball.getYcoord() >= brick[k][j].getYpos() - 3 &&
            			ball.getYcoord() <= brick[k][j].getYpos() + 3 &&
            			ball.getXcoord() >= brick[k][j].getXpos() - 3 &&
            			ball.getXcoord() <= brick[k][j].getXpos() + brick[k][j].getLength() +3) { 			//Top collision
            		ball.changeYdirection();
            		System.out.println("TOP");
            		brick[k][j].setXpos(655);
            		brick[k][j].setYpos(725);
            	} else if(ball.getYcoord() >= brick[k][j].getYpos() + brick[k][j].getHeight() - 3 && 
            			ball.getYcoord() <= brick[k][j].getYpos() + brick[k][j].getHeight() + 3 &&
            			ball.getXcoord() >= brick[k][j].getXpos() -3 &&
            			ball.getXcoord() <= brick[k][j].getXpos() + brick[k][j].getLength() + 3) { 			//Bottom collision
            		ball.changeYdirection();
            		System.out.println("BOTTOM");
            		brick[k][j].setXpos(655);
            		brick[k][j].setYpos(725);
            	} else if(ball.getYcoord() >= brick[k][j].getYpos() - 3  &&
            			ball.getYcoord() <= brick[k][j].getYpos() + brick[k][j].getHeight() + 3 &&
            			ball.getXcoord() >= brick[k][j].getXpos() - 3 &&
            			ball.getXcoord() <= brick[k][j].getXpos() + 3) { 									//Left collision
            		ball.changeXdirection();
            		System.out.println("LEFT");
            		brick[k][j].setXpos(655);
            		brick[k][j].setYpos(725);
            	} else if(ball.getYcoord() >= brick[k][j].getYpos() - 3 &&
            			ball.getYcoord() <= brick[k][j].getYpos() + brick[k][j].getHeight() + 3 &&
            			ball.getXcoord() >= brick[k][j].getXpos() + brick[k][j].getLength() - 3 &&
            			ball.getXcoord() <= brick[k][j].getXpos() + brick[k][j].getLength() + 3) { 			//Right collision
            		ball.changeXdirection();
            		System.out.println("RIGHT");
            		brick[k][j].setXpos(655);
            		brick[k][j].setYpos(725);
            	}
            	
            	//If the brick hasn't already been hit, then redraw it every frame
                if(brick[k][j].getXpos() != 655) {
                	brick[k][j] = new Brick(g, 5+(k*65), 10+(j*25));
                }
            }
        }         	
    }
   
    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
 
            appgc = new AppGameContainer(new SimpleSlickGame("Breakout"));                  //Name of the game
            appgc.setDisplayMode(getScreenWidth(), getScreenHeight(), false);  				//Fit window to screen size
            appgc.setTargetFrameRate(120);													//Limit the framerate to make the speed consistent over all computers
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
    /**
     * Gets the width of the playing window
     *
     * @return width of the screen in pixel
     */
    public static int getScreenWidth() {                                                                
        return 650;
        
    }
   
    /**
     * Gets the height of the playing window
     *
     * @return height of the screen in pixel
     */
    public static int getScreenHeight() {
        return 720;    
    }
   
    /**
     * Sets the score
     *
     * @param toScore   An integer that is added to the current score.
     */
    public void setScore(int toScore) {
        score = score + toScore;
    }
   
    public void gameOverText(GameContainer gc, Graphics g, int score)  {
    	
        int x = 0;
        int y = 0;
        float boxLength = SimpleSlickGame.getScreenWidth();                                //Gets screen width
        float boxHeight = SimpleSlickGame.getScreenHeight();                               //Gets screen height
        String endText = ("Game over! Your score was " + score);                           //STILL NEEDS A SCORE TO PRINT OUT
        float textPosX = SimpleSlickGame.getScreenWidth()*0.31f;
        float textPosY = SimpleSlickGame.getScreenHeight()*0.50f;
       
        g.setColor(Color.cyan);
        g.fillRect(x, y, boxLength, boxHeight);
        g.drawRect(x, y, boxLength, boxHeight);
        g.setColor(Color.black);
        g.drawString(endText, textPosX, textPosY);
    }
}
