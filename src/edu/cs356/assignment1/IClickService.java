package edu.cs356.assignment1;

/**
 * 
 * @author Sam
 *
 */
public class IClickService {

	public static void main(String[] args) {
		Answer a = new MultiAnswer("A, B, C,   D, E , F");
		
		System.out.println(a.getAvailableAnswers());
		
		System.out.println(a.setResponse("B, C  , G"));
		
		System.out.println(a.getResponse());
		

	}

}
