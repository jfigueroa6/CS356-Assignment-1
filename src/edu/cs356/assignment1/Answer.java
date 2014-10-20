package edu.cs356.assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Answer {
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
	public Answer(String availableAnswers) {
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
	 * get available answer choices.
	 * @return	Available answers.
	 */
	public ArrayList<String> getAvailableAnswers() {
		return availableAnswers;
	}
	
	/**
	 * Override to set submitted response.
	 * @param response	Submitted response
	 * @return	True if response accepted
	 */
	public abstract boolean setResponse(String response);
	/**
	 * get submitted response
	 * @return	Submitted response
	 */
	public HashMap<String, Boolean> getResponse() {
		return response;
	}
}
