package mars.sinkdotcom;

import java.util.ArrayList;

class DotCom {
	
	private ArrayList<String> locationCells;
	private String mName;
	
	public DotCom() {
		setName("Unnamed.com");
	}
	
	public DotCom(String name) {
		setName(name);
	}
	
	public void setName(String name) {
		mName = name;
	}
	
	public String name() {
		return mName;
	}
	
	public void setLocationCells(ArrayList<String> loc) { 
		locationCells = loc;
	}
	
	public String checkYourself(String userInput)
	{
		String result = "miss";
		
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index);
			if (locationCells.isEmpty()) {
				result = "kill";
				System.out.println("Ouch! You sunk \"" + mName + "\" :(");
			}
			else {
				result = "hit";
			}
		}
		
		return result;
	}
}
