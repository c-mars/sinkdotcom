package mars.sinkdotcom;

import java.util.ArrayList;

public class Game
{
	GameHelper mGameHelper;
	
	Game(GameHelper helper) {
		mGameHelper = helper;
	}
	
	void play() {
		int numOfGuesses = 0;
		
		SimpleDotCom theDotCom = new SimpleDotCom();
		
		int randomNum = (int) (Math.random() * 5);
		
		ArrayList<String> locations = new ArrayList<String>();
		
		locations.add(Integer.toString(randomNum));
		locations.add(Integer.toString(randomNum+1));
		locations.add(Integer.toString(randomNum+2));
		
		theDotCom.setLocationCells(locations); 
		boolean isAlive = true;
		while(isAlive == true) {
			
			String guess = mGameHelper.getUserInput("enter a number");
			String result = theDotCom.checkYourself(guess);
			System.out.println(result);
			numOfGuesses++;
			
			if (result.equals("kill")) { 
				isAlive = false; 
				System.out.println("You took " + numOfGuesses + " guesses"); 
			} // close if 
		}
	}
}
