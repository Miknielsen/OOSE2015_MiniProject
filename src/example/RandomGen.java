package example;

import java.util.Random;

public class RandomGen {

    /**
     * Creates a random value between 2 given input values, minimum and maximum
     * 
     * @param min       Takes an integer as value and sets it to minimum
     * @param max       Takes an integer as value and sets it to maximum
     * @return          Returns and integer which is the random value between minimum and maximum
     */
	public static int randInt(int min, int max) {
		
		Random rand = new Random();
		
		int randomNum = rand.nextInt((max - min) +1) + min;
		
		return randomNum;
	}
	
}
