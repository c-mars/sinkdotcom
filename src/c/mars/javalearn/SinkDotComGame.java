package c.mars.javalearn;

public class SinkDotComGame
{
	void play() {
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		
		SimpleDotCom theDotCom = new SimpleDotCom();
		
		int randomNum = (int) (Math.random() * 5);
		
		int[] locations = {randomNum, randomNum+1, randomNum+2};
		theDotCom.setLocationCells(locations); boolean isAlive = true;
		while(isAlive == true) {
			2
			give the dot com its locations (the array)
			make a boolean variable to track whether the game is still alive, to use in the while loop test. repeat while game is still alive.
				String guess = helper.getUserInput(“enter a number”);
			String result = theDotCom.checkYourself(guess); increment guess count
			numOfGuesses++;
			get user input String
			ask the dot com to check the guess; save the returned result in a String
			if (result.equals(“kill”)) { isAlive = false; System.out.println(“You took “ + numOfGuesses + “ guesses”); } // close if }
	}
}
