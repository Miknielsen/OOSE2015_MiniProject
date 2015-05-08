/*------------------------------------------------------------------------------------
 *  Author:        Mads Kondrup Haugaard, Mikkel Moenster Nielsen, Nicolai Foldager
 *  Written:       30/3/2015
 *  Last updated:  07/5/2015
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
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;
 
 
public class SimpleSlickGame extends BasicGame {
    
    private int matrixX = 10;																		/*Set size of X in the matrix array to use with the bricks*/
    private int matrixY = 10;																		/*Set size of Y in the matrix arrray to use with the bricks*/
    
    Brick brick[][] = new Brick[matrixX+1][matrixY+1];                     	             			/*Allocate memory for the array*/
    Player player = new Player();
    Ball ball = new Ball();
    
    private int score = 0;
    
    public boolean ballStart = false;
    private boolean bricksCreated = false;															/*Boolean to check if the bricks are created.*/
    
    int dead = 700;


    public SimpleSlickGame(String gamename) {
        super(gamename);    
    }
 
    @Override
    public void init(GameContainer gc) throws SlickException {}
    
    @Override
    public void update(GameContainer gc, int i) throws SlickException {
               
        Input input = gc.getInput();

        if(player.getXpos() < getScreenWidth()-50 - player.getLength()/2 && 								
        		input.isKeyDown(Input.KEY_D)) {														/*Checks if the player is within the window*/
            player.moveRight();
        }

        if(player.getXpos() + player.getLength() > 100 && input.isKeyDown(Input.KEY_A)) {			/*Checks if the player is within the window*/
            player.moveLeft();
        }
        
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException  {
    																								
    	g.drawString("Blocks hit: "+ score, 
    		SimpleSlickGame.getScreenHeight()*0.42f,SimpleSlickGame.getScreenHeight()*0.95f);		/*Draw the score in the game-window and place it just below the players start position.*/
    	
    	//End game if the player has eliminated all the blocks (all 100).
    	if  (score==100){
    		
        	int input = JOptionPane.showOptionDialog(null, "You have won the game \nYour score was "+ 
        				score, "SUCCESS!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, 
        				null, null, null);															/*JPane to show the user that they've won.*/
        	if(input == JOptionPane.OK_OPTION) {
        		System.exit(0);
        	}
        		
        }
    	
    	if(!bricksCreated) {																		/*Checks if the bricks have been drawn once*/
		    for (int i = 0; i<matrixY; i++) {
		        for (int j = 0; j < matrixX; j++) {
        			brick[i][j] = new Brick(g, 5+(i*65), 10+(j*25)); 								/*Create the bricks with a spacing of 15 and 10 (bricklength+15=65 & brickheight+10=25)*/
	        	}
	        }
		    bricksCreated = true;																	/*When bricks have been drawn, set to false to avoid them being redrawn every frame*/
    	}
    	
        player.createPlayer(g);																		/*Creates the player*/
        
        ball.createBall(g);																			/*Creates the ball*/
        ball.update();																				/*Update the position of the ball*/
            
        if(ball.getYcoord() > player.getYpos() - (player.getHeight()/2) &&
                ball.getXcoord() > (player.getXpos()) &&
                ball.getXcoord() < (player.getXpos() + player.getLength())) {
            ball.changeYdirection();																/*Changes the direction of the ball on the Y-axis*/
            ball.setSpeed(1.025f);																	/*Increases the speed of the ball each time it hits the player*/
        } else if (ball.getXcoord() <= 0.0f || ball.getXcoord() > getScreenWidth() - 10.0f) {		/*Check if the ball has hit the far right side of the screen*/
            ball.changeXdirection();																/*Changes the direction of the ball on the X-axis*/
        } else if (ball.getYcoord() == getScreenHeight()-10.0f || ball.getYcoord() <= 0.0f) {		/*Checks if the ball has hit the top*/
            ball.changeYdirection();																
        } else if (ball.getYcoord() > player.getYpos() + player.getHeight()) {						/*A check to see if the ball is underneath the y-position of the player.*/
            
            ball.stopBall();																		/*Stops the ball from moving*/
            
            //Set the coords of the ball to be considered dead to avoid overflow 
            ball.setXcoord(dead);
            ball.setYcoord(dead);

            int input = JOptionPane.showOptionDialog(null, "You have lost the game. \nYour score was " + 
            		score, "GAME OVER", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
            		null, null, null);																/*Creates jpanel with game over screen and score display.*/
            
            if(input == JOptionPane.OK_OPTION)				
            {
                System.exit(0);																		/*If the OK button is cancelled then exit the program with no errors*/
            }
            
            if(input == JOptionPane.OK_CANCEL_OPTION)
            {
            	System.exit(0);																		/*If the OK button is cancelled then exit the program with no errors*/	
            }
        }
        
        for (int k = 0; k<matrixY; k++) {
            for (int j = 0; j < matrixX; j++) {
            	if(brick[k][j].getXpos() != dead &&
            			ball.getYcoord() >= brick[k][j].getYpos() - 3 &&
            			ball.getYcoord() <= brick[k][j].getYpos() + 3 &&
            			ball.getXcoord() >= brick[k][j].getXpos() - 3 &&
            			ball.getXcoord() <= brick[k][j].getXpos() + brick[k][j].getLength() +3) { 	/*Check to see if the ball has hit the top*/
            		ball.changeYdirection();
            		score++;																		/*Add one to score after each collision*/
            		brick[k][j].setXpos(dead);														/*Move the brick out of the window to avoid another collision*/
            	} else if(brick[k][j].getXpos() != dead &&
            			ball.getYcoord() >= brick[k][j].getYpos() + brick[k][j].getHeight() - 3 && 
            			ball.getYcoord() <= brick[k][j].getYpos() + brick[k][j].getHeight() + 3 &&
            			ball.getXcoord() >= brick[k][j].getXpos() -3 &&
            			ball.getXcoord() <= brick[k][j].getXpos() + brick[k][j].getLength() + 3) { 	/*Check to see if the ball has hit the bottom*/
            		ball.changeYdirection();
            		score++;																		/*Add one to score after each collision*/
            		brick[k][j].setXpos(dead);														/*Move the brick out of the window to avoid another collision*/
            	} else if(brick[k][j].getXpos() != dead &&
            			ball.getYcoord() >= brick[k][j].getYpos() - 3  &&
            			ball.getYcoord() <= brick[k][j].getYpos() + brick[k][j].getHeight() + 3 &&
            			ball.getXcoord() >= brick[k][j].getXpos() - 3 &&
            			ball.getXcoord() <= brick[k][j].getXpos() + 3) { 							/*Check to see if the ball has hit the left*/
            		ball.changeXdirection();
            		score++;																		/*Add one to score after each collision*/
            		brick[k][j].setXpos(dead);														/*Move the brick out of the window to avoid another collision*/
            	} else if(brick[k][j].getXpos() != dead &&
            			ball.getYcoord() >= brick[k][j].getYpos() - 3 &&
            			ball.getYcoord() <= brick[k][j].getYpos() + brick[k][j].getHeight() + 3 &&
            			ball.getXcoord() >= brick[k][j].getXpos() + brick[k][j].getLength() - 3 &&
            			ball.getXcoord() <= brick[k][j].getXpos() + brick[k][j].getLength() + 3) { 	/*Check to see if the ball has hit the right*/
            		ball.changeXdirection();
            		score++;																		/*Add one to score after each collision*/
            		brick[k][j].setXpos(dead);														/*Move the brick out of the window to avoid another collision*/
            	} else if(brick[k][j].getXpos() != dead) {
                	brick[k][j] = new Brick(g, 5+(k*65), 10+(j*25)); 								/*Redraw the brick if it's not considered dead*/        								   		
            	}
            }
        }         	
    }
   
    public static void main(String[] args) {
    	
        try {
            AppGameContainer appgc;
 
            appgc = new AppGameContainer(new SimpleSlickGame("Breakout"));                 			/*Name of the game*/
            appgc.setDisplayMode(getScreenWidth(), getScreenHeight(), false);  						/*Fit window to screen size*/
            appgc.setTargetFrameRate(120);															/*Limit the framerate to make the speed consistent over all computers*/
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
        return 650;    
    }

}
