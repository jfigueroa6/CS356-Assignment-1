package edu.cs356.assignment1;

public class MultiAnswerQuestion implements Question {
	//=================================================================
	// Data Members
	//=================================================================
	private MultiAnswer answer;		/** Holds the answers available for the question*/
	private String question;		/** Stores the question being asked */
	//=================================================================
	// Constructor
	//=================================================================
	public MultiAnswerQuestion(String question, String availableAnswers) {
		//Store question and create MultiAnswer object
		this.question = question;
		answer = new MultiAnswer(availableAnswers);
	}
	//=================================================================
	// Methods
	//=================================================================
	
	@Override
	/**
	 * Create a copy of the stored answer object. That way it can be used
	 * directly.
	 * @return Copy of stored MultiAnswer object.
	 */
	public Answer getAnswerOptions() {
		//Get the available answers and remove the brackets placed by toString();
		String temp = answer.getAvailableAnswers().toString();
		temp = temp.substring(1, temp.length() - 1);
		
		//Return copy object
		return new MultiAnswer(temp);
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
