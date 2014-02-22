package mars.javalearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mars.sinkdotcom.GameHelper;

public class GameHelperAndroid extends GameHelper
{
	@Override
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(
					new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0 )
				return null;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return inputLine;
	}
}
