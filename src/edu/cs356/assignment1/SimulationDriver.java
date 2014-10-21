package edu.cs356.assignment1;

public class SimulationDriver {

	public static void main(String[] args) {
		IClickService service = new IClickService();
		
		Question q = new MultiAnswerQuestion("Test", "A, B,  C, D, E ,F ");
		
		service.setCurrentQuestion(q);
		
		q = service.getCurrentQuestion();
		
		Answer a = q.getAnswerOptions();
		
		a.setResponse("A, C");
		
		service.startAcceptingSubmissions();
		
		service.submit("11", a);
		
		System.out.println(service.getResultStatistics());
		
		a = q.getAnswerOptions();
		
		a.setResponse("B,D");
		
		System.out.println(service.submit("11", a));
		
		System.out.println(service.getResultStatistics());
		
		service.stopAcceptingSubmissions();
		
		service.reset();
		
		System.out.println(service.getResultStatistics());
		
	}

}
