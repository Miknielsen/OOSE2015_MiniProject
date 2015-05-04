package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

public class Ball {
    
    public float 
    ballRadius = 15.0f,                                                             //The radius of the ball
    ballXpos = SimpleSlickGame.getScreenWorkingWidth()/2.0f,                        //The start X-coordinates of the ball, center of screen
    ballYpos = SimpleSlickGame.getScreenWorkingHeight()*0.80f;                      //The start Y-coordinates of the ball, 80% on the Y-axis
    
    public void createBall(Graphics g){

        g.drawOval(ballXpos, ballYpos, ballRadius, ballRadius);                     //Creates an oval shape, X-pos, Y-pos, radius, radius
    }
    
    public void ballMovement(){
        
    }

}
