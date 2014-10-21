package edu.cs356.assignment1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SimulationDriver {
	private static Random random;
	

	public static void main(String[] args) {
		IClickService service = new IClickService();
		random = new Random();
		
		//Create a question and place into service and start accepting submissions
		Question question = getRandomQuestion();
		service.setCurrentQuestion(question);
		service.startAcceptingSubmissions();
		
		//Have students submit answers
		studentsSubmit(service);
		
		//Show Results
		showResults(service);		
		
	}
	
	public static Question getRandomQuestion() {
		Question[] questions = {
				new SingleAnswerQuestion("How much wood could a wood chuck chuck if a wood chuck could chuck would?",
										 "A. 10, B. 20, C. 1000000, D. 50, E. -27"),
				new MultiAnswerQuestion("What are your favorite colors?",
										"A. Black, B. Pink, C. White, D. Red, E. Rainbow"),
				new SingleAnswerQuestion("If a car travels at 60 MPH, at what time will train A arrive?",
										 "A. 4:45 PM, B. 1:00 AM, C. 5:00 PM Next Year, D. 3:35 PM Yesterday"),
				new MultiAnswerQuestion("What movies do you enjoy?",
										"A. Star Wars, B. Star Trek, C. There Should be better options, D. None")
		};
		
		int q = random.nextInt(4);
		return questions[q];
	}
	
	public static void studentsSubmit(IClickService service) {
		//Number of students that will submit answers. Allow a max of 50 students
		int numStudents = random.nextInt(50);
		
		//Run submission until there are numStudents submitted answers
		while (service.getNumberSubmissions() < numStudents) {
			//Create student and give them an id of length 4
			Student student = new Student();
			student.setID(getID(4));
			
			//Get response for student
			Answer answer = service.getCurrentQuestion().getAnswerOptions();
			studentAnswers(answer);
			
			//Submit response
			service.submit(student.getID(), answer);
		}
	}
	
	public static String getID(int length) {
		char[] result = new char[length];
		
		for (int i = 0; i < length; i++)
			result[i] = (char) (random.nextInt(10) + '0');
		
		return new String(result);
	}
	
	public static void studentAnswers(Answer answer) {
		//Store the response in a hashMap. The key is the index of answer in options list,
		//and the value is the actual response. This prevents repeated responses.
		HashMap<Integer, String> response = new HashMap<Integer, String>();
		
		//Get list of available answer options
		List<String> options = answer.getAvailableAnswers();
		
		//If this is a MultiAnswerQuestion allow for multiple answers
		int numAnswers;
		if (answer instanceof MultiAnswer) {
			//How many answers will the student submit? Allow 1 to all
			numAnswers = random.nextInt(options.size()) + 1;
			
		} else {
			//Only allow 1 answer
			numAnswers = 1;
		}
		
		while (response.size() < numAnswers) {
			int op = random.nextInt(options.size());
			response.put(op, options.get(op));
		}
		
		//Get response string from hash map, and remove brackets
		String result = response.values().toString();
		result = result.substring(1, result.length() - 1);
		
		//Place response into Answer object
		answer.setResponse(result);
	}
	
	public static void showResults(IClickService service) {
		Map<String, Integer> results = service.getResultStatistics();
		List<String> options = service.getCurrentQuestion().getAnswerOptions().getAvailableAnswers();
		
		//Print Question
		System.out.println(service.getCurrentQuestion().getQuestion());
		
		//Show the results.
		for (int i = 0; i < options.size(); i++)
			System.out.println(options.get(i) + " : " + results.get(options.get(i)));
		
		//Display Number of submissions
		System.out.println("\nTotal Submissions: " + service.getNumberSubmissions());
	}

}
