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
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;
 
 
public class SimpleSlickGame extends BasicGame {
   
    Brick brick[][] = new Brick[10][10];                                  
    Player player = new Player();
    Ball ball = new Ball();
   
    private int score = 0;
   
   
    public SimpleSlickGame(String gamename) {
        super(gamename);    
    }
 
    @Override
    public void init(GameContainer gc) throws SlickException {}
 
    @Override
    public void update(GameContainer gc, int i) throws SlickException {
               
        Input input = gc.getInput();
       
        if(player.getXpos() < getScreenWidth()-50 - player.getLength()/2 && input.isKeyDown(Input.KEY_D)) {
            player.moveRight();
            Log.debug("Player moved right");
        }
       
        if(player.getXpos() + player.getLength() > 100 && input.isKeyDown(Input.KEY_A)) {
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
        } else if (ball.getXcoord() == 0 || ball.getXcoord() > getScreenWidth() - 10) {
            ball.changeXdirection();
        } else if (ball.getYcoord() == getScreenHeight()-10 || ball.getYcoord() == 0) {
            ball.changeYdirection();
        } else if (ball.getYcoord() > player.getYpos() + player.getHeight()) {
            //TODO Show game over splash screen here
            ball.stopBall();
            System.out.println("Game over!");
            gameOverText(gc, g, 10);
        }
       
        for (int i = 0; i<10; i++) {
            for (int j = 0; j < 10; j++) {
                brick[i][j] = new Brick(g, 5+(i*65), 10+(j*25), 55, 15);
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
     * Gets the width of the playing window
     *
     * @return width of the screen in pixel
     */
    public static int getScreenWidth() {                                                                
        return 1280;        
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
        String endText = ("Game over! Your score was " +score);                                         //STILL NEEDS A SCORE TO PRINT OUT
        float textPosX = SimpleSlickGame.getScreenWidth()*0.40f;
        float textPosY = SimpleSlickGame.getScreenHeight()*0.50f;
       
        g.setColor(Color.blue);
        g.fillRect(x, y, boxLength, boxHeight);
        g.drawRect(x, y, boxLength, boxHeight);
        g.setColor(Color.black);
        g.drawString(endText, textPosX, textPosY);
    }
}