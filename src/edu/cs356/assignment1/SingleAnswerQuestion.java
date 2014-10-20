package edu.cs356.assignment1;

public class SingleAnswerQuestion implements Question {
	//=================================================================
	// Data Members
	//=================================================================
	private SingleAnswer answer;		/** Holds the answers available for the question*/
	private String question;		/** Stores the question being asked */
	//=================================================================
	// Constructor
	//=================================================================
	public SingleAnswerQuestion(String question, String availableAnswers) {
		//Store question and create MultiAnswer object
		this.question = question;
		answer = new SingleAnswer(availableAnswers);
	}
	//=================================================================
	// Methods
	//=================================================================
	
	@Override
	/**
	 * Create a copy of the stored answer object. That way it can be used
	 * directly.
	 * @return Copy of stored SingleAnswer object
	 */
	public Answer getAnswerOptions() {
		//Get the available answers and remove the brackets placed by toString();
		String temp = answer.getAvailableAnswers().toString();
		temp = temp.substring(1, temp.length() - 1);
		
		//Return copy object
		return new SingleAnswer(temp);
	}

	@Override
	/**
	 * Get stored question.
	 * @return Stored question
	 */
	public String getQuestion() {
		return question;
	}
}
