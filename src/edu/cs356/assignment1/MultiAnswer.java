package edu.cs356.assignment1;

import java.util.Scanner;

public class MultiAnswer extends Answer {	
	//=================================================================
	// Constructor
	//=================================================================
	/**
	 * Default constructor. Will initialize availableAnswers and response hash map.
	 * @param availableAnswers	Answers that are available
	 */
	public MultiAnswer(String availableAnswers) {
		super(availableAnswers);
	}
	
	/**
	 * @return Gets the available answers.
	 */
	
	//==================================================================
	// Methods
	//==================================================================
	/**
	 * The submitted response is checked to ensure that there are no unknown selections, and
	 * changes the appropriate answer to true.
	 * @param subResponse	Submitted response
	 * @return	True if the submission is successful. False otherwise.
	 */
	public boolean setResponse(String subResponse) {
		boolean successful = true;		//Returns if there is an error with submission
		//Create scanner to go through submitted response by using ',' as a delimiter
		Scanner scanResponse = new Scanner(subResponse);
		scanResponse.useDelimiter(",");
		
		//For every response, check that it exists in the hashmap.
		//If it doesn't, then there is an error with the input. Else,
		//change the stored value to true.
		while (scanResponse.hasNext()) {
			//Get response and trim whitespace
			String temp = scanResponse.next();
			temp = temp.trim();
			
			//Find if the answer is acceptable, and make it true if it is.
			if (super.getResponse().containsKey(temp))
				super.getResponse().put(temp, true);
			//Answer unacceptable so close scanner and return false
			else
				successful = false;
		}
		
		//Submission was successful
		scanResponse.close();
		return successful;
	}

}
