package example;
 
import java.util.Random;
 
import org.newdawn.slick.Graphics;
 
public class Brick {
       
        public Brick(Graphics g, int xPos, int yPos, int x, int y){
                g.drawRect(xPos,yPos, x, y);
        }
       
}
