
package example;

import org.newdawn.slick.Graphics;
 
public class Brick {
	
	int g_xPos;															//initializing the two position variables.
	int g_yPos;
	int length = 55;													//Length of each brick
	int height = 15;													//Height of each brick
	 
	/**
	 * Creates an enemy brick at a given position and given size
	 * 
	 * @param g        Graphics engine to draw the brick
	 * @param xPos     Integer value which sets the x-coordinate of a brick
	 * @param yPos     Integer value which sets the y-coordinate of a brick
	 */
    public Brick(Graphics g, int xPos, int yPos){
    	
    	g.drawRect(xPos,yPos, length, height);
    	      
            g_xPos = xPos;
            g_yPos = yPos;
    }
    
    /**
     * Setter for the position of the brick on the x-axis
     * 
     * @param pos       Integer value to set the x-coordinates of a brick
     */
    public void setXpos(int pos) {
    	g_xPos = pos;
    	
    }
    
    /**
     * Setter for the position of the brick on the y-axis
     * 
     * @param pos       Integer value to set the y-coordinates of a brick
     */
    public void setYpos(int pos) {
    	g_yPos = pos;
    }
    
    /**
     * Getter for the position that has been set for a brick on the x-axis
     * 
     * @return          Returns the integer value of the coordinate of a brick on the x-axis
     */
    public int getXpos() {
    	return g_xPos;
    }
    
    /**
     * Getter for the position that has been set for a brick on the y-axis
     * 
     * @return          Returns the integer value of the coordinate of a brick on the y-axis
     */
    public int getYpos() {
    	return g_yPos;
    }
    
    /**
     * Getter for the length of a brick
     * 
     * @return          Returns the integer value of the length of a brick
     */
    public int getLength() {
    	return length;
    }
    
    /**
     * Getter for the height of a brick
     * 
     * @return          Returns the integer value of the height of a brick
     */
    public int getHeight() {
    	return height;
    }
       
}
