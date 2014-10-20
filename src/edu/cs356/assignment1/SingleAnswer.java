package edu.cs356.assignment1;

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
		
		//Since only a single answer, assume the entire string is the answer. Option should
		//already exist in hash map. If not, then there is an error: either multiple answers
		//or unknown option.
		subResponse = subResponse.trim();
		if (super.getResponse().containsKey(subResponse))
			super.getResponse().put(subResponse, true);
		else
			successful = false;
		
		//Submission was successful
		return successful;
	}
}
