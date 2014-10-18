package edu.cs356.assignment1;

import java.util.ArrayList;
import java.util.HashMap;

public interface Answer {
	/**
	 * Override to get available answer choices.
	 * @return	Available answers.
	 */
	public ArrayList<String> getAvailableAnswers();
	/**
	 * Override to set submitted response.
	 * @param response	Submitted response
	 * @return	True if response accepted
	 */
	public boolean setResponse(String response);
	/**
	 * Override to get submitted response
	 * @return	Submitted response
	 */
	public HashMap<String, Boolean> getResponse();
}
