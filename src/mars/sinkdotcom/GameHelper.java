package mars.sinkdotcom;

import java.util.ArrayList;

public class GameHelper
{
	private static final String sAlphabet = "abcdefg";
	private int mGridLength = 7;
	private int mGridSize = 49;
	private int [] mGrid = new int[mGridSize];
	private int mComCount = 0;
	
	public String getUserInput(String prompt) {
		return "This is fake getUserInput call. You need override GameHelper method in your praticular helper class";
	}
	
	public void printMessage(String message) {
		System.out.println("This is fake printMessage(\"" + message +"\") call. You need override GameHelper method in your praticular helper class");
	}
	
	public ArrayList<String> placeDotCom(int comSize) { 
		ArrayList<String> alphaCells = new ArrayList<String>();
		String temp = null; 									// temporary String for concat
		int [] coords = new int[comSize]; 						// current candidate coords
		int attempts = 0; 										// current attempts counter
		boolean success = true; 								// flag = found a good location ?
		int location = 0; 										// current starting location
		
		mComCount++; 											// nth dot com to place
		
		int incr = 1; 											// set horizontal increment
		if ((mComCount % 2) == 1) { 							// if odd dot com (place vertically)
			incr = mGridLength; 								// set vertical increment
		}
		
		do { 													// main search loop (32)
			
			location = (int) (Math.random() * mGridSize); 		// get random starting point   //System.out.print(“ try “ + location);
			int x = 0; 											// nth position in dotcom to place success = true; // assume success
			success = true; 									// we need to assume that search is successful until no error conditions found
			
			while (success && x < comSize) { 					// look for adjacent unused spots
				
				if (mGrid[location] == 0) { 					// if not already used
					coords[x] = location; 						// save location in numeric style
					
					if (++x >= comSize)							// if dotCom is already filled with locations - just break iterations
						break;
					
					location += incr; 							// try 'next' adjacent
					if (location >= mGridSize) { 				// out of bounds - ‘bottom’
						success = false; 
					}
					if (x > 0 && (location % mGridLength == 0)) { // out of bounds - right edge
						success = false;
					}
					
				} else { 										// found already used location
					success = false;
				}
			}
		} 
		while (!success & attempts++ < 200 );
		
		int x = 0; 												// turn location into alpha coords
		int row = 0;
		int column = 0;

		while (x < comSize) {
			mGrid[coords[x]] = 1; 								// mark master grid pts. as ‘used’
			
			row = (int) (coords[x] / mGridLength + 1); 			// get row value
			column = coords[x] % mGridLength; 					// get numeric column value
			temp = String.valueOf(sAlphabet.charAt(column)); 	// convert to alpha
			
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++; 
		}

		return alphaCells;
	}
}
