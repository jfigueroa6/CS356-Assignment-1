package edu.cs356.assignment1;

public abstract class Question {
	//=================================================================
	//	Data Members
	//=================================================================
	private Answer options;
	
	//=================================================================
	//	Methods
	//=================================================================
	protected Answer getAnswerOptions() {
		return new Answer());
	}

	protected void setAnswerOptions(Answer options) {
		this.options = options;
	}
}
