package edu.cs356.assignment1;

import java.util.HashMap;

/**
 * 
 * @author Sam
 *
 */
public class IClickService {
	//=================================================================
	// Data Members
	//=================================================================
	private boolean acceptAnswers = false;		/** When true, responses can be submitted */
	private Question currentQuestion = null;	/** Question currently receiving submission for*/
	private HashMap<String, Answer> submissions = null;		/** Stores submitted responses by ID */
	//=================================================================
	// Constructor
	//=================================================================
	//=================================================================
	// Methods
	//=================================================================
	/**
	 * Gets the current question being asked.
	 * @return	Question being asked
	 */
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	
	/**
	 * Resets the service to accept a new question. Clears students, question,
	 * and stops accepting answers.
	 */
	public void reset() {
		acceptAnswers = false;
		currentQuestion = null;
		submissions = null;
		//TODO: Finish implementing this as new methods/members are added
	}
	
	/**
	 * Sets the current question.
	 * @param question	Question to be asked.
	 */
	public void setCurrentQuestion(Question question) {
		currentQuestion = question;
	}
	
	public void startAcceptingSubmissions() {
		if (currentQuestion != null) {
			acceptAnswers = true;
			submissions = new HashMap<String, Answer>();
		}
	}
	
	public void stopAcceptingSubmissions() {
		acceptAnswers = false;
	}
	
	//TODO: Create submit(String id, Answer answer) method and statistics() method
}
