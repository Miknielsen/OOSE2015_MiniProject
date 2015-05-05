
package example;

import org.newdawn.slick.Graphics;
 
public class Brick {
	
	int g_xPos;
	int g_yPos;
	int length = 55;
	int height = 15;
       
    public Brick(Graphics g, int xPos, int yPos){
            g.drawRect(xPos,yPos, length, height);
          
            g_xPos = xPos;
            g_yPos = yPos;
    }
    
    public void setXpos(int pos) {
    	g_xPos = pos;
    }
    
    public void setYpos(int pos) {
    	g_yPos = pos;
    }
    
    public int getXpos() {
    	return g_xPos;
    }
    
    public int getYpos() {
    	return g_yPos;
    }
    
    public int getLength() {
    	return length;
    }
    
    public int getHeight() {
    	return height;
    }
       
}
