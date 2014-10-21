package edu.cs356.assignment1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IClickService {
	//=================================================================
	// Data Members
	//=================================================================
	private boolean acceptAnswers = false;		/** When true, responses can be submitted */
	private Question currentQuestion = null;	/** Question currently receiving submission for*/
	private Map<String, Answer> submissions = null;		/** Stores submitted responses by ID */
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
	 * Get how many submissions have been accepted.
	 * @return Number of submissions
	 */
	public int getNumberSubmissions() {
		return submissions.size();
	}
	
	/**
	 * Calculates the number of responses for each answer option. The results are 
	 * stored in a hash map with the key being the answer option, and the value being
	 * the number of responses for that answer.
	 * @return	Hash Map holding results.
	 */
	public Map<String, Integer> getResultStatistics() {
		//Create a hash map to store the results
		Map<String, Integer> stats = new HashMap<String, Integer>();
		
		if (submissions != null) {
			//Get the iterator for the submission hash map
			Iterator<Answer> it = submissions.values().iterator();
			
			//Get the list of answers stored in the question and initialize the stats hash map
			List<String> choices = currentQuestion.getAnswerOptions().getAvailableAnswers();
			for (int i = 0; i < choices.size(); i++)
				stats.put(choices.get(i), 0);
			
			//Process each answer that was submitted
			while (it.hasNext()) {
				Answer temp = it.next();
				Map<String, Boolean> response = temp.getResponse();
				
				//For each answer key check if the stored value is true. If it is, then increase its
				//corresponding value in stats
				for (int i = 0; i < choices.size(); i++) {
					if (response.get(choices.get(i))) {
						int value = stats.get(choices.get(i));
						value++;
						stats.put(choices.get(i), value);
					}
				}	
			}
		}
		
		return stats;
	}
	
	
	/**
	 * Resets the service to accept a new question. Clears students, question,
	 * and stops accepting answers.
	 */
	public void reset() {
		acceptAnswers = false;
		currentQuestion = null;
		submissions = null;
	}
	
	/**
	 * Sets the current question.
	 * @param question	Question to be asked.
	 */
	public void setCurrentQuestion(Question question) {
		currentQuestion = question;
	}
	
	/**
	 * Tells service to start accepting submissions via the submit method.
	 * Only occurs if a Question has been given.
	 * @return	True if submissions are now allowed. False if a question must be given. 
	 */
	public boolean startAcceptingSubmissions() {
		boolean success = false;
		if (currentQuestion != null) {
			acceptAnswers = true;
			//Only create a new HashMap for submissions if reset() has been executed.
			//else just continue keep the previous responses.
			if (submissions == null)
				submissions = new HashMap<String, Answer>();
			success = true;
		}
		
		return success;
	}
	
	/**
	 * Tells the service to stop accepting submissions.
	 */
	public void stopAcceptingSubmissions() {
		acceptAnswers = false;
	}
	
	/**
	 * Allows the submission of a response to the service. The answer is stored in the
	 * hash map by using the id as a key.
	 * @param id	ID of the entity that is submitting.
	 * @param answer	Answer that is being submitted.
	 * @return	True if submission was successful. False otherwise.
	 */
	public boolean submit(String id, Answer answer) {
		boolean success = false;
		//Only allow submissions if startAcceptingSubmissions() has been executed
		if (acceptAnswers) {
			//Will replace old answer if it exists, else it will just add to hash map.
			submissions.put(id, answer);
			success = true;
		}
		
		return success;
	}
}
