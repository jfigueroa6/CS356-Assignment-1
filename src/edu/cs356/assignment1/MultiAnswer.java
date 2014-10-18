package edu.cs356.assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MultiAnswer implements Answer {
	//=================================================================
	// Data Members
	//=================================================================
	private ArrayList<String> availableAnswers;	/**Store the available answers*/
	private HashMap<String, Boolean> response;	/**Stores submitted response*/
	
	//=================================================================
	// Constructor
	//=================================================================
	/**
	 * Default constructor. Will initialize availableAnswers and response hash map.
	 * @param availableAnswers	Answers that are available
	 */
	public MultiAnswer(String availableAnswers) {
		//Initialize available answers and initialize hashmap
		this.availableAnswers = new ArrayList<String>(0);
		response = new HashMap<String, Boolean>();	//Use default capacity of 16
		
		//Store the available answers into hashmap, so only those responses
		//can be used. Like checking for incorrect input.
		Scanner scanAnswers = new Scanner(availableAnswers);
		scanAnswers.useDelimiter(",");	//Use ',' as a delimiter to separate answer options
		while (scanAnswers.hasNext()) {
			String temp = scanAnswers.next();
			
			//Remove leading and trailing whitespace
			temp = temp.trim();
			
			//Store in hashmap and available answers
			response.put(temp, false);
			this.availableAnswers.add(temp);		
		}
		
		//Close scanner
		scanAnswers.close();
	}
	
	/**
	 * @return Gets the available answers.
	 */
	public ArrayList<String> getAvailableAnswers() {
		return availableAnswers;
	}

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
			if (response.containsKey(temp))
				response.put(temp, true);
			//Answer unacceptable so close scanner and return false
			else
				successful = false;
		}
		
		//Submission was successful
		scanResponse.close();
		return successful;
	}
	
	/**
	 * Get the submitted response.
	 * @return Returns response hash map
	 */
	public HashMap<String, Boolean> getResponse() {
		return response;
	}

}
