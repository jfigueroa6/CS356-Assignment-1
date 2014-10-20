package edu.cs356.assignment1;

import java.util.Scanner;

public class SingleAnswer extends Answer {
	//=================================================================
	// Constructor
	//=================================================================
	/**
	 * Default constructor. Will initialize availableAnswers and response hash map.
	 * @param availableAnswers	Answers that are available
	 */
	public SingleAnswer(String availableAnswers) {
		super(availableAnswers);
	}
	
	//=================================================================
	// Methods
	//=================================================================
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
		
		//TODO: Single answer implementation
		
		
		//Submission was successful
		scanResponse.close();
		return successful;
	}
}
