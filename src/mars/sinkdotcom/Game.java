package mars.sinkdotcom;

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
		
		int[] locations = {randomNum, randomNum+1, randomNum+2};
		theDotCom.setLocationCells(locations); 
		boolean isAlive = true;
		while(isAlive == true) {
			
			String guess = mGameHelper.getUserInput("enter a number");
			String result = theDotCom.checkYourself(guess);
			numOfGuesses++;
			
			if (result.equals("kill")) { 
				isAlive = false; 
				System.out.println("You took " + numOfGuesses + " guesses"); 
			} // close if 
		}
	}
}
