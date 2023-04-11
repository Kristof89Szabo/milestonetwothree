package com.exam.solid.s.example;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Application!");
		
		// we can get the values
		Pair pair = InputProcessor.process();
			
	    // check whether the inputs are fine or not
		if(!ViolationChecker.isValid(pair)) {
			System.out.println("One of the input is invalid...");
			return;
		}

		// convert str to int
		int firstInteger = Converter.convertToInt(pair.getFirst());
		int secondInteger = Converter.convertToInt(pair.getSecond());
		
		// do the mathematical operation
		int result = Operation.execute(firstInteger, secondInteger);
		
		System.out.println("The result is: " + result);
		System.out.println("End of the application!");
	}
}
