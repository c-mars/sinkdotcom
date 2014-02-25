package mars.sinkdotcom;

import java.util.ArrayList;

public class DotComBust
{
	private GameHelper mHelper;
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int mNumOfGuesses = 0;
	
	DotComBust(GameHelper helper) {
		mHelper = helper;
		setUpGame();
	}
	
	private void setUpGame() { 
		// first make some dot coms and give them locations
		DotCom one = new DotCom("Pets.com");
		DotCom two = new DotCom("eToys.com");
		DotCom three = new DotCom("Go2.com");

		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);

		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses");

		for (DotCom dotComToSet : dotComsList) { 
			ArrayList<String> newLocation = mHelper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation); 
		} // close for loop
	} // close setUpGame method
	
	public void startPlaying(){ 
		while(!dotComsList.isEmpty()) { 
			String userGuess = mHelper.getUserInput("Enter a guess"); 
			checkUserGuess(userGuess); 
		} // close while

		finishGame();
	} 
	
	private void checkUserGuess(String userGuess) {
		mNumOfGuesses++;
		String result = "miss"; 
		
		for (DotCom dotComToTest : dotComsList) {
			result = dotComToTest.checkYourself(userGuess); 
			
			if (result.equals("hit")) {
				break;
			}
			
			if (result.equals("kill")) { 
				dotComsList.remove(dotComToTest); 
				break;
			} 
		}
		System.out.println(result);
	}
	
	private void finishGame(){
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if (mNumOfGuesses <= 18) {
			System.out.println("It only took you " + mNumOfGuesses + " guesses.");
			System.out.println(" You got out before your options sank.");
		} else { 
			System.out.println("Took you long enough. " + mNumOfGuesses + " guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}
}
